package net.snorps.endofmending;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static net.snorps.endofmending.Config.SPEC_COMMON;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("endofmending")
public class EndOfMending
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public static final TagKey<Item> DONT_AFFECT = ItemTags.create(new ResourceLocation("endofmending", "dont_affect"));

    public EndOfMending() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, SPEC_COMMON);
    }
}
