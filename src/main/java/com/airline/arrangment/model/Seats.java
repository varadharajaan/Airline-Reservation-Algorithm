package com.airline.arrangment.model;

import java.util.List;
import java.util.Objects;

/**
 * @Author Varadharajan on 26/05/20 00:02
 * @Projectname Airline_Arrangement
 */
public class Seats {

    private int seatNumber;

    private  List<List<String[]>> seats;

    private  int count;

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public List<List<String[]>> getSeats() {
        return seats;
    }

    public void setSeats(List<List<String[]>> seats) {
        this.seats = seats;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Seats)) return false;
        Seats seats1 = (Seats) o;
        return seatNumber == seats1.seatNumber &&
                count == seats1.count &&
                Objects.equals(seats, seats1.seats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seatNumber, seats, count);
    }

    @Override
    public String toString() {
        return "Seats{" +
                "seatNumber=" + seatNumber +
                ", seats=" + seats +
                ", count=" + count +
                '}';
    }


}
