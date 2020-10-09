package com.focamacho.sealmessages.mixin;

import com.focamacho.sealmessages.util.JsonHandler;
import net.minecraftforge.fml.common.FMLCommonHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.File;

@Mixin(value = FMLCommonHandler.class, remap = false)
public class MixinFMLCommonHandler {

    private String serverStarting = "Server is still starting! Please wait before reconnecting.";
    private String missingMods = "This server has mods that require FML/Forge to be installed on the client. Contact your server admin for more details.";

    @Inject(method = "<init>()V", at = @At("RETURN"))
    private void init(CallbackInfo info) {
        try {
            File jsonFile = new File("./config/SealMessages.json");
            JsonHandler.getOrCreateJson(jsonFile);

            serverStarting = JsonHandler.getOrCreateString(jsonFile, "serverStarting", serverStarting);
            missingMods = JsonHandler.getOrCreateString(jsonFile, "missingMods", missingMods);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @ModifyConstant(method = "handleServerHandshake")
    private String getServerStartingMessage(String original) {
        if(original.equalsIgnoreCase("Server is still starting! Please wait before reconnecting.")) return serverStarting;
        else if(original.equalsIgnoreCase("This server has mods that require FML/Forge to be installed on the client. Contact your server admin for more details.")) return missingMods;
        else return original;
    }

}
