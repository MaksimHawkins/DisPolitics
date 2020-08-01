package com.dispolitics.server;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.security.auth.login.LoginException;

@SpringBootApplication
public class ServerApplication {

    private static JDA jda;

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);

        try {
            jda = JDABuilder.createDefault("NzM5MDU5NTQxMzM3MTc4MTky.XyU81Q.stPRkENShdodBZJGK4UC9yf5fVM")
                    .addEventListeners(new MessageListener())
                    .build();
        } catch (LoginException e) {
            e.printStackTrace();
            return;
        }
	}

}
