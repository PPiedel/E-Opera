package model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Pawel_Piedel on 2017-01-21.
 */
public class PerformanceTest {
    @Test
    public void purchaseMoreTicketsThanAvailable() throws Exception {
        Performance performance = new Performance();
        performance.setTicketsAvailableNumber(3);

        //when someone try to purchase more tickets than avaialble
        performance.purchaseTickets(4);

        //then tickets available are the same as previous
        assertEquals(new Integer(3),performance.getTicketsAvailableNumber());
    }

    @Test
    public void purchaseTickets() throws Exception{
        Performance performance = new Performance();

        //when tickets available number is 100
        performance.setTicketsAvailableNumber(100);
        performance.setPurchasedTicketsNumber(0);

        //and someone try to purchase 5 tickets
        performance.purchaseTickets(5);

        //then everything is ok
        assertEquals(new Integer(95),performance.getTicketsAvailableNumber());
        assertEquals(new Integer(5),performance.getPurchasedTicketsNumber());

    }

}