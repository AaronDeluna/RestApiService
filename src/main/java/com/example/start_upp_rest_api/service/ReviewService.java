package com.example.start_upp_rest_api.service;

import com.example.start_upp_rest_api.exception.InvalidReviewDataException;
import com.example.start_upp_rest_api.models.Review;
import com.example.start_upp_rest_api.util.FileWriterUtil;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class ReviewService {
    private static final int MINIMAL_RATING = 1;
    private static final int MAXIMUM_RATING = 5;
    private static final String REVIEW_FILE_NAME = "review.txt";

    /**
     * Добавляет новый отзыв в файл.
     *
     * @param review объект {@link Review}, который нужно сохранить.
     * @throws InvalidReviewDataException если данные отзыва некорректны.
     * @throws IOException при ошибке записи в файл.
     */
    public void addReview(Review review) throws InvalidReviewDataException {
        FileWriterUtil.writeToFile(REVIEW_FILE_NAME, validDataReview(review));
    }

    /**
     * Проверяет корректность данных отзыва.
     *
     * @param review объект {@link Review} для проверки.
     * @return тот же объект {@link Review}, если данные корректны.
     * @throws InvalidReviewDataException если рейтинг меньше минимального или больше максимального значения.
     */
    private Review validDataReview(Review review) throws InvalidReviewDataException {
        if (!(review.getRating() < MINIMAL_RATING || review.getRating() <= MAXIMUM_RATING)) {
            throw new InvalidReviewDataException("Ошибка: рейтинг не может быть меньше 1 и больше 5");
        }
        return review;
    }
}
