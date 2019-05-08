package Game;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.util.Random;

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

    public void colorToolFill(Canvas colorTool, int colorToolSize){
        GraphicsContext colorToolGC = colorTool.getGraphicsContext2D();
        colorToolGC.setFill(Color.RED);
        colorToolGC.fillRect(0,0, colorToolSize, colorToolSize);
        colorToolGC.setFill(Color.YELLOW);
        colorToolGC.fillRect(0, colorToolSize, colorToolSize, colorToolSize);
        colorToolGC.setFill(Color.BLUE);
        colorToolGC.fillRect(colorToolSize,0, colorToolSize, colorToolSize);
        colorToolGC.setFill(Color.BLACK);
        colorToolGC.fillRect(colorToolSize, colorToolSize, colorToolSize, colorToolSize);
    }

    public void bwToolFill(Canvas bwTool, int bwToolSize) {
        GraphicsContext bwToolGC = bwTool.getGraphicsContext2D();
        bwToolGC.setFill(Color.BLACK);
        bwToolGC.fillRect(0, 0, bwToolSize, bwToolSize);
        bwToolGC.setFill(Color.WHITE);
        bwToolGC.fillRect(bwToolSize, 0, bwToolSize, bwToolSize);
    }

    public void golCanvasFill(Canvas golCanvas) {
        Random golGenerator = new Random();
        GraphicsContext golCanvasGC = golCanvas.getGraphicsContext2D();
        golCanvasGC.setFill(Color.BLACK);
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                if (golGenerator.nextBoolean() == true)
                    golCanvasGC.setFill(Color.WHITE);
                else
                    golCanvasGC.setFill(Color.BLACK);
                golCanvasGC.fillRect(j * this.cellSize, this.cellSize * i, this.cellSize, this.cellSize);
            }
        }
    }

    public void canvasBlackFill(Canvas wwCanvas) {
        GraphicsContext wwCanvasGC = wwCanvas.getGraphicsContext2D();
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                wwCanvasGC.setFill(Color.BLACK);
                wwCanvasGC.fillRect(j * this.cellSize, this.cellSize * i, this.cellSize, this.cellSize);
            }
        }
    }

    public void wwCanvasRandomFill(Canvas wwCanvas) {
        GraphicsContext wwCanvasGC = wwCanvas.getGraphicsContext2D();
        Random wwGenerator = new Random();
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 32; j++) {
                if (wwGenerator.nextInt() % 4 == 0)
                    wwCanvasGC.setFill(Color.RED);
                else if (wwGenerator.nextInt() % 4 == 1)
                    wwCanvasGC.setFill(Color.YELLOW);
                else if (wwGenerator.nextInt() % 4 == 2)
                    wwCanvasGC.setFill(Color.BLUE);
                else
                    wwCanvasGC.setFill(Color.BLACK);
                wwCanvasGC.fillRect(j * this.cellSize, this.cellSize * i, this.cellSize, this.cellSize);
            }
        }
    }

    public void setDimension(TextField columns, TextField rows) {
        this.setColumns(Integer.parseInt(columns.getText()));
        this.setRows(Integer.parseInt(rows.getText()));
    }

    public void setPromptForDimensions(TextField columns, TextField rows) {
        columns.setPromptText("columns");
        rows.setPromptText("rows");
    }

    //Getters and Setters methods
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


