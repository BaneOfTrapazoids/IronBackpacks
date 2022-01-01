package com.baneoftrapazoids.ironbackpacks.gui;

import com.baneoftrapazoids.ironbackpacks.IronBackpacks;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModGuis {

    public static ScreenHandlerType<LeatherGui> LEATHER_HANDLER_TYPE;
    public static ScreenHandlerType<IronGui> IRON_HANDLER_TYPE;
    public static ScreenHandlerType<GoldGui> GOLD_HANDLER_TYPE;
    public static ScreenHandlerType<DiamondGui> DIAMOND_HANDLER_TYPE;

    public static void registerGuisServer(){
        LEATHER_HANDLER_TYPE = ScreenHandlerRegistry.registerSimple(new Identifier(IronBackpacks.MOD_ID, "leather_backpack_gui"), (syncId, inventory) -> new LeatherGui(syncId, inventory, new SimpleInventory(9)));
        IRON_HANDLER_TYPE = ScreenHandlerRegistry.registerSimple(new Identifier(IronBackpacks.MOD_ID, "iron_backpack_gui"), (syncId, inventory) -> new IronGui(syncId, inventory, new SimpleInventory(18)));
        GOLD_HANDLER_TYPE = ScreenHandlerRegistry.registerSimple(new Identifier(IronBackpacks.MOD_ID, "gold_backpack_gui"), (syncId, inventory) -> new GoldGui(syncId, inventory, new SimpleInventory(36)));
        DIAMOND_HANDLER_TYPE = ScreenHandlerRegistry.registerSimple(new Identifier(IronBackpacks.MOD_ID, "diamond_backpack_gui"), (syncId, inventory) -> new DiamondGui(syncId, inventory, new SimpleInventory(54)));
    }

    public static void registerGuisClient(){
        ScreenRegistry.<BackpackGuiDescription, BackpackScreen>register(LEATHER_HANDLER_TYPE, (gui, inventory, title) -> new BackpackScreen(gui, inventory.player, title));
        ScreenRegistry.<BackpackGuiDescription, BackpackScreen>register(IRON_HANDLER_TYPE, (gui, inventory, title) -> new BackpackScreen(gui, inventory.player, title));
        ScreenRegistry.<BackpackGuiDescription, BackpackScreen>register(GOLD_HANDLER_TYPE, (gui, inventory, title) -> new BackpackScreen(gui, inventory.player, title));
        ScreenRegistry.<BackpackGuiDescription, BackpackScreen>register(DIAMOND_HANDLER_TYPE, (gui, inventory, title) -> new BackpackScreen(gui, inventory.player, title));
    }
}
