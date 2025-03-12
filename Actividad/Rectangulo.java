package Actividad;

// Clase que representa un rectángulo definido por dos coordenadas
class Rectangulo {
    private Coordenada esquina1;
    private Coordenada esquina2;

    public Rectangulo(Coordenada c1, Coordenada c2) {
        ordenarEsquinas(c1, c2);
    }

    // Método que ordena las esquinas para asegurar que siempre la esquina inferior
    // izquierda
    // sea esquina1 y la superior derecha sea esquina2
    private void ordenarEsquinas(Coordenada c1, Coordenada c2) {
        double xMenor = Math.min(c1.getX(), c2.getX());
        double yMenor = Math.min(c1.getY(), c2.getY());
        double xMayor = Math.max(c1.getX(), c2.getX());
        double yMayor = Math.max(c1.getY(), c2.getY());
        this.esquina1 = new Coordenada(xMenor, yMenor);
        this.esquina2 = new Coordenada(xMayor, yMayor);
    }

    public Coordenada getEsquina1() {
        return esquina1;
    }

    public Coordenada getEsquina2() {
        return esquina2;
    }

    public double calcularArea() {
        return (esquina2.getX() - esquina1.getX()) * (esquina2.getY() - esquina1.getY());
    }

    @Override
    public String toString() {
        return "Rectángulo = (" + esquina1 + ", " + esquina2 + ")";
    }
}
