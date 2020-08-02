package com.dispolitics.server;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class MessageListener extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {

        Guild guild = event.getGuild();

        for (TestController testController : ServerApplication.testControllers) {
            testController.updateText(event.getMessage().getContentRaw());
        }

        /*try {
            Member user = event.getMember();
            if (!user.getUser().isBot()) {
                VoiceChannel channel = guild.getVoiceChannelsByName(event.getMessage().getContentRaw(), false).get(0);
                guild.moveVoiceMember(user, channel).delay(Duration.ofSeconds(3)).complete();
            }
        } catch (Exception e) {
            TextChannel channel = guild.getTextChannelsByName("general", true).get(0);
            channel.sendMessage("Нет такой страны, создаю канал").complete();
            VoiceChannel newVoiceChannel = guild.createVoiceChannel(event.getMessage().getContentRaw()).complete();

        }*/

    }
}
