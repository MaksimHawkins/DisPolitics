package com.dispolitics.server;


import com.vaadin.flow.component.*;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Input;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.router.Route;

@Push
@Route("test")
public class TestController extends VerticalLayout {

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

        add(input);
        add(button);
        add(cities);
        add(text);
    }

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        //new TestThread(attachEvent.getUI(), this).start();
        this.ui = attachEvent.getUI();
        ServerApplication.testControllers.add(this);
    }

    @Override
    protected void onDetach(DetachEvent detachEvent) {
        ServerApplication.testControllers.remove(this);
    }

    public void updateText(String text) {
        this.ui.access(() -> {
            this.text.setText(text);
        });
    }

    private class TestThread extends Thread {
        private UI ui;
        private TestController view;

        private int j;

        public TestThread(UI ui, TestController view) {
            this.ui = ui;
            this.view = view;
        }

        @Override
        public void run() {
            try {
                for (j = 0; j < 10; j++) {
                    Thread.sleep(1000);
                    ui.access(() -> {
                        view.text.setText("Так-то " + j);
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
