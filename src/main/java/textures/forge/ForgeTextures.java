package textures.forge;

import java.util.Iterator;

import org.apache.logging.log4j.Logger;

import textures.forge.plugin.PluginManager;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
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
    
    Minecraft mc = Minecraft.getMinecraft();
    
    // Get bread, and change the texture/icon to apple
    Item bread = Item.getItemById(297);
    bread.setTextureName("apple");
    Item bread2 = (Item) Item.itemRegistry.getObjectById(297);
    bread2.setTextureName("apple");
    
    // Iterate through all the blocks and items
    Iterator iterator_blocks = Block.blockRegistry.getKeys().iterator();
    while (iterator_blocks.hasNext()) {
      System.out.println("[Block]: "+(String)iterator_blocks.next());
    }
    Iterator iterator_items = Item.itemRegistry.getKeys().iterator();
    while (iterator_items.hasNext()) {
      System.out.println("[Item]: "+(String)iterator_items.next());
    }
    
    // Start our manager
    PluginManager manager = new PluginManager();
    // Load plugins
    manager.load();
    // Start our plugins
    manager.start();

    LOGGER.info("[FT]: Forge Textures is DONE starting up.");
  }
  
  
}
