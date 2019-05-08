package Game;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import java.util.Random;

public class CanvasController {

    @FXML
    Canvas wwCanvas;
    @FXML
    Canvas golCanvas;
    @FXML
    Canvas colorTool;
    int colorToolSize = 40;
    @FXML
    Canvas bwTool;
    int bwToolSize = 40;
    @FXML
    TextField golColumns;
    @FXML
    TextField golRows;
    @FXML
    TextField wwColumns;
    @FXML
    TextField wwRows;
    @FXML
    Button golDimension;

    Board golBoard = new Board(240,240, golCanvas);
    Board wwBoard = new Board(64,48, wwCanvas);

    public void initialize(){

        //Settings for WireWorld
        wwBoard.colorToolFill(colorTool, colorToolSize);
        //wwBoard.canvasBlackFill(wwCanvas);
        //wwBoard.setDimension(wwColumns, wwRows);
        wwBoard.setPromptForDimensions(wwColumns, wwRows);

        //Settings for Game of Life
        golBoard.bwToolFill(bwTool, bwToolSize);
        golBoard.golCanvasFill(golCanvas);
        //golBoard.setDimension(golColumns, golRows);
        golBoard.setPromptForDimensions(golColumns, golRows);

    }
}
