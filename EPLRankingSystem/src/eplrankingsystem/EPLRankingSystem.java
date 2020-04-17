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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import org.apache.commons.math3.distribution.NormalDistribution;

/**
 *
 * @author suhee
 */
public class EPLRankingSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<String> l = new ArrayList<>();
         l.add("2000-2001.csv");
         l.add("2001-2002.csv");
         l.add("2002-2003.csv");
         l.add("2003-2004.csv");
         l.add("2004-2005.csv");
         l.add("2005-2006.csv");
         l.add("2006-2007.csv");
         l.add("2007-2008.csv");
         l.add("2008-2009.csv");
         l.add("2009-2010.csv");
         l.add("2010-2011.csv");
         l.add("2011-2012.csv");
         l.add("2012-2013.csv");
         l.add("2013-2014.csv");
         l.add("2014-2015.csv");
         l.add("2015-2016.csv");
         l.add("2016-2017.csv");
         l.add("2017-2018.csv");
         l.add("2018-2019.csv");
         l.add("2019-2020.csv");
         //l.add("sample2.csv");
         Dataloader dataloader =new Dataloader();
         for(int i=0;i<l.size();i++){
             String filePath="files/"+l.get(i);
             URL f=Thread.currentThread().getContextClassLoader().getResource(filePath);
            dataloader.getValues(f);
         }
         Scanner sc= new Scanner(System.in);
         int option = 0;
        String homeTeam,awayTeam;
        System.out.println("Select one of the choices");
        System.out.println("1.Predict result between two teams");
        System.out.println("2.Predict EPL Standings for 2019-2021");
        System.out.println("3.Exit");
        option = sc.nextInt();
        switch(option){
            case 1: System.out.println("Enter two teams (1st team entered will be considered as the home team)");
                       sc.nextLine();
                       homeTeam=sc.nextLine();
                       awayTeam=sc.nextLine();
                       int value = findWinner(homeTeam,awayTeam);
                       if(value==0)
                            System.out.println("Match will be draw");
                       else if(value>1)
                            System.out.println(homeTeam+" will win the match");
                       else
                           System.out.println(awayTeam+" will win the match");
                       break;
            case 2: predictCurrentSeasonRankings();
         }
    }
    
    public static int findWinner(String homeTeam,String awayTeam){
        TeamDirectory teamDirectory = TeamDirectory.getInstance();
        teamDirectory.calculateTeamStats();
        Team team1 = teamDirectory.getTeam(homeTeam.toLowerCase());
        if(team1 == null){
            return 0;
        }
        ProbabilityDensityFunction pdf = team1.getPdfs().get(awayTeam.toLowerCase());
        if(pdf==null){
            return 0;
        }
        double mean = pdf.getMean();
        double sd = pdf.getSd();
        if(sd==0)
            sd=0.001;
        NormalDistribution d = new NormalDistribution(mean, sd);
        double winningProbability = d.probability(0.5, 99);
        //System.out.println(winningProbability);
        double drawProbability = d.probability(-0.5, 0.5);
        //System.out.println(drawProbability);
        double losingProbabaility = d.probability(-99, -0.5);
        //System.out.println(losingProbabaility);
        if(winningProbability>drawProbability && winningProbability>losingProbabaility)
            return 1;
        else if(drawProbability>losingProbabaility)
            return 0;
        else
            return -1;
    }
    
    public static void predictCurrentSeasonRankings(){
        String s ="2019-2020.csv";
        String filePath="files/"+s;
        URL f=Thread.currentThread().getContextClassLoader().getResource(filePath);
        createTableForPlayedMatches(f);
        s ="RemainingFixtures.csv";
        filePath="files/"+s;
        f=Thread.currentThread().getContextClassLoader().getResource(filePath);
        predictRemainingMatches(f);
    }
    
    public static void createTableForPlayedMatches(URL url){
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        Table table = Table.getInstance();

        try {
            br = new BufferedReader(new InputStreamReader(url.openStream()));
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] record = line.split(cvsSplitBy);
                String homeTeam = record[2].toUpperCase();
                String awayTeam = record[3].toUpperCase();
                int goalDifference = Integer.parseInt(record[4])-Integer.parseInt(record[5]);
                updateTable(homeTeam, awayTeam, goalDifference);
            }
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
    
    public static void predictRemainingMatches(URL url){
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        Table table = Table.getInstance();

        try {
            br = new BufferedReader(new InputStreamReader(url.openStream()));
            while ((line = br.readLine()) != null) {
                String[] record = line.split(cvsSplitBy);
                String homeTeam = record[0].toUpperCase();
                String awayTeam = record[1].toUpperCase();
                int goalDifference = findWinner(homeTeam,awayTeam);
                updateTable(homeTeam, awayTeam, goalDifference);
            }
            Collections.sort(table.getTableEntries());
            table.printTable();
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
    
    public static void updateTable(String homeTeam, String awayTeam, int goalDifference){
        Table table = Table.getInstance();
        TableEntry homeTableEntry = table.getTeam(homeTeam);
        TableEntry awayTableEntry = table.getTeam(awayTeam);
        if(homeTableEntry ==null){
            homeTableEntry = new TableEntry(homeTeam,0);
            table.getTableEntries().add(homeTableEntry);
        }
        if(awayTableEntry ==null){
            awayTableEntry = new TableEntry(awayTeam,0);
            table.getTableEntries().add(awayTableEntry);
        } 
        if(goalDifference>0)
            homeTableEntry.setPoints(homeTableEntry.getPoints()+3);
        else if(goalDifference<0)
            awayTableEntry.setPoints(awayTableEntry.getPoints()+3);
        else{
            homeTableEntry.setPoints(homeTableEntry.getPoints()+1);
            awayTableEntry.setPoints(awayTableEntry.getPoints()+1);
        }
    }
}