package net.squeeg.realism.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.squeeg.realism.Realism;
import net.squeeg.realism.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup RUBY_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Realism.MOD_ID, "ruby"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.ruby"))
                    .icon(() -> new ItemStack(ModItems.RUBY)).entries((displayContext, entries) -> {
                        entries.add(ModItems.RUBY);

                        entries.add(ModItems.RUBY_PICKAXE);

                        entries.add(ModBlocks.RUBY_BLOCK);

                    }).build());
    public static void registerItemGroups() {
        Realism.LOGGER.info("Registering Item Groups for " + Realism.MOD_ID);
    }
}
