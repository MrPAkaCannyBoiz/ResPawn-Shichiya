package org.example.respawnmarket.Service;

import com.respawnmarket.LoginResellerRequest;
import com.respawnmarket.LoginResellerResponse;
import com.respawnmarket.LoginResellerServiceGrpc;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import org.example.respawnmarket.dtos.ResellerLoginRequestDto;
import org.example.respawnmarket.dtos.ResellerLoginResponseDto;
import org.springframework.stereotype.Service;

@Service
public class LoginResellerGrpcService extends LoginResellerServiceGrpc.LoginResellerServiceImplBase {

    private final ResellerLoginService resellerLoginService;

    public LoginResellerGrpcService(ResellerLoginService resellerLoginService) {
        this.resellerLoginService = resellerLoginService;
    }

    @Override
    public void loginReseller(LoginResellerRequest request,
                              StreamObserver<LoginResellerResponse> responseObserver) {

        try {
            // convert proto -> DTO
            ResellerLoginRequestDto dto =
                    new ResellerLoginRequestDto(request.getUsername(), request.getPassword());

            // call Java login service
            ResellerLoginResponseDto result = resellerLoginService.login(dto);

            // convert DTO -> proto response
            LoginResellerResponse response = LoginResellerResponse.newBuilder()
                    .setId(result.getId())
                    .setUsername(result.getUsername())
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
        catch (Exception e) {
            responseObserver.onError(
                    Status.INVALID_ARGUMENT
                            .withDescription(e.getMessage())
                            .asRuntimeException()
            );
        }

    }
}