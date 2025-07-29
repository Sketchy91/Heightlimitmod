
package com.sketch.heightlimitmod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Arrays;
import java.util.List;

public class HUDRenderer {
    @SubscribeEvent
    public void onRender(RenderGameOverlayEvent.Text event) {
        Minecraft mc = Minecraft.getMinecraft();
        if (mc.thePlayer == null) return;

        String mapName = HypixelUtils.getMapNameFromTab();
        if (mapName == null) return;

        MapHeightData data = MapDataLoader.getMapData(mapName);
        if (data == null) return;

        int y = mc.thePlayer.getPosition().getY();
        int diff = data.maxBuild - y;

        List<String> lines = Arrays.asList(
            "§aMap: §f" + data.name,
            "§eMin Y: §f" + data.minBuild,
            "§cMax Y: §f" + data.maxBuild,
            "§bY Left: §f" + diff
        );

        int x = 10, yPos = 10;
        for (String line : lines) {
            mc.fontRendererObj.drawString(line, x, yPos, 0xFFFFFF);
            yPos += 10;
        }
    }
}
