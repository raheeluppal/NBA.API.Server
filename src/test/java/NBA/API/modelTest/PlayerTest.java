package NBA.API.modelTest;

import NBA.API.models.Player;
import NBA.API.models.Team;
import org.junit.Assert;
import org.junit.Test;
public class PlayerTest {

    @Test
    public void idGetterSetterTest(){
        Player player = new Player();
        player.setId(23L);

        Long idExpected = player.getId();
        Long idActual = 23L;

        Assert.assertEquals(idExpected,idActual);
    }
    @Test
    public void firstNameGetterSetterTest(){
        Player player = new Player();
        player.setFirst_name("first name");

        String fnExpected = player.getFirst_name();
        String fnActual = "first name";

        Assert.assertEquals(fnExpected,fnActual);

    }
    @Test
    public void lastNameGetterSetterTest(){
        Player player = new Player();
        player.setLast_name("last name");

        String lnExpected = player.getLast_name();
        String lnActual = "last name";

        Assert.assertEquals(lnExpected,lnActual);
    }

    @Test
    public void positionGetterSetterTest(){
        Player player = new Player();
        player.setPosition("point guard");

        String pExpected = player.getPosition();
        String pActual = "point guard";

        Assert.assertEquals(pExpected,pActual);
    }
    @Test
    public void heightGetterSetterTest(){
        Player player = new Player();
        player.setHeight_feet(6);
        player.setHeight_inches(3);

        Integer hfExpected = player.getHeight_feet();
        Integer hfActual = 6;

        Integer hiExpected = player.getHeight_inches();
        Integer hiActual = 3;

        Assert.assertEquals(hfExpected,hfActual);
        Assert.assertEquals(hiExpected,hiActual);
    }
    @Test
    public void weightGetterSetterTest(){
        Player player = new Player();
        player.setWeight_pounds(250);

        Integer wExpected = player.getWeight_pounds();
        Integer wActual = 250;

        Assert.assertEquals(wExpected,wActual);
    }
    @Test
    public void teamGetterSetterTest(){
        Player player = new Player();
        Team team = new Team();
        player.setTeam(team);


        Assert.assertNotNull(player.getTeam());
    }

}
