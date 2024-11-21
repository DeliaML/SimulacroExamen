import java.util.Objects;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //notas sirve para saber cuantas notas hay que apuntar
        int notas;
        System.out.println("(a) Aprobados y suspendidos.");
        System.out.println("(b) Billetes a Madrid.");
        System.out.println("(c) Salir");
        //resp sirve para saber que programa usar
        String resp = in.nextLine();
        //trash sirve para que los String funcionen correctamente, aparte trash se utiliza en el código para eliminar sus propias warnings por no usarlo
        String trash;
        //name sirve para introducir el nombre de cada familiar
        String name;
        //nota sirve para saber el valor de cada nota en espicifico
        int nota;
        //apr sirve para contar los aprobados
        int apr = 0;
        //sus sirve para contar los suspendidos
        int sus = 0;
        //fam sirve para saber cuantos familiares hay
        int fam;
        //age sirve para indicar la edad de cada familiar en especifico
        int age;
        //disc son las formulas de cada descuento
        double disc10 = 32 - ((double) (32 * 10) / 100);
        double disc8 = 32 - ((double) (32 * 8) / 100);
        double disc35 = 32 - ((double) (32 * 35) / 100);
        //price acumula el precio que la familia tiene que pagar en total
        double price = 0;
        if (Objects.equals(resp, "a")) {
            System.out.println("Dime cuantas notas vas a introducir");
            notas = in.nextInt();
            while (notas < 0) {
                System.out.println("Introduce un número positivo");
                notas = in.nextInt();
            }
            while (notas > 0) {
                System.out.println("Dame una nota");
                nota = in.nextInt();
                if (nota < 5 && nota >= 0) {
                    sus ++;
                    notas --;
                }
                else if (nota >= 5 && nota <= 10) {
                    apr ++;
                    notas --;
                } else {
                    System.out.println("La nota no es valida");
                }
            }
            if (apr > sus) {
                System.out.println("Hay mas aprobados que suspensos");
            } else if (sus > apr) {
                System.out.println("Hay mas suspensos que aprobados");
            } else {
                System.out.println("Hay el mismo número de suspensos que aprobados");
            }
        } else if (Objects.equals(resp, "b")) {
            System.out.println("Cuantos familiares sois");
            fam = in.nextInt();
            while (fam < 0) {
                System.out.println("Introduce un número valido");
                fam = in.nextInt();
            }
            //Pregunto cuantos miembros son y me aseguro de que el numero sea valido
            while (fam > 0) {
                System.out.println("Introduce tu nombre");
                trash = in.nextLine();
                name = in.nextLine();
                System.out.println(name + " introduce tu edad");
                age = in.nextInt();
                if (age >= 65) {
                    price = price + disc10;
                    fam --;
                } else if (age >= 12 && age <= 15) {
                    price = price + disc8;
                    fam --;
                } else if (age >= 4 && age <= 11) {
                    price = price + disc35;
                    fam --;
                } else if (age >= 0 && age <= 3) {
                    fam --;
                } else if (age >= 16) {
                    price = price + 32;
                    fam --;
                } else {
                    System.out.println(name + " introduce una edad valida" + trash);
                }
            }
            System.out.println("El precio total a pagar por todos los miembros de la familia es " + price + " euros");
        } else if (Objects.equals(resp, "c")) {
            System.out.println("Adios");
        } else {
            System.out.println("Introduce una opción valida");
        }
    }
}
