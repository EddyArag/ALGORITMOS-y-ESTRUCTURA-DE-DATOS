package Actividad;
// Clase contenedora de rectángulos
class ContainerRect {
    private Rectangulo[] rectangulos;
    private double[] distancias;
    private double[] areas;
    private int numRec;

    public ContainerRect() {
        this.rectangulos = new Rectangulo[2];
        this.distancias = new double[2];
        this.areas = new double[2];
        this.numRec = 0;
    }

    public void addRectangulo(Rectangulo r) {
        if (numRec < 2) {
            rectangulos[numRec] = r;
            distancias[numRec] = r.getEsquina1().distancia(r.getEsquina2());
            areas[numRec] = r.calcularArea();
            numRec++;
        } else {
            System.out.println("Solo se pueden almacenar dos rectangulos");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rectangulo\tCoordenadas\t\t\tDistancia\tArea\n");
        for (int i = 0; i < numRec; i++) {
            Coordenada e1 = rectangulos[i].getEsquina1();
            Coordenada e2 = rectangulos[i].getEsquina2();
            sb.append((i + 1) + "\t\t(" + e1.getX() + ", " + e1.getY() + ") - (" + e2.getX() + ", " + e2.getY() + ")"
                    + "\t" + String.format("%.3f", distancias[i]) + "\t" + "\t" + String.format("%.2f", areas[i]) + "\n");
        }
        return sb.toString();
    }
}
