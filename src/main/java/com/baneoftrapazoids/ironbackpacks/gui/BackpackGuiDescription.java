package com.baneoftrapazoids.ironbackpacks.gui;

import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WItemSlot;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

public class BackpackGuiDescription extends SyncedGuiDescription{
    public BackpackGuiDescription(ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory, @Nullable Inventory blockInventory, @Nullable PropertyDelegate propertyDelegate, int rows) {
        super(type, syncId, playerInventory, blockInventory, propertyDelegate);

        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(145, 100);
        root.setInsets(Insets.ROOT_PANEL);
        for(int i = 1; i <= rows; i++){
            for(int j = 1; j <= 9; j++){
                root.add(WItemSlot.of(blockInventory, (i-1)*9+(j-1)), j-1, i);
                System.out.printf("Added Slot to %s, %s, at position %s\n", j-1, i, (i-1)*9+(j-1));
            }
        }
        root.add(this.createPlayerInventoryPanel(), 0, rows+1);
        root.validate(this);
    }
}
