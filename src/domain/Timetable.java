package domain;

import java.util.*;

public class Timetable {
    private List<ExerciseLesson> lessons = new ArrayList<>();

    public Timetable() {
        lessons = new ArrayList<>();
    }

    public void addLesson(ExerciseLesson lesson) {
        lessons.add(lesson);
    }

    public List<ExerciseLesson> getLessonsByDay(String day) {
        List<ExerciseLesson> result = new ArrayList<>();
        for (ExerciseLesson lesson : lessons) {
            if (lesson.getDay().equalsIgnoreCase(day)) {
                result.add(lesson);
            }
        }
        return result;
    }

    public List<ExerciseLesson> getLessonsByExercise(String exerciseName) {
        List<ExerciseLesson> result = new ArrayList<>();
        for (ExerciseLesson lesson : lessons) {
            if (lesson.getExerciseName().equalsIgnoreCase(exerciseName)) {
                result.add(lesson);
            }
        }
        return result;
    }

    public List<ExerciseLesson> getAllLessons() {
        return lessons;
    }

    public ExerciseLesson findLessonById(int id) {
        for (ExerciseLesson lesson : lessons) {
            if (lesson.getLessonId() == id) {
                return lesson;
            }
        }
        return null;
    }
}