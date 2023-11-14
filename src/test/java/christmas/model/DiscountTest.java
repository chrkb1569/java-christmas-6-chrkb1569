package christmas.model;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class DiscountTest {
    private final int INITIAL_VALUE = 0;
    private final int WEEKEND_DISCOUNT = 2_023;
    private final int HOLIDAY_DISCOUNT = 2_023;
    private final int SPECIAL_DISCOUNT = 1_000;
    private Discount discount;

    @BeforeEach
    public void initTest() {
        discount = new Discount();
    }

    @Nested
    @DisplayName("dayDiscount() method 테스트")
    public class dayDiscountTest {
        private final int BEFORE_CHRISTMAS = 5;
        private final int AFTER_CHRISTMAS = 31;

        @Test
        @DisplayName("이벤트 기간이 아니기 때문에 크리스마스 디데이 할인을 받지 못한다.")
        public void excludeFromDiscountByInvalidDate() {
            // when
            int dayDiscount = discount.dayDiscount(AFTER_CHRISTMAS);

            // then
            assertThat(dayDiscount).isEqualTo(INITIAL_VALUE);
        }

        @Test
        @DisplayName("크리스마스 디데이 할인을 받는다.")
        public void getDiscountByValidDate() {
            // when
            int dayDiscount = discount.dayDiscount(BEFORE_CHRISTMAS);

            // then
            assertThat(dayDiscount).isNotEqualTo(INITIAL_VALUE);
        }
    }

    @Nested
    @DisplayName("freebieItem() method 테스트")
    public class freebieItemTest {
        private final int VALID_COST = 150_000;
        private final int INVALID_COST = 100_000;
        private final int FREE_BIE_COST = 50_000;

        @Test
        @DisplayName("총 주문 금액이 특정 금액에 도달하지 않아 증정품을 받지 못한다.")
        public void excludeFromDiscountByPurchaseCost() {
            // when
            boolean result = discount.freebieItem(INVALID_COST, FREE_BIE_COST);

            // then
            assertAll(
                    () -> assertThat(result).isFalse(),
                    () -> assertThat(discount.getDisCountValue()).isEqualTo(INITIAL_VALUE)
            );
        }

        @Test
        @DisplayName("총 주문 금액이 특정 금액에 도달하여 증정품을 받는다.")
        public void getDiscountByPurchaseCost() {
            // when
            boolean result = discount.freebieItem(VALID_COST, FREE_BIE_COST);

            // then
            assertAll(
                    () -> assertThat(result).isTrue(),
                    () -> assertThat(discount.getDisCountValue()).isNotEqualTo(INITIAL_VALUE)
            );
        }
    }

    @Test
    @DisplayName("getDisCountValue() method 테스트")
    public void getDisCountValueTest() {
        // when
        int disCountValue = discount.getDisCountValue();

        // then
        assertThat(disCountValue).isEqualTo(INITIAL_VALUE);
    }

    @Test
    @DisplayName("weekendDiscount() method 테스트")
    public void weekendDiscountTest() {
        // given
        int dessertCount = 10;

        // when
        int weekendDiscount = discount.weekendDiscount(dessertCount);

        // then
        assertThat(weekendDiscount).isEqualTo(WEEKEND_DISCOUNT * dessertCount);
    }

    @Test
    @DisplayName("holidayDiscount() method 테스트")
    public void holidayDiscountTest() {
        // given
        int mainCount = 10;

        // when
        int holidayDiscount = discount.holidayDiscount(mainCount);

        // then
        assertThat(holidayDiscount).isEqualTo(HOLIDAY_DISCOUNT * mainCount);
    }

    @Test
    @DisplayName("specialDiscount() method 테스트")
    public void specialDiscountTest() {
        // when
        int specialDiscount = discount.specialDiscount();

        // then
        assertThat(specialDiscount).isEqualTo(SPECIAL_DISCOUNT);
    }
}
