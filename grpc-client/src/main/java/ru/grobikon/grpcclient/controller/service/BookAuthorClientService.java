package ru.grobikon.grpcclient.controller.service;

import com.google.protobuf.Descriptors;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;
import ru.grobikon.Author;
import ru.grobikon.BookAuthorServiceGrpc;

import java.util.Map;

@Service
public class BookAuthorClientService {

    @GrpcClient("grpc-devproblems-service")
    BookAuthorServiceGrpc.BookAuthorServiceBlockingStub synchronousClient;

    public Map<Descriptors.FieldDescriptor, Object> getAuthor(int authorId) {
        Author authorRequest = Author.newBuilder().setAuthorId(authorId).build();
        Author authorResponse = synchronousClient.getAuthor(authorRequest);
        return authorResponse.getAllFields();
    }
}
