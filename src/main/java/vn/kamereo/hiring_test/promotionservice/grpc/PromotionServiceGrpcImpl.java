package vn.kamereo.hiring_test.promotionservice.grpc;

import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;
import vn.kamereo.hiring_test.GetPromotionRequest;
import vn.kamereo.hiring_test.GetPromotionResponse;
import vn.kamereo.hiring_test.PromotionServiceGrpc;

@Service
public class PromotionServiceGrpcImpl extends PromotionServiceGrpc.PromotionServiceImplBase {

    @Override
    public void getPromotion(
        final GetPromotionRequest request,
        final StreamObserver<GetPromotionResponse> responseObserver
    ) {
        // implement this method
        responseObserver.onError(Status.UNIMPLEMENTED.asRuntimeException());
    }
}
