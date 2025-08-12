package ra.edu.repo;

import ra.edu.model.PaginationResult;
import ra.edu.model.Room;

public interface RoomRepo {
    // CRUD
    boolean addRoom(Room room);

    boolean updateRoom(Room room);

    boolean deleteRoom(int id);

    boolean updateRoomStatus(int id, String status);

    PaginationResult<Room> getAllRooms(int limit, int offset);

    boolean isRoomNameUnique(int id, String roomName);

    Room findById(int id);
}
