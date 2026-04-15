package test;

import domain.*;
import service.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReviewServiceTest {

    @Test
    public void testAddReview() {
        Member member = new Member(1, "Ali", "mail");
        ExerciseLesson lesson = new ExerciseLesson(1, "Yoga", "Saturday", "Morning", 10);

        ReviewService reviewService = new ReviewService();
        reviewService.addReview(member, lesson, 5, "Great");

        assertEquals(5, lesson.getAverageRating());
    }
}