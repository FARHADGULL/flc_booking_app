package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import domain.*;
import service.*;

import java.util.*;

public class ReportServiceTest {

    @Test
    public void testReportsRun() {
        ExerciseLesson lesson1 = new ExerciseLesson(1, "Yoga", "Saturday", "Morning", 10);
        ExerciseLesson lesson2 = new ExerciseLesson(2, "Zumba", "Sunday", "Evening", 12);

        Member m = new Member(1, "Ali", "mail");
        lesson1.addMember(m);
        lesson2.addMember(m);

        ReportService reportService = new ReportService();

        List<ExerciseLesson> lessons = new ArrayList<>();
        lessons.add(lesson1);
        lessons.add(lesson2);

        reportService.generateLessonReport(lessons);
        reportService.generateHighestIncomeReport(lessons);
    }
}