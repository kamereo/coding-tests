package vn.kamereo.hiring_test.promotionservice.repository;

import com.google.common.collect.ImmutableSet;
import org.springframework.stereotype.Repository;
import vn.kamereo.hiring_test.promotionservice.dto.Promotion;
import vn.kamereo.hiring_test.promotionservice.exception.PromotionNotFoundException;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

@Repository
public class DummyPromotionRepository implements PromotionRepository {

    private static final ZoneId HO_CHI_MINH_ZONE_ID = ZoneId.of("Asia/Ho_Chi_Minh");

    private static final Set<String> INTERNAL_USERS = ImmutableSet.of(
        "463B0988-3128-430C-9410-0F7E35CCB172"
    );

    @Override
    public Promotion getPromotion(final String promotionCode, final String userId) {
        if ("internalPromo".equals(promotionCode) && INTERNAL_USERS.contains(userId)) {
            return new Promotion(
                "7A273BE7-28F3-46E6-9509-781EB4CB376C",
                "internalPromo",
                50_000L,
                ZonedDateTime.of(2020, 4, 1, 0, 0, 0, 0, HO_CHI_MINH_ZONE_ID),
                ZonedDateTime.of(2020, 9, 1, 0, 0, 0, 0, HO_CHI_MINH_ZONE_ID)
            );
        }

        if ("firstOrderPromo".equals(promotionCode)) {
            return new Promotion(
                "703E34B7-3EFB-438B-88F0-D2B3E2D50021",
                "firstOrderPromo",
                50_000L,
                ZonedDateTime.of(2020, 4, 1, 0, 0, 0, 0, HO_CHI_MINH_ZONE_ID),
                ZonedDateTime.of(2050, 4, 1, 0, 0, 0, 0, HO_CHI_MINH_ZONE_ID)
            );
        }

        throw new PromotionNotFoundException(promotionCode, "Given promotion code doesn't exist");
    }
}
