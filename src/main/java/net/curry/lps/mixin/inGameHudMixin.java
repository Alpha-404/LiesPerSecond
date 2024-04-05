package net.curry.lps.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.awt.*;

@Mixin(InGameHud.class)
public class inGameHudMixin {

    @Inject(method = "render", at = @At("RETURN"), cancellable = true)

    public void onRender (DrawContext context, float tickDelta, CallbackInfo ci) {
        //MinecraftClient.getInstance().textRenderer.draw(matrices, "Text", 5, 5, -1);
        MinecraftClient mc = MinecraftClient.getInstance();
        String fps = "FPS: " + (((retrieveFps) mc).retFps() + 764);
        context.drawText(mc.textRenderer, fps, 5, 5, 999, true);
    }

}
