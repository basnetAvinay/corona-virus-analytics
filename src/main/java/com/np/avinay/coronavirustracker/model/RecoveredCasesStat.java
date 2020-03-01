package com.np.avinay.coronavirustracker.model;

public class RecoveredCasesStat {

    private String state;
    private String country;
    private Integer latestRecoveredCases;
    private Integer diffRecoveredFromPrevDay;

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

    public Integer getLatestRecoveredCases() {
        return latestRecoveredCases;
    }

    public void setLatestRecoveredCases(Integer latestRecoveredCases) {
        this.latestRecoveredCases = latestRecoveredCases;
    }

    public Integer getDiffRecoveredFromPrevDay() {
        return diffRecoveredFromPrevDay;
    }

    public void setDiffRecoveredFromPrevDay(Integer diffRecoveredFromPrevDay) {
        this.diffRecoveredFromPrevDay = diffRecoveredFromPrevDay;
    }

    @Override
    public String toString() {
        return "RecoveredCasesStat{" +
                "state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", latestRecoveredCases=" + latestRecoveredCases +
                ", diffRecoveredFromPrevDay=" + diffRecoveredFromPrevDay +
                '}';
    }
}
