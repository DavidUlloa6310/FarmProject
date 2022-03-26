package com.example.farmproject;

public class Farm {
    private String farmerName;
    private int numCows;
    private int numPigs;
    private int numSheeps;
    private String funFact;

    public Farm(String farmerName, String numCows, String numPigs, String numSheeps) {
        this.farmerName = farmerName;
        this.numCows = Integer.parseInt(numCows);
        this.numPigs = Integer.parseInt(numPigs);
        this.numSheeps = Integer.parseInt(numSheeps);
        this.funFact = getFunFact();
    }

    public String getFunFact() {
        if (numCows > numPigs && numCows > numSheeps) {
            return "Cows have 32 teeth!";
        }

        if (numPigs > numCows && numPigs > numSheeps) {
            return "Pigs can't sweat!";
        }

        return "Sheeps have rectangular pupils!";
    }

    public String getFarmerName() {
        return farmerName;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }

    public int getNumCows() {
        return numCows;
    }

    public void setNumCows(int numCows) {
        this.numCows = numCows;
    }

    public int getNumPigs() {
        return numPigs;
    }

    public void setNumPigs(int numPigs) {
        this.numPigs = numPigs;
    }

    public int getNumSheeps() {
        return numSheeps;
    }

    public void setNumSheeps(int numSheeps) {
        this.numSheeps = numSheeps;
    }
}
