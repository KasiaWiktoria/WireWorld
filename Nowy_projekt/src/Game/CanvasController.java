package Game;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;


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
    @FXML
    Button wwDimension;
    @FXML
    Button start;
    @FXML
    Button wwBoardReset;
    @FXML
    Button golBoardReset;
    @FXML
    Button golRandomFill;



    Board golBoard = new Board(32,24, golCanvas);
    Board wwBoard  = new Board(64,48, wwCanvas);

    public void initialize() {

        //Settings for WireWorld
        wwBoard.colorToolFill(colorTool, colorToolSize);
        wwBoard.canvasBlackFill(wwCanvas);
        wwBoard.setPromptForDimensions(wwColumns, wwRows);
        wwDimension.setOnAction(e -> wwBoard.setDimension(wwColumns, wwRows, wwCanvas, "ww"));
        wwBoardReset.setOnAction(e -> wwBoard.canvasBlackFill(wwCanvas));

        //Settings for Game of Life
        golBoard.bwToolFill(bwTool, bwToolSize);
        golBoard.golCanvasRandomFill(golCanvas);
        golBoard.setPromptForDimensions(golColumns, golRows);
        golDimension.setOnAction(e -> golBoard.setDimension(golColumns, golRows, golCanvas, "gol"));
        //golDimension.setOnAction(e -> golBoard.setDimension(golColumns, golRows, golCanvas, Board.class.getMethod("canvasBlackFill", Canvas.class) ));
        golBoardReset.setOnAction(e -> golBoard.canvasBlackFill(golCanvas));
        golRandomFill.setOnAction(e -> golBoard.golCanvasRandomFill(golCanvas));
    }
}
