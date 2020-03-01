package com.np.avinay.coronavirustracker.controller;

import com.np.avinay.coronavirustracker.model.ConfirmedCasesStat;
import com.np.avinay.coronavirustracker.model.DeathCasesStat;
import com.np.avinay.coronavirustracker.model.RecoveredCasesStat;
import com.np.avinay.coronavirustracker.services.CoronaVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private CoronaVirusDataService coronaVirusDataService;

    @GetMapping("/")
    public String index(Model model) {
        List<ConfirmedCasesStat> allConfirmedCasesStats = coronaVirusDataService.getAllConfirmedCasesStats();
        List<RecoveredCasesStat> allRecoveredCasesStats = coronaVirusDataService.getAllRecoveredCasesStats();
        List<DeathCasesStat> allDeathCasesStats = coronaVirusDataService.getAllDeathCasesStats();

        int confirmedTotalCases = allConfirmedCasesStats.stream().mapToInt(ConfirmedCasesStat::getLatestTotalCases).sum();
        int newConfirmedTotalCases = allConfirmedCasesStats.stream().mapToInt(ConfirmedCasesStat::getDiffTotalFromPrevDay).sum();
        model.addAttribute("allConfirmedCasesStats", allConfirmedCasesStats);
        model.addAttribute("confirmedTotalCases", confirmedTotalCases);
        model.addAttribute("newConfirmedTotalCases", newConfirmedTotalCases);

        int recoveredTotalCases = allRecoveredCasesStats.stream().mapToInt(RecoveredCasesStat::getLatestRecoveredCases).sum();
        int newRecoveredTotalCases = allRecoveredCasesStats.stream().mapToInt(RecoveredCasesStat::getDiffRecoveredFromPrevDay).sum();
        model.addAttribute("allRecoveredCasesStats", allRecoveredCasesStats);
        model.addAttribute("recoveredTotalCases", recoveredTotalCases);
        model.addAttribute("newRecoveredTotalCases", newRecoveredTotalCases);

        int deathTotalCases = allDeathCasesStats.stream().mapToInt(DeathCasesStat::getLatestDeathCases).sum();
        int newDeathTotalCases = allDeathCasesStats.stream().mapToInt(DeathCasesStat::getDiffDeathFromPrevDay).sum();
        model.addAttribute("allDeathCasesStats", allDeathCasesStats);
        model.addAttribute("deathTotalCases", deathTotalCases);
        model.addAttribute("newDeathTotalCases", newDeathTotalCases);
        return "index";
    }
}
