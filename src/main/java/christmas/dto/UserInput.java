package christmas.dto;

import java.util.List;

public class UserInput {
    private final static int MENU_INDEX = 0;
    private final static int QUANTITY_INDEX = 1;
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
        return new UserInput(orders.get(MENU_INDEX), Integer.parseInt(orders.get(QUANTITY_INDEX)));
    }
}