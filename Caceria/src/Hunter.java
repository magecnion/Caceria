import java.util.Random;

public class Hunter extends Thread implements FieldItem {
    private HuntField huntField;
    private int shots;
    private Position position;
    int state = 0;

    public Hunter (HuntField huntField) {
        super();
        this.huntField = huntField;
        Random random = new Random();
        Position pos;
        while (true) {
            pos = new Position((int)(random.nextDouble()*huntField.getYLength()), (int)(random.nextDouble()*huntField.getXLength()));
            if (this.huntField.setItem(this, pos)) {
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
        state++;
        return true;
    }
    
    @Override
    public char getType() {
        return 'H';
    }
    
    public int hunted() {
        return shots;
    }
    
    public void run() {
        while (state==0) {
            try{
                
                if (huntField.shot(new Position(position.getX(), position.getY()+1))) {
                    shots++;
                    huntField.moveItem(this, position, new Position(position.getX(), position.getY()+1));
                }
                if (huntField.shot(new Position(position.getX()+1, position.getY()))) {
                    shots++;
                    huntField.moveItem(this, position, new Position(position.getX()+1, position.getY()));
                }
                if (huntField.shot(new Position(position.getX(), position.getY()-1))) {
                    shots++;
                    huntField.moveItem(this, position, new Position(position.getX(), position.getY()-1));
                }
                if (huntField.shot(new Position(position.getX()-1, position.getY()))) {
                    shots++;  
                    huntField.moveItem(this, position, new Position(position.getX()-1, position.getY()));
                }
                Thread.sleep(100);
            }catch(InterruptedException e) {};
        }
        
    }
}