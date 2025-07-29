
package com.sketch.heightlimitmod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetworkPlayerInfo;

public class HypixelUtils {
    public static String getMapNameFromTab() {
        if (Minecraft.getMinecraft().thePlayer == null) return null;
        for (NetworkPlayerInfo info : Minecraft.getMinecraft().getNetHandler().getPlayerInfoMap()) {
            String name = info.getGameProfile().getName();
            if (name.contains("Map: ")) {
                return name.split("Map: ")[1].trim();
            }
        }
        return null;
    }
}
