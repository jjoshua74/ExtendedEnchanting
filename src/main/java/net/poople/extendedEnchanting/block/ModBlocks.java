package net.poople.extendedEnchanting.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.poople.extendedEnchanting.ExtendedEnchanting;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ExtendedEnchanting.MOD_ID);

//    public static final RegistryObject<Block> EXTENDED_ENCHANTING_BLOCK = BLOCKS.register(
//            "enchanting_table_extended",
//           () -> new ExtendedEnchantingTableBlock()
//    );

    public static final RegistryObject<Block> SAPPHIRE_BLOCK = BLOCKS.register(
            "sapphire_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK))
    );

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
