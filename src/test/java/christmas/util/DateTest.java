package christmas.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Date Enum Class 테스트 코드")
public class DateTest {
    @ParameterizedTest
    @DisplayName("convertDate() method 테스트")
    @CsvSource(value = {"1, 금요일", "9, 토요일", "17, 일요일", "26, 화요일"})
    public void convertDateTest(int input, String result) {
        // when
        String output = Date.convertDate(input);

        // then
        Assertions.assertThat(output).isEqualTo(result);
    }
}
