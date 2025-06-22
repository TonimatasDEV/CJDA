package dev.tonimatas.cjda.slash;

import net.dv8tion.jda.api.interactions.InteractionContextType;
import net.dv8tion.jda.api.interactions.commands.SlashCommandInteraction;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;

import java.util.List;

public interface SlashCommand {
    void execute(SlashCommandInteraction interaction);
    
    SlashCommandData init(SlashCommandData data);

    String getCommandName();
    
    String getDescription();
    
    List<InteractionContextType> getContexts();
}
