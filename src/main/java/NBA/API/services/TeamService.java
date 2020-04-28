package NBA.API.services;


import NBA.API.models.Team;
import NBA.API.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamService {

    private TeamRepository repo;

    @Autowired
    public TeamService(TeamRepository repo){
        this.repo = repo;
    }

    public Optional<Team> findById(Long id){
        return repo.findById(id);
    }

}
