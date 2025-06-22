package dev.tonimatas.cjda;

import dev.tonimatas.cjda.slash.SlashCommand;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;

public interface CJDA {
    void registerCommand(SlashCommand command);
    
    CJDA registerCommand(SlashCommand ... command);

    CommandListUpdateAction init();
}
