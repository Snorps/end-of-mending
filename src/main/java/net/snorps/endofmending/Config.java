package net.snorps.endofmending;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import org.apache.commons.lang3.tuple.Pair;
@Mod.EventBusSubscriber(modid = "endofmending", bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
    public static final CommonConfig COMMON;
    public static final ForgeConfigSpec SPEC_COMMON;
    static {
        final Pair<CommonConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(CommonConfig::new);
        COMMON = specPair.getLeft();
        SPEC_COMMON = specPair.getRight();
    }

    public static double durabilityMult;

    @SubscribeEvent
    public static void onModConfigEvent(final ModConfigEvent.Loading configEvent) {
        if (configEvent.getConfig().getSpec() == Config.SPEC_COMMON) {
            durabilityMult = COMMON.durabilityMult.get();
            int a = 3;
        }
    }

    public static class CommonConfig  {
        public final ForgeConfigSpec.DoubleValue durabilityMult;

        CommonConfig(ForgeConfigSpec.Builder builder) {
            builder.push("durability multiply");
            durabilityMult = builder.translation("endofmending" + ".config.durabilityMultiplier")
                    .comment(
                            """
                                    The multiplier to apply to the durability of all repairable items. e.g 2.0 will double all durability
                                    1 item will still repair half of an items durability, so this decreases the amount of resources a player will
                                    end up spending repairing their tools, weapons, and armour.
                                    Default: 2.0""".indent(1))
                    .defineInRange("Durability Multiplier", 2.0D, 0.0D, 100.0D);
            builder.pop();
        }
    }
}