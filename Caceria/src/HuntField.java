public class HuntField {
    private FieldItem[][] huntField;
    private int rows;
    private int columns;
    
    public HuntField (int rows, int columns) {
        huntField = new FieldItem[rows][columns];
        this.rows = rows;
        this.columns = columns;
    }
    
    public int getXLength() {
        return columns;
    }
    
    public int getYLength() {
        return rows;
    }
    
    public synchronized boolean setItem (FieldItem item, Position position) {
        //if (position != null) return false;
        if ((position.getX() > columns-1) || (position.getY() > rows-1)) return false;
        if ((position.getX() < 0) || (position.getY() < 0)) return false;
        if ((huntField[position.getY()][position.getX()]) != null) return false;
        huntField[position.getY()][position.getX()] = item;
        return true;
    }
    
    public synchronized boolean shot (Position position) {
        if ((position.getX() < 0) || (position.getY() < 0)) return false;
        if ((position.getX() > columns-1) || (position.getY() > rows-1)) return false;
        if ((huntField[position.getY()][position.getX()]) == null) return false;
        return huntField[position.getY()][position.getY()].fired();
    }
    
    public synchronized boolean removeItem (FieldItem item, Position position) {
        if (item.getType() == huntField[position.getY()][position.getX()].getType()) {
            huntField[position.getY()][position.getX()] = null;
            return true;
        }
        return false;
    }
    
    public synchronized char getItemType (Position position) {
        if (huntField[position.getY()][position.getX()] != null)
            return huntField[position.getY()][position.getX()].getType();
        return ' ';
    }
    
    public synchronized boolean moveItem (FieldItem item, Position position1, Position position2) {
    //    if ((item.getPosition().getX() != position1.getX()) || (item.getPosition().getY() != position1.getY())) return false;
        if ((position1.getX() > columns-1) || (position1.getY() > rows-1)) return false;
        if ((position2.getX() > columns-1) || (position2.getY() > rows-1)) return false;
        while (huntField[position2.getY()][position2.getX()] != null) {
            try {
                wait();
            } catch(InterruptedException e) { };
        }
        huntField[position2.getY()][position2.getX()] = item;
        removeItem(item, position1);
        notify();
        return true;
    }
    
    public synchronized int getNumberOfItems (char itemType) {
        int count=0;
        for (int i=0; i<rows; i++) {
            for (int j=0; j<columns; j++) {
                if (huntField[i][j] != null)
                    if (huntField[i][j].getType() == itemType)
                        count++;
            }
        }
        return count;
    }
    
    @Override
    public String toString() {
        String result = "";
        for (int i=0; i<rows; i++) {
            for (int j=0; j<columns; j++) {
                if (huntField[i][j] != null)
                    result+=huntField[i][j].getType();
                else
                    result+=" ";
            }
            result+="\n";
        }
        return result;
    }

    
}
