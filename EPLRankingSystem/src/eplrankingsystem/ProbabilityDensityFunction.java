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
public class ProbabilityDensityFunction {
    private double mean;
    private double sd;
    Map<Integer,Integer> occurence;
    Map<Integer,Double> probability;

    public ProbabilityDensityFunction() {
        occurence = new HashMap();
        probability = new HashMap();
    }

    public double getMean() {
        return mean;
    }

    public void setMean(double mean) {
        this.mean = mean;
    }

    public double getSd() {
        return sd;
    }

    public void setSd(double sd) {
        this.sd = sd;
    }

    public Map<Integer, Integer> getOccurence() {
        return occurence;
    }

    public void setOccurence(Map<Integer, Integer> occurence) {
        this.occurence = occurence;
    }

    public Map<Integer, Double> getProbility() {
        return probability;
    }

    public void setProbility(Map<Integer, Double> probility) {
        this.probability = probility;
    }
    
}
