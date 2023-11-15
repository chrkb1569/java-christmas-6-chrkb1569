package christmas.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Menu Enum Class 테스트 코드")
public class MenuTest {
    @Nested
    @DisplayName("findMenu() method 테스트")
    public class findMenuTest {
        @ParameterizedTest
        @DisplayName("존재하지 않는 메뉴는 찾을 수 없다.")
        @ValueSource(strings = {"error1", "error2", "error3"})
        public void fail(String errorMenu) {
            // when
            boolean result = Menu.findMenu(errorMenu);

            // then
            Assertions.assertThat(result).isFalse();
        }

        @ParameterizedTest
        @DisplayName("메뉴의 존재를 확인한다.")
        @ValueSource(strings = {"아이스크림", "해산물파스타", "제로콜라"})
        public void success(String menu) {
            // when
            boolean result = Menu.findMenu(menu);

            // then
            Assertions.assertThat(result).isTrue();
        }
    }

    @ParameterizedTest
    @DisplayName("getPriceByName() method 테스트")
    @CsvSource(value = {"양송이수프, 6000", "타파스, 5500", "해산물파스타, 35000", "초코케이크, 15000", "레드와인, 60000"})
    public void getPriceByNameTest(String menu, int price) {
        // when
        int resultPrice = Menu.getPriceByName(menu);

        // then
        Assertions.assertThat(resultPrice).isEqualTo(price);
    }

    @ParameterizedTest
    @DisplayName("getTypeByName() method 테스트")
    @CsvSource(value = {"시저샐러드, APPETIZER", "티본스테이크, MAIN_MENU", "초코케이크, DESSERT", "제로콜라, BEVERAGE", "샴페인, BEVERAGE"})
    public void getTypeByNameTest(String menu, Type type) {
        // when
        Type resultType = Menu.getTypeByName(menu);

        // then
        Assertions.assertThat(resultType).isEqualTo(type);
    }
}
