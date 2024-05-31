package net.squeeg.realism.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.PickaxeItem;
import net.minecraft.registry.Registry;
import net.squeeg.realism.Realism;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;

public class ModItems {
    public static final Item RUBY = registerItem( "ruby", new Item(new FabricItemSettings()));

    public static final Item RUBY_PICKAXE = registerItem( "ruby_pickaxe",
            new PickaxeItem(ModToolMaterial.RUBY,2,2f, new FabricItemSettings()));

    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(RUBY);
    }
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Realism.MOD_ID, name), item);
    }
    public static void registerModItems() {
        Realism.LOGGER.info("Registering Mod Items for " + Realism.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
    }
}
