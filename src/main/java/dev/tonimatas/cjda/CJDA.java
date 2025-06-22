package dev.tonimatas.cjda;

import dev.tonimatas.cjda.slash.SlashCommand;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;

/**
 * Primary class of this library
 * 
 * <p>Usage example:</p>
 * 
 * <pre><code>
 *     CJDA cjda = CJDABuilder.create(jda);
 *     
 *     cjda.registerCommands(new ExampleCommand());
 *     
 *     cjda.init().queue();
 * </code></pre>
 * 
 * @author TonimatasDEV
 */
public interface CJDA {
    /**
     * Register one command to the CJDA api. You should use {@link CJDA#registerCommands(SlashCommand...)}
     *
     * @param command The slash command to register
     */
    void registerCommand(SlashCommand command);

    /**
     * Register multiple commands to the CJDA api. 
     *
     * @param command The slash command to register
     * @return Returns your {@link CJDA} instance
     */
    CJDA registerCommands(SlashCommand ... command);

    /**
     * Initialize the CJDA command registration.
     * 
     * @return The command update action
     * @see CommandListUpdateAction
     */
    CommandListUpdateAction init();
}
