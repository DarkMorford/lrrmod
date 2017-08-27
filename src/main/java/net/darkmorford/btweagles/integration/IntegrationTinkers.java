package net.darkmorford.btweagles.integration;

import mariot7.xlfoodmod.init.ItemListxlfoodmod;
import net.darkmorford.btweagles.block.ModBlocks;
import net.darkmorford.btweagles.fluid.ModFluids;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Optional;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.smeltery.CastingRecipe;
import slimeknights.tconstruct.library.smeltery.MeltingRecipe;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;

public class IntegrationTinkers
{
	@Optional.Method(modid = "tconstruct")
	public static void init()
	{
		TinkerRegistry.registerMelting(new MeltingRecipe(RecipeMatch.of(ModBlocks.butter, 1000), ModFluids.liquid_butter, 300));
		TinkerRegistry.registerBasinCasting(new CastingRecipe(new ItemStack(ModBlocks.butter), ModFluids.liquid_butter, 1000, 60));

		if (Loader.isModLoaded("xlfoodmod"))
		{
			TinkerRegistry.registerMelting(new MeltingRecipe(RecipeMatch.of(ItemListxlfoodmod.butter, 250), ModFluids.liquid_butter, 200));
			TinkerRegistry.registerTableCasting(new CastingRecipe(new ItemStack(ItemListxlfoodmod.butter), RecipeMatch.of(TinkerSmeltery.castIngot), ModFluids.liquid_butter, 250, 15));
		}
	}
}
