import java.util.Objects;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //pais se usa para indicar si el país es Japón o España
        String pais;
        //dia se usa para indicar el dia de la semana
        String dia;
        //error se usa para que no te indica la hora del otro país si has introducido algo mal
        int error = 0;
        //exit se usa para salir del programa
        int exit = 0;
        //hours se usa para trabajar y mostrar las horas
        int hours;
        //minutes se indica para mostrar los minutos
        int minutes;
        //trash se usa para que lea los String bien y para usar los if y else correctamente, aparte trash se utiliza en el código para eliminar sus propias warnings por no usarlo
        String trash;
        while (exit == 0) {
            System.out.println("Introduce la hora");
            hours = in.nextInt();
            while (hours < 0 || hours >= 24) {
                System.out.println("Introduce una hora valida");
                hours = in.nextInt();
            }
            System.out.println("Introduce los minutos");
            minutes = in.nextInt();
            while (minutes < 0 || minutes >= 60) {
                System.out.println("Introduce minutos validos");
                minutes = in.nextInt();
            }
            System.out.println("Cuál es el país de Origen");
            trash = in.nextLine();
            pais = in.nextLine();
            System.out.println("Cual es el dia de la semana");
            dia = in.nextLine();
            if (Objects.equals(pais, "Japón")) {
                hours = hours + 8;
                if (hours >= 24 && Objects.equals(dia, "lunes")) {
                    hours = hours - 24;
                    dia = "martes";
                } else if (hours >= 24 && Objects.equals(dia, "martes")) {
                    hours = hours - 24;
                    dia = "miercoles";
                } else if (hours >= 24 && Objects.equals(dia, "miercoles")) {
                    hours = hours - 24;
                    dia = "jueves";
                } else if (hours >= 24 && Objects.equals(dia, "jueves")) {
                    hours = hours - 24;
                    dia = "viernes";
                } else if (hours >= 24 && Objects.equals(dia, "viernes")) {
                    hours = hours - 24;
                    dia = "sabado";
                } else if (hours >= 24 && Objects.equals(dia, "sabado")) {
                    hours = hours - 24;
                    dia = "domingo";
                } else if (hours >= 24 && Objects.equals(dia, "domingo")) {
                    hours = hours - 24;
                    dia = "lunes";
                } else if (hours < 24) {
                    trash = " ";
                } else {
                    System.out.println("Introduce el dia de la semana en minusculas y sin acentos");
                    error ++;
                }
            } else if (Objects.equals(pais, "España")) {
                hours = hours - 8;
                if (hours < 0 && Objects.equals(dia, "lunes")) {
                    hours = hours + 24;
                    dia = "domingo";
                } else if (hours < 0 && Objects.equals(dia, "martes")) {
                    hours = hours + 24;
                    dia = "lunes";
                } else if (hours < 0 && Objects.equals(dia, "miercoles")) {
                    hours = hours + 24;
                    dia = "martes";
                } else if (hours < 0 && Objects.equals(dia, "jueves")) {
                    hours = hours + 24;
                    dia = "miercoles";
                } else if (hours < 0 && Objects.equals(dia, "viernes")) {
                    hours = hours + 24;
                    dia = "jueves";
                } else if (hours < 0 && Objects.equals(dia, "sabado")) {
                    hours = hours + 24;
                    dia = "viernes";
                } else if (hours < 0 && Objects.equals(dia, "domingo")) {
                    hours = hours + 24;
                    dia = "sabado";
                } else if (hours > 0) {
                    trash = " ";
                } else {
                    System.out.println("Introduce el dia de la semana en minusculas y sin acentos");
                    error ++;
                }
            } else {
                System.out.println("Introduce España o Japón");
                error++;
            }
            if (error == 0 && Objects.equals(pais, "Japón")) {
                System.out.println("España " + hours + ":" + minutes + " " + dia);
            }
            if (error == 0 && Objects.equals(pais, "España")) {
                System.out.println("Japón " + hours + ":" + minutes + " " + dia);
            }
            error = 0;
            System.out.println("pulsa 0 si te quieres quedar y otro número para salir" + trash);
            exit = in.nextInt();
        }
    }
}
