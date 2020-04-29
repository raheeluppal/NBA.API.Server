package NBA.API.repositories;

import NBA.API.models.PlayerList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerListRepository extends JpaRepository<PlayerList, Long> {
}
