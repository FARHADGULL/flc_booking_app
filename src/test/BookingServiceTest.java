package src.test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import domain.*;
import service.*;


public class BookingServiceTest {

    @Test
    public void testBookingSuccess() {
        Member member = new Member(1, "Ali", "ali@mail.com");
        ExerciseLesson lesson = new ExerciseLesson(1, "Yoga", "Saturday", "Morning", 10);

        BookingService bookingService = new BookingService();
        boolean result = bookingService.bookLesson(member, lesson);

        assertTrue(result);
        assertEquals(1, lesson.getBookedCount());
    }

    @Test
    public void testLessonCapacity() {
        BookingService bookingService = new BookingService();
        ExerciseLesson lesson = new ExerciseLesson(1, "Yoga", "Saturday", "Morning", 10);

        for (int i = 1; i <= 4; i++) {
            bookingService.bookLesson(new Member(i, "M" + i, "mail"), lesson);
        }

        boolean result = bookingService.bookLesson(new Member(5, "Extra", "mail"), lesson);
        assertFalse(result);
    }

    @Test
    public void testTimeConflict() {
        BookingService bookingService = new BookingService();
        Member member = new Member(1, "Ali", "mail");

        ExerciseLesson lesson1 = new ExerciseLesson(1, "Yoga", "Saturday", "Morning", 10);
        ExerciseLesson lesson2 = new ExerciseLesson(2, "Zumba", "Saturday", "Morning", 12);

        bookingService.bookLesson(member, lesson1);
        boolean result = bookingService.bookLesson(member, lesson2);

        assertFalse(result);
    }
}