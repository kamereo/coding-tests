package vn.kamereo.hiring_test.promotionservice;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;
import io.grpc.util.TransmitStatusRuntimeExceptionInterceptor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vn.kamereo.hiring_test.PromotionServiceGrpc;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class MainApplication implements CommandLineRunner {

    private final PromotionServiceGrpc.PromotionServiceImplBase promotionService;

    public MainApplication(final PromotionServiceGrpc.PromotionServiceImplBase promotionService) {
        this.promotionService = promotionService;
    }

    public static void main(final String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Override
    public void run(final String... args) throws IOException {
        final Server server = ServerBuilder.forPort(8888)
            .addService(promotionService)
            .addService(ProtoReflectionService.newInstance())
            .intercept(TransmitStatusRuntimeExceptionInterceptor.instance())
            .build();
        server.start();

        try {
            server.awaitTermination(3, TimeUnit.SECONDS);
        } catch (final InterruptedException e) {
            server.shutdownNow();
        }
    }
}
