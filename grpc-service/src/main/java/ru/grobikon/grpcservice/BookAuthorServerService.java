package ru.grobikon.grpcservice;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import ru.grobikon.Author;
import ru.grobikon.BookAuthorServiceGrpc;
import ru.grobikon.common.proto.TempDB;

@GrpcService
public class BookAuthorServerService extends BookAuthorServiceGrpc.BookAuthorServiceImplBase{

    @Override
    public void getAuthor(Author request, StreamObserver<Author> responseObserver) {
        TempDB.getAuthorsFromTempDb()
                .stream()
                .filter(author -> author.getAuthorId() == request.getAuthorId())
                .findFirst()
                .ifPresent(responseObserver::onNext);
        responseObserver.onCompleted();
    }
}
