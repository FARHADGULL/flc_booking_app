package service;

import domain.*;
import java.util.*;

public class ReportService {

    public void generateLessonReport(List<ExerciseLesson> lessons) {
        System.out.println("\n=== Lesson Report ===");

        for (ExerciseLesson lesson : lessons) {
            System.out.println(
                    lesson.getExerciseName() +
                    " | " + lesson.getDay() +
                    " | Booked: " + lesson.getBookedCount() +
                    " | Avg Rating: " + lesson.getAverageRating()
            );
        }
    }

    public void generateHighestIncomeReport(List<ExerciseLesson> lessons) {
        Map<String, Double> incomeMap = new HashMap<>();

        for (ExerciseLesson lesson : lessons) {
            incomeMap.put(
                    lesson.getExerciseName(),
                    incomeMap.getOrDefault(lesson.getExerciseName(), 0.0) + lesson.getIncome()
            );
        }

        String topExercise = "";
        double maxIncome = 0;

        for (String exercise : incomeMap.keySet()) {
            if (incomeMap.get(exercise) > maxIncome) {
                maxIncome = incomeMap.get(exercise);
                topExercise = exercise;
            }
        }

        System.out.println("\n=== Highest Income Exercise ===");
        System.out.println(topExercise + " earned " + maxIncome);
    }
}