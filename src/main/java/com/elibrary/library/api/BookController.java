package com.elibrary.library.api;

import com.elibrary.library.payload.StandardResponse;
import com.elibrary.library.service.custom.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/all")
    public ResponseEntity<StandardResponse> getAllAuthors() {
        try {
            return ResponseEntity.ok(
                    StandardResponse.builder()
                            .code(200)
                            .message("Success")
                            .data(bookService.getAll()).build());
        } catch (Exception e) {
            return ResponseEntity.status(500).body(
                    StandardResponse.builder()
                            .code(500)
                            .message(e.getMessage()).build());
        }
    }

}
