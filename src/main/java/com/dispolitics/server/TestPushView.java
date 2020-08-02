package com.dispolitics.server;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.server.VaadinRequest;

public class TestPushView extends UI {

    Text text = new Text("Тут будет обнова");

    @Override
    protected void init(VaadinRequest request) {

    }
}
