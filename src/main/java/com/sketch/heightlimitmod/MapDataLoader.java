
package com.sketch.heightlimitmod;

import com.google.gson.*;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class MapDataLoader {
    private static final Map<String, MapHeightData> MAPS = new HashMap<>();

    static {
        try (InputStream in = Minecraft.getMinecraft().getResourceManager().getResource(
                new ResourceLocation("heightlimitmod", "maps.json")).getInputStream()) {
            JsonArray array = new JsonParser().parse(new InputStreamReader(in)).getAsJsonArray();
            for (JsonElement element : array) {
                JsonObject obj = element.getAsJsonObject();
                MapHeightData data = new MapHeightData();
                data.name = obj.get("name").getAsString();
                data.minBuild = obj.get("minBuild").getAsInt();
                data.maxBuild = obj.get("maxBuild").getAsInt();
                data.buildRadius = obj.get("buildRadius").getAsInt();
                MAPS.put(data.name.toLowerCase(), data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static MapHeightData getMapData(String mapName) {
        return MAPS.get(mapName.toLowerCase());
    }
}
