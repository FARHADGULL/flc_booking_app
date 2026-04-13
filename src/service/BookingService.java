package service;

import domain.ExerciseLesson;
import domain.Member;

public class BookingService {

    public boolean bookLesson(Member member, ExerciseLesson lesson) {

        // Check time conflict
        for (ExerciseLesson bookedLesson : member.getBookings()) {
            if (bookedLesson.getDay().equals(lesson.getDay()) &&
                bookedLesson.getTimeSlot().equals(lesson.getTimeSlot())) {
                return false; // Time conflict
            }
        }

        // Check capacity and add member
        boolean added = lesson.addMember(member);

        if (added) {
            member.addBooking(lesson);
            return true;
        }

        return false;
    }

    public boolean changeBooking(Member member, ExerciseLesson oldLesson, ExerciseLesson newLesson) {
    // Check if member actually booked old lesson
    if (!member.getBookings().contains(oldLesson)) {
        System.out.println("You haven't booked the old lesson.");
        return false;
    }

    // Check time conflict
    for (ExerciseLesson booked : member.getBookings()) {
        if (booked.getDay().equals(newLesson.getDay()) &&
            booked.getTimeSlot().equals(newLesson.getTimeSlot())) {
            System.out.println("Time conflict!");
            return false;
        }
    }

    // Try booking new lesson
    if (newLesson.addMember(member)) {
        member.getBookings().remove(oldLesson);
        member.addBooking(newLesson);
        return true;
    }

    System.out.println("New lesson is full!");
    return false;
}
}