package net.poopstinkyfunny.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.poopstinkyfunny.tutorialmod.TutorialMod;
import net.poopstinkyfunny.tutorialmod.block.ModBlocks;

public class ModItemGroups {

    // adds a tab to the creative inventory for the pink garnet items
    public static final ItemGroup PINK_GARNET_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID, "pink_garnet_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.PINK_GARNET)) //sets an icon for the tab
                    .displayName(Text.translatable("itemgroup.tutorialmod.pink_garnet_items")) //sets a title for the tab which is translatable
                    .entries(((displayContext, entries) -> { //adds all the items that belong to this tab
                        entries.add(ModItems.PINK_GARNET);
                        entries.add(ModItems.RAW_PINK_GARNET);
                        entries.add(ModItems.CHISEL);
                    })).build());

    // adds a tab to the creative inventory for the pink garnet blocks
    public static final ItemGroup PINK_GARNET_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID, "pink_garnet_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.PINK_GARNET_BLOCK)) //sets an icon for the tab
                    .displayName(Text.translatable("itemgroup.tutorialmod.pink_garnet_blocks")) //sets a title for the tab which is translatable
                    .entries(((displayContext, entries) -> { //adds all the blocks that belong to this tab
                        entries.add(ModBlocks.PINK_GARNET_BLOCK);
                        entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);
                        entries.add(ModBlocks.PINK_GARNET_ORE);
                        entries.add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);
                    })).build());

    // registers the item groups
    public static void registerItemGroups(){
        TutorialMod.LOGGER.info("Registering Item Groups for " + TutorialMod.MOD_ID);
    }
}
