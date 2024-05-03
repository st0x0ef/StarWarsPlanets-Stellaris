package fr.tathan.swplanets;

import com.teamresourceful.resourcefulconfig.api.loader.Configurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Constants {

	public static final String MODID = "swplanets";
	public static final String MOD_NAME = "Star Wars Planets";
	public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);
	public static final Configurator CONFIGURATOR = new Configurator(MODID);

}