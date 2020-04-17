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
    
    public Team(String teamName){
        this.teamName = teamName;
        pdfs = new HashMap<>();
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
    
    public void calculateTeamStats(){
        for(Map.Entry map:pdfs.entrySet()){
            ProbabilityDensityFunction pdf = (ProbabilityDensityFunction)map.getValue();
            pdf.calculateTeamStats();
        }
    }
}
