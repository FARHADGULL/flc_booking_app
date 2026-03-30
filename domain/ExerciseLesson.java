package domain;

import java.util.*;

public class ExerciseLesson {
    private int lessonId;
    private String exerciseName;
    private String day;
    private String timeSlot;
    private double price;
    private int capacity = 4;

    private List<Member> bookedMembers;
    private List<Review> reviews;

    public ExerciseLesson(int lessonId, String exerciseName, String day, String timeSlot, double price) {
        this.lessonId = lessonId;
        this.exerciseName = exerciseName;
        this.day = day;
        this.timeSlot = timeSlot;
        this.price = price;
        this.bookedMembers = new ArrayList<>();
        this.reviews = new ArrayList<>();
    }

    public boolean addMember(Member member) {
        if (bookedMembers.size() < capacity) {
            bookedMembers.add(member);
            return true;
        }
        return false;
    }

    public int getBookedCount() {
        return bookedMembers.size();
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    public double getAverageRating() {
        if (reviews.isEmpty()) return 0;
        int sum = 0;
        for (Review r : reviews) {
            sum += r.getRating();
        }
        return (double) sum / reviews.size();
    }

    public double getIncome() {
        return bookedMembers.size() * price;
    }

    public String getExerciseName() { return exerciseName; }
    public String getDay() { return day; }
    public String getTimeSlot() { return timeSlot; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return exerciseName + " | " + day + " | " + timeSlot + " | £" + price;
    }
}