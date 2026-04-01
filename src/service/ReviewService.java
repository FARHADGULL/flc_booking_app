package service;

import domain.*;

public class ReviewService {

    public void addReview(Member member, ExerciseLesson lesson, int rating, String comment) {
        Review review = new Review(member, rating, comment);
        lesson.addReview(review);
    }
}