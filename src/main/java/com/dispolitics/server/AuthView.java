package com.dispolitics.server;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;

import java.util.List;
import java.util.Map;

@Route("auth")
public class AuthView extends VerticalLayout implements HasUrlParameter<String> {

    Text text = new Text("Тут будет имя");

    public AuthView() {
        setAlignItems(Alignment.CENTER);
        setSizeFull();
        add(text);
    }

    @Override
    public void setParameter(BeforeEvent beforeEvent, @OptionalParameter String param) {
        Location location = beforeEvent.getLocation();
        Map<String, List<String>> parameters = location.getQueryParameters().getParameters();
        try {
            text.setText(new ProfileGetter().getProfile(parameters.get("code").get(0)));
        } catch (NullPointerException e) {

        }

    }
}
