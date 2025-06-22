package dev.tonimatas.cjda;

import dev.tonimatas.cjda.slash.SlashCommand;

public interface CJDA {
    void registerCommand(SlashCommand command);
    
    CJDA registerCommand(SlashCommand ... command);
}
