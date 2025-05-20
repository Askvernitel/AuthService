package com.judge.auth.grpc;

import com.judge.auth.controllers.AuthController;
import com.judge.auth.grpc.Auth.AuthRequest;
import com.judge.auth.grpc.Auth.AuthResponse;
import com.judge.auth.grpc.AuthServiceGrpc.AuthServiceImplBase;

import com.judge.auth.services.security.jwt.JWTService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * AuthService
 */
@GrpcService
public class AuthServiceImpl extends AuthServiceImplBase {
  @Autowired
  AuthController authController;
  @Autowired
  JWTService jwtService;

  private void handleErrorResponse(StreamObserver<AuthResponse> responseObserver) {
    AuthResponse auth = AuthResponse.newBuilder().setOk(false).build();
    responseObserver.onNext(auth);
    responseObserver.onCompleted();
  }

  private void handleSuccessResponse(StreamObserver<AuthResponse> responseObserver) {
    AuthResponse auth = AuthResponse.newBuilder().setOk(true).build();
    responseObserver.onNext(auth);
    responseObserver.onCompleted();
  }

  @Override
  public void auth(AuthRequest request, StreamObserver<AuthResponse> responseObserver) {
    // authController.login()
    String token = request.getToken();
    try {
      jwtService.isValidJWT(token);
      System.out.println("Cool It Is valid ");
    } catch (Exception e) {
      System.out.println(e.getMessage());
      System.out.println("NOT VALID :(");
      handleErrorResponse(responseObserver);
      return;
    }
    handleSuccessResponse(responseObserver);
  }

}
