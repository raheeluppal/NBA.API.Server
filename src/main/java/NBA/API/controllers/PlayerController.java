package NBA.API.controllers;

import NBA.API.models.Player;
import NBA.API.models.PlayerList;
import NBA.API.models.Team;
import NBA.API.services.PlayerService;
import NBA.API.services.TeamService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PlayerController {

    private PlayerService service;
    private TeamService tService;

    @Autowired
    public PlayerController(PlayerService service, TeamService tService){
        this.service = service;
        this.tService = tService;
    }




    @GetMapping("/players/{id}")
    public ResponseEntity<?> getPlayers(@PathVariable Long id) {

        Optional<Team> tId = tService.findById(id);

        if (tId.isPresent()) {

        }

            HttpResponse<String> response = Unirest.get("https://free-nba.p.rapidapi.com/teams/" + id)
                    .header("x-rapidapi-host", "free-nba.p.rapidapi.com")
                    .header("x-rapidapi-key", "4c4e379b8cmsh5b8ee3f43ccd278p1a858cjsn82edf9884af0")
                    .asString();
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                Team team = objectMapper
                        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                        .readValue(response.getBody(), Team.class);
                Long teamId = team.getId();

                List<Player> players = new ArrayList<>();


                for (int i = 0; i < 5000; i++) {

                    HttpResponse<String> response1 = Unirest.get("https://free-nba.p.rapidapi.com/players?page=" + i + "&per_page=100")
                            .header("x-rapidapi-host", "free-nba.p.rapidapi.com")
                            .header("x-rapidapi-key", "5a87be5815mshdb4b1c83761247fp139fabjsn922a1206fa25")
                            .asString();

                    PlayerList playersTemp = objectMapper
                            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                            .readValue(response1.getBody(), PlayerList.class);

                    if (playersTemp.getData().isEmpty()) {
                        break;
                    }

                    for (Player p : playersTemp.getData()) {
                        if (p.getTeam().getId().equals(teamId)) {
                            players.add(p);
                        }
                    }

                }
                if (players.size() > 0) {

                    return new ResponseEntity<>(players, HttpStatus.OK);

                } else {
                    return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
                }
            } catch (JsonProcessingException ignored) {
            }
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
}
