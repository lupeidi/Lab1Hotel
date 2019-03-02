package Service;

import Domain.AverageRoomRating;
import Domain.Room;
import Repository.RoomRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoomService {
    private RoomRepository repository;

    /**
     * ...
     *
     * @param repository
     */

    public RoomService(RoomRepository repository) {
        this.repository = repository;
    }

    /**
     * ...
     *
     * @param id
     * @param roomNumber
     * @param guestNumber
     * @param stayNumber
     */

    public void enterService(int id, int roomNumber, int guestNumber, int stayNumber) {

        Room room = new Room(id, guestNumber, roomNumber, stayNumber);
        List<Room> rooms = repository.getAll();
        for (Room r : rooms) {
            if (r.getRoomNumber() == roomNumber && r.isOccupied()) {
                throw new RuntimeException("That room is already taken!");
            }
        }
        repository.add(room);
    }

    /**
     * @param roomNumber
     * @param feedback
     * @param rating
     */
    public void exitService(int roomNumber, String feedback, int rating) {
        Room roomLeftByGuests = null;
        List<Room> rooms = repository.getAll();
        for (Room r : rooms) {
            if (r.getRoomNumber() == roomNumber && r.isOccupied() ) {
                roomLeftByGuests = r;
            }
        }

        if (roomLeftByGuests != null) {
            roomLeftByGuests.setFeedback(feedback);
            roomLeftByGuests.setRating(rating);
            roomLeftByGuests.setOccupied(false);
            repository.update(roomLeftByGuests);
        } else {
            throw new RuntimeException("There is no room occupied to be vacated!");
        }
    }



    public List<AverageRoomRating> getAverageRoomRating() {
        List<AverageRoomRating> results = new ArrayList<>();
        Map<Integer, List<Integer>> ratingsforRooms = new HashMap<>();

        for (Room r : repository.getAll()) {
            if (!r.isOccupied()) {
                int roomNumber = r.getRoomNumber();
                int rating = r.getRating();

                if (!ratingsforRooms.containsKey(roomNumber)) {
                    ratingsforRooms.put(roomNumber, new ArrayList<>());
                }
                ratingsforRooms.get(roomNumber).add(rating);
            }
        }

        for (int roomNumber : ratingsforRooms.keySet()) {
            List<Integer> rating = ratingsforRooms.get(roomNumber);
            double average = 0;
            for (Integer p : rating) {
                average += p;
            }
            average /= rating.size();
            results.add( new AverageRoomRating( roomNumber, average) );
        }

        results.sort((r1, r2) -> {
            if (r1.getAverageRating() > r2.getAverageRating())
                return -1;
            else if (r1.getAverageRating() == r2.getAverageRating())
                return 0;
            else
                return 1;
        });
        return results;
    }

    public List<Room> getAll() {
        return repository.getAll();
    }

}
