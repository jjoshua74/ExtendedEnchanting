package net.poople.extended_enchanting.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.Nameable;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EnchantingTableBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.EnchantingTableBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.poople.extended_enchanting.block.CustomEnchantingTableMenu;

import java.util.List;

public class ExtendedEnchantingTableBlock extends EnchantingTableBlock {
    public static final List<BlockPos> CUSTOM_BOOKSHELF_OFFSETS = BlockPos.betweenClosedStream(-16, 0, -16, 16, 1, 16)
            .filter(p_328998_ -> Math.abs(p_328998_.getX()) == 2 || Math.abs(p_328998_.getZ()) == 2)
            .map(BlockPos::immutable)
            .toList();

    public ExtendedEnchantingTableBlock(){
        super(Properties.ofFullCopy(Blocks.ENCHANTING_TABLE));
    }

    // TODO this need real logic
    public static boolean isValidBookShelf(Level pLevel, BlockPos pEnchantingTablePos, BlockPos pBookshelfPos) {
        return true;
    }

    // oh, this is just to make tha sparkles appear...
    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        super.animateTick(pState, pLevel, pPos, pRandom);

        for (BlockPos blockpos : ExtendedEnchantingTableBlock.CUSTOM_BOOKSHELF_OFFSETS) {
            if (pRandom.nextInt(16) == 0 && isValidBookShelf(pLevel, pPos, blockpos)) {
                pLevel.addParticle(
                        ParticleTypes.ENCHANT,
                        (double)pPos.getX() + 0.5,
                        (double)pPos.getY() + 2.0,
                        (double)pPos.getZ() + 0.5,
                        (double)((float)blockpos.getX() + pRandom.nextFloat()) - 0.5,
                        (double)((float)blockpos.getY() - pRandom.nextFloat() - 1.0F),
                        (double)((float)blockpos.getZ() + pRandom.nextFloat()) - 0.5
                );
            }
        }
    }

    @Override
    protected MenuProvider getMenuProvider(BlockState pState, Level pLevel, BlockPos pPos) {
        BlockEntity blockentity = pLevel.getBlockEntity(pPos);
        if (blockentity instanceof EnchantingTableBlockEntity) {
            Component component = ((Nameable)blockentity).getDisplayName();
            return new SimpleMenuProvider(
                    (p_328554_, p_332165_, p_330050_) -> new CustomEnchantingTableMenu(p_328554_, p_332165_, ContainerLevelAccess.create(pLevel, pPos)), component
            );
        } else {
            return null;
        }
    }
}

