package net.darkmorford.btweagles;

import net.darkmorford.btweagles.item.ModItems;
import net.darkmorford.btweagles.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(
		modid = BetterThanWeagles.MODID,
		name = BetterThanWeagles.MODNAME,
		version = BetterThanWeagles.VERSION,
		useMetadata = true
)
public class BetterThanWeagles
{
	public static final String MODID = "btweagles";
	public static final String MODNAME = "BetterThanWeagles";
	public static final String VERSION = "1.12-0.0.1.0";

	@Mod.Instance
	public static BetterThanWeagles instance;

	@SidedProxy(clientSide = "net.darkmorford.btweagles.proxy.ClientProxy", serverSide = "net.darkmorford.btweagles.proxy.ServerProxy")
	public static CommonProxy proxy;

	public static Logger logger;

	public static final CreativeTabs tabBTWeagles = new CreativeTabs("btweagles")
	{
		@Override
		public ItemStack getTabIconItem()
		{
			return new ItemStack(ModItems.butter);
		}
	};

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		logger = event.getModLog();
		proxy.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		proxy.postInit(event);
	}
}