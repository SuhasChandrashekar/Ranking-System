/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eplrankingsystem;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author suhas
 */
public class TeamDirectory {
    private List<Team> teamList;
    private static final TeamDirectory teamDirectory = new TeamDirectory(); 

    private TeamDirectory() {
        teamList = new ArrayList();
    }
    
    public static TeamDirectory getInstance(){ 
        return teamDirectory; 
    } 
    
    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }
    
     public Team getTeam(String teamName){
        for(Team team:teamList){
            if(team.getTeamName().equals(teamName))
                return team;
        }
        return null;
    }
}
