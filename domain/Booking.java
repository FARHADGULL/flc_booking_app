package domain;

public class Booking {
    private int bookingId;
    private Member member;
    private ExerciseLesson lesson;
    private String status;

    public Booking(int bookingId, Member member, ExerciseLesson lesson, String status) {
        this.bookingId = bookingId;
        this.member = member;
        this.lesson = lesson;
        this.status = status;
    }

    public Member getMember() {
        return member;
    }

    public ExerciseLesson getLesson() {
        return lesson;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void setLesson(ExerciseLesson lesson) {
        this.lesson = lesson;
    }
}