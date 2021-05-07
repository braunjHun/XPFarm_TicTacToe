import java.util.ArrayList;

public class Row {

    private ArrayList<Cell> rowCells;
    public Row() {
    }

    public Row(int boardSize) {
        rowCells = new ArrayList<Cell>();        
        for (int i = 0; i<boardSize; i++){
            Cell cell = new Cell();
            rowCells.add(cell);
        }

    }

    public ArrayList<Cell> getRowCells() {
        return rowCells;
    }

    public boolean isRowFull(){
        int noOfFilledCells = 0;
        for (Cell cell : rowCells) {
            if (cell.getValue() != ' ') {
                noOfFilledCells++;
            }
        }
        return noOfFilledCells==rowCells.size();
    }

    
    
}
