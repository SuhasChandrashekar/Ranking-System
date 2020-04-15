/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eplrankingsystem;

import java.util.Map;

/**
 *
 * @author suhas
 */
public class Team {
    private String teamName;
    private Map<String, ProbabilityDensityFunction> pdf;
    private ProbabilityDensityFunction cumulativePdf;
    private double rankingIndex;
    

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Map<String, ProbabilityDensityFunction> getPdf() {
        return pdf;
    }

    public void setPdf(Map<String, ProbabilityDensityFunction> pdf) {
        this.pdf = pdf;
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
    
}
