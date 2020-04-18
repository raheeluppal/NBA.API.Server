package NBA.API.controllers;

import NBA.API.models.Team;
import NBA.API.services.TeamService;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.type.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import kong.unirest.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class TeamController {

    private TeamService service;

    @Autowired
    public TeamController(TeamService service) { this.service = service; }

    @GetMapping("/teams/{id}")
    public ResponseEntity<?> getTeams(@PathVariable Long id) {
        HttpResponse<String> response = Unirest.get("https://free-nba.p.rapidapi.com/teams/" + id)
                .header("x-rapidapi-host", "free-nba.p.rapidapi.com")
                .header("x-rapidapi-key", "4c4e379b8cmsh5b8ee3f43ccd278p1a858cjsn82edf9884af0")
                .asString();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Team teams = objectMapper
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                    .readValue(response.getBody(), Team.class);

            if (teams != null) { return new ResponseEntity<>(teams, HttpStatus.OK); }
            else { return new ResponseEntity<>(null, HttpStatus.NO_CONTENT); }
        } catch (JsonProcessingException ignored) {}
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
