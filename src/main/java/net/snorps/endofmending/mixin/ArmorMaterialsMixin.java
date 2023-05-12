package net.snorps.endofmending.mixin;

import net.minecraft.world.item.ArmorMaterials;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import net.snorps.endofmending.Config;

@Mixin(ArmorMaterials.class)
public class ArmorMaterialsMixin {
    /*@ModifyVariable(method = "<init>", require = 0, argsOnly = true, at = @At(value = "HEAD"), index = 4)
    private static int replaceDurabilityMult(int defaultValue) {
        return (int)(defaultValue * Config.durabilityMult);
    }*/
}