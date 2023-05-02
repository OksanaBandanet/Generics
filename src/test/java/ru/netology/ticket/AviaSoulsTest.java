package ru.netology.ticket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {
    @Test
    public void testSortTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSV", "SPB", 5_000, 8, 9);//2
        Ticket ticket2 = new Ticket("NEW", "LS", 15_000, 10, 14);
        Ticket ticket3 = new Ticket("MSV", "SPB", 4_000, 10, 11);//1
        Ticket ticket4 = new Ticket("NEW", "LS", 15_000, 4, 8);
        Ticket ticket5 = new Ticket("LS", "NEW", 15_000, 1, 5);
        Ticket ticket6 = new Ticket("MSV", "SPB", 6_000, 2, 3);//3
        Ticket ticket7 = new Ticket("SPB", "MSK", 5_000, 10, 11);
        Ticket ticket8 = new Ticket("MSV", "SPB", 8_000, 17, 18);//4
        Ticket ticket9 = new Ticket("KZ", "SPB", 3_000, 10, 12);
        Ticket ticket10 = new Ticket("UFA", "SPB", 7_000, 12, 14);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] expected = {ticket3, ticket1, ticket6, ticket8};
        Ticket[] actual = manager.search("MSV", "SPB");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortInaccurateTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSV", "SPB", 5_000, 8, 9);//2
        Ticket ticket2 = new Ticket("NEW", "LS", 15_000, 10, 14);
        Ticket ticket3 = new Ticket("MSV", "SPB", 4_000, 10, 11);//1
        Ticket ticket4 = new Ticket("NEW", "LS", 15_000, 4, 8);
        Ticket ticket5 = new Ticket("LS", "NEW", 15_000, 1, 5);
        Ticket ticket6 = new Ticket("MSV", "SPB", 6_000, 2, 3);//3
        Ticket ticket7 = new Ticket("SPB", "MSK", 5_000, 10, 11);
        Ticket ticket8 = new Ticket("MSV", "SPB", 8_000, 17, 18);//4
        Ticket ticket9 = new Ticket("KZ", "SPB", 3_000, 10, 12);
        Ticket ticket10 = new Ticket("UFA", "SPB", 7_000, 12, 14);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] expected = {};
        Ticket[] actual = manager.search("MSV", "LS");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortOneTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSV", "SPB", 5_000, 8, 9);//2
        Ticket ticket2 = new Ticket("NEW", "LS", 15_000, 10, 14);
        Ticket ticket3 = new Ticket("MSV", "SPB", 4_000, 10, 11);//1
        Ticket ticket4 = new Ticket("NEW", "LS", 15_000, 4, 8);
        Ticket ticket5 = new Ticket("LS", "NEW", 15_000, 1, 5);
        Ticket ticket6 = new Ticket("MSV", "SPB", 6_000, 2, 3);//3
        Ticket ticket7 = new Ticket("SPB", "MSK", 5_000, 10, 11);
        Ticket ticket8 = new Ticket("MSV", "SPB", 8_000, 17, 18);//4
        Ticket ticket9 = new Ticket("KZ", "SPB", 3_000, 10, 12);
        Ticket ticket10 = new Ticket("UFA", "SPB", 7_000, 12, 14);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] expected = {ticket10};
        Ticket[] actual = manager.search("UFA", "SPB");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFlyTime() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSV", "SPB", 5_000, 8, 10);//2
        Ticket ticket2 = new Ticket("NEW", "LS", 15_000, 10, 14);
        Ticket ticket3 = new Ticket("MSV", "SPB", 4_000, 10, 11);//1
        Ticket ticket4 = new Ticket("NEW", "LS", 15_000, 4, 8);
        Ticket ticket5 = new Ticket("LS", "NEW", 15_000, 1, 5);
        Ticket ticket6 = new Ticket("MSV", "SPB", 6_000, 2, 3);//1
        Ticket ticket7 = new Ticket("SPB", "MSK", 5_000, 10, 11);
        Ticket ticket8 = new Ticket("MSV", "SPB", 8_000, 17, 20);//3
        Ticket ticket9 = new Ticket("KZ", "SPB", 3_000, 10, 12);
        Ticket ticket10 = new Ticket("UFA", "SPB", 7_000, 12, 14);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket3, ticket6, ticket1, ticket8};
        Ticket[] actual = manager.search("MSV", "SPB", comparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFlyTimeOneTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSV", "SPB", 5_000, 8, 10);//2
        Ticket ticket2 = new Ticket("NEW", "LS", 15_000, 10, 14);
        Ticket ticket3 = new Ticket("MSV", "SPB", 4_000, 10, 11);//1
        Ticket ticket4 = new Ticket("NEW", "LS", 15_000, 4, 8);
        Ticket ticket5 = new Ticket("LS", "NEW", 15_000, 1, 5);
        Ticket ticket6 = new Ticket("MSV", "SPB", 6_000, 2, 3);//1
        Ticket ticket7 = new Ticket("SPB", "MSK", 5_000, 10, 11);
        Ticket ticket8 = new Ticket("MSV", "SPB", 8_000, 17, 20);//3
        Ticket ticket9 = new Ticket("KZ", "SPB", 3_000, 10, 12);
        Ticket ticket10 = new Ticket("UFA", "SPB", 7_000, 12, 14);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket10};
        Ticket[] actual = manager.search("UFA", "SPB", comparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFlyTimeInaccurateTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSV", "SPB", 5_000, 8, 10);//2
        Ticket ticket2 = new Ticket("NEW", "LS", 15_000, 10, 14);
        Ticket ticket3 = new Ticket("MSV", "SPB", 4_000, 10, 11);//1
        Ticket ticket4 = new Ticket("NEW", "LS", 15_000, 4, 8);
        Ticket ticket5 = new Ticket("LS", "NEW", 15_000, 1, 5);
        Ticket ticket6 = new Ticket("MSV", "SPB", 6_000, 2, 3);//1
        Ticket ticket7 = new Ticket("SPB", "MSK", 5_000, 10, 11);
        Ticket ticket8 = new Ticket("MSV", "SPB", 8_000, 17, 20);//3
        Ticket ticket9 = new Ticket("KZ", "SPB", 3_000, 10, 12);
        Ticket ticket10 = new Ticket("UFA", "SPB", 7_000, 12, 14);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Ticket[] actual = manager.search("UFA", "LS", comparator);
        Assertions.assertArrayEquals(expected, actual);
    }

}
