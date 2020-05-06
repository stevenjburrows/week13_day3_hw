package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor visitor;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void canVisit() {
        visitor = new Visitor(13, 146, 25);
        assertEquals(true, rollerCoaster.isAllowedTo(visitor));
    }

    @Test
    public void cantVisit() {
        visitor = new Visitor(16, 140, 25);
        assertEquals(false, rollerCoaster.isAllowedTo(visitor));
    }

    @Test
    public void tooYoung() {
        visitor = new Visitor(11, 146, 25);
        assertEquals(false, rollerCoaster.isAllowedTo(visitor));
    }

    @Test
    public void defaultFee() {
        visitor = new Visitor(20, 148, 25);
        assertEquals(8.40, rollerCoaster.defaultPrice(), 0.01);
    }

    @Test
    public void doubleFee() {
        visitor = new Visitor(21, 201, 25);
        assertEquals(16.80, rollerCoaster.priceFor(visitor), 0.01);
    }

    @Test
    public void singleFee() {
        visitor = new Visitor(21, 199, 25);
        assertEquals(8.40, rollerCoaster.priceFor(visitor), 0.01);
    }


}
