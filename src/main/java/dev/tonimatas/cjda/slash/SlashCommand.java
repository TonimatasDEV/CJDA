package dev.tonimatas.cjda.slash;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.interactions.InteractionContextType;
import net.dv8tion.jda.api.interactions.commands.SlashCommandInteraction;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;

import java.util.Set;

/**
 * Slash command interface for CJDA.
 * @author TonimatasDEV
 */
public interface SlashCommand {
    /**
     * It is called when a slash command with the {@link SlashCommand#getName()} is executed in Discord.
     *
     * @param interaction The slash command interaction that contains important information
     */
    void execute(SlashCommandInteraction interaction);

    /**
     * Executed when the command is updated {@link JDA#updateCommands()}. It should be used to add extra command data
     * like subcommands groups, subcommands and options.
     * The rest of the SlashCommandData is registered automatically or here.
     *
     * @param data The slash command interaction that contains important information
     * @return The command data
     */
    default SlashCommandData init(SlashCommandData data) {
        return data;
    }

    /**
     * That is to assign the command name {@link SlashCommandData#setName(String)} and id.
     * 
     * @return The command name
     */
    String getName();

    /**
     * Used to add a default command description {@link SlashCommandData#setDescription(String)}.
     * 
     * @return The command description
     */
    String getDescription();

    /**
     * This method is used to add the command contexts. {@link SlashCommandData#setContexts(InteractionContextType...)}
     * 
     * 
     * @return The command contexts
     */
    Set<InteractionContextType> getContexts();
}
