package com.elibrary.library.api;

import com.elibrary.library.dto.BookDto;
import com.elibrary.library.payload.StandardResponse;
import com.elibrary.library.service.custom.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/existsByCode")
    public ResponseEntity<StandardResponse> existsById(@RequestBody String code) {
        try {
            return ResponseEntity.ok(
                    StandardResponse.builder()
                            .code(200)
                            .message("Success")
                            .data(bookService.existsById(code)).build());
        } catch (Exception e) {
            return ResponseEntity.status(500).body(
                    StandardResponse.builder()
                            .code(500)
                            .message(e.getMessage()).build());
        }
    }
    @PostMapping("/save")
    public ResponseEntity<StandardResponse> save(@Valid @RequestBody BookDto dto, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return ResponseEntity.status(
                        HttpStatus.BAD_REQUEST).body(
                        new StandardResponse(500, "Fail", bindingResult.getAllErrors()));
            }
            return ResponseEntity.ok(
                    StandardResponse.builder()
                            .code(200)
                            .message("Success")
                            .data(bookService.save(dto)).build());

        } catch (Exception e) {
            return ResponseEntity.status(500).body(
                    StandardResponse.builder()
                            .code(500)
                            .message(e.getMessage()).build());
        }
    }

    @GetMapping("/search")
    public ResponseEntity<StandardResponse> search(@RequestParam String isbn) {
        try {
            return ResponseEntity.ok(
                    StandardResponse.builder()
                            .code(200)
                            .message("Success")
                            .data(bookService.get(isbn)).build());
        } catch (Exception e) {
            return ResponseEntity.status(500).body(
                    StandardResponse.builder()
                            .code(500)
                            .message(e.getMessage()).build());
        }
    }

    @PatchMapping("/update")
    public ResponseEntity<StandardResponse> update(@Valid @RequestBody BookDto dto, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return ResponseEntity.status(
                        HttpStatus.BAD_REQUEST).body(
                        new StandardResponse(500, "Fail", bindingResult.getAllErrors()));
            }
            return ResponseEntity.ok(
                    StandardResponse.builder()
                            .code(200)
                            .message("Success")
                            .data(bookService.update(dto)).build());

        } catch (Exception e) {
            return ResponseEntity.status(500).body(
                    StandardResponse.builder()
                            .code(500)
                            .message(e.getMessage()).build());
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<StandardResponse> delete(@RequestParam String isbn) {
        try {
            return ResponseEntity.ok(
                    StandardResponse.builder()
                            .code(200)
                            .message("Success")
                            .data(bookService.delete(isbn)).build());
        } catch (Exception e) {
            return ResponseEntity.status(500).body(
                    StandardResponse.builder()
                            .code(500)
                            .message(e.getMessage()).build());
        }
    }
}
