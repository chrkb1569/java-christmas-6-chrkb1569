package christmas.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class GameUtilTest {
    @ParameterizedTest
    @DisplayName("splitByComma() method 테스트")
    @MethodSource(value = "getSplitByCommaExamples")
    public void splitByCommaTest(String input, List<String> output) {
        // when
        List<String> result = GameUtil.splitByComma(input);

        // then
        Assertions.assertThat(result).isEqualTo(output);
    }

    @ParameterizedTest
    @DisplayName("splitByHyphen() method 테스트")
    @MethodSource(value = "getSplitByHyphenExamples")
    public void splitByHyphenTest(String input, List<String> output) {
        // when
        List<String> result = GameUtil.splitByHyphen(input);

        // when
        Assertions.assertThat(result).isEqualTo(output);
    }

    private static Stream<Arguments> getSplitByCommaExamples() {
        return Stream.of(
                Arguments.of("1,2,3,4,5", List.of("1","2","3","4","5")),
                Arguments.of("123,4,56,7,8", List.of("123","4","56","7","8"))
        );
    }

    private static Stream<Arguments> getSplitByHyphenExamples() {
        return Stream.of(
                Arguments.of("1-2-3-4-5", List.of("1", "2", "3", "4", "5")),
                Arguments.of("123-55-87-0-24", List.of("123", "55", "87", "0", "24"))
        );
    }
}
