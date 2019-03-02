package Repository;

import Domain.Room;
import Domain.RoomValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoomRepository {

    private Map<Integer, Room> storage = new HashMap<>();

    private RoomValidator validator;

    /**
     * Instantiates a repository for rooms.
     * @param validator the validator used.
     */
    public RoomRepository(RoomValidator validator) {
        this.validator = validator;

        // low coupling, high cohesion
    }

    // CRUD: Create, Read, Update, Delete

    /**
     * create
     * @param room
     */
    public void add(Room room) {
        if (storage.containsKey(room.getId())) {
            throw new RuntimeException("A room with that id already exists!");
        }
        validator.validate(room);
        storage.put(room.getId(), room);
    }

    /**
     * update
     * @param room
     */
    public void update(Room room) {
        if (!storage.containsKey(room.getId())) {
            throw new RuntimeException("There is no room with the given id to update!");
        }

        validator.validate(room);
        storage.put(room.getId(), room);
    }

    /**
     * @return a list of all room.
     */
    public List<Room> getAll() {

        return new ArrayList<>(storage.values());
    }

}
