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
public class Table {
    private List<TableEntry> tableEntries;
    private static final Table table = new Table();

    private Table() {
        tableEntries = new ArrayList();
    }
    
    public static Table getInstance(){ 
        return table; 
    } 

    public void printTable() {
        for(TableEntry tableEntry:tableEntries){
            //System.out.println(tableEntry.getTeam()+"\t\t"+tableEntry.getPoints());
            System.out.printf("%-25s %-5d\n",tableEntry.getTeam(),tableEntry.getPoints());
        }
    }
    
    public List<TableEntry> getTableEntries() {
        return tableEntries;
    }

    public void setTeamList(List<TableEntry> tableEntries) {
        this.tableEntries = tableEntries;
    }
    
    public TableEntry getTeam(String teamName){
        for(TableEntry tableEntry:tableEntries){
            if(tableEntry.getTeam().equalsIgnoreCase(teamName))
                return tableEntry;
        }
        return null;
    }
}
