package vn.kamereo.hiring_test.promotionservice.dto;

import java.time.ZonedDateTime;
import java.util.Objects;

public class Promotion {

    private final String id;

    private final String code;

    private final Long discountPrice;

    // inclusive
    private final ZonedDateTime validPeriodStart;

    // exclusive
    private final ZonedDateTime validPeriodEnd;

    public Promotion(
        final String id,
        final String code,
        final Long discountPrice,
        final ZonedDateTime validPeriodStart,
        final ZonedDateTime validPeriodEnd
    ) {
        this.id = id;
        this.code = code;
        this.discountPrice = discountPrice;
        this.validPeriodStart = validPeriodStart;
        this.validPeriodEnd = validPeriodEnd;
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public Long getDiscountPrice() {
        return discountPrice;
    }

    public ZonedDateTime getValidPeriodStart() {
        return validPeriodStart;
    }

    public ZonedDateTime getValidPeriodEnd() {
        return validPeriodEnd;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Promotion)) {
            return false;
        }
        final Promotion promotion = (Promotion) o;
        return Objects.equals(getId(), promotion.getId()) &&
            Objects.equals(getCode(), promotion.getCode()) &&
            Objects.equals(getDiscountPrice(), promotion.getDiscountPrice()) &&
            Objects.equals(getValidPeriodStart(), promotion.getValidPeriodStart()) &&
            Objects.equals(getValidPeriodEnd(), promotion.getValidPeriodEnd());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCode(), getDiscountPrice(), getValidPeriodStart(), getValidPeriodEnd());
    }
}
