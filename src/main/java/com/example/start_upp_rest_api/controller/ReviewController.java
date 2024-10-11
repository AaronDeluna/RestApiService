package com.example.start_upp_rest_api.controller;

import com.example.start_upp_rest_api.exception.InvalidReviewDataException;
import com.example.start_upp_rest_api.models.Review;
import com.example.start_upp_rest_api.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/review")
@AllArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    /**
     * Добавляет новый отзыв.
     *
     * @param review объект {@link Review} с данными отзыва.
     * @return {@link ResponseEntity} с сообщением и статусом 201 (CREATED) или 400 (BAD_REQUEST) при ошибке.
     */
    @PostMapping
    public ResponseEntity<String> addReview(@RequestBody Review review) {
        try {
            reviewService.addReview(review);
            return new ResponseEntity<>("Отзыв успешно сохранен!", HttpStatus.CREATED);
        } catch (InvalidReviewDataException e) {
            return new ResponseEntity<>("Не удалось записать отзыв: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
