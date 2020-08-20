package com.dispolitics.server;

import com.jagrosh.jdautilities.oauth2.OAuth2Client;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.security.auth.login.LoginException;

@Configuration
@ConfigurationProperties(prefix = "discord")
public class DiscordConfiguration {

    private long clientId;
    private String clientSecret;
    private String botToken;

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getBotToken() {
        return botToken;
    }

    public void setBotToken(String botToken) {
        this.botToken = botToken;
    }

    @Bean
    @Scope("singleton")
    public JDA discordJDA() {
        try {
            return JDABuilder.createDefault(botToken)
                    .addEventListeners(new MessageListener())
                    .build();
        } catch (LoginException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Bean
    public OAuth2Client oAuth2Client() {
        return new OAuth2Client.Builder()
                .setClientSecret(clientSecret)
                .setClientId(clientId)
                .build();
    }

}
