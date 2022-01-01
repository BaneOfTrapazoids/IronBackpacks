package com.baneoftrapazoids.ironbackpacks.items;

import com.baneoftrapazoids.ironbackpacks.IronBackpacks;
import com.baneoftrapazoids.ironbackpacks.gui.ModGuis;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static BackpackBase LEATHER_BACKPACK;
    public static BackpackBase IRON_BACKPACK;
    public static BackpackBase GOLD_BACKPACK;
    public static BackpackBase DIAMOND_BACKPACK;


    public static Item register(Item item, String name){
        Registry.register(Registry.ITEM, new Identifier(IronBackpacks.MOD_ID, name), item);
        return item;
    }

    public static void registerItems() {
        LEATHER_BACKPACK = (BackpackBase) register(new BackpackBase(new FabricItemSettings().maxCount(1).group(IronBackpacks.ITEM_GROUP), 1, "item.ironbackpacks.leather_backpack", ModGuis.LEATHER_HANDLER_TYPE), "leather_backpack");
        IRON_BACKPACK = (BackpackBase) register(new BackpackBase(new FabricItemSettings().maxCount(1).group(IronBackpacks.ITEM_GROUP), 2, "item.ironbackpacks.iron_backpack", ModGuis.IRON_HANDLER_TYPE), "iron_backpack");
        GOLD_BACKPACK = (BackpackBase) register(new BackpackBase(new FabricItemSettings().maxCount(1).group(IronBackpacks.ITEM_GROUP), 4, "item.ironbackpacks.gold_backpack", ModGuis.GOLD_HANDLER_TYPE), "gold_backpack");
        DIAMOND_BACKPACK = (BackpackBase) register(new BackpackBase(new FabricItemSettings().maxCount(1).group(IronBackpacks.ITEM_GROUP), 6, "item.ironbackpacks.diamond_backpack", ModGuis.DIAMOND_HANDLER_TYPE), "diamond_backpack");
    }
}
