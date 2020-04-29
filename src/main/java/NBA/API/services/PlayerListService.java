package NBA.API.services;

import NBA.API.models.PlayerList;
import NBA.API.models.Team;
import NBA.API.repositories.PlayerListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerListService {

    private PlayerListRepository repo;

    @Autowired
    public PlayerListService(PlayerListRepository repo){
        this.repo = repo;
    }

    public PlayerList saveByTeamId(PlayerList playerList, Team team){
        return repo.save(playerList);
    }

    public PlayerList findByTeamId(){

        return null;
    }
}
