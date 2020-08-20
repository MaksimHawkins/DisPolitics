package com.dispolitics.server;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.DetachEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import org.springframework.beans.factory.annotation.Autowired;

@Route("")
@SpringComponent
public class MainView extends VerticalLayout {

    @Autowired
    DiscordService discordService;

    Anchor discordLink;
    Button discordAuth;

    public MainView() {
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setAlignItems(Alignment.CENTER);

        discordAuth = new Button("Авторизоваться с помощью Discord", new Image("discord32x32.png", ""));
        discordAuth.addThemeVariants(ButtonVariant.LUMO_PRIMARY); //Белый текст
        discordAuth.getStyle().set("background", "#7289da"); //Фиолетовый фон
        discordAuth.setAutofocus(true);

        discordLink = new Anchor("", discordAuth);

        add(discordLink);
    }

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);

        discordLink.setHref(discordService.generateOAuthUrl());
    }

    @Override
    protected void onDetach(DetachEvent detachEvent) {

    }
}
