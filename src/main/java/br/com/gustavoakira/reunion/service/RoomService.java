package br.com.gustavoakira.reunion.service;

import br.com.gustavoakira.reunion.model.Room;

import java.util.List;

public interface RoomService {
    public Room getRoom(Long id);
    public List<Room> getRooms();
    public Room updateRoom(Long id, Room room);
    public String deleteRoom(Long id);
    public Room saveRoom(Room room);
}
