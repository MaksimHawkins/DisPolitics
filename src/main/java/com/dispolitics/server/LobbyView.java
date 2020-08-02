package com.dispolitics.server;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("lobby")
public class LobbyView extends HorizontalLayout {

    public LobbyView() {
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        VerticalLayout usersLayout = new VerticalLayout();
        usersLayout.getStyle()
                .set("border" , "1px solid #ccc")
                .set("border-radious", "3px");
        usersLayout.setWidth("25%");

        for (int i = 0; i < 5; i++) {
            usersLayout.add(userLayout("user" + (i + 1)));
        }

        add(usersLayout);
    }

    public HorizontalLayout userLayout(String username) {
        HorizontalLayout layout = new HorizontalLayout();

        layout.setWidthFull();

        Label label = new Label(username);
        label.getStyle().set("font-size", "x-large");
        layout.add(label);

        HorizontalLayout div = new HorizontalLayout();
        div.getStyle()
                .set("background", "lightgreen")
                .set("border-radius", "50%");
        div.setWidth("40px");
        div.setAlignSelf(Alignment.END);

        layout.add(div);

        return layout;
    }
}
