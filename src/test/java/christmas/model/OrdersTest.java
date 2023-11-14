package christmas.model;

import christmas.dto.UserInput;
import christmas.factory.UserInputFactory;
import christmas.util.Menu;
import christmas.util.Type;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

@DisplayName("Orders Domain 테스트 코드")
public class OrdersTest {
    private final int MENU_QUANTITY = 10;

    @ParameterizedTest
    @DisplayName("getQuantityByType() method 테스트")
    @ValueSource(strings = {"양송이수프", "티본스테이크", "초코케이크"})
    public void getQuantityByTypeTest(String menu) {
        // given
        List<UserInput> userInputs = UserInputFactory.getUserInputs(menu, MENU_QUANTITY);
        Type type = Menu.getTypeByName(menu);
        Orders orders = new Orders(userInputs);

        // then
        int quantity = orders.getQuantityByType(type);

        // then
        Assertions.assertThat(quantity).isEqualTo(MENU_QUANTITY);
    }

    @ParameterizedTest
    @DisplayName("getInitialCost() method 테스트")
    @ValueSource(strings = {"타파스", "바비큐립", "샴페인"})
    public void getInitialCostTest(String menu) {
        // given
        List<UserInput> userInputs = UserInputFactory.getUserInputs(menu, MENU_QUANTITY);
        int price = Menu.getPriceByName(menu);
        Orders orders = new Orders(userInputs);

        // then
        int initialCost = orders.getInitialCost();

        // then
        Assertions.assertThat(initialCost).isEqualTo(price * MENU_QUANTITY);
    }
}
