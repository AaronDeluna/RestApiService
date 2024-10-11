package com.example.start_upp_rest_api.validation.review;

import com.example.start_upp_rest_api.exception.InvalidReviewDataException;
import com.example.start_upp_rest_api.models.Review;

public class ReviewValidation {
    private static final int MINIMAL_RATING = 1;
    private static final int MAXIMUM_RATING = 5;

    /**
     * Проверяет корректность данных отзыва.
     *
     * @param review объект {@link Review} для проверки.
     * @return тот же объект {@link Review}, если данные корректны.
     * @throws InvalidReviewDataException если рейтинг меньше минимального или больше максимального значения.
     */
    public static Review validation(Review review) throws InvalidReviewDataException {
        if (!(review.getRating() < MINIMAL_RATING || review.getRating() <= MAXIMUM_RATING)) {
            throw new InvalidReviewDataException("Ошибка: рейтинг не может быть меньше 1 и больше 5");
        }
        return review;
    }
}
