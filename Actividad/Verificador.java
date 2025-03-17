ackage Actividad;

// Clase que verifica la relación entre dos rectángulos
class Verificador {
    public static boolean SobrePuestos(Rectangulo a, Rectangulo b) {
        // Caso 1: Los rectángulos se sobreponen si comparten un área en común

        if ((a.getEsquina1().getX() < b.getEsquina2().getX() && a.getEsquina2().getX() > b.getEsquina1().getX()) &&
                (a.getEsquina1().getY() < b.getEsquina2().getY() && a.getEsquina2().getY() > b.getEsquina1().getY())) {
            return true;
        }
        return false;
    }
    public static boolean esJuntos(Rectangulo a, Rectangulo b) {

        // Caso 2: Los rectángulos están juntos si comparten un lado en común sin
        // superponerse
        if ((SobrePuestos(a,b)) || (a.getEsquina2().getX() == b.getEsquina1().getX() || a.getEsquina1().getX() == b.getEsquina2().getX()) || (a.getEsquina2().getY() == b.getEsquina1().getY() || a.getEsquina1().getY() == b.getEsquina2().getY())   ) {
            return true;
        }
        return false;
    }
    public static boolean Disjuntos(Rectangulo a, Rectangulo b) {
        // Caso 3: Los rectángulos son disjuntos si no tienen contacto ni se sobreponen
        if(esJuntos(a, b) || SobrePuestos(a, b)) {
            return false;
        }
        return true;
    }
}
