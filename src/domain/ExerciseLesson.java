package domain;

import java.util.*;

public class ExerciseLesson {

    private final int lessonId;
    private String exerciseName;
    private String day;
    private String timeSlot;
    private double price;
    private List<Member> members = new ArrayList<>();
    private List<Review> reviews = new ArrayList<>();

    public ExerciseLesson(int lessonId, String exerciseName, String day, String timeSlot, double price) {
        this.lessonId = lessonId;
        this.exerciseName = exerciseName;
        this.day = day;
        this.timeSlot = timeSlot;
        this.price = price;
    }

    public int getLessonId() {
        return lessonId;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public String getDay() {
        return day;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public double getPrice() {
        return price;
    }

   public boolean addMember(Member member) {
        if (members.size() < 4) {
            members.add(member);
            return true;
        }
        return false;
    }

    public int getBookedCount() {
        return members.size();
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    public double getAverageRating() {
        if (reviews.isEmpty()) return 0;
        int total = 0;
        for (Review r : reviews) {
            total += r.getRating();
        }
        return (double) total / reviews.size();
    }

    public double getIncome() {
        return members.size() * price;
    }

    @Override
    public String toString() {
        return "LessonID: " + lessonId +
                " | " + exerciseName +
                " | " + day +
                " | " + timeSlot +
                " | Price: " + price +
                " | Booked: " + members.size();
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}