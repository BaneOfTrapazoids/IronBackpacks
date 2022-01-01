package com.baneoftrapazoids.ironbackpacks.gui;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandlerType;
import org.jetbrains.annotations.Nullable;

public class IronGui extends BackpackGuiDescription{
    public IronGui(int syncId, PlayerInventory playerInventory, @Nullable Inventory blockInventory) {
        super(ModGuis.IRON_HANDLER_TYPE, syncId, playerInventory, blockInventory, null, 2);
    }
}
