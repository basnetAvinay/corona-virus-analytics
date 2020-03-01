package com.np.avinay.coronavirustracker.model;

public class DeathCasesStat {

    private String state;
    private String country;
    private Integer latestDeathCases;
    private Integer diffDeathFromPrevDay;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getLatestDeathCases() {
        return latestDeathCases;
    }

    public void setLatestDeathCases(Integer latestDeathCases) {
        this.latestDeathCases = latestDeathCases;
    }

    public Integer getDiffDeathFromPrevDay() {
        return diffDeathFromPrevDay;
    }

    public void setDiffDeathFromPrevDay(Integer diffDeathFromPrevDay) {
        this.diffDeathFromPrevDay = diffDeathFromPrevDay;
    }

    @Override
    public String toString() {
        return "DeathCasesStat{" +
                "state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", latestDeathCases=" + latestDeathCases +
                ", diffDeathFromPrevDay=" + diffDeathFromPrevDay +
                '}';
    }
}
