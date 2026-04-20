package main;

import domain.*;
import java.util.*;
import service.*;
import utils.*;

public class LeisureCentreApp {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            List<Member> members = DataSeeder.seedMembers();
            Timetable timetable = DataSeeder.seedTimetable();

            BookingService bookingService = new BookingService();
            ReviewService reviewService = new ReviewService();
            ReportService reportService = new ReportService();

            DataSeeder.seedReviews(members, timetable, reviewService);
            DataSeeder.seedBookings(members, timetable, bookingService);

            while (true) {
                System.out.println("\n=== Furzefield Leisure Centre ===");
                System.out.println("1. View Timetable");
                System.out.println("2. Book Lesson");
                System.out.println("3. Add Review");
                System.out.println("4. Generate Reports");
                System.out.println("5. Change Booking");
                System.out.println("6. Exit");
                System.out.print("Select option: ");

                int choice = scanner.nextInt();

                switch (choice) {

                    case 1 -> {
                        System.out.println("1. View by Day");
                        System.out.println("2. View by Exercise");
                        System.err.println("3. View Complete Time Table");
                        int subChoice = scanner.nextInt();
                        scanner.nextLine();

                        if (subChoice == 1) {
                            System.out.print("Enter Day (Saturday/Sunday): ");
                            String day = scanner.nextLine();

                            List<ExerciseLesson> lessonsByDay = timetable.getLessonsByDay(day);
                            for (ExerciseLesson l : lessonsByDay) {
                                System.out.println(l);
                            }
                        } else if (subChoice == 2) {
                            System.out.print("Enter Exercise Name (Yoga, Zumba, Box Fit, Aquacise): ");
                            String ex = scanner.nextLine();

                            List<ExerciseLesson> lessonsByExercise = timetable.getLessonsByExercise(ex);
                            for (ExerciseLesson l : lessonsByExercise) {
                                System.out.println(l);
                            }
                        } else if(subChoice == 3) {
                            for (ExerciseLesson lesson : timetable.getAllLessons()) {
                                System.out.println(lesson);
                            }
                        }
                    }

                    case 2 -> {
                        System.out.print("Enter Member ID: ");
                        int memberId = scanner.nextInt();
                        Member member = members.get(memberId - 1);

                        System.out.print("Enter Lesson ID: ");
                        int lessonId = scanner.nextInt();

                        ExerciseLesson lesson = timetable.findLessonById(lessonId);

                        if (lesson != null) {
                            boolean booked = bookingService.bookLesson(member, lesson);
                            if (booked)
                                System.out.println("Booking successful!");
                            else
                                System.out.println("Booking failed (Full or Time conflict)");
                        }
                    }

                    case 3 -> {
                        System.out.print("Enter Member ID: ");
                        int mId = scanner.nextInt();
                        Member m = members.get(mId - 1);

                        System.out.print("Enter Lesson ID: ");
                        int lId = scanner.nextInt();
                        ExerciseLesson l = timetable.findLessonById(lId);

                        System.out.print("Enter Rating (1-5): ");
                        int rating = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Enter Review Comment: ");
                        String comment = scanner.nextLine();

                        reviewService.addReview(m, l, rating, comment);
                        System.out.println("Review added!");
                    }

                    case 4 -> {
                        reportService.generateLessonReport(timetable.getAllLessons());
                        reportService.generateHighestIncomeReport(timetable.getAllLessons());
                    }

                    case 5 -> {
                         System.out.print("Enter Member ID: ");
                        int memId = scanner.nextInt();
                        Member mem = members.get(memId - 1);

                        System.out.print("Enter OLD Lesson ID: ");
                        int oldId = scanner.nextInt();

                        System.out.print("Enter NEW Lesson ID: ");
                        int newId = scanner.nextInt();

                        ExerciseLesson oldLesson = timetable.findLessonById(oldId);
                        ExerciseLesson newLesson = timetable.findLessonById(newId);

                        boolean changed = bookingService.changeBooking(mem, oldLesson, newLesson);

                        if (changed)
                            System.out.println("Booking changed successfully!");
                        else
                            System.out.println("Change failed!");
                    }

                    case 6 -> {
                        System.out.println("Goodbye!");
                        return;
                    }
                }
            }
        }
    }
}