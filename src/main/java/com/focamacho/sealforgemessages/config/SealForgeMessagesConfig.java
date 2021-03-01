package com.focamacho.sealforgemessages.config;

import com.focamacho.sealconfig.relocated.blue.endless.jankson.Comment;

public class SealForgeMessagesConfig {

    @Comment("Mensagem que é exibida quando alguém tenta entrar no servidor antes dele ter terminado de iniciar.")
    public String serverStarting = "Server is still starting! Please wait before reconnecting.";

    @Comment("Mensagem que é exibida quando alguém tenta entrar no servidor sem ter o Forge instalado.")
    public String missingMods = "This server has mods that require FML/Forge to be installed on the client. Contact your server admin for more details.";

}
