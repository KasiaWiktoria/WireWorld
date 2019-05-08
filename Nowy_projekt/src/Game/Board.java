package Game;

import javafx.scene.canvas.Canvas;

public class Board {

    private int columns;
    private int rows;
    Canvas canvas;
    double cellSize;

    public Board(int columns, int rows, Canvas canvas) {
        this.columns = columns;
        this.rows = rows;
        this.canvas = canvas;
        if(800/this.columns<600/this.rows)
            this.cellSize = 800./(double)this.columns;
        else
            this.cellSize = 600./(double)this.rows;
    }
    public void setColumns(int columns) {
        this.columns = columns;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public Canvas getCanvas() {
        return canvas;
    }

}
