package com.dispolitics.server;

import com.jagrosh.jdautilities.oauth2.OAuth2Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscordService {

    @Autowired
    private OAuth2Client oAuth2Client;

    private static final String oAuthManualUrl = "https://discord.com/api/oauth2/authorize?client_id=739059541337178192&redirect_uri=http%3A%2F%2F127.0.0.1%3A8080%2Fauth&response_type=code&scope=identify%20guilds";

    public String generateOAuthUrl() {
        //return oAuth2Client.generateAuthorizationURL(oAuth2Client.generateAuthorizationURL("http://127.0.0.1:8080/auth", Scope.IDENTIFY, Scope.GUILDS));
        return oAuthManualUrl;
    }

}
