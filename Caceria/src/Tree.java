import java.util.Random;

public class Tree implements FieldItem {
    private HuntField huntField;
    private Position position;


    public Tree (HuntField huntField) {
        this.huntField = huntField;
        Random random = new Random();
        Position pos;
        while (true) {
            pos = new Position((int)(random.nextDouble()*huntField.getYLength()), (int)(random.nextDouble()*huntField.getXLength()));
            if (huntField.setItem(this, pos)) {
                this.position = pos;
                break;
            }
        }
        
    }
    
    public Position getPosition() {
        return position;
    }
    
    @Override
    public boolean fired() {
        return false;
    }
    
    @Override
    public char getType() {
        return 'T';
    }
    
    
}