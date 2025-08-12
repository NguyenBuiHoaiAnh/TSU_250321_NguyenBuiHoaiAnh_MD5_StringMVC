package ra.edu.service;

import ra.edu.model.Room;

public interface RoomService extends PaginationService{
    boolean addRoom(Room room);

    boolean updateRoom(Room room);

    boolean deleteRoom(int id);

    boolean updateRoomStatus(int id, String status);

    boolean isRoomNameUnique(int id, String roomName);

    Room findById(int id);
}
