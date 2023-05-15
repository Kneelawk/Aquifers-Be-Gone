package com.kneelawk.aquifersbegone.mixin;

import java.util.function.Function;

import org.apache.commons.lang3.mutable.MutableBoolean;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.CarvingMask;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.Aquifer;
import net.minecraft.world.level.levelgen.carver.CanyonWorldCarver;
import net.minecraft.world.level.levelgen.carver.CarverConfiguration;
import net.minecraft.world.level.levelgen.carver.CarvingContext;
import net.minecraft.world.level.levelgen.carver.CaveWorldCarver;
import net.minecraft.world.level.levelgen.carver.WorldCarver;

@Mixin(WorldCarver.class)
public abstract class WorldCarverMixin {
    @Shadow
    protected abstract boolean canReplaceBlock(CarverConfiguration $$0, BlockState $$1);

    @Shadow
    @Final
    protected static BlockState CAVE_AIR;

    @Inject(method = "carveBlock", at = @At("HEAD"), cancellable = true)
    private void onCarveBlock(CarvingContext ctx, CarverConfiguration config, ChunkAccess chunk,
                              Function<BlockPos, Holder<Biome>> posToBiome, CarvingMask mask,
                              BlockPos.MutableBlockPos pos, BlockPos.MutableBlockPos downPos, Aquifer aquifer,
                              MutableBoolean foundSurface, CallbackInfoReturnable<Boolean> cir) {
        if (((Object) this) instanceof CaveWorldCarver || ((Object) this) instanceof CanyonWorldCarver) {
            if (canReplaceBlock(config, chunk.getBlockState(pos)) && chunk.getFluidState(pos).isEmpty()) {
                chunk.setBlockState(pos, CAVE_AIR, false);
                cir.setReturnValue(true);
            } else {
                cir.setReturnValue(false);
            }
        }
    }
}
