package com.trilogyed.rsvp.model;

import java.io.Serializable;
import java.util.Objects;

public class Rsvp implements Serializable {
    private int rsvpId;
    private String guestName;
    private int totalAttending;

    // Adding a comment to test the push trigger

    public Rsvp() {

    }

    public Rsvp(String guestName, int totalAttending) {
        this.guestName = guestName;
        this.totalAttending = totalAttending;
    }

    public int getRsvpId() {
        return rsvpId;
    }

    public void setRsvpId(int rsvpId) {
        this.rsvpId = rsvpId;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public int getTotalAttending() {
        return totalAttending;
    }

    public void setTotalAttending(int totalAttending) {
        this.totalAttending = totalAttending;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rsvp)) return false;
        Rsvp rsvp = (Rsvp) o;
        return getRsvpId() == rsvp.getRsvpId() &&
                getTotalAttending() == rsvp.getTotalAttending() &&
                Objects.equals(getGuestName(), rsvp.getGuestName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRsvpId(), getGuestName(), getTotalAttending());
    }

    @Override
    public String toString() {
        return "Rsvp{" +
                "rsvpId=" + rsvpId +
                ", guestName='" + guestName + '\'' +
                ", totalAttending=" + totalAttending +
                '}';
    }
}
