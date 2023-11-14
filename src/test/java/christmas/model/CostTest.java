package christmas.model;

import christmas.dto.UserInput;
import christmas.factory.UserInputFactory;
import christmas.util.Menu;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

@DisplayName("Cost Domain 테스트 코드")
public class CostTest {
    private int MENU_QUANTITY = 10;

    @ParameterizedTest
    @DisplayName("getInitialCost() method 테스트")
    @ValueSource(strings = {"양송이수프", "티본스테이크", "초코케이크"})
    public void getInitialCostTest(String menuName) {
        // given
        List<UserInput> userInputs = UserInputFactory.getUserInputs(menuName, MENU_QUANTITY);
        Cost cost = new Cost(userInputs);
        int price = Menu.getPriceByName(menuName);

        // when
        int initialCost = cost.getInitialCost();

        // then
        Assertions.assertThat(initialCost).isEqualTo(MENU_QUANTITY * price);
    }
}
