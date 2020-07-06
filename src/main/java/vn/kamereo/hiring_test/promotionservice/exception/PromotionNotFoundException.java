package vn.kamereo.hiring_test.promotionservice.exception;

public class PromotionNotFoundException extends IllegalArgumentException{

    private final String promotionCode;

    public PromotionNotFoundException(final String promotionCode, final String message) {
        super(message);
        this.promotionCode = promotionCode;
    }
}
