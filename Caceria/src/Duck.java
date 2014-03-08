
import java.util.Random;

public class Duck extends Thread implements FieldItem {

    private HuntField huntField;
    private Position position;
    int state = 0;

    public Duck(HuntField huntField) {
        super();
        this.huntField = huntField;
        Random random = new Random();
        Position pos;
        while (true) {
            pos = new Position((int) (random.nextDouble() * huntField.getYLength()), (int) (random.nextDouble() * huntField.getXLength()));
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
        return 'D';
    }

    public void run() {
        while (state == 0) {
            Random random = new Random();
            int number = (int) random.nextDouble() * 4 + 1;
            if (number == 1) {
                huntField.moveItem(this, position, new Position(position.getX(), position.getY() + 1));
            }
            if (number == 2) {
                huntField.moveItem(this, position, new Position(position.getX() + 1, position.getY()));
            }
            if (number == 3) {
                huntField.moveItem(this, position, new Position(position.getX(), position.getY() - 1));
            }
            if (number == 4) {
                huntField.moveItem(this, position, new Position(position.getX() - 1, position.getY()));
            }

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
            };
        }
    }
}