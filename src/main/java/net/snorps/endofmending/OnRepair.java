/*
package net.snorps.endofmending;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class OnRepair {
    @SubscribeEvent
    public void onRepair(AnvilUpdateEvent e) {
        ItemStack leftstack = e.getLeft();
        ItemStack rightstack = e.getRight();
        ItemStack outputstack = e.getOutput();

        if (!rightstack.getItem().equals(Items.ENCHANTED_BOOK) && !leftstack.getItem().equals(rightstack.getItem()) && outputstack.isEmpty()) {
            Item leftitem = leftstack.getItem();
            if (!leftitem.isValidRepairItem(leftstack, rightstack)) {
                return;
            }

            int levelcost = leftstack.getBaseRepairCost()
            int materialcost = ConfigHandler.GENERAL.repairCostMaterialAmount.get();

            if (levelcost >= 1 || materialcost >= 1) {
                if (levelcost >= 1) {
                    e.setCost(levelcost);
                }
                if (materialcost >= 1) {
                    e.setMaterialCost(materialcost);

                    if (materialcost > rightstack.getCount()) {
                        e.setCanceled(true);
                        return;
                    }
                }

                int currentdamage = leftstack.getDamageValue();
                int maxdamage = leftstack.getMaxDamage();
                int repairamount = (int)(maxdamage * ConfigHandler.GENERAL.percentRepairedPerAction.get());

                currentdamage -= repairamount;
                if (currentdamage < 0) {
                    currentdamage = 0;
                }

                ItemStack newoutputstack = leftstack.copy();
                newoutputstack.setDamageValue(currentdamage);

                e.setOutput(newoutputstack);
            }
        }
    }
}
*/