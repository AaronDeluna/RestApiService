package com.example.start_upp_rest_api.service;

import com.example.start_upp_rest_api.exception.InvalidReviewDataException;
import com.example.start_upp_rest_api.models.Review;
import com.example.start_upp_rest_api.util.file.FileWriterUtils;
import com.example.start_upp_rest_api.validation.review.ReviewValidation;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class ReviewService {
    private static final String REVIEW_FILE_NAME = "review.txt";

    /**
     * Добавляет новый отзыв в файл.
     *
     * @param review объект {@link Review}, который нужно сохранить.
     * @throws InvalidReviewDataException если данные отзыва некорректны.
     * @throws IOException при ошибке записи в файл.
     */
    public void addReview(Review review) throws InvalidReviewDataException {
        FileWriterUtils.writeToFile(REVIEW_FILE_NAME, ReviewValidation.validation(review));
    }
}
