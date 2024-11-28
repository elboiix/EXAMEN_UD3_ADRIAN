package org.example;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
public class Examen {
    public void ejercicio1(){

        Scanner entrada = new Scanner(System.in);
        Random aleatorio = new Random();

        String carton[][] = new String[3][3];

        System.out.println("***BIENVENIDO AL BINGO DEL CASINO CANTÁBRICO***");

        System.out.println();

        int bolas_cantidad = aleatorio.nextInt(40 - 10 + 1) + 10; //Calculo la cantidad de bolas con un random.

        int vector_bolas[] = new int[bolas_cantidad];
        Integer vector_bolas_integer[] = new Integer[bolas_cantidad];     //Creo un vector para los numeros, en int y en Integer para usar el AsList más tarde.

        while (true){
            for(int i = 0; i < bolas_cantidad; i++){
                int bola_num_aleatorio = aleatorio.nextInt(90)+1;
                vector_bolas[i] = bola_num_aleatorio;                           //Meto némeros aleatorios en cada posición del array.
                vector_bolas_integer[i] = bola_num_aleatorio;
            }
            int vector_bolas2[] = Arrays.stream(vector_bolas).distinct().toArray();  //Si hay numeros repetidos se vuelve a calcular los números.
            if (vector_bolas2.length == vector_bolas.length){
                break;
            }
        }

        System.out.println(bolas_cantidad + " bolas extraidas hasta ahora: " + Arrays.toString(vector_bolas));

        System.out.println();

        System.out.println("***Introduce los datos de tu cartón***");

        for(int i = 0; i < carton.length; i++){
            System.out.println("Fila " + (i+1) + ":");
            String fila_numeros = entrada.next();                               //Creo un formato para que el usuario introduzca las filas del carton.
            if(!fila_numeros.matches("\\d{1,2}-\\d{1,2}-\\d{1,2}")){
                System.out.println("Cerrando programa... Introduce valores con el formato correcto (N-N-N).");
                return;
            }
            String fila_numeros_vector[] = fila_numeros.split("-");

            for(int j = 0; j < carton.length; j++){                            //Paso a vector cada fila con un split.
                carton[i][j] = fila_numeros_vector[j];
            }
        }

        System.out.println("Datos del cartón introducido:");

        for(String fila[] : carton){
            for(String columna : fila){                //Muestro los datos en pantalla con un ForEach.
                System.out.print(columna + " ");
            }
            System.out.println();
        }


        System.out.println();

        System.out.println("PREMIOS:");

        System.out.println();

        int numeros_totales_acertados = 0;
        int numeros_linea1_acertados= 0;
        int numeros_linea2_acertados= 0;
        int numeros_linea3_acertados= 0;

        for(int i = 0; i < carton.length; i++){
            for(int j = 0; j < carton[i].length; j++){              //Voy pasando por cada numero y va comparando con el vector_bolas.
                int aux = Integer.parseInt(carton[i][j]);

                if(i == 0){
                    if(Arrays.asList(vector_bolas_integer).contains(aux)){         //Compara en la fila 1
                        numeros_linea1_acertados++;
                    }
                }

                if(i == 1){
                    if(Arrays.asList(vector_bolas_integer).contains(aux)){           //Compara en la fila 2
                        numeros_linea2_acertados++;
                    }
                }

                if(i == 2){
                    if(Arrays.asList(vector_bolas_integer).contains(aux)){          //Compara en la fila 3
                        numeros_linea3_acertados++;
                    }
                }

                if(Arrays.asList(vector_bolas_integer).contains(aux)){
                    numeros_totales_acertados++;
                }
            }
        }
        if (numeros_totales_acertados == 9){
            System.out.println("HAY BINGO!!");
            return;
        }else{
            System.out.println("No hay BINGO.");
        }

        if (numeros_linea1_acertados == 3){
                System.out.println("Linea 1: " + "CORRECTA!!");
        }else{
            System.out.println("Linea 1: " + "NO");
        }

        if (numeros_linea2_acertados == 3){
            System.out.println("Linea 2: " + "CORRECTA!!");
        }else{
            System.out.println("Linea 2: " + "NO");
        }

        if (numeros_linea3_acertados == 3){
            System.out.println("Linea 3: " + "CORRECTA!!");
        }else{
            System.out.println("Linea 3: " + "NO");
        }


    }
}
