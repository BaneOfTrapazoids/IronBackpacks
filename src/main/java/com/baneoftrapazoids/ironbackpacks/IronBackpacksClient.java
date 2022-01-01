package com.baneoftrapazoids.ironbackpacks;

import com.baneoftrapazoids.ironbackpacks.gui.ModGuis;
import net.fabricmc.api.ClientModInitializer;

public class IronBackpacksClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModGuis.registerGuisClient();
    }
}
