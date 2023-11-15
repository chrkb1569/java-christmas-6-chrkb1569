package christmas;

import christmas.controller.EventConfiguration;
import christmas.controller.EventController;

public class Application {
    public static void main(String[] args) {
        EventConfiguration eventConfiguration = new EventConfiguration();
        EventController eventController = eventConfiguration.eventController();
        eventController.doProcess();
    }
}
