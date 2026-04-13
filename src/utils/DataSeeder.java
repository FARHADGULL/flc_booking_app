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

        int id = 1;

        for (int week = 1; week <= 8; week++) {
            for (String day : days) {
                for (int i = 0; i < slots.length; i++) {

                    ExerciseLesson lesson = new ExerciseLesson(
                            id++,
                            exercises[(week + i) % exercises.length],
                            day,
                            slots[i],
                            prices[(week + i) % prices.length]
                    );

                    timetable.addLesson(lesson);
                }
            }
        }

        return timetable;
    }

    public static void seedBookings(List<Member> members, Timetable timetable, BookingService bookingService) {
        List<ExerciseLesson> lessons = timetable.getAllLessons();

        int index = 0;

        for (Member m : members) {
            // each member gets 2 bookings
            bookingService.bookLesson(m, lessons.get(index % lessons.size()));
            bookingService.bookLesson(m, lessons.get((index + 3) % lessons.size()));
            index++;
        }
    }

    public static void seedReviews(List<Member> members, Timetable timetable, ReviewService reviewService) {
        List<ExerciseLesson> lessons = timetable.getAllLessons();

        int count = 0;

        for (ExerciseLesson lesson : lessons) {
            if (count >= 20) break;

            Member m = members.get(count % members.size());
            int rating = (count % 5) + 1;

            reviewService.addReview(m, lesson, rating, "Good session");
            count++;
        }
    }
}