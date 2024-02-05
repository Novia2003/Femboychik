package org.example;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.interactions.modals.ModalMapping;
import org.jetbrains.annotations.NotNull;

import javax.management.modelmbean.ModelMBean;
import javax.swing.text.html.Option;
import java.util.Map;

public class Listeners extends ListenerAdapter {
    @Override
    public void onButtonInteraction(@NotNull ButtonInteractionEvent event) {
        if (event.getButton().getId().equals("yes-button")) event.reply("Nice, so do I").queue();
        else if (event.getButton().getId().equals("no-button")) event.reply("You nigga").queue();

        event.getMessage().delete().queue();
    }

    @Override
    public void onModalInteraction(@NotNull ModalInteractionEvent event) {
        if (event.getModalId().equals("person-modal")) {
            ModalMapping nameValue = event.getValue("name-field");
            ModalMapping ageValue = event.getValue("age-field");
            ModalMapping descriptionValue = event.getValue("description-field");

            String name = nameValue.getAsString();
            String description = descriptionValue.getAsString();

            String age;

            if (ageValue.getAsString().isBlank()) age = "N/A";
            else age = ageValue.getAsString();

            EmbedBuilder builder = new EmbedBuilder();
            builder.setTitle(name);
            builder.setDescription("The description of " + name);
            builder.addField("Name", name, false);
            builder.addField("Age", age, false);
            builder.addField("Description", description, false);

            event.replyEmbeds(builder.build()).queue();
        }
    }

    //    @Override
//    public void onReady(@NotNull ReadyEvent event) {
//        Guild guild = event.getJDA().getGuildById(1203375947135328306L);
//        guild.upsertCommand("sum", "Gives sum pisoses")
//                .addOptions(
//                        new OptionData(OptionType.INTEGER, "number1", "The first number", true)
//                                .setMinValue(1)
//                                .setMaxValue(45),
//                        new OptionData(OptionType.INTEGER, "number2", "The second number", false)
//                                .setMinValue(4)
//                                .setMaxValue(100)
//                        ).queue();
//
//    }

//    @Override
//    public void onReady(@NotNull ReadyEvent readyEvent) {
//        JDA jda = readyEvent.getJDA();
//
//        for (Guild guild : jda.getGuilds())
//            for (TextChannel textChannel : guild.getTextChannelCache())
//                textChannel.sendMessage("Hello").queue();
//    }

//    @Override
//    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
//        if (event.getAuthor().isBot()) return;
//
//        MessageChannel channel = event.getChannel();
//        channel.sendMessage(event.getMessage().getContentRaw()).queue();
//    }

}
