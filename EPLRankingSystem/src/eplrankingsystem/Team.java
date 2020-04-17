/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eplrankingsystem;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author suhas
 */
public class Team {
    private String teamName;
    private Map<String, ProbabilityDensityFunction> pdfs;
    private ProbabilityDensityFunction cumulativePdf;
    private double rankingIndex;
    
    public Team(String teamName){
        this.teamName = teamName;
        pdfs = new HashMap<>();
        cumulativePdf = new ProbabilityDensityFunction();
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Map<String, ProbabilityDensityFunction> getPdfs() {
        return pdfs;
    }

    public void setPdfs(Map<String, ProbabilityDensityFunction> pdfs) {
        this.pdfs = pdfs;
    }

    public double getRankingIndex() {
        return rankingIndex;
    }

    public void setRankingIndex(double rankingIndex) {
        this.rankingIndex = rankingIndex;
    }

    public ProbabilityDensityFunction getCumulativeDistributionFunction() {
        return cumulativePdf;
    }

    public void setCumulativeDistributionFunction(ProbabilityDensityFunction cumulativeDistributionFunction) {
        this.cumulativePdf = cumulativeDistributionFunction;
    }
    
    public void calculateTeamStats(){
        for(Map.Entry map:pdfs.entrySet()){
            ProbabilityDensityFunction pdf = (ProbabilityDensityFunction)map.getValue();
            pdf.calculateTeamStats();
        }
    }
}
