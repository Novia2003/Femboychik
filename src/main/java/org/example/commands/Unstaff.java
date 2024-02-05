package org.example.commands;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.example.ICommand;

import java.util.List;

public class Unstaff implements ICommand {
    @Override
    public String getName() {
        return "unstaff";
    }

    @Override
    public String getDescription() {
        return "Will remove staff";
    }

    @Override
    public List<OptionData> getOptions() {
        return null;
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        Member member = event.getMember();
        Guild guild = event.getGuild();
        Role role = guild.getRoleById(1203646051555217428L);
        guild.removeRoleFromMember(member, role).queue();
        event.reply("Role removed").queue();
    }
}
