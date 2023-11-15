package christmas.checker;

import christmas.exception.NotValidInputException;
import christmas.view.checker.InputValueChecker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static christmas.exception.EventExceptionMessage.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("InputValueChecker Class 테스트 코드")
public class InputValueCheckerTest {
    private InputValueChecker inputValueChecker;

    @BeforeEach
    public void initTest() {
        inputValueChecker = new InputValueChecker();
    }

    @Nested
    @DisplayName("사용자로부터 입력 받는 날짜의 유효성을 검사한다.")
    public class checkDateValidationTest {
        @ParameterizedTest
        @DisplayName("수를 입력하지 않는 경우, 오류를 반환한다.")
        @ValueSource(strings = {"hello", "test test", "2-3", "", " "})
        public void throwExceptionByInputFormat(String input) {
            // when - then
            assertThatThrownBy(() -> inputValueChecker.checkDateValidation(input))
                    .isInstanceOf(NotValidInputException.class)
                    .hasMessage(NOT_VALID_DATE.getMessage());
        }

        @ParameterizedTest
        @DisplayName("유효하지 않은 범위의 날짜를 입력하는 경우, 오류를 반환한다.")
        @ValueSource(strings = {"-1", "35", "77", "1000", "-142"})
        public void throwExceptionByNumberRange(String input) {
            // when - then
            assertThatThrownBy(() -> inputValueChecker.checkDateValidation(input))
                    .isInstanceOf(NotValidInputException.class)
                    .hasMessage(NOT_VALID_DATE.getMessage());
        }

        @ParameterizedTest
        @DisplayName("날짜 유효성 검사에 통과한다.")
        @ValueSource(strings = {"1", "5", "15", "22", "30"})
        public void successCheckValidation(String input) {
            // when - then
            assertDoesNotThrow(() -> inputValueChecker.checkDateValidation(input));
        }
    }

    @Nested
    @DisplayName("사용자로부터 입력 받는 메뉴의 유효성을 검사한다.")
    public class checkOrderValidationTest {
        @ParameterizedTest
        @DisplayName("주문 형식에 일치하지 않는 경우, 오류를 반환한다.")
        @ValueSource(strings = {"주문-!!", "error", " ", "", "234"})
        public void throwExceptionByOrderFormat(String input) {
            // when - then
            assertThatThrownBy(() -> inputValueChecker.checkOrderValidation(input))
                    .isInstanceOf(NotValidInputException.class)
                    .hasMessage(NOT_VALID_ORDER.getMessage());
        }

        @ParameterizedTest
        @DisplayName("존재하지 않는 메뉴를 주문하는 경우, 오류를 반환한다.")
        @ValueSource(strings = {"실론티-1", "닥터페퍼-2", "민트초코-3", "솔의눈-4", "데자와-5"})
        public void throwExceptionByInvalidMenu(String input) {
            // when - then
            assertThatThrownBy(() -> inputValueChecker.checkOrderValidation(input))
                    .isInstanceOf(NotValidInputException.class)
                    .hasMessage(NOT_VALID_ORDER.getMessage());
        }

        @ParameterizedTest
        @DisplayName("메뉴를 중복하여 주문하는 경우, 오류를 반환한다.")
        @ValueSource(strings = {"바비큐립-1, 바비큐립-2, 시저샐러드-3", "시저샐러드-1, 시저샐러드-2, 시저샐러드-3", "크리스마스파스타-1, 크리스마스파스타-5"})
        public void throwExceptionByDuplicatedMenu(String input) {
            // when - then
            assertThatThrownBy(() -> inputValueChecker.checkOrderValidation(input))
                    .isInstanceOf(NotValidInputException.class)
                    .hasMessage(NOT_VALID_ORDER.getMessage());
        }

        @ParameterizedTest
        @DisplayName("주문한 메뉴의 수량이 너무 많은 경우, 오류를 반환한다.")
        @ValueSource(strings = {"바비큐립-50", "바비큐립-5,크리스마스파스타-5,아이스크림-10,양송이수프-5", "제로콜라-10,레드와인-10,티본스테이크-10"})
        public void throwExceptionByOrderQuantity(String input) {
            // when - then
            assertThatThrownBy(() -> inputValueChecker.checkOrderValidation(input))
                    .isInstanceOf(NotValidInputException.class)
                    .hasMessage(NOT_VALID_ORDER.getMessage());
        }

        @ParameterizedTest
        @DisplayName("주문 유효성 검사에 성공한다.")
        @ValueSource(strings = {"바비큐립-1,크리스마스파스타-2,레드와인-2", "아이스크림-20", "제로콜라-5"})
        public void successCheckValidation(String input) {
            // when - then
            assertDoesNotThrow(() -> inputValueChecker.checkOrderValidation(input));
        }
    }
}
