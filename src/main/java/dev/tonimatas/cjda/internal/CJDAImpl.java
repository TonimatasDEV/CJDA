package dev.tonimatas.cjda.internal;

import dev.tonimatas.cjda.CJDA;
import dev.tonimatas.cjda.CJDABuilder;
import dev.tonimatas.cjda.slash.SlashCommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;
import net.dv8tion.jda.api.interactions.commands.localization.LocalizationFunction;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation of {@link CJDA}
 * 
 * @author TonimatasDEV
 */
public class CJDAImpl extends ListenerAdapter implements CJDA {
    private static final Logger LOGGER = LoggerFactory.getLogger(CJDAImpl.class);
    private final Map<String, SlashCommand> slashCommands = new HashMap<>();
    private final JDA jda;
    private final LocalizationFunction localization;

    /**
     * This should not be used. Please use {@link CJDABuilder}
     * 
     * @param jda Your {@link JDA} instance
     */
    public CJDAImpl(JDA jda) {
        this(jda, null);
    }

    /**
     * This should not be used. Please use {@link CJDABuilder}
     * 
     * @param jda Your {@link JDA} instance
     * @param localization Your {@link LocalizationFunction} instance
     */
    public CJDAImpl(JDA jda, LocalizationFunction localization) {
        this.jda = jda;
        this.localization = localization;
    }

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        SlashCommand slashCommand = slashCommands.get(event.getName());
        
        if (isRegistered(slashCommand)) {
            slashCommand.execute(event);
        }
    }

    @Override
    public void registerCommand(SlashCommand command) {
        if (isRegistered(command)) {
            LOGGER.error("Slash command {} is already registered!", command.getCommandName());
            return;
        }

        slashCommands.put(command.getCommandName(), command);
    }

    @Override
    public CJDA registerCommands(SlashCommand... commands) {
        for (SlashCommand command : commands) {
            registerCommand(command);
        }

        return this;
    }
    
    @Override
    public CommandListUpdateAction init() {
        List<SlashCommandData> slashCommandDataList = new ArrayList<>();
        
        for (SlashCommand command : slashCommands.values()) {
            SlashCommandData data = Commands.slash(command.getCommandName(), command.getDescription());
            
            if (localization != null) {
                data.setLocalizationFunction(localization);
            }
            
            data.setContexts(command.getContexts());
            slashCommandDataList.add(command.init(data));
        }

        jda.addEventListener(this);

        return jda.updateCommands().addCommands(slashCommandDataList);
    }
    
    private boolean isRegistered(SlashCommand command) {
        return slashCommands.get(command.getCommandName()) != null;
    }
}
