package utils;

import domain.*;
import java.util.*;
import service.*;

public class DataSeeder {

    public static List<Member> seedMembers() {
        List<Member> members = new ArrayList<>();

        members.add(new Member(1, "Ali", "ali@1mail.com"));
        members.add(new Member(2, "Sara", "sara@mail.com"));
        members.add(new Member(3, "John", "john@mail.com"));
        members.add(new Member(4, "Emma", "emma@mail.com"));
        members.add(new Member(5, "David", "david@mail.com"));
        members.add(new Member(6, "Sophia", "sophia@mail.com"));
        members.add(new Member(7, "Liam", "liam@mail.com"));
        members.add(new Member(8, "Noah", "noah@mail.com"));
        members.add(new Member(9, "Olivia", "olivia@mail.com"));
        members.add(new Member(10, "Mason", "mason@mail.com"));

        return members;
    }

    public static Timetable seedTimetable() {
        Timetable timetable = new Timetable();

        String[] exercises = {"Yoga", "Zumba", "Box Fit", "Aquacise"};
        String[] days = {"Saturday", "Sunday"};
        String[] slots = {"Morning", "Afternoon", "Evening"};
        double[] prices = {10, 12, 15, 11};

        int lessonId = 1;

        // 8 weekends → 48 lessons
        for (int week = 1; week <= 8; week++) {
            for (String day : days) {
                for (int i = 0; i < slots.length; i++) {
                    ExerciseLesson lesson = new ExerciseLesson(
                            lessonId++,
                            exercises[i % exercises.length],
                            day,
                            slots[i],
                            prices[i % prices.length]
                    );
                    timetable.addLesson(lesson);
                }
            }
        }

        return timetable;
    }

    public static void seedBookings(List<Member> members, Timetable timetable, BookingService bookingService) {
        List<ExerciseLesson> lessons = timetable.getAllLessons();
        Random random = new Random();

        for (Member member : members) {
            for (int i = 0; i < 2; i++) {
                ExerciseLesson lesson = lessons.get(random.nextInt(lessons.size()));
                bookingService.bookLesson(member, lesson);
            }
        }
    }

    public static void seedReviews(List<Member> members, Timetable timetable, ReviewService reviewService) {
        List<ExerciseLesson> lessons = timetable.getAllLessons();
        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            Member member = members.get(random.nextInt(members.size()));
            ExerciseLesson lesson = lessons.get(random.nextInt(lessons.size()));
            int rating = random.nextInt(5) + 1;

            reviewService.addReview(member, lesson, rating, "Good lesson");
        }
    }
}