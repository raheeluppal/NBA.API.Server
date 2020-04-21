package NBA.API.modelTest;

import NBA.API.models.Player;
import NBA.API.models.Team;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TeamTest {

    @Test
    public void idGetterSetterTest(){
        Team team = new Team();
        team.setId(1L);

        Long expected = team.getId();
        Long actual = 1L;

        Assert.assertEquals(expected,actual);
    }
    @Test
    public void abbreviationGetterSetterTest(){
        Team team = new Team();
        team.setAbbrevation("abbreviation");

        String expected = team.getAbbrevation();
        String actual = "abbreviation";

        Assert.assertEquals(expected,actual);
    }
    @Test
    public void cityGetterSetterTest(){
        Team team = new Team();
        team.setCity("city");

        String expected = team.getCity();
        String actual = "city";

        Assert.assertEquals(expected,actual);
    }
    @Test
    public void conferenceGetterSetterTest(){
        Team team = new Team();
        team.setConference("conference");

        String expected = team.getConference();
        String actual = "conference";

        Assert.assertEquals(expected,actual);
    }
    @Test
    public void divisionGetterSetterTest(){
        Team team = new Team();
        team.setConference("conference");

        String expected = team.getConference();
        String actual = "conference";

        Assert.assertEquals(expected,actual);
    }
    @Test
    public void fullNameGetterSetterTest(){
        Team team = new Team();
        team.setFull_name("full name");

        String expected = team.getFull_name();
        String actual = "full name";

        Assert.assertEquals(expected,actual);
    }
    @Test
    public void nameGetterSetterTest(){
        Team team = new Team();
        team.setName("name");

        String expected = team.getName();
        String actual = "name";

        Assert.assertEquals(expected,actual);
    }
    @Test
    public void playersGetterSetterTest(){
        Team team = new Team();

        List<Player> players = new ArrayList<>();
        players.add(new Player());

        team.setPlayers(players);

        Integer expected = team.getPlayers().size();
        Integer actual = 1;

        Assert.assertEquals(expected,actual);
    }
}
