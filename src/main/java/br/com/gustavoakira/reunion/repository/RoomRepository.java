package br.com.gustavoakira.reunion.repository;

import br.com.gustavoakira.reunion.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {
}
