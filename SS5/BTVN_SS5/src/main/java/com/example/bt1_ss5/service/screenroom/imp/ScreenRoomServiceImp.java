package com.example.bt1_ss5.service.screenroom.imp;

import com.example.bt1_ss5.model.ScreenRoom;
import com.example.bt1_ss5.repo.screenroom.ScreenRoomDao;
import com.example.bt1_ss5.repo.screenroom.imp.ScreenRoomDaoImp;
import com.example.bt1_ss5.service.screenroom.ScreenRoomService;

import java.util.List;

public class ScreenRoomServiceImp implements ScreenRoomService {

    private ScreenRoomDao screenRoomDao;

    public ScreenRoomServiceImp() {
        screenRoomDao = new ScreenRoomDaoImp();
    }

    // Display
    @Override
    public List<ScreenRoom> getScreenRooms() {
        return screenRoomDao.getAllScreenRoom();
    }

}
