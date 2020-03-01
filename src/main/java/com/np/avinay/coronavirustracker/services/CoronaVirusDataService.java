package com.np.avinay.coronavirustracker.services;

import com.np.avinay.coronavirustracker.model.ConfirmedCasesStat;
import com.np.avinay.coronavirustracker.model.DeathCasesStat;
import com.np.avinay.coronavirustracker.model.RecoveredCasesStat;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class CoronaVirusDataService {

    private static String CASES_CONFIRMED_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_19-covid-Confirmed.csv";
    private static String DEATH_CONFIRMED_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_19-covid-Deaths.csv";
    private static String RECOVERED_CONFIRMED_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_19-covid-Recovered.csv";

    private List<ConfirmedCasesStat> allConfirmedCasesStats = new ArrayList<>();
    private List<RecoveredCasesStat> allRecoveredCasesStats = new ArrayList<>();
    private List<DeathCasesStat> allDeathCasesStats = new ArrayList<>();

    public List<ConfirmedCasesStat> getAllConfirmedCasesStats() {
        return allConfirmedCasesStats;
    }

    public List<RecoveredCasesStat> getAllRecoveredCasesStats() {
        return allRecoveredCasesStats;
    }

    public List<DeathCasesStat> getAllDeathCasesStats() {
        return allDeathCasesStats;
    }

    @PostConstruct
    @Scheduled(cron = "0 0 4,16 * * *")
    public void fetchConfirmedCasesData() {
        try {
            List<ConfirmedCasesStat> newConfirmedStats = new ArrayList<>();
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(CASES_CONFIRMED_URL))
                    .build();

            HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(httpResponse);

            StringReader csvBodyReader = new StringReader(httpResponse.body());
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);

            for (CSVRecord record : records) {
                ConfirmedCasesStat confirmedCasesStat = new ConfirmedCasesStat();
                confirmedCasesStat.setState(record.get("Province/State"));
                confirmedCasesStat.setCountry(record.get("Country/Region"));

                int latestCases = Integer.parseInt(record.get(record.size() - 1));
                int prevDayCases = Integer.parseInt(record.get(record.size() - 2));

                confirmedCasesStat.setLatestTotalCases(latestCases);
                confirmedCasesStat.setDiffTotalFromPrevDay(latestCases - prevDayCases);

                newConfirmedStats.add(confirmedCasesStat);
            }
            this.allConfirmedCasesStats = newConfirmedStats;
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @PostConstruct
    @Scheduled(cron = "0 0 4,16 * * *")
    public void fetchRecoveredCasesData() {
        try {
            List<RecoveredCasesStat> newRecoveredCasesStats = new ArrayList<>();
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(RECOVERED_CONFIRMED_URL))
                    .build();

            HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(httpResponse);

            StringReader csvBodyReader = new StringReader(httpResponse.body());
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);

            for (CSVRecord record : records) {
                RecoveredCasesStat recoveredCasesStat = new RecoveredCasesStat();
                recoveredCasesStat.setState(record.get("Province/State"));
                recoveredCasesStat.setCountry(record.get("Country/Region"));

                int latestCases = Integer.parseInt(record.get(record.size() - 1));
                int prevDayCases = Integer.parseInt(record.get(record.size() - 2));

                recoveredCasesStat.setLatestRecoveredCases(latestCases);
                recoveredCasesStat.setDiffRecoveredFromPrevDay(latestCases - prevDayCases);

                newRecoveredCasesStats.add(recoveredCasesStat);
            }
            this.allRecoveredCasesStats = newRecoveredCasesStats;
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @PostConstruct
    @Scheduled(cron = "0 0 4,16 * * *")
    public void fetchDeathCasesData() {
        try {
            List<DeathCasesStat> newDeathCasesStats = new ArrayList<>();
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(DEATH_CONFIRMED_URL))
                    .build();

            HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(httpResponse);

            StringReader csvBodyReader = new StringReader(httpResponse.body());
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);

            for (CSVRecord record : records) {
                DeathCasesStat recoveredCasesStat = new DeathCasesStat();
                recoveredCasesStat.setState(record.get("Province/State"));
                recoveredCasesStat.setCountry(record.get("Country/Region"));

                int latestCases = Integer.parseInt(record.get(record.size() - 1));
                int prevDayCases = Integer.parseInt(record.get(record.size() - 2));

                recoveredCasesStat.setLatestDeathCases(latestCases);
                recoveredCasesStat.setDiffDeathFromPrevDay(latestCases - prevDayCases);

                newDeathCasesStats.add(recoveredCasesStat);
            }
            this.allDeathCasesStats = newDeathCasesStats;
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
