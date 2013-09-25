package ejercicios;

import java.util.Scanner;

public class Vector {

    private String[] v;

    public Vector(int size) {
        v = new String[size];
    }

    public String[] getV() {
        return v;
    }

    public void enterWords() {
        Scanner in = new Scanner(System.in); // BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
        String word = "";
        for (int i = 0; i < this.getV().length; i++) {
            word = in.next(); // in.readLine();
            this.getV()[i] = word;
        }

    }

    public void orderWords() {
        for (int i = 0; i < this.getV().length; i++) {
            for (int j = 0; j < this.getV().length && j < i; j++) {
                if (this.getV()[i].compareToIgnoreCase(this.getV()[j]) < 0) {
                    String aux = this.getV()[i];
                    this.getV()[i] = this.getV()[j];
                    this.getV()[j] = aux;
                }
            }
        }
    }

    public void show() {
        for (String a : this.getV()) {
            System.out.println(a);
        }
    }
}
