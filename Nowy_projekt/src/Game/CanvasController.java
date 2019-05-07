package Game;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;

public class CanvasController {

    Board board;

    @FXML
    Canvas canvas;
    @FXML
    Canvas colorTool;
    @FXML
    Canvas bwTool;


    public void initialize(){

        //colorTool fill for WireWorld
        GraphicsContext colorToolGC = colorTool.getGraphicsContext2D();
        colorToolGC.setFill(Color.RED);
        colorToolGC.fillRect(0,0,40,40);
        colorToolGC.setFill(Color.YELLOW);
        colorToolGC.fillRect(0,40,40,40);
        colorToolGC.setFill(Color.BLUE);
        colorToolGC.fillRect(40,0,40,40);
        colorToolGC.setFill(Color.BLACK);
        colorToolGC.fillRect(40,40,40,40);

        //bwToll fill for Game of Life
        GraphicsContext bwToolGC = colorTool.getGraphicsContext2D();
        bwToolGC.setFill(Color.BLACK);
        bwToolGC.fillRect(0,0,40,40);
        bwToolGC.setFill(Color.WHITE);
        bwToolGC.fillRect(40,0,40,40);

        Board board = new Board(20,30,canvas);

    }

}
