
package com.sketch.heightlimitmod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = "heightlimitmod", name = "Height Limit Mod", version = "1.0")
public class HeightLimitMod {
    @Mod.Instance
    public static HeightLimitMod instance;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new HUDRenderer());
    }
}
