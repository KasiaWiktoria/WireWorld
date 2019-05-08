package Game;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;

import java.awt.*;
import java.util.Random;

public class CanvasController {


    @FXML
    Canvas colorCanvas;
    @FXML
    Canvas bwCanvas;
    @FXML
    Canvas colorTool;
    int colorToolSize = 40;
    @FXML
    Canvas bwTool;
    int bwToolSize = 40;
    @FXML
    TextField columns;
    @FXML
    TextField rows;

    Board bwBoard = new Board(240,240, bwCanvas);
    Board colorBoard = new Board(64,48, colorCanvas);


    public void initialize(){

        //colorTool fill for WireWorld
        GraphicsContext colorToolGC = colorTool.getGraphicsContext2D();
        colorToolGC.setFill(Color.RED);
        colorToolGC.fillRect(0,0, colorToolSize, colorToolSize);
        colorToolGC.setFill(Color.YELLOW);
        colorToolGC.fillRect(0, colorToolSize, colorToolSize, colorToolSize);
        colorToolGC.setFill(Color.BLUE);
        colorToolGC.fillRect(colorToolSize,0, colorToolSize, colorToolSize);
        colorToolGC.setFill(Color.BLACK);
        colorToolGC.fillRect(colorToolSize, colorToolSize, colorToolSize, colorToolSize);

        //bwToll fill for Game of Life
        GraphicsContext bwToolGC = bwTool.getGraphicsContext2D();
        bwToolGC.setFill(Color.BLACK);
        bwToolGC.fillRect(0,0,bwToolSize,bwToolSize);
        bwToolGC.setFill(Color.WHITE);
        bwToolGC.fillRect(bwToolSize,0, bwToolSize, bwToolSize);


        //bwCanvas fill for Game of Life
        Random bwGenerator = new Random();
        GraphicsContext bwCanvasGC = bwCanvas.getGraphicsContext2D();
        bwCanvasGC.setFill(Color.BLACK);
        for(int i = 0; i<bwBoard.getRows(); i++){
            for(int j = 0; j<bwBoard.getColumns(); j++){
                if(bwGenerator.nextBoolean() == true)
                    bwCanvasGC.setFill(Color.WHITE);
                else
                    bwCanvasGC.setFill(Color.BLACK);
                bwCanvasGC.fillRect(j*bwBoard.cellSize,bwBoard.cellSize*i, bwBoard.cellSize, bwBoard.cellSize);
            }
        }
        //colorCanvas fill for WireWorld
        Random colorGenerator = new Random();
        GraphicsContext colorCanvasGC = colorCanvas.getGraphicsContext2D();

        //Black fill for WireWorld
        for(int i = 0; i<colorBoard.getRows(); i++){
            for(int j = 0; j<colorBoard.getColumns(); j++){
                    colorCanvasGC.setFill(Color.BLACK);
                colorCanvasGC.fillRect(j*colorBoard.cellSize,colorBoard.cellSize*i,colorBoard.cellSize,colorBoard.cellSize);
            }
        }
        /*for(int i = 0; i<24; i++){
            for(int j = 0; j<32; j++){
                if(colorGenerator.nextInt() % 4 == 0)
                    colorCanvasGC.setFill(Color.RED);
                else if(colorGenerator.nextInt() % 4 == 1)
                    colorCanvasGC.setFill(Color.YELLOW);
                else if(colorGenerator.nextInt() % 4 == 2)
                    colorCanvasGC.setFill(Color.BLUE);
                else
                    colorCanvasGC.setFill(Color.BLACK);
                colorCanvasGC.fillRect(j*colorBoard.cellSize,colorBoard.cellSize*i,colorBoard.cellSize,colorBoard.cellSize);
            }
        }*/

        //Dimensions of the board
        /*
        if(columns != null) {

            bwBoard.setColumns(Integer.parseInt(columns.getText()));
            bwBoard.setRows(Integer.parseInt(rows.getText()));
        }*/

    }

}
