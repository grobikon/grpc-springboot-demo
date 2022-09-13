package ru.grobikon.grpcclient.controller.controller;

import com.google.protobuf.Descriptors;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.grobikon.grpcclient.controller.service.BookAuthorClientService;

import java.util.Map;

@RestController
@AllArgsConstructor
public class BookAuthorController {

    private final BookAuthorClientService bookAuthorClientService;

    @GetMapping("/author/{id}")
    public Map<Descriptors.FieldDescriptor, Object> getAuthor(@PathVariable String id) {
        return bookAuthorClientService.getAuthor(Integer.parseInt(id));
    }
}
