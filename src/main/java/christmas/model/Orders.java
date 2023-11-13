package christmas.model;

import christmas.dto.UserInput;
import christmas.util.Menu;
import christmas.util.Type;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Orders {
    private Map<Type, Order> orders;
    private Cost cost;

    public Orders(List<UserInput> inputValues) {
        orders = getOrders(inputValues);
        cost = new Cost(inputValues);
    }

    public int getQuantityByType(Type type) {
        if(!orders.containsKey(type)) return 0;
        return this.orders.get(type).getQuantity();
    }

    public int getInitialCost() {
        return this.cost.getInitialCost();
    }

    private Map<Type, Order> getOrders(List<UserInput> inputValues) {
        Map<Type, Order> orders = new ConcurrentHashMap<>();

        for(UserInput inputValue : inputValues) {
            Type type = Menu.getTypeByName(inputValue.getMenu());
            int quantity = inputValue.getQuantity();

            orders = putTypeValue(orders, type, quantity);
        }

        return orders;
    }

    private Map<Type, Order> putTypeValue(Map<Type, Order> orders, Type type, int quantity) {
        if(orders.containsKey(type)) {
            Order order = orders.get(type);
            orders.put(type, new Order(order.getQuantity() + quantity));

            return orders;
        }

        orders.put(type, new Order(quantity));
        return orders;
    }
}