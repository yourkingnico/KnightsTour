package edu.bsu.cs224;

import java.util.ArrayList;
import java.util.List;

public class Tour {

    private int widthLength;
    private int heightLength;
    private int solutions;
    private final int UN_VISITED = -1;
    private int [][] solutionBoard;

    public Tour(int width, int height){
        solutions =0;
        this.widthLength =width;
        this.heightLength = height;
        solutionBoard = new int[height][width];
        for(int q = 0; q< height; q++ ){
            for(int j=0; j<width; j++){
                solutionBoard[q][j]= UN_VISITED;
            }
        }
    }

    public void findSolutions(){
        for (int q = 0; q< heightLength; q++){
            for(int j = 0; j< widthLength; j++){
                // Starts at 0,0 (top left) and moves right looking for possible solutions
                makeMove(j,q,0);{
                    solutionBoard[q][j]= UN_VISITED;
                }
            }
        }
    }

    private void makeMove(int x, int y, int turn) {
        solutionBoard[y][x] = turn;
        if (turn == (widthLength * heightLength) - 1) {
            solutions++;
            printBoard();
        }
        else{
            for (Coordinates c : getMoves(x, y)) {
                if (solutionBoard[c.getY()][c.getX()] == UN_VISITED) {
                    makeMove(c.getX(), c.getY(), turn + 1);
                    // Recursively trys solutions until one is found.
                    solutionBoard[c.getY()][c.getX()] = UN_VISITED;
                }
            }
        }
    }

    private List<Coordinates> getMoves(int x, int y){
        List<Coordinates>coordinatesList = new ArrayList<>();
        if (x + 2 < widthLength && y - 1 >= 0){
            coordinatesList.add(new Coordinates(x + 2, y - 1));
        }
        if (x + 1 < widthLength && y - 2 >= 0){
            coordinatesList.add(new Coordinates(x + 1, y - 2));
        }
        if (x - 1 >= 0 && y - 2 >= 0){
            coordinatesList.add(new Coordinates(x - 1, y - 2));
        }
        if (x - 2 >= 0 && y - 1 >= 0){
            coordinatesList.add(new Coordinates(x - 2, y - 1));
        }
        if (x - 2 >= 0 && y + 1 < heightLength){
            coordinatesList.add(new Coordinates(x - 2, y + 1));
        }
        if (x - 1 >= 0 && y + 2 < heightLength){
            coordinatesList.add(new Coordinates(x - 1, y + 2));
        }
        if (x + 1 < widthLength && y + 2 < heightLength){
            coordinatesList.add(new Coordinates(x + 1, y + 2));
        }
        if (x + 2 < widthLength && y + 1 < heightLength){
            coordinatesList.add(new Coordinates(x + 2, y + 1));
        }
        return coordinatesList;
    }

    private void printBoard() {
        System.out.println("Solution #" + solutions);
        for (int[] aSolutionBoard : solutionBoard) {
            for (int anASolutionBoard : aSolutionBoard) {
                System.out.print(anASolutionBoard + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public int getSolutions(){
        return solutions;
    }
}