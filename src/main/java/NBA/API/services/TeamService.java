package NBA.API.services;


import NBA.API.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    private TeamRepository repo;

    @Autowired
    public TeamService(TeamRepository repo){
        this.repo = repo;
    }

}
