package NBA.API.modelTest;

import NBA.API.models.Player;
import NBA.API.models.PlayerList;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PlayerListTest {
    @Test
    public void getSetIdTest(){
        PlayerList playerList = new PlayerList();
        playerList.setId(1L);
        playerList.setTeamId(1L);

        Long tExpected = playerList.getTeamId();
        Long tActual = 1L;

        Long expected = playerList.getId();
        Long actual = 1L;

        Assert.assertEquals(tExpected,tActual);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void listTest(){
        PlayerList playerList = new PlayerList();
        List<Player> playerData = new ArrayList<>();

        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        playerData.add(player1);
        playerData.add(player2);
        playerData.add(player3);


        playerList.setData(playerData);
        Integer expected = playerList.getData().size();
        Integer actual = 3;

        Assert.assertEquals(expected,actual);
    }
}
