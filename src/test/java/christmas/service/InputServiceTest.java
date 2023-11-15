package christmas.service;

import christmas.dto.Benefit;
import christmas.dto.EventResult;
import christmas.dto.UserInput;
import christmas.factory.BenefitFactory;
import christmas.factory.EventResultFactory;
import christmas.factory.UserInputFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("EventService Class 테스트 코드")
public class InputServiceTest {
    private final static String menu = "크리스마스파스타";
    private final static int quantity = 10;
    private EventService eventService;

    @BeforeEach
    public void initTest() {
        eventService = new EventService();
    }

    @ParameterizedTest
    @DisplayName("getEventResult() method 테스트")
    @MethodSource(value = "getEventResultExamples")
    public void getEventResultTest(int input, EventResult output) {
        // when
        EventResult resultInstance = eventService.getEventResult(input);

        // then
        assertAll(
                () -> assertThat(resultInstance.getDate()).isEqualTo(output.getDate()),
                () -> assertThat(resultInstance.isWeekendDiscount()).isEqualTo(output.isWeekendDiscount()),
                () -> assertThat(resultInstance.isHolidayDiscount()).isEqualTo(output.isHolidayDiscount()),
                () -> assertThat(resultInstance.isSpecialDiscount()).isEqualTo(output.isSpecialDiscount())
        );
    }

    @ParameterizedTest
    @DisplayName("getTotalBenefit() method 테스트")
    @MethodSource(value = "getTotalBenefitExamples")
    public void getTotalBenefitTest(EventResult input, Benefit output) {
        // given
        List<UserInput> userInputs = UserInputFactory.getUserInputs(menu, quantity);

        // when
        Benefit outputInstance = eventService.getTotalBenefit(userInputs, input);

        // then
        assertAll(
                () -> assertThat(outputInstance.getInitialCost()).isEqualTo(output.getInitialCost()),
                () -> assertThat(outputInstance.getTotalDiscountValue()).isEqualTo(output.getTotalDiscountValue()),
                () -> assertThat(outputInstance.getDayDiscountValue()).isEqualTo(output.getDayDiscountValue()),
                () -> assertThat(outputInstance.getWeekendDiscountValue()).isEqualTo(output.getWeekendDiscountValue()),
                () -> assertThat(outputInstance.getHolidayDiscountValue()).isEqualTo(output.getHolidayDiscountValue()),
                () -> assertThat(outputInstance.getFreebie()).isEqualTo(output.getFreebie()),
                () -> assertThat(outputInstance.getTotalResult()).isEqualTo(output.getTotalResult())
        );
    }

    private static Stream<Arguments> getEventResultExamples() {
        return Stream.of(
                Arguments.of(7, EventResultFactory.EVENT_RESULT_1.getInstance()),
                Arguments.of(25, EventResultFactory.EVENT_RESULT_2.getInstance()),
                Arguments.of(30, EventResultFactory.EVENT_RESULT_3.getInstance())
        );
    }

    private static Stream<Arguments> getTotalBenefitExamples() {
        return Stream.of(
                Arguments.of(EventResultFactory.EVENT_RESULT_1.getInstance(), BenefitFactory.BENEFIT_1.getInstance()),
                Arguments.of(EventResultFactory.EVENT_RESULT_2.getInstance(), BenefitFactory.BENEFIT_2.getInstance()),
                Arguments.of(EventResultFactory.EVENT_RESULT_3.getInstance(), BenefitFactory.BENEFIT_3.getInstance())
        );
    }
}
