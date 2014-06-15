package textures.forge;

import org.apache.logging.log4j.Logger;

import textures.forge.plugin.PluginManager;
import net.minecraft.client.Minecraft;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = ForgeTextures.MODID, version = ForgeTextures.VERSION)
public class ForgeTextures {

  // All our static data
  public static final String MODID = "Forge Textures";
  public static final String VERSION = "alpha-0.1";
  public static Logger LOGGER = FMLLog.getLogger();

  @EventHandler
  public void init(FMLInitializationEvent event) {
    LOGGER.info("[FT]: Starting up");
    
    // Start our manager
    PluginManager manager = new PluginManager();
    // Load plugins
    manager.load();
    // Start our plugins
    manager.start();

    LOGGER.info("[FT]: Forge Textures is DONE starting up.");
  }
}
