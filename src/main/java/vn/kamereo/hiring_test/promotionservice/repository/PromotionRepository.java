package vn.kamereo.hiring_test.promotionservice.repository;

import vn.kamereo.hiring_test.promotionservice.dto.Promotion;

public interface PromotionRepository {
    /**
     * Return promotion object when the given promotionCode is valid for given userId.
     * Otherwise, PromotionNotFoundException will be thrown.
     * @param promotionCode
     * @param userId
     * @return
     */
    Promotion getPromotion(final String promotionCode, final String userId);
}
