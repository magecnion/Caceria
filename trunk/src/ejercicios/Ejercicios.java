package ejercicios;

import java.util.Scanner;

public class Ejercicios {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
        int size;
        Vector myVec;        

        System.out.println("Introduce el número de palabras a introducir");
        size = in.nextInt(); // in.readLine();
        myVec = new Vector(size);
        System.out.println("Comienza a introducir las palabras");
        myVec.enterWords();
        myVec.orderWords();
        myVec.show();
       

    }
}

// http://www.youtube.com/playlist?list=PLpORqNwoZaa7akHDSTmMmiecipuog6EYc
// http://www.youtube.com/watch?v=gcHhplMUf3A