package com.np.avinay.coronavirustracker.model;


public class ConfirmedCasesStat {

    private String state;
    private String country;
    private Integer latestTotalCases;
    private Integer diffTotalFromPrevDay;

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

    public Integer getLatestTotalCases() {
        return latestTotalCases;
    }

    public void setLatestTotalCases(Integer latestTotalCases) {
        this.latestTotalCases = latestTotalCases;
    }

    public Integer getDiffTotalFromPrevDay() {
        return diffTotalFromPrevDay;
    }

    public void setDiffTotalFromPrevDay(Integer diffTotalFromPrevDay) {
        this.diffTotalFromPrevDay = diffTotalFromPrevDay;
    }

    @Override
    public String toString() {
        return "LocationStats{" +
                "state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", latestTotalCases=" + latestTotalCases +
                '}';
    }
}
