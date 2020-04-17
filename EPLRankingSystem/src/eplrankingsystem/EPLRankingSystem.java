/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eplrankingsystem;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

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
         //l.add("sample.csv");
         Dataloader dataloader =new Dataloader();
         for(int i=0;i<l.size();i++){
             String filePath="files/"+l.get(i);
             URL f=Thread.currentThread().getContextClassLoader().getResource(filePath);
            dataloader.getValues(f);
         }
    }
    }