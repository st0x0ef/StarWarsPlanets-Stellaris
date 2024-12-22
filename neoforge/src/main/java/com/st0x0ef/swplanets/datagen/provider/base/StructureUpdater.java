package com.st0x0ef.swplanets.datagen.provider.base;

/*
 *  BluSunrize
 *  Copyright (c) 2021
 *
 *  This code is licensed under "Blu's License of Common Sense"
 *  Details can be found in the license file in the root folder of this project
 *
 * Methods below are taken from Immersive Engineering and modified to fit Ad Astra -> https://github.com/BluSunrize/ImmersiveEngineering
 */

import com.google.common.hash.Hashing;
import com.mojang.datafixers.DataFixer;
import com.mojang.datafixers.DataFixerUpper;
import com.teamresourceful.resourcefullib.common.lib.SWPlanets;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtAccounter;
import net.minecraft.nbt.NbtIo;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.MultiPackResourceManager;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.util.datafix.DataFixTypes;
import net.minecraft.util.datafix.DataFixers;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

public class StructureUpdater implements DataProvider {
    private final String basePath;
    private final String modid;
    private final PackOutput output;
    private final MultiPackResourceManager resources;

    public StructureUpdater(
            String basePath, String modid, ExistingFileHelper helper, PackOutput output
    ) {
        this.basePath = basePath;
        this.modid = modid;
        this.output = output;
        try {
            Field serverData = ExistingFileHelper.class.getDeclaredField("serverData");
            serverData.setAccessible(true);
            resources = (MultiPackResourceManager) serverData.get(helper);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CompletableFuture<?> run(@NotNull CachedOutput cache) {
        try {
            for (var entry : resources.listResources(basePath, $ -> true).entrySet())
                if (entry.getKey().getNamespace().equals(modid))
                    process(entry.getKey(), entry.getValue(), cache);
            return CompletableFuture.completedFuture(null);
        } catch (IOException x) {
            return CompletableFuture.failedFuture(x);
        }
    }

    private void process(ResourceLocation loc, Resource resource, CachedOutput cache) throws IOException {
        CompoundTag inputNBT = NbtIo.readCompressed(resource.open(), NbtAccounter.unlimitedHeap());
        CompoundTag converted = updateNBT(inputNBT);
        if (!converted.equals(inputNBT)) {
            SWPlanets.LOGGER.info("Found outdated NBT file: {}", loc);
            Class<? extends DataFixer> fixerClass = DataFixers.getDataFixer().getClass();
            if (!fixerClass.equals(DataFixerUpper.class))
                throw new RuntimeException("Structures are not up to date, but unknown data fixer is in use: " + fixerClass.getName());
            writeNBTTo(loc, converted, cache);
        }
    }

    private void writeNBTTo(ResourceLocation loc, CompoundTag data, CachedOutput cache) throws IOException {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        NbtIo.writeCompressed(data, bytearrayoutputstream);
        byte[] bytes = bytearrayoutputstream.toByteArray();
        Path outputPath = output.getOutputFolder().resolve("data/" + loc.getNamespace() + "/" + loc.getPath());
        cache.writeIfNeeded(outputPath, bytes, Hashing.sha1().hashBytes(bytes));
    }

    private static CompoundTag updateNBT(CompoundTag nbt) {
        final CompoundTag updatedNBT = DataFixTypes.STRUCTURE.updateToCurrentVersion(
                DataFixers.getDataFixer(), nbt, nbt.getInt("DataVersion")
        );
        StructureTemplate template = new StructureTemplate();
        template.load(BuiltInRegistries.BLOCK.asLookup(), updatedNBT);
        return template.save(new CompoundTag());
    }

    @NotNull
    @Override
    public String getName() {
        return "Update structure files in " + basePath;
    }
}
