package com.example.bt1_ss5.repo.schedule.imp;

import com.example.bt1_ss5.model.Movie;
import com.example.bt1_ss5.model.Schedule;
import com.example.bt1_ss5.model.ScreenRoom;
import com.example.bt1_ss5.repo.schedule.ScheduleDao;
import com.example.bt1_ss5.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDaoImp implements ScheduleDao {

    // Display
    @Override
    public List<Schedule> getAllSchedule() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Schedule> scheduleList = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call display_schedule_screenroom()}");
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


    // Add
    @Override
    public boolean addSchedules(Schedule schedule) {
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call add_schedule(?,?,?,?,?,?)}");

            callSt.setString(1, schedule.getMovieTitle());
            callSt.setInt(2, schedule.getMovieId());
            callSt.setTimestamp(3, java.sql.Timestamp.valueOf(schedule.getShowTime()));
            callSt.setInt(4, schedule.getScreenRoomId());
            callSt.setInt(5, schedule.getAvailableSeats());
            callSt.setString(6, schedule.getFormat().trim());
            callSt.executeUpdate();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

    // Update

    @Override
    public Schedule getScheduleById(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        Schedule schedule = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_by_id(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                schedule = new Schedule();
                schedule.setId(rs.getInt("id"));
                schedule.setTitle(rs.getString("title"));
                schedule.setDirector(rs.getString("director"));
                schedule.setGenre(rs.getString("genre"));
                schedule.setDescription(rs.getString("description"));
                schedule.setDuration(rs.getString("duration"));
                schedule.setLanguage(rs.getString("language"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return schedule;
    }

    @Override
    public boolean updateMovies(Schedule schedule) {
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call update_movie(?,?,?,?,?,?,?)}");
            callSt.setInt(1, schedule.getId());
            callSt.setString(2, schedule.getMovieTitle());
            callSt.setInt(3, schedule.getMovieId());
            callSt.setTimestamp(3, java.sql.Timestamp.valueOf(schedule.getShowTime()));
            callSt.setInt(5, schedule.getScreenRoomId());
            callSt.setInt(6, schedule.getAvailableSeats());
            callSt.setString(7, schedule.getFormat());
            callSt.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

//
//    @Override
//    public boolean deleteSchedule(int id) {
//        Connection connection = null;
//        CallableStatement callableStatement = null;
//        try {
//            connection = ConnectionDB.openConnection();
//            callableStatement = connection.prepareCall("{call delete_schedule(?)}");
//            callableStatement.setLong(1, id);
//            int rows = callableStatement.executeUpdate();
//            if (rows > 0) return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            ConnectionDB.closeConnection(connection, callableStatement);
//        }
//        return false;
//    }
}
