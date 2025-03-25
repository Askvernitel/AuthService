package com.judge.auth.grpc;

import com.judge.auth.grpc.Auth.AuthRequest;
import com.judge.auth.grpc.Auth.AuthResponse;
import com.judge.auth.grpc.AuthServiceGrpc.AuthServiceImplBase;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

/**
 * AuthService
 */
@GrpcService
public class AuthServiceImpl extends AuthServiceImplBase {
  @Override
  public void auth(AuthRequest request, StreamObserver<AuthResponse> responseObserver) {

    AuthResponse auth = AuthResponse.newBuilder().setOk(true).build();
    responseObserver.onNext(auth);
    responseObserver.onCompleted();
  }
}
