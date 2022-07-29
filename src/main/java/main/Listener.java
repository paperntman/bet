package main;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Listener extends ListenerAdapter {
    Logger logger = LoggerFactory.getLogger(Listener.class);
    public static JDA jda = Main.jda;
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        switch (event.getName()) {
            case "bet" -> {

                break;
            }
            case "betstart" -> {
                break;
            }
            case "betend" -> {
                break;
            }
        }
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        logger.info(event.getMessage().getContentRaw());
    }
}


/*
    /bet start
    /bet 1 (포인트)
    /bet 2 (포인트)


 */