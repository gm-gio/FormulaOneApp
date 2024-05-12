package com.meshveliani.giorgi.formuloneapp.model;

import java.util.Objects;

public class Racer {
    private String fullName;
    private String teamName;

    public Racer(String fullName, String teamName) {
        this.fullName = fullName;
        this.teamName = teamName;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public String toString() {
        return "Racers [fullName=" + fullName + ", teamName=" + teamName + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, teamName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Racer other = (Racer) obj;
        return Objects.equals(fullName, other.fullName) && Objects.equals(teamName, other.teamName);
    }
}
