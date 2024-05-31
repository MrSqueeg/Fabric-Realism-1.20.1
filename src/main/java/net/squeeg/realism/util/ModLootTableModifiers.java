package net.squeeg.realism.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import net.squeeg.realism.item.ModItems;

import java.io.File;

public class ModLootTableModifiers {

    private static final Identifier VILLAGE_TAIGA_HOUSE_ID =
            new Identifier("minecraft", "chests/village/village_taiga_house");

    private static final Identifier OAK_LEAVES_ID =
            new Identifier("minecraft", "blocks/oak_leaves");

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(VILLAGE_TAIGA_HOUSE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f)) // 1 = 100%
                        .with(ItemEntry.builder(ModItems.RUBY_PICKAXE)) // Item
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build()); // Number of Items

                tableBuilder.pool(poolBuilder.build());
            }

            if(OAK_LEAVES_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f)) // 1 = 100%
                        .with(ItemEntry.builder(ModItems.RUBY_PICKAXE)) // Item
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build()); // Number of Items

                tableBuilder.pool(poolBuilder.build());
            }
        }));
    }
}
