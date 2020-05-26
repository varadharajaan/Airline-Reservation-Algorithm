package com.airline.arrangment.model;

import java.util.Objects;

/**
 * @Author Varadharajan on 26/05/20 12:03
 * @Projectname airline
 */
public class RequestDTO {

    private  String seat;

    private  int passenger;

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public int getPassenger() {
        return passenger;
    }

    public void setPassenger(int passenger) {
        this.passenger = passenger;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RequestDTO)) return false;
        RequestDTO that = (RequestDTO) o;
        return passenger == that.passenger &&
                Objects.equals(seat, that.seat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seat, passenger);
    }

    @Override
    public String toString() {
        return "RequestDTO{" +
                "seat='" + seat + '\'' +
                ", passenger=" + passenger +
                '}';
    }
}
