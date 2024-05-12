package com.meshveliani.giorgi.formuloneapp.model;

import java.time.LocalTime;
import java.util.Objects;

public class Race {
    private LocalTime startTime;
    private LocalTime endTime;
    private Racer racer;

    public Race(LocalTime startTime, LocalTime endTime, Racer racer) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.racer = racer;

    }

    public Racer getRacer() {
        return racer;
    }

    public void setRacer(Racer racer) {
        this.racer = racer;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Race [startTime=" + startTime + ", endTime=" + endTime + ", racer=" + racer + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(endTime, racer, startTime);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Race other = (Race) obj;
        return Objects.equals(endTime, other.endTime) && Objects.equals(racer, other.racer)
                && Objects.equals(startTime, other.startTime);
    }

}


