package org.example.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.utils.messages.MessageCreateBuilder;
import net.dv8tion.jda.api.utils.messages.MessageCreateData;
import org.example.ICommand;

import java.util.List;

public class Buttons implements ICommand {
    @Override
    public String getName() {
        return "buttons";
    }

    @Override
    public String getDescription() {
        return "Buttons";
    }

    @Override
    public List<OptionData> getOptions() {
        return null;
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        EmbedBuilder builder = new EmbedBuilder();
        builder.setTitle("Pizza?");
        builder.setDescription("Do you like pizza?");

        Button yesButton = Button.danger("yes-button", "Yes");
        Button noButton = Button.danger("no-button", "No");

        MessageCreateData messageCreateData = new MessageCreateBuilder()
                .setEmbeds(builder.build())
                .addComponents(ActionRow.of(yesButton, noButton))
                .build();

        event.reply(messageCreateData).queue();
    }
}
