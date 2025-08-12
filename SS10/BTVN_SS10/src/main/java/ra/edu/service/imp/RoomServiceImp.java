package ra.edu.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ra.edu.model.Room;
import ra.edu.repo.RoomRepo;
import ra.edu.service.RoomService;

@Repository
public class RoomServiceImp implements RoomService {

    @Autowired
    private RoomRepo roomRepo;

    @Override
    public boolean addRoom(Room room) {
        return roomRepo.addRoom(room);
    }

    @Override
    public boolean updateRoom(Room room) {
        return roomRepo.updateRoom(room);
    }

    @Override
    public boolean deleteRoom(int id) {
        return roomRepo.deleteRoom(id);
    }

    @Override
    public boolean updateRoomStatus(int id, String status) {
        return roomRepo.updateRoomStatus(id, status);
    }

    @Override
    public boolean isRoomNameUnique(int id, String roomName) {
        return roomRepo.isRoomNameUnique(id, roomName);
    }

    @Override
    public Room findById(int id) {
        return roomRepo.findById(id);
    }
}
