package com.dispolitics.server;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.router.Route;

@Route("lobby")
public class LobbyView extends HorizontalLayout {

    public LobbyView() {
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);

        HorizontalLayout middleLayout = new HorizontalLayout();
        middleLayout.setAlignItems(Alignment.CENTER);
        middleLayout.setDefaultVerticalComponentAlignment(Alignment.END);

        VerticalLayout usersLayout = new VerticalLayout();
        usersLayout.getStyle()
                .set("border" , "1px solid #ccc")
                .set("border-radious", "3px");
        usersLayout.setWidth("100%");
        usersLayout.setMaxWidth("450px");

        for (int i = 0; i < 5; i++) {
            usersLayout.add(userLayout("user" + (i + 1)));
        }

        middleLayout.add(usersLayout);

        VerticalLayout countriesLayout = new VerticalLayout();
        countriesLayout.setWidth("15%");
        countriesLayout.getStyle()
                .set("border" , "1px solid #ccc")
                .set("border-radious", "3px");

        RadioButtonGroup<String> countriesRadio = new RadioButtonGroup<>();
        countriesRadio.setItems("Польша", "США", "Россия");
        countriesRadio.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);
        countriesRadio.addValueChangeListener(event -> {
            Notification.show(event.getValue());
        });

        countriesLayout.add(countriesRadio);

        middleLayout.add(countriesLayout);

        add(middleLayout);
    }

    public HorizontalLayout userLayout(String username) {
        HorizontalLayout layout = new HorizontalLayout();

        layout.setWidthFull();

        Label label = new Label(username);
        label.getStyle().set("font-size", "x-large");
        layout.add(label);

        Div div = new Div();
        div.getStyle()
                .set("background", "lightgreen")
                .set("border-radius", "50%");
        div.setWidth("40px");

        layout.add(div);
        layout.expand(label);

        return layout;
    }
}
