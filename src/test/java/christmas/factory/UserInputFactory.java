package christmas.factory;

import christmas.dto.UserInput;

import java.util.LinkedList;
import java.util.List;

public class UserInputFactory {
    public static List<UserInput> getUserInputs(String menu, int quantity) {
        List<UserInput> userInputs = new LinkedList<>();
        userInputs.add(new UserInput(menu, quantity));

        return userInputs;
    }
}