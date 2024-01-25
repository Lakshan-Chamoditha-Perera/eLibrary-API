package com.elibrary.library.api;

import com.elibrary.library.dto.AuthorDto;
import com.elibrary.library.payload.StandardResponse;
import com.elibrary.library.service.custom.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<StandardResponse> save(@Valid @RequestBody AuthorDto dto, BindingResult bindingResult) {
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
                            .data(authorService.save(dto)).build());

        } catch (Exception e) {
            return ResponseEntity.status(500).body(
                    StandardResponse.builder()
                            .code(500)
                            .message(e.getMessage()).build());
        }
    }

    @GetMapping("/get")
    public ResponseEntity<StandardResponse> get(@RequestParam String id) {
        try {
            return ResponseEntity.ok(
                    StandardResponse.builder()
                            .code(200)
                            .message("Success")
                            .data(authorService.get(id)).build());

        } catch (Exception e) {
            return ResponseEntity.status(500).body(
                    StandardResponse.builder()
                            .code(500)
                            .message(e.getMessage()).build());
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<StandardResponse> delete(@RequestParam String id) {
        try {
            return ResponseEntity.ok(
                    StandardResponse.builder()
                            .code(200)
                            .message("Success")
                            .data(authorService.delete(id)).build());

        } catch (Exception e) {
            return ResponseEntity.status(500).body(
                    StandardResponse.builder()
                            .code(500)
                            .message(e.getMessage()).build());
        }
    }

    @PatchMapping("/update")
    public ResponseEntity<StandardResponse> update(@Valid @RequestBody AuthorDto dto, BindingResult bindingResult) {
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
                            .data(authorService.update(dto)).build());

        } catch (Exception e) {
            return ResponseEntity.status(500).body(
                    StandardResponse.builder()
                            .code(500)
                            .message(e.getMessage()).build());
        }
    }


}
