/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eplrankingsystem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 *
 * @author suhee
 */
public class Dataloader {
    public void getValues(URL url){
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        TeamDirectory teamDirectory = TeamDirectory.getInstance();

        try {
            //System.out.println("practice.Dataloader.getValues()"+url);
            br = new BufferedReader(new InputStreamReader(url.openStream()));
            //int count=0;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                // use comma as separator
                //count++;
                String[] record = line.split(cvsSplitBy);
                //System.err.println("HomeTeam :"+record[2]+" , AwayTeam :" + record[3]+" , FTHG :" + record[4]+" , FTAG :" + record[5]);
                String homeTeam = record[2].toLowerCase();
                String awayTeam = record[3].toLowerCase();
                int goalDifference = Integer.parseInt(record[4])-Integer.parseInt(record[5]);
                Team team = teamDirectory.getTeam(homeTeam);
                if(team ==null){
                    team = new Team(homeTeam);
                    teamDirectory.getTeamList().add(team);
                }                   
                ProbabilityDensityFunction pdf = team.getPdfs().get(awayTeam);
                if(pdf!=null){
                    if(pdf.getOccurence().get(goalDifference) == null)
                        pdf.getOccurence().put(goalDifference, 1);
                    else
                        pdf.getOccurence().put(goalDifference,pdf.getOccurence().get(goalDifference)+1);
                }
                else{
                    pdf = new ProbabilityDensityFunction();
                    pdf.getOccurence().put(goalDifference, 1);
                    team.getPdfs().put(awayTeam, pdf);
                }
            }
            //System.out.println("count"+count);
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                }
            }
        }
    }
    
}
