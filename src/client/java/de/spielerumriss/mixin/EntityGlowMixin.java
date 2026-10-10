package de.spielerumriss.mixin;

import de.spielerumriss.SpielerUmrissClient;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
abstract class EntityGlowMixin {
    @Inject(method = "isCurrentlyGlowing", at = @At("HEAD"), cancellable = true)
    private void spielerumriss$enablePlayerOutline(CallbackInfoReturnable<Boolean> callback) {
        Entity entity = (Entity) (Object) this;
        if (SpielerUmrissClient.isEnabled()
                && entity instanceof Player
                && entity != Minecraft.getInstance().player) {
            callback.setReturnValue(true);
        }
    }

    @Inject(method = "getTeamColor", at = @At("HEAD"), cancellable = true)
    private void spielerumriss$setPlayerOutlineColor(CallbackInfoReturnable<Integer> callback) {
        Entity entity = (Entity) (Object) this;
        if (SpielerUmrissClient.isEnabled()
                && entity instanceof Player
                && entity != Minecraft.getInstance().player) {
            callback.setReturnValue(0xFF00D8);
        }
    }
}
