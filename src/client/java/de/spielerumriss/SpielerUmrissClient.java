package de.spielerumriss;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import org.lwjgl.glfw.GLFW;

public final class SpielerUmrissClient implements ClientModInitializer {
    private static KeyMapping toggleKey;
    private static boolean enabled;

    @Override
    public void onInitializeClient() {
        toggleKey = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.spielerumriss.toggle",
                InputConstants.Type.KEYSYM,
                GLFW.GLFW_KEY_K,
                KeyMapping.Category.MISC
        ));
        ClientTickEvents.END_CLIENT_TICK.register(SpielerUmrissClient::onClientTick);
    }

    public static boolean isEnabled() {
        return enabled;
    }

    private static void onClientTick(Minecraft client) {
        while (toggleKey.consumeClick()) {
            enabled = !enabled;
            if (client.player != null) {
                client.player.displayClientMessage(Component.translatable(
                        enabled ? "message.spielerumriss.enabled" : "message.spielerumriss.disabled"
                ), true);
            }
        }
    }
}
