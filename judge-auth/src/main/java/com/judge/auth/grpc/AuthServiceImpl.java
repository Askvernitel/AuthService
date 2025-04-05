package com.judge.auth.grpc;

import com.judge.auth.controllers.AuthController;
import com.judge.auth.grpc.Auth.AuthRequest;
import com.judge.auth.grpc.Auth.AuthResponse;
import com.judge.auth.grpc.AuthServiceGrpc.AuthServiceImplBase;

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
  @Override
  public void auth(AuthRequest request, StreamObserver<AuthResponse> responseObserver) {
    //authController.login()

    AuthResponse auth = AuthResponse.newBuilder().setOk(true).build();
    responseObserver.onNext(auth);
    responseObserver.onCompleted();
  }
}
