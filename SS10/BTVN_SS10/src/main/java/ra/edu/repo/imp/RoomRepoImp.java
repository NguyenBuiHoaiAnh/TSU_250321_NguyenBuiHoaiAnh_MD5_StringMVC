package ra.edu.repo.imp;

import org.springframework.stereotype.Repository;
import ra.edu.model.PaginationResult;
import ra.edu.model.Room;
import ra.edu.model.dto.RoomStatus;
import ra.edu.repo.RoomRepo;
import ra.edu.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RoomRepoImp implements RoomRepo {
    // CRUD
    @Override
    public boolean addRoom(Room room) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call add_room(?,?,?,?,?)}");
            callSt.setString(1, room.getRoomName());
            callSt.setString(2, room.getRoomType());
            callSt.setString(3, room.getStatus().name());
            callSt.setDouble(4, room.getPrice());
            callSt.setString(5, room.getImage());
            callSt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

    @Override
    public boolean updateRoom(Room room) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call update_room(?,?,?,?,?,?)}");
            callSt.setLong(1, room.getId());
            callSt.setString(2, room.getRoomName());
            callSt.setString(3, room.getRoomType());
            callSt.setString(4, room.getStatus().name());
            callSt.setDouble(5, room.getPrice());
            callSt.setString(6, room.getImage());
            callSt.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

    @Override
    public boolean deleteRoom(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call delete_room(?)}");
            callSt.setLong(1, id);
            callSt.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;

    }

    @Override
    public Room findById(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        Room room = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call get_room_by_id(?)}");
            callSt.setLong(1, id);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                room = new Room();
                room.setId(rs.getInt("id"));
                room.setRoomName(rs.getString("room_name"));
                room.setRoomType(rs.getString("room_type"));
                room.setStatus(RoomStatus.valueOf(rs.getString("status")));
                room.setDelete(rs.getBoolean("is_delete"));
                room.setPrice(rs.getDouble("price"));
                room.setImage(rs.getString("image"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return room;
    }

    @Override
    public boolean updateRoomStatus(int id, String status) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call update_room_status(?,?)}");
            callSt.setLong(1, id);
            callSt.setString(2, status);
            callSt.executeUpdate();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

    @Override
    public PaginationResult<Room> getAllRooms(int size, int currentPage) {
        Connection conn = null;
        CallableStatement callSt = null;
        PaginationResult<Room> roomPaginationResult = new PaginationResult<>();
        List<Room> roomList = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call get_rooms(?,?,?)}");
            callSt.setInt(1, size);
            callSt.setInt(2, currentPage);
            callSt.registerOutParameter(3, Types.INTEGER);

            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Room room = new Room();
                room.setId(rs.getInt("id"));
                room.setRoomName(rs.getString("room_name"));
                room.setRoomType(rs.getString("room_type"));
                room.setStatus(RoomStatus.valueOf(rs.getString("status")));
                room.setDelete(rs.getBoolean("is_delete"));
                room.setPrice(rs.getDouble("price"));
                room.setImage(rs.getString("image"));
                roomList.add(room);
            }

            roomPaginationResult.setTotalPages(callSt.getInt(3));
            roomPaginationResult.setDataList(roomList);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return roomPaginationResult;
    }

    @Override
    public boolean isRoomNameUnique(int id, String roomName) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call is_room_name_unique(?,?)}");
            callSt.setInt(1, id);
            callSt.setString(2, roomName);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                return rs.getInt("cnt") == 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }


}
