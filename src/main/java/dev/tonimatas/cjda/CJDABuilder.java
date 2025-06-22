package dev.tonimatas.cjda;

import dev.tonimatas.cjda.internal.CJDAImpl;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.interactions.commands.localization.LocalizationFunction;

public class CJDABuilder {
    public static CJDA create(JDA jda) {
        return new CJDAImpl(jda);
    }
    
    public static CJDA createLocalized(JDA jda, LocalizationFunction localization) {
        return new CJDAImpl(jda, localization);
    }
}
