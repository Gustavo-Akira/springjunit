package br.com.gustavoakira.reunion.controller;

import br.com.gustavoakira.reunion.model.Room;
import br.com.gustavoakira.reunion.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class RoomController {
    @Autowired
    private RoomService service;

    @GetMapping("/rooms")
    public ResponseEntity<List<Room>> getAllRooms(){
        return ResponseEntity.ok(service.getRooms());
    }

    @GetMapping("/room/{roomId}")
    public ResponseEntity<Room> getRoomById(@PathVariable(value = "roomId") Long roomId){
        return ResponseEntity.ok(service.getRoom(roomId));
    }

    @PostMapping("/room")
    public ResponseEntity<Room> saveRoom(@Valid @RequestBody Room room){
        return  ResponseEntity.status(HttpStatus.CREATED).body(service.saveRoom(room));
    }

    @PutMapping("/room/{roomId}")
    public ResponseEntity<Room> updateRoom(@PathVariable(value = "roomId") Long roomId, @Valid @RequestBody Room room ){
        return ResponseEntity.ok(service.updateRoom(roomId,room));
    }

    @DeleteMapping("/room/{roomId}")
    public ResponseEntity<String> removeRoom(@PathVariable(value = "roomId") Long roomId){
        return ResponseEntity.ok(service.deleteRoom(roomId));
    }
}
