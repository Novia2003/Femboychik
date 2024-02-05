package org.example;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.example.commands.*;
import org.example.commands.music.*;

public class Main {
    public static void main(String[] args) {
        JDA jda = JDABuilder.
                createDefault("popec").
                enableIntents(GatewayIntent.MESSAGE_CONTENT).build();

        jda.addEventListener(new Listeners());
        CommandManager manager = new CommandManager();
//        manager.addCommand(new Sum());
//        manager.addCommand(new Embed());
//        manager.addCommand(new Buttons());
//        manager.addCommand(new Modals());
//        manager.addCommand(new Staff());
//        manager.addCommand(new Unstaff());
//        manager.addCommand(new Ban());
//        manager.addCommand(new Mute());
//        manager.addCommand(new Unmute());
        manager.addCommand(new Play());
        manager.addCommand(new Skip());
        manager.addCommand(new Stop());
        manager.addCommand(new NowPlaying());
        manager.addCommand(new Queue());
        manager.addCommand(new Repeat());
        jda.addEventListener(manager);

    }
}