package Actividad;

// Clase que verifica la relación entre dos rectángulos
class Verificador {
    public static String verificarRelacion(Rectangulo a, Rectangulo b) {
        // Caso 1: Los rectángulos se sobreponen si comparten un área en común
        if ((a.getEsquina1().getX() < b.getEsquina2().getX() && a.getEsquina2().getX() > b.getEsquina1().getX()) &&
                (a.getEsquina1().getY() < b.getEsquina2().getY() && a.getEsquina2().getY() > b.getEsquina1().getY())) {
            return "Los rectángulos A y B se sobreponen.";
        }

        // Caso 2: Los rectángulos están juntos si comparten un lado en común sin
        // superponerse
        else if ((a.getEsquina2().getX() == b.getEsquina1().getX() || a.getEsquina1().getX() == b.getEsquina2().getX())
                ||
                (a.getEsquina2().getY() == b.getEsquina1().getY()
                        || a.getEsquina1().getY() == b.getEsquina2().getY())) {
            return "Los rectángulos A y B están juntos.";
        }

        // Caso 3: Los rectángulos son disjuntos si no tienen contacto ni se sobreponen
        else {
            return "Los rectángulos A y B son disjuntos.";
        }
    }
}
