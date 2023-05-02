package ru.netology.ticket;

import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {
    @Override
    public int compare(Ticket o1, Ticket o2) {
        int timeFlyOne = o1.getTimeTo() - o1.getTimeFrom();
        int timeFlyTwo = o2.getTimeTo() - o2.getTimeFrom();
        return timeFlyOne - timeFlyTwo;
    }
}
