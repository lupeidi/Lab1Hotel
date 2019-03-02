package Domain;

public class AverageRoomRating {
    private int roomNumber;
    private double averageRating;

    public AverageRoomRating(int roomNumber, double averageRating) {
        this.roomNumber = roomNumber;
        this.averageRating = averageRating;
    }

    @Override
    public String toString() {
        return "AverageRoomRating{" +
                "roomNumber=" + roomNumber +
                ", averageRating=" + averageRating +
                '}';
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }
}
