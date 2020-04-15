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
import java.util.List;

/**
 *
 * @author suhee
 */
public class Dataloader {
    public void getValues(URL url){
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {
            System.out.println("practice.Dataloader.getValues()"+url);
            br = new BufferedReader(new InputStreamReader(url.openStream()));
            int count=0;
            while ((line = br.readLine()) != null) {
                // use comma as separator
                count++;
                String[] country = line.split(cvsSplitBy);
                    System.err.println("HomeTeam :"+country[2]+" , AwayTeam :" + country[3]+" , FTHG :" + country[4]+" , FTAG :" + country[5]);
            }
            System.out.println("count"+count);
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
