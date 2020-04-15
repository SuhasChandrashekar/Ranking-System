/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eplrankingsystem;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author suhas
 */
public class TeamDirectory {
    private List<Team> teamList;

    public TeamDirectory() {
        teamList = new ArrayList();
    }

    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }

}
