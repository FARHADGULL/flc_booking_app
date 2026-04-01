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
}