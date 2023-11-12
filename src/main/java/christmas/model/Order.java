package christmas.model;

import christmas.dto.UserInput;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Order {
    private Map<String, Integer> orders;

    public Order(List<UserInput> inputValues) {
        orders = initOrder(inputValues);
    }

    public int getQuantity(String menu) {
        return this.orders.get(menu);
    }

    private Map<String, Integer> initOrder(List<UserInput> inputValues) {
        Map<String, Integer> orders = new ConcurrentHashMap<>();

        for(UserInput inputValue : inputValues) {
            orders.put(inputValue.getMenu(), inputValue.getQuantity());
        }

        return orders;
    }
}