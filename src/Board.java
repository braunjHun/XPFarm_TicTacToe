import java.util.ArrayList;


public class Board {

    private static final int BOARD_SIZE = 3;

    private ArrayList<Row> boardRows;


    public Board(String start) {
        System.out.println("Game Board Creation…");
        createBoard(BOARD_SIZE);
        drawBoard();
        System.out.println("Board Created.");
        System.out.println("The game will start with player "+start);
    }

    private void createBoard(int size) {
        boardRows = new ArrayList<Row>();
        
        for (int y=0; y < size; y++) {
            Row row = new Row(size);
            boardRows.add(row);
        }

    }

    private void drawBoard() {
        System.out.println(drawDash(BOARD_SIZE));
        for (Row row : boardRows) {
            for (Cell cell : row.getRowCells()) {
                System.out.print(cell.getValue() + "|");
            }
            System.out.println();
            System.out.println(drawDash(BOARD_SIZE));
        }

    }

    private String drawDash(int length){
        int finalLength = length;
        String retValue = "";
        for (int i = 0; i<finalLength; i++) {
            retValue += "-+";
        }
        return retValue;
    }

    public boolean takeStep(Player player, int xCo, int yCo){
        if (checkCell(xCo,yCo)){
            boardRows.get(xCo).getRowCells().get(yCo).setValue(player.getPlayerSign());
            drawBoard();
        } else {
            return false;
        }
        return true;
    }

    private boolean checkCell(int xCo, int yCo){
        if (xCo > BOARD_SIZE || yCo > BOARD_SIZE || xCo < 0 || yCo < 0) {
            return false;
        }

        if (boardRows.get(xCo).getRowCells().get(yCo).getValue() != ' '){
            return false;
        }

        return true;
    }

    public char checkResult(){
        char firstSign = ' ';
        int numberOfFullRows = 0;
        int numberOfSameSign = 0;
        // DRAW
        for (Row row : boardRows) {
            if (row.isRowFull()) {
                numberOfFullRows++;
            }
        }        
        if (numberOfFullRows == BOARD_SIZE){
            return '-';
        }
        // ROW
        for (int xCo = 0; xCo < boardRows.size(); xCo++){
            Row row = boardRows.get(xCo);
            numberOfSameSign = 0;
            if (row.isRowFull()) {
                firstSign = row.getRowCells().get(0).getValue();
                for (Cell cell : row.getRowCells()){
                    if (cell.getValue() == firstSign) {
                        numberOfSameSign++;
                    }
                }
            } 
            if (numberOfSameSign==BOARD_SIZE) {
                return firstSign;
            }
        }
        // COLL
        Row firstRow = boardRows.get(0);
        for (int yCo = 0; yCo < BOARD_SIZE; yCo++){
            Cell cell = firstRow.getRowCells().get(yCo);
            firstSign = cell.getValue();
            numberOfSameSign = 0;
            if (firstSign != ' ') {
                for (Row row : boardRows){
                    if (row.getRowCells().get(yCo).getValue() == firstSign) {
                        numberOfSameSign++;
                    }
                }
            } 
            if (numberOfSameSign==BOARD_SIZE) {
                return firstSign;
            }
        }
        // DIAGONAL from first
        firstSign = firstRow.getRowCells().get(0).getValue();
        numberOfSameSign = 0;
        if (firstSign != ' ') {
            int newYCo = 0;
            for (Row row : boardRows){
                if (row.getRowCells().get(newYCo).getValue() == firstSign) {
                    numberOfSameSign++;
                    newYCo++;
                }
            }
        } 
        if (numberOfSameSign==BOARD_SIZE) {
            return firstSign;
        }
        // DIAGONAL from last
        firstSign = firstRow.getRowCells().get(BOARD_SIZE-1).getValue();
        numberOfSameSign = 0;
        if (firstSign != ' ') {
            int newYCo = BOARD_SIZE-1;
            for (Row row : boardRows){
                if (row.getRowCells().get(newYCo).getValue() == firstSign) {
                    numberOfSameSign++;
                    newYCo--;
                }
            }
        } 
        if (numberOfSameSign==BOARD_SIZE) {
            return firstSign;
        }
        return ' ';
    }
    
}
