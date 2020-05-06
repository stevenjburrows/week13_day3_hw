package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class DodgemTest {

    Dodgems dodgems;
    Visitor visitor;

    @Before
    public void setUp() throws Exception {
        dodgems = new Dodgems("Bumper Cars", 5);
    }


    @Test
    public void hasName() {
        assertEquals("Bumper Cars", dodgems.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(5, dodgems.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, dodgems.getVisitCount());
    }

    @Test
    public void defaultFee() {
        visitor = new Visitor(20, 148, 25);
        assertEquals(4.50, dodgems.defaultPrice(), 0.01);
    }

    @Test
    public void halfFee() {
        visitor = new Visitor(11, 201, 25);
        assertEquals(2.25, dodgems.priceFor(visitor), 0.01);
    }

    @Test
    public void singleFee() {
        visitor = new Visitor(21, 199, 25);
        assertEquals(4.50, dodgems.priceFor(visitor), 0.01);
    }
}
