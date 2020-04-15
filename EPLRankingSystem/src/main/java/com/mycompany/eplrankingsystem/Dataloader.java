/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
    
     public static void main(String[] args) throws FileNotFoundException, IOException {
        
         List<String> l = new ArrayList<String>();
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
         Dataloader dataloader =new Dataloader();
         for(int i=0;i<l.size();i++){
             String filePath="files/"+l.get(i);
             URL f=Thread.currentThread().getContextClassLoader().getResource(filePath);
            dataloader.getValues(f);
         }
        
     }
}
