package domain;

import java.util.*;

public class Member {

    private int memberId;
    private String name;
    private String email;
    private List<ExerciseLesson> bookings = new ArrayList<>();

    public Member(int memberId, String name, String email) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public List<ExerciseLesson> getBookings() {
        return bookings;
    }

    public void addBooking(ExerciseLesson lesson) {
        bookings.add(lesson);
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBookings(List<ExerciseLesson> bookings) {
        this.bookings = bookings;
    }
}