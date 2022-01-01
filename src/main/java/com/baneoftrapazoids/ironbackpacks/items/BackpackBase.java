package com.baneoftrapazoids.ironbackpacks.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class BackpackBase extends Item{

    public int rows;
    public String name;
    private ScreenHandlerType<?> type;

    public BackpackBase(Settings settings, int rows, String name, ScreenHandlerType<?> type) {
        super(settings);
        this.type = type;
        this.rows = rows;
        this.name = name;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if(!world.isClient){
            user.openHandledScreen(new BackpackInventory(stack, this.rows, this.name, this.type));
        }
        return TypedActionResult.success(stack);
    }
}
