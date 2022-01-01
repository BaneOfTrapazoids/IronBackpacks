package com.baneoftrapazoids.ironbackpacks;

import com.baneoftrapazoids.ironbackpacks.gui.ModGuis;
import com.baneoftrapazoids.ironbackpacks.items.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class IronBackpacks implements ModInitializer {

    public static final String MOD_ID = "ironbackpacks";

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "iron_backpacks"), () -> new ItemStack(Items.IRON_INGOT));

    @Override
    public void onInitialize() {
        ModGuis.registerGuisServer();
        ModItems.registerItems();
    }
}