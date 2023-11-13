package christmas.model;

import christmas.dto.UserInput;
import christmas.util.Menu;

import java.util.List;

public class Cost {
    private int initialCost;

    public Cost(List<UserInput> inputValues) {
        this.initialCost = getCost(inputValues);
    }

    public int getInitialCost() {
        return this.initialCost;
    }

    private int getCost(List<UserInput> inputValues) {
        int cost = 0;

        for(UserInput inputValue : inputValues) {
            String menu = inputValue.getMenu();
            int quantity = inputValue.getQuantity();

            cost += Menu.getPriceByName(menu) * quantity;
        }

        return cost;
    }
}
