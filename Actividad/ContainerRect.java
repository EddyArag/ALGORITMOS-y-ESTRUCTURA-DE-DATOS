// Clase contenedora de rectángulos
class ContainerRect {
    private Rectangulo[] rectangulos;
    private double[] distancias;
    private double[] areas;
    private int numRec;
    private int n;

    public ContainerRect(int capacidad) {
        this.n = capacidad;
        this.rectangulos = new Rectangulo[2];
        this.distancias = new double[2];
        this.areas = new double[2];
        this.numRec = 0;
    }

    public void addRectangulo(Rectangulo r) {
        if (numRec < n) {
            rectangulos[numRec] = r;
            distancias[numRec] = r.getEsquina1().distancia(r.getEsquina2());
            areas[numRec] = r.calcularArea();
            numRec++;
        } else {
            System.out.println("Solo se pueden almacenar dos rectángulo");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rectángulo\tCoordenadas\tDistancia\tÁrea\n");
        for (int i = 0; i < numRec; i++) {
            sb.append((i + 1) + "\t" + rectangulos[i] + "\t" + String.format("%.3f", distancias[i]) + "\t"
                    + String.format("%.2f", areas[i]) + "\n");
        }
        return sb.toString();
    }
}
