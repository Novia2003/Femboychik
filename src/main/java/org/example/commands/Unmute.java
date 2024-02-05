package org.example.commands;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.example.ICommand;

import java.util.ArrayList;
import java.util.List;

public class Unmute implements ICommand {
    @Override
    public String getName() {
        return "unmute";
    }

    @Override
    public String getDescription() {
        return "Will unmute a user";
    }

    @Override
    public List<OptionData> getOptions() {
        List<OptionData> options = new ArrayList<>();
        options.add(new OptionData(OptionType.USER, "unmuted", "The user to ummute", true));
        return options;
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        Member member = event.getMember();
        Guild guild = event.getGuild();
        Role role = guild.getRoleById(1203646051555217428L);
        if (member.getRoles().contains(role)) {
            Member mutedMember = event.getOption("unmuted").getAsMember();
            Role muteRole = guild.getRoleById(1203676374259204207L);
            Role defaultRole = guild.getRoleById(1203676214800420934L);
            guild.removeRoleFromMember(mutedMember, muteRole).queue();
            guild.addRoleToMember(mutedMember, defaultRole).queue();
            event.reply("Unmute member").queue();
        } else
            event.reply("You do not have the required permission to execute this command").queue();
    }
}
