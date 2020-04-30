package NBA.API.services;

import NBA.API.models.PlayerList;
import NBA.API.models.Team;
import NBA.API.repositories.PlayerListRepository;
import NBA.API.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class PlayerListService {

    private final PlayerListRepository repo;
    private final TeamRepository teamRepo;

    @Autowired
    public PlayerListService(PlayerListRepository repo, TeamRepository teamRepo){
        this.repo = repo;
        this.teamRepo = teamRepo;
    }

    public PlayerList saveByTeamId(PlayerList playerList){
        boolean found = false;
        if(playerList.getTeamId() != null) {
            for (Team t : teamRepo.findAll()){
                if (t != null && playerList.getTeamId() != null){
                    if(t.getId().equals(playerList.getTeamId())){
                        playerList.setTeamId(t.getId());
                        found = true;
                        break;
                    }
                }
            }
        }
        if (!found) {
            if (playerList.getTeamId() == null) {
                Long temp = playerList.getTeamId();
                teamRepo.save(playerList.getTeamById(temp));
            }
        }
        return this.repo.save(playerList);
    }

    public Collection<PlayerList> findByTeamId(Long teamId){
        return repo.findByTeamId(teamId);
    }
}
