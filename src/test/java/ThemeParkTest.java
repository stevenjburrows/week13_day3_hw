import attractions.Attraction;
import attractions.Dodgems;
import attractions.RollerCoaster;
import behaviours.IReviewed;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.CandyflossStall;
import stalls.IceCreamStall;
import stalls.ParkingSpot;
import stalls.TobaccoStall;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {
    ThemePark themePark;
    Visitor visitor;
    Attraction dodgems;
    IReviewed stall1;
    IReviewed stall2;
    IReviewed stall3;
    IReviewed att1;

    @Before
    public void before(){
        dodgems = new Dodgems("Bumper Cars", 5);
        att1 = new RollerCoaster("Roll1", 3);
        themePark = new ThemePark();
        stall1 = new TobaccoStall("Adam's Baccy", "Adam", ParkingSpot.A1, 5);
        stall2 = new CandyflossStall("Steven's Floss", "Steven", ParkingSpot.A4, 5);
        stall3 = new IceCreamStall("Keith's Ice Cream", "Keith", ParkingSpot.B3, 3);
        visitor = new Visitor(25, 230, 30);
    }

    @Test
    public void canGetAllRatings(){
        themePark.addStall(stall1);
        themePark.addStall(stall2);
        themePark.addStall(stall3);
        assertEquals(3, themePark.getAllReviewed().size());
    }

    @Test
    public void canVisitAttraction(){
        themePark.visit(visitor, dodgems);
        assertEquals(1, visitor.getVisitedAttractions().size());
        assertEquals(1, dodgems.getVisitCount());

    }

    @Test
    public void canReturnReviews(){
        themePark.addStall(stall1);
        themePark.addStall(stall2);
        themePark.addStall(stall3);
        assertEquals(3, themePark.reviews().size());
    }


}
