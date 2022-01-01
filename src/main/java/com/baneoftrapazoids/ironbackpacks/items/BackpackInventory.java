package com.baneoftrapazoids.ironbackpacks.items;

import com.baneoftrapazoids.ironbackpacks.gui.BackpackGuiDescription;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import org.jetbrains.annotations.Nullable;

public class BackpackInventory implements ImplementedInventory, NamedScreenHandlerFactory {
    private ScreenHandlerType<?> type;
    private ItemStack stack;
    private final DefaultedList<ItemStack> items;
    private final int rows;
    private final String name;
    private NbtCompound nbt;

    public BackpackInventory(ItemStack stack, int rows, String name, ScreenHandlerType<?> type){
        this.type = type;
        this.stack = stack;
        this.rows = rows;
        this.name = name;
        this.items = DefaultedList.ofSize(this.rows * 9, ItemStack.EMPTY);
        this.nbt = this.stack.getOrCreateNbt();
        if(this.nbt.contains("Items")){
            this.readNbt(this.nbt);
        }
    }

    public void readNbt(NbtCompound nbt){
        Inventories.readNbt(nbt, this.items);
    }

    public void writeNbt(NbtCompound nbt){
        Inventories.writeNbt(nbt, this.items);
    }

    public BackpackInventory setBackpackStack(ItemStack stack){
        this.stack = stack;
        this.nbt = this.stack.getOrCreateNbt();
        if(this.nbt != new NbtCompound() && this.nbt.contains("Items")){
            Inventories.readNbt(this.nbt, this.items);
        }
        return this;
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.items;
    }

    @Override
    public Text getDisplayName() {
        return new TranslatableText(this.name);
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new BackpackGuiDescription(this.type, syncId, inv, this, null, this.rows);
    }

    @Override
    public void markDirty(){
        this.writeNbt(this.stack.getOrCreateNbt());
    }

    @Override
    public void setStack(int slot, ItemStack stack) {
        System.out.println(slot);
        getItems().set(slot, stack);
        if (stack.getCount() > getMaxCountPerStack()) {
            stack.setCount(getMaxCountPerStack());
        }
    }
}
