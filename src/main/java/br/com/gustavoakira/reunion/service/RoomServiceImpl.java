package br.com.gustavoakira.reunion.service;

import br.com.gustavoakira.reunion.exception.ResourceNotFoundException;
import br.com.gustavoakira.reunion.model.Room;
import br.com.gustavoakira.reunion.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository repository;

    @Override
    public Room getRoom(Long id) {
        Optional<Room> op = repository.findById(id);
        op.orElseThrow(()->new ResourceNotFoundException(id.toString()));
        return op.get();
    }

    @Override
    public List<Room> getRooms() {
        return repository.findAll();
    }

    @Override
    public Room updateRoom(Long id, Room room) {
        Room old = getRoom(id);
        old.setDate(room.getDate());
        old.setName(room.getName());
        old.setStartHour(room.getStartHour());
        old.setEndHour(room.getEndHour());
        room = repository.save(old);
        return room;
    }

    @Override
    public String deleteRoom(Long id) {
        Room toDelete = getRoom(id);
        repository.delete(toDelete);
        return "ok";
    }

    @Override
    public Room saveRoom(Room room) {
        return repository.save(room);
    }
}
