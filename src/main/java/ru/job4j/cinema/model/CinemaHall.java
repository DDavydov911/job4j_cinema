package ru.job4j.cinema.model;

import java.util.concurrent.ConcurrentHashMap;

public class CinemaHall {
    private final int rows;
    private final int cells;
    /*
    private final ConcurrentHashMap<Integer, ConcurrentHashMap<Integer, Boolean>> hall
            = new ConcurrentHashMap<>();

     */


    public CinemaHall() {
        this.rows = 4;
        this.cells = 4;
    }

    public int getRows() {
        return rows;
    }

    public int getCells() {
        return cells;
    }

    /*
    Первоначально хотел создать здесь весь зал, чтобы все запросы выполнять здесь.
    Но потом сделал проще. Код оставил для себя.
    public CinemaHall(int rows, int cells) {
        this.rows = rows;
        this.cells = cells;
        for (int i = 1; i <= rows; i++) {
            ConcurrentHashMap<Integer, Boolean> interMap = new ConcurrentHashMap();
            for (int j = 1; j <= cells ; j++) {
               interMap.put(j, true);
            }
            hall.put(i, interMap);
        }
    }

    public boolean bookTicket(int row, int cell) {
        boolean result = hall.get(row).replace(cell, true, false);
        return result;
    }

    public List<Integer> getAvailableRows(int row) {
        List<Integer> rows = new ArrayList<>();
        for (Map.Entry<Integer, ConcurrentHashMap<Integer, Boolean>> entry : hall.entrySet()) {
            if (!getAvailableCells(entry.getKey()).isEmpty()) {
                rows.add(entry.getKey());
            }
        }
        Collections.sort(rows);
        return rows;
    }

    public List<Integer> getAvailableCells(int row) {
        List<Integer> cells = new ArrayList<>();
        for (Map.Entry<Integer, Boolean> entry : hall.get(row).entrySet()) {
            if (entry.getValue()) {
                cells.add(entry.getKey());
            }
        }
        Collections.sort(cells);
        return cells;
    }
    */
}
