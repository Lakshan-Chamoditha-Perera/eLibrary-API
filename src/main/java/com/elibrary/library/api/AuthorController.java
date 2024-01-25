package com.elibrary.library.api;

import com.elibrary.library.dto.AuthorDto;
import com.elibrary.library.payload.StandardResponse;
import com.elibrary.library.service.custom.AuthorService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/authors")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping("/all")
    public ResponseEntity<StandardResponse> getAllAuthors() {
        try {
            return ResponseEntity.ok(
                    StandardResponse.builder()
                            .code(200)
                            .message("Success")
                            .data(authorService.getAll()).build());
           } catch (Exception e) {
            return ResponseEntity.status(500).body(
                    StandardResponse.builder()
                            .code(500)
                            .message(e.getMessage()).build());
        }
    }

    @GetMapping("/existsById")
    public ResponseEntity<StandardResponse> existsById(String id) {
        try {
            return ResponseEntity.ok(
                    StandardResponse.builder()
                            .code(200)
                            .message("Success")
                            .data(authorService.existsById(id)).build());

        } catch (Exception e) {
            return ResponseEntity.status(500).body(
                    StandardResponse.builder()
                            .code(500)
                            .message(e.getMessage()).build());
        }
    }

    @PostMapping("/save")
    public ResponseEntity<StandardResponse> save( AuthorDto dto) {
        try {
            validateAuthor(dto);
            return ResponseEntity.ok(
                    StandardResponse.builder()
                            .code(200)
                            .message("Success")
                            .data(authorService.save(dto)).build());

        } catch (Exception e) {
            return ResponseEntity.status(500).body(
                    StandardResponse.builder()
                            .code(500)
                            .message(e.getMessage()).build());
        }
    }

    private void validateAuthor(AuthorDto dto) {

    }

}
