package Actividad;

import java.awt.*;
import javax.swing.*;
import java.util.Scanner;

public class Principal extends JPanel {
    private Rectangulo rect1, rect2, interseccion;

    // Constructor que recibe los rectángulos y calcula la intersección
    public Principal(Rectangulo rect1, Rectangulo rect2) {
        this.rect1 = rect1;
        this.rect2 = rect2;
        this.interseccion = rectanguloSobre(rect1, rect2);
    }

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
        boolean  relacion = Verificador.SobrePuestos(rect1, rect2);
        System.out.println(relacion);

        if (relacion) {
            Rectangulo interseccion = rectanguloSobre(rect1, rect2);
            if (interseccion != null) {
                System.out.println("Área de sobreposición: " + interseccion.calcularArea());
            }
        }
        // Crear ventana con el componente gráfico
        JFrame ventana = new JFrame("Dibujo de Rectángulos");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(600, 600);

        // Agregar panel gráfico con los rectángulos
        Principal panel = new Principal(rect1, rect2);
        ventana.add(panel);
        ventana.setVisible(true);


        scanner.close();
    }

    // Método para calcular la intersección entre dos rectángulos
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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Convertir Graphics a Graphics2D para mayor control
        Graphics2D g2d = (Graphics2D) g;

        // Definir el factor de escala para agrandar el dibujo
        double factorEscala = 100.0;

        // Escalar las coordenadas de los rectángulos
        int x1 = (int) (rect1.getEsquina1().getX() * factorEscala);
        int y1 = (int) (rect1.getEsquina1().getY() * factorEscala);
        int x2 = (int) (rect1.getEsquina2().getX() * factorEscala);
        int y2 = (int) (rect1.getEsquina2().getY() * factorEscala);

        // Establecer color y dibujar el primer rectángulo
        g2d.setColor(Color.BLUE);
        g2d.fillRect(x1, y1, x2 - x1, y2 - y1);

        // Escalar las coordenadas del segundo rectángulo
        x1 = (int) (rect2.getEsquina1().getX() * factorEscala);
        y1 = (int) (rect2.getEsquina1().getY() * factorEscala);
        x2 = (int) (rect2.getEsquina2().getX() * factorEscala);
        y2 = (int) (rect2.getEsquina2().getY() * factorEscala);

        // Establecer color y dibujar el segundo rectángulo
        g2d.setColor(Color.RED);
        g2d.fillRect(x1, y1, x2 - x1, y2 - y1);

        // Si hay intersección, escalar las coordenadas y dibujarla con otro color
        if (interseccion != null) {
            x1 = (int) (interseccion.getEsquina1().getX() * factorEscala);
            y1 = (int) (interseccion.getEsquina1().getY() * factorEscala);
            x2 = (int) (interseccion.getEsquina2().getX() * factorEscala);
            y2 = (int) (interseccion.getEsquina2().getY() * factorEscala);

            g2d.setColor(new Color(0, 255, 0, 128)); // Verde semitransparente
            g2d.fillRect(x1, y1, x2 - x1, y2 - y1);
        }
    }

}
