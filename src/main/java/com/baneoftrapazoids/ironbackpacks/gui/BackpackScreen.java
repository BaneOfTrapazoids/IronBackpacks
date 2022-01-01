package com.baneoftrapazoids.ironbackpacks.gui;

import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

public class BackpackScreen extends CottonInventoryScreen<BackpackGuiDescription> {

    public BackpackScreen(BackpackGuiDescription description, PlayerEntity player, Text title) {
        super(description, player, title);
    }
}
