package net.snorps.endofmending;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import org.apache.commons.lang3.tuple.Pair;

public class Config {
    public static final Config COMMON;
    public static final ForgeConfigSpec SPEC_COMMON;
    static {
        final Pair<Config, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Config::new);
        COMMON = specPair.getLeft();
        SPEC_COMMON = specPair.getRight();
    }

    public static double DURABILITY_MULT;

    @SubscribeEvent
    public static void onModConfigEvent(final ModConfigEvent.Loading configEvent) {
        if (configEvent.getConfig().getSpec() == Config.SPEC_COMMON) {
            DURABILITY_MULT = COMMON.durabilityMult.get();
        }
    }

    protected final ForgeConfigSpec.ConfigValue<Double> durabilityMult;

    public Config(final ForgeConfigSpec.Builder BUILDER) {
        BUILDER
                .comment(
                        """
                                
                          End of Mending Config - Common
                          
""")
                .push("General");

        durabilityMult = BUILDER
                .comment(
                        """
                                The multiplier to apply to the durability of all repairable items. e.g 2.0 will double all durability
                                1 item will still repair half of an items durability, so this decreases the amount of resources a player will
                                end up spending repairing their tools, weapons, and armour.
                                Default: 2.0""".indent(1))
                .worldRestart()
                .define("Durability Multiplier", 2.0);

        BUILDER.pop();
    }
}