package org.example.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.example.ICommand;

import java.util.ArrayList;
import java.util.List;

public class Sum implements ICommand {

    @Override
    public String getName() {
        return "sum";
    }

    @Override
    public String getDescription() {
        return "Will take the sum of 2 numbers";
    }

    @Override
    public List<OptionData> getOptions() {
        List<OptionData> options = new ArrayList<>();
        options.add(new OptionData(OptionType.INTEGER, "number1", "The first number", true)
                .setMinValue(1)
                .setMaxValue(45));
        options.add(new OptionData(OptionType.INTEGER, "number2", "The second number", false)
                .setMinValue(4)
                .setMaxValue(100));
        return options;
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        OptionMapping number1 = event.getOption("number1");
        OptionMapping number2 = event.getOption("number2");

        int num1 = number1.getAsInt();
        int num2 =  1;

        if (number2 != null) num2 = number2.getAsInt();

        event.reply(num1 + num2 + "").queue();
    }

    //    @Override
//    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
//        if (!event.getName().equals("sum")) return;
//
//        OptionMapping number1 = event.getOption("number1");
//        OptionMapping number2 = event.getOption("number2");
//
//        int num1 = number1.getAsInt();
//        int num2 =  1;
//
//        if (number2 != null) num2 = number2.getAsInt();
//
//        event.reply(num1 + num2 + "").queue();
//    }
}
