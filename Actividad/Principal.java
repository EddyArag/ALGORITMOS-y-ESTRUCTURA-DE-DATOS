package Actividad;

import java.util.Scanner;

// Clase principal que maneja la interacción con el usuario
public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ContainerRect contenedor = new ContainerRect();

        System.out.println("Ingrese la coordenada x de la primera esquina del 1er rectángulo:");
        double x1 = scanner.nextDouble();
        System.out.println("Ingrese la coordenada y de la primera esquina del 1er rectángulo:");
        double y1 = scanner.nextDouble();
        System.out.println("Ingrese la coordenada x de la segunda esquina del 1er rectángulo:");
        double x2 = scanner.nextDouble();
        System.out.println("Ingrese la coordenada y de la segunda esquina del 1er rectángulo:");
        double y2 = scanner.nextDouble();
        Rectangulo rect1 = new Rectangulo(new Coordenada(x1, y1), new Coordenada(x2, y2));

        System.out.println("Ingrese la coordenada x de la primera esquina del 2do rectángulo:");
        double x3 = scanner.nextDouble();
        System.out.println("Ingrese la coordenada y de la primera esquina del 2do rectángulo:");
        double y3 = scanner.nextDouble();
        System.out.println("Ingrese la coordenada x de la segunda esquina del 2do rectángulo:");
        double x4 = scanner.nextDouble();
        System.out.println("Ingrese la coordenada y de la segunda esquina del 2do rectángulo:");
        double y4 = scanner.nextDouble();
        Rectangulo rect2 = new Rectangulo(new Coordenada(x3, y3), new Coordenada(x4, y4));

        contenedor.addRectangulo(rect1);
        contenedor.addRectangulo(rect2);

        System.out.println("\n Contenedor:");
        System.out.println(contenedor);

        System.out.println(rect1);
        System.out.println(rect2);

        // Evaluar las relaciones con los métodos booleanos
        if (Verificador.esSobrePos(rect1, rect2)) {
            System.out.println("Los rectángulos A y B se sobreponen.");
            Rectangulo interseccion = rectanguloSobre(rect1, rect2);
            if (interseccion != null) {
                System.out.println("Área de sobreposición: " + interseccion.calcularArea());
            }
        } else if (Verificador.esJunto(rect1, rect2)) {
            System.out.println("Los rectángulos A y B están juntos.");
            } else {
                System.out.println("Los rectángulos A y B son disjuntos.");
            }

        scanner.close();
    }

    // Método de clase que calcula el rectángulo de sobreposición entre dos
    // rectángulos
    public static Rectangulo rectanguloSobre(Rectangulo a, Rectangulo b) {
        double x1 = Math.max(a.getEsquina1().getX(), b.getEsquina1().getX());
        double y1 = Math.max(a.getEsquina1().getY(), b.getEsquina1().getY());
        double x2 = Math.min(a.getEsquina2().getX(), b.getEsquina2().getX());
        double y2 = Math.min(a.getEsquina2().getY(), b.getEsquina2().getY());

        if (x1 < x2 && y1 < y2) {
            return new Rectangulo(new Coordenada(x1, y1), new Coordenada(x2, y2));
        } else {
            return null;
        }
    }
}
