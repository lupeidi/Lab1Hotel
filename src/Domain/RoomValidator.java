package Domain;

public class RoomValidator {
    /**
     * Validates a room
     * throws exception if tehere are errors
     */
    public void validate(Room room) {
        if (room.getStayNumber() <= 0) {
            throw new RuntimeException("The number of days cannot be 0 or negative!");
        }

        if (room.getRating() >= 6 && room.getRating() <= 0) {
            throw new RuntimeException("The rating must be on a scale from 1 to 5!");
        }

        if (room.getFeedback() == null && !room.isOccupied()){
            throw new RuntimeException("The feedback is empty!");
        }

        if (!room.isOccupied() && room.getRating() >= 6 && room.getRating() <= 0) {
            throw new RuntimeException("Room must have rating!");
        }
    }
}
