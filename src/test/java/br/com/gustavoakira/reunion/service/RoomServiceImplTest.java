package br.com.gustavoakira.reunion.service;

import br.com.gustavoakira.reunion.model.Room;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoomServiceImplTest {

    @Autowired
    private RoomService service;

    @Test
    public void getRoomsTest(){
        assertNotEquals(null, service.getRooms());
    }

    @Test
    public void saveRoomTest(){
        assertNotEquals(null,service.saveRoom(getRoom()));
    }

    @Test
    public void getOneRoomTest(){
        saveRoomTest();
        Long id = service.getRooms().get(0).getId();
        assertNotEquals(null,service.getRoom(id));
    }

    @Test
    public void updateRoomTest(){
        saveRoomTest();
        Room newRoom = getRoom();
        newRoom.setName("Vanderlei");
        Long id = service.getRooms().get(0).getId();
        assertNotEquals(null, service.updateRoom(id,newRoom));
    }

    @Test
    public void removeRoomTest(){
        saveRoomTest();
        Long id = service.getRooms().get(0).getId();
        assertEquals("ok",service.deleteRoom(id));
    }
    Room getRoom(){
        Room room = new Room();
        room.setName("Akira");
        room.setDate("12/11/2002");
        room.setStartHour("11:11:20");
        room.setEndHour("11:22:22");
        return  room;
    }


}