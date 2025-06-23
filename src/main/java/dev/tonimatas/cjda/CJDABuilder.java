package dev.tonimatas.cjda;

import dev.tonimatas.cjda.internal.CJDAImpl;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.localization.LocalizationFunction;

/**
 * Use CJDABuilder to create CJDA instances.
 * @see CJDA
 * @author TonimatasDEV
 */
public final class CJDABuilder {
    /**
     * What are you doing reading this useless constructor?
     */
    private CJDABuilder() {
        // Necessary to delete Javadocs warnings :)
    }

    /**
     * Create a simple CJDA instance for your commands.
     * 
     * @param jda Your {@link JDA} instance
     * @return The created CJDA
     */
    public static CJDA create(JDA jda) {
        return new CJDAImpl(jda);
    }

    /**
     * You can use that to create a localized CJDA instance, automatically adding {@link CommandData#setLocalizationFunction(LocalizationFunction)}.
     * 
     * @param jda Your {@link JDA} instance
     * @param localization Your {@link LocalizationFunction} instance
     * @return The created CJDA
     */
    public static CJDA createLocalized(JDA jda, LocalizationFunction localization) {
        return new CJDAImpl(jda, localization);
    }
}
