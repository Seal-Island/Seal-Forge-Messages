package com.focamacho.sealmessages;

import net.minecraftforge.fml.common.Mod;

@Mod(
        modid = SealMessages.MOD_ID,
        name = SealMessages.MOD_NAME,
        version = SealMessages.VERSION,
        acceptableRemoteVersions = "*"
)
public class SealMessages {

    public static final String MOD_ID = "sealmessages";
    public static final String MOD_NAME = "Seal Messages";
    public static final String VERSION = "1.0";

    @Mod.Instance(MOD_ID)
    public static SealMessages INSTANCE;

}
