package net.poople.extendedEnchanting.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.EnchantingTableBlock;

import java.util.List;

public class ExtendedEnchantingTableBlock extends EnchantingTableBlock {
    public static final List<BlockPos> BOOKSHELF_OFFSETS = BlockPos.betweenClosedStream(-8, -8, -8, 8, 8, 8)
            .filter(p_328998_ -> Math.abs(p_328998_.getX()) == 2 || Math.abs(p_328998_.getZ()) == 2)
            .map(BlockPos::immutable)
            .toList();

    public ExtendedEnchantingTableBlock(){
        super(Properties.of());
    }
}
