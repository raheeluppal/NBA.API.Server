package NBA.API.repositories;

import NBA.API.models.Player;
import NBA.API.models.PlayerList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerListRepository extends JpaRepository<PlayerList, Long> {

    @Query("SELECT t FROM Player WHERE t.team_id = : team_is")
    Long findByTeamId(Player player);
}
