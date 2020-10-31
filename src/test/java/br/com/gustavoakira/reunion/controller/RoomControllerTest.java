package br.com.gustavoakira.reunion.controller;

import br.com.gustavoakira.reunion.model.Room;
import br.com.gustavoakira.reunion.repository.RoomRepository;
import br.com.gustavoakira.reunion.service.RoomService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RoomController.class)
class RoomControllerTest {

    @MockBean
    private RoomService service;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private RoomRepository repository;

    private Long id;

    @BeforeEach
    void beforeAll(){
        id = 1L;
    }

    @Test
    void getAllRooms() throws Exception {
        mockMvc.perform(get("/api/v1/rooms"))
        .andExpect(status().isOk());
    }

    @Test
    void getRoomById() throws Exception {
        mockMvc.perform(get("/api/v1/room/{roomId}",id))
        .andExpect(status().isOk());
    }

    @Test
    void saveRoom() throws Exception {
        String json = mapper.writeValueAsString(getRoom());
        mockMvc.perform(post("/api/v1/room")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
        ).andExpect(status().isCreated());
    }

    @Test
    void updateRoom() throws Exception {
        Room newRoom = getRoom();
        newRoom.setName("Vanderlei");
        String json = mapper.writeValueAsString(newRoom);
        mockMvc.perform(put("/api/v1/room/{roomId}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
        )
        .andExpect(status().isOk());
    }

    @Test
    void removeRoom() throws Exception {
        mockMvc.perform(delete("/api/v1/room/{roomId}",id))
        .andExpect(status().isOk());
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