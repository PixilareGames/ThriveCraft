package pixilaregames.thrivecraft.World;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;
import pixilaregames.thrivecraft.Config.ConfigOptions;
import pixilaregames.thrivecraft.Lists.BlockList;

public class OreGeneration
{	
	public static void setupOreGeneration()
	{
		for(Biome biome : ForgeRegistries.BIOMES)
		{
			biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NATURAL_STONE, BlockList.onyx_ore.getDefaultState(), ConfigOptions.onyx_ore_chance.get()), Placement.COUNT_RANGE, new CountRangeConfig(10, 1, 0, 100)));
			biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NETHERRACK, BlockList.onyx_ore.getDefaultState(), ConfigOptions.onyx_ore_chance.get()), Placement.COUNT_RANGE, new CountRangeConfig(10, 1, 0, 100)));
			//biome.addFeature(Decoration.UNDERGROUND_ORES, new DimensionalGenerator<>(Feature.MINABLE, new MinableConfig(IS_ENDSTONE, BlockList.onyx_ore.getDefaultState(), 20), new CountRange(), onyx_ore_end_placement, DimensionType.THE_END));
		}
	}
	
	
}
