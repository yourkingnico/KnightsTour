package edu.bsu.cs224;

public class Main {

    public static void main(String[] args){
            Tour myTour = new Tour(3,4);
            myTour.findSolutions();
            System.out.println("# of Solutions: "+myTour.getSolutions());

    }
}
