package com.example.bt1_ss5.repo.screenroom.imp;

import com.example.bt1_ss5.model.Schedule;
import com.example.bt1_ss5.model.ScreenRoom;
import com.example.bt1_ss5.repo.screenroom.ScreenRoomDao;
import com.example.bt1_ss5.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ScreenRoomDaoImp implements ScreenRoomDao {

    @Override
    public List<ScreenRoom> getAllScreenRoom() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<ScreenRoom> screenRoomList = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call get_screenroom()}");
            ResultSet rs = callSt.executeQuery();
            screenRoomList = new ArrayList<>();

            while (rs.next()) {
                ScreenRoom screenRoom = new ScreenRoom();
                screenRoom.setId(rs.getInt("id"));
                screenRoom.setScreenRoomName(rs.getString("screen_room_name"));
                screenRoom.setTotalSeat(rs.getInt("totalSeat"));

                screenRoomList.add(screenRoom);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return screenRoomList;

    }

    @Override
    public List<Schedule> getAllScheduleByMovieID(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Schedule> scheduleList = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call get_screenroom(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            scheduleList = new ArrayList<>();

            while (rs.next()) {
                Schedule schedule = new Schedule();
                schedule.setId(rs.getInt("id"));
                schedule.setMovieTitle(rs.getString("movie_title"));
                schedule.setMovieId(rs.getInt("movie_id"));
                schedule.setScreenRoomId(rs.getInt("screen_room_id"));
                schedule.setShowTime(rs.getTimestamp("show_time").toLocalDateTime());
                schedule.setFormat(rs.getString("format"));
                schedule.setAvailableSeats(rs.getInt("available_seats"));
                schedule.setScreenRoomName(rs.getString("screen_room_name"));
                scheduleList.add(schedule);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return scheduleList;

    }

}
