package model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Pawel_Piedel on 2017-01-21.
 */
public class ClientTest {
    @Test
    public void makeFirstOrder() throws Exception {
        //when client has no orders
        Client client = new Client();

        //first order can be made
        assertTrue(client.addOrder(new Order()));
    }

    @Test
    public void addLastPossibleOrder() throws Exception {
        Client client = new Client();
        List<Order> curentOrders = new ArrayList<>(5);

        //when client has 4 orders
        client.addOrder(new Order());
        client.addOrder(new Order());
        client.addOrder(new Order());
        client.addOrder(new Order());

        //5th order is the last one, he can make
        Order newOrder = new Order();
        assertTrue( client.addOrder(newOrder));

    }

    @Test
    public void tryOverOrder() throws Exception {
        Client client = new Client();
        List<Order> curentOrders = new ArrayList<>(5);

        //when client has 5 orders
        client.addOrder(new Order());
        client.addOrder(new Order());
        client.addOrder(new Order());
        client.addOrder(new Order());
        client.addOrder(new Order());

        //he can not make more orders
        Order newOrder = new Order();
        assertFalse( client.addOrder(newOrder));

    }

    @Test
    public void trySetUnderAge() throws Exception{
        //when client has no age setted
        Client client = new Client();

        //client must be adult
        assertFalse(client.setAge(15));
    }

    @Test
    public void trySetOkAge() throws Exception{
        //when client has no age setted
        Client client = new Client();

        //client must be adult
        assertTrue(client.setAge(18));
    }

    @Test
    public void makeFirstBooking() throws Exception{
        Client client = new Client();

        //client can make first booking
        assertTrue(client.addBooking(new Booking()));
    }

    @Test
    public void makeLastPossibleBooking() throws Exception{
        Client client = new Client();
        client.addBooking(new Booking());
        client.addBooking(new Booking());
        client.addBooking(new Booking());
        client.addBooking(new Booking());
        client.addBooking(new Booking());
        client.addBooking(new Booking());
        client.addBooking(new Booking());
        client.addBooking(new Booking());
        client.addBooking(new Booking());
        client.addBooking(new Booking());

        //11th booking is the last possible booking
        assertTrue(client.addBooking(new Booking()));
    }

    @Test
    public void tryOverBooking() throws Exception{
        Client client = new Client();
        client.addBooking(new Booking());
        client.addBooking(new Booking());
        client.addBooking(new Booking());
        client.addBooking(new Booking());
        client.addBooking(new Booking());
        client.addBooking(new Booking());
        client.addBooking(new Booking());
        client.addBooking(new Booking());
        client.addBooking(new Booking());
        client.addBooking(new Booking());
        client.addBooking(new Booking());

        //client can not make more bookings
        assertFalse(client.addBooking(new Booking()));
    }



}