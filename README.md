# KAMEREO Coding Test

# Question 1

# Question 2
At KAMEREO, we internally use gRPC between the inter-service communication. 
Imagine we introduce a new service to manage promotion code. You can find the API definition in _promotion_service.proto_
under `src/main/proto/kamereo/hiring_test`. _GetPromotion_ API is responsible for returning the matching promotion with 
the given _promotion_code_ and _user_id_.
When there is no valid promotion found, the API should return [NOT_FOUND](https://grpc.github.io/grpc-java/javadoc/io/grpc/Status.html#NOT_FOUND).
Please implement `vn.kamereo.hiring_test.promotionservice.PromotionServiceGrpcImpl#getPromotion` using
`vn.kamereo.hiring_test.promotionservice.repository.DummyPromotionRepository#getPromotion` method.

useful tools:
- https://github.com/fullstorydev/grpcurl

## Evaluation Points
- Code Quality
- Abstraction
- Test Coverage
