package ru.job4j.cinema.model;

public class CinemaHall {
    private int rows;
    private int cells;
    private boolean[][] isOccupiedSeat;

    public CinemaHall(int rows, int cells) {
        this.rows = rows;
        this.cells = cells;
        this.isOccupiedSeat = new boolean[rows][cells];
    }

    public int getRows() {
        return rows;
    }

    public int getCells() {
        return cells;
    }
}
