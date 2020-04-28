package NBA.API.services;

import NBA.API.models.Player;
import NBA.API.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    private PlayerRepository repo;

    @Autowired
    public PlayerService(PlayerRepository repo){
        this.repo = repo;
    }

    public Player save(Player player){
        return repo.save(player);
    }
}
