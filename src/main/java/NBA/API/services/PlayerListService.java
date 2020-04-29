package NBA.API.services;

import NBA.API.models.Player;
import NBA.API.models.PlayerList;
import NBA.API.models.Team;
import NBA.API.repositories.PlayerListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerListService {

    private PlayerListRepository repo;

    @Autowired
    public PlayerListService(PlayerListRepository repo){
        this.repo = repo;
    }

    public PlayerList saveByTeamId(PlayerList playerList){
//        List<Player> plData = playerList.getData();
//        for(Player p : plData){
//            p.getTeam().getId();
//        }
        return repo.save(playerList);
    }

    public Optional<Player> findByTeamId(Player player){
//        List<Player> plData = playerList.getData();
//        for(Player p : plData){
//            p.getTeam().getId();
//        }
//        return repo.findByTeamId(player.getTeam().getId());
        return Optional.empty();
    }
}
