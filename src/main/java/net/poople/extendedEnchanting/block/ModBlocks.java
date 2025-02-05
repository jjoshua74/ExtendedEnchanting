package net.poople.extendedEnchanting.block;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.poople.extendedEnchanting.ExtendedEnchanting;
import net.poople.extendedEnchanting.block.custom.ExtendedEnchantingTableBlock;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ExtendedEnchanting.MOD_ID);

    public static final RegistryObject<Block> EXTENDED_ENCHANTING_BLOCK = BLOCKS.register(
            "enchanting_table",
            ExtendedEnchantingTableBlock::new
    );

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
