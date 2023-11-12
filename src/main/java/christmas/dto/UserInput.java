package christmas.dto;

import java.util.List;

public class UserInput {
    private String menu;
    private int quantity;

    public UserInput(String menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public String getMenu() {
        return this.menu;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public static UserInput toDto(List<String> orders) {
        return new UserInput(orders.get(0), Integer.parseInt(orders.get(1)));
    }
}