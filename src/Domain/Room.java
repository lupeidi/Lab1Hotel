package Domain;

public class Room {
    private int id; //unic
    private int guestNumber;
    private int roomNumber; //neocupat
    private int stayNumber; //>0
    private boolean occupied;
    private String feedback;
    private int rating;

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", guestNumber=" + guestNumber +
                ", roomNumber=" + roomNumber +
                ", stayNumber=" + stayNumber +
                ", occupied=" + occupied +
                ", feedback='" + feedback + '\'' +
                ", rating=" + rating +
                '}';
    }

    public Room(int id, int guestNumber, int roomNumber, int stayNumber, boolean occupied, String feedback, int rating) {
        this.id = id;
        this.guestNumber = guestNumber;
        this.roomNumber = roomNumber;
        this.stayNumber = stayNumber;
        this.occupied = occupied;
        this.feedback = feedback;
        this.rating = rating;
    }

    public Room(int id, int guestNumber, int roomNumber, int stayNumber) {
        this.id = id;
        this.guestNumber = guestNumber;
        this.roomNumber = roomNumber;
        this.stayNumber = stayNumber;
        this.occupied = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGuestNumber() {
        return guestNumber;
    }

    public void setGuestNumber(int guestNumber) {
        this.guestNumber = guestNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getStayNumber() {
        return stayNumber;
    }

    public void setStayNumber(int stayNumber) {
        this.stayNumber = stayNumber;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
