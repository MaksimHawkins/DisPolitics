package com.dispolitics.server;


import com.dispolitics.server.models.City;
import com.dispolitics.server.models.CityRepository;
import com.dispolitics.server.models.CityRepositoryImpl;
import com.jagrosh.jdautilities.oauth2.Scope;
import com.vaadin.flow.component.*;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Input;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.Router;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.RouteRegistry;
import com.vaadin.flow.spring.annotation.SpringComponent;
import org.apache.catalina.Server;
import org.springframework.beans.factory.annotation.Autowired;

@Push
@Route("test")
public class TestController extends VerticalLayout {

    @Autowired
    CityRepositoryImpl cityRepository;

    int i = 0;

    public Text text = new Text("Тут будет обнова...");

    public UI ui;

    public TestController() {

        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        HorizontalLayout cities = new HorizontalLayout();

        add(new H2("Введи название города,\nчтобы добавить его в список"));
        Input input = new Input();
        Button button = new Button("Добавить город");
        button.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> buttonClickEvent) {
                Text text = new Text(input.getValue());
                VerticalLayout layout = new VerticalLayout(text);
                layout.setMargin(true);

                cities.add(layout);


                Notification.show("Добавлен город");
            }
        });

        for (City city : cityRepository.getAllCities()) {
            Text text = new Text(input.getValue());
            VerticalLayout layout = new VerticalLayout(text);
            layout.setMargin(true);

            cities.add(city.getName());
        }

        add(input);
        add(button);
        add(cities);
        add(text);
    }

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        //new TestThread(attachEvent.getUI(), this).start();
        this.ui = attachEvent.getUI();
        //ServerApplication.testControllers.add(this);
    }

    @Override
    protected void onDetach(DetachEvent detachEvent) {
        //ServerApplication.testControllers.remove(this);
    }

    public void updateText(String text) {
        this.ui.access(() -> {
            this.text.setText(text);
        });
    }
}
