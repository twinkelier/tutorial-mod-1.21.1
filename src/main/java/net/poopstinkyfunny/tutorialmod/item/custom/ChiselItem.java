package net.poopstinkyfunny.tutorialmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;
import net.poopstinkyfunny.tutorialmod.block.ModBlocks;

import java.util.Map;

public class ChiselItem extends Item {

    private static final Map<Block, Block> CHISEL_MAP =
            Map.of(
                    Blocks.OAK_LOG, Blocks.DARK_OAK_LOG,
                    Blocks.STONE, Blocks.DEEPSLATE,
                    ModBlocks.RAW_PINK_GARNET_BLOCK , ModBlocks.PINK_GARNET_BLOCK
    );

    public ChiselItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if(CHISEL_MAP.containsKey(clickedBlock)){ //checks if the clicked block is in the chisel map
            if(!world.isClient){ //checks if the world is server based

                world.setBlockState(context.getBlockPos(), CHISEL_MAP.get(clickedBlock).getDefaultState()); //transforms the block

                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND)); //damages the chisel

                world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS); //plays a sound
            }
        }

        return ActionResult.SUCCESS;
    }
}
