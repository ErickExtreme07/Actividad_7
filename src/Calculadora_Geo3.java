import java.util.Scanner;

public class Calculadora_Geo3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] resul= new double[10];
        int indiceResul = 0;

        while (true) {
            Menu();
            int opcion = obtenerOpcion(scanner);

            if (opcion == 0) {
                break;
            }

            double resultado = realizarOperacion(opcion, scanner);
            resul[indiceResul++] = resultado;
        }

        // Imprimir resultados almacenados
        System.out.println("Resultados almacenados:");
        for (int i = 0; i < indiceResul; i++) {
            System.out.println(resul[i]);
        }

        scanner.close();
    }

    // Menú de opciones
    private static void Menu() {
        System.out.println("Elija una figura Geometrica:");
        System.out.println("1. Círculo");
        System.out.println("2. Cuadrado");
        System.out.println("3. Triángulo");
        System.out.println("4. Rectángulo");
        System.out.println("5. Pentágono");
        System.out.println("6. Potencia");
        System.out.println("0. Salir");
    }

    // Funcion para obtener la opción del usuario
    private static int obtenerOpcion(Scanner scanner) {
        System.out.print("Ingrese Numero: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Ingrese un número.");
            System.out.print("Ingrese Numero ");
            scanner.next(); // Limpia
        }
        return scanner.nextInt();
    }
    private static double realizarOperacion(int opcion, Scanner scanner) {
        switch (opcion) {
            case 1:
                return AreaCirculo(scanner);
            case 2:
                return AreaCuadrado(scanner);
            case 3:
                return AreaTriangulo(scanner);
            case 4:
                return AreaRectangulo(scanner);
            case 5:
                return AreaPentagono(scanner);
            case 6:
                return calcularPotencia(scanner);
            default:
                System.out.println("Numero Invalido");
                return 0;
        }
    }
    // Funcion para cada figura geométrica
    private static double AreaCirculo(Scanner scanner) {
        System.out.println("Ingrese el radio del círculo:");
        double radio = scanner.nextDouble();
        return Math.PI * radio * radio;
    }
    private static double AreaCuadrado(Scanner scanner) {
        System.out.println("Ingrese el lado del cuadrado:");
        double lado = scanner.nextDouble();
        return lado * lado;
    }
    private static double AreaTriangulo(Scanner scanner) {
        System.out.println("Ingrese la base del triángulo:");
        double base = scanner.nextDouble();
        System.out.println("Ingrese la altura del triángulo:");
        double altura = scanner.nextDouble();
        return (base * altura) / 2;
    }
    private static double AreaRectangulo(Scanner scanner) {
        System.out.println("Ingrese la base del rectángulo:");
        double base = scanner.nextDouble();
        System.out.println("Ingrese la altura del rectángulo:");
        double altura = scanner.nextDouble();
        return base * altura;
    }
    private static double AreaPentagono(Scanner scanner) {
        System.out.println("Ingrese la longitud del lado del pentágono:");
        double lado = scanner.nextDouble();
        double apotema = lado / (2 * Math.tan(Math.PI / 5));
        return (5 * lado * apotema) / 2; // Fórmula del área de un pentágono regular

    }
    private static double calcularPotencia(Scanner scanner) {
        System.out.println("Por favor, introduzca la base:");
        double base = scanner.nextDouble();
        System.out.println("Por favor, introduzca el exponente:");
        int exponente = scanner.nextInt();
        return potencia(base, exponente);
    }
    // Método recursivo para calcular la potencia
    private static double potencia(double base, int exponente) {
        if (exponente == 0) {
            return 1;
        } else if (exponente > 0) {
            return base * potencia(base, exponente - 1);
        } else {
            return 1 / (base * potencia(base, -exponente - 1));
        }
    }
}