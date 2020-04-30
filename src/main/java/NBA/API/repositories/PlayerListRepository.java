package NBA.API.repositories;

import NBA.API.models.PlayerList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;


@Repository
public interface PlayerListRepository extends JpaRepository<PlayerList, Long> {

    @Query(value = "SELECT * FROM playerlist p WHERE team_id =: teamId",
    nativeQuery = true)
    Collection<PlayerList>findByTeamId(@Param("teamId") Long teamId);
}
