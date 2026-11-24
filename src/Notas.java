/**
 * Clase que permite calcular y gestionar las notas de los alumnos.
 * Calcula la media de tres notas, comprueba si el alumno ha aprobado
 * y obtiene su calificación.
 * La nota final se calcula restando 0.1 puntos por cada falta
 * de asistencia a la nota media, sin bajar de cero.
 *
 * @author Tu nombre
 * @version 1.0
 */
public class Notas {

    /** Nota mínima necesaria para aprobar. */
    public static final double NOTA_APROBADO = 5.0;

    /**
     * Calcula la media aritmética de tres notas.
     *
     * @param nota1 Primera nota.
     * @param nota2 Segunda nota.
     * @param nota3 Tercera nota.
     * @return Media de las tres notas.
     */
    public static double media(double nota1, double nota2, double nota3) {
        return (nota1 + nota2 + nota3) / 3;
    }

    /**
     * Comprueba si un alumno ha aprobado.
     *
     * @param nota Nota del alumno.
     * @return true si la nota es igual o superior a 5,
     *         false en caso contrario.
     */
    public static boolean estaAprobado(double nota) {
        return nota >= NOTA_APROBADO;
    }

    /**
     * Obtiene la calificación correspondiente a una nota.
     * Insuficiente: inferior a 5.
     * Suficiente: desde 5 hasta menos de 6.
     * Bien: desde 6 hasta menos de 7.
     * Notable: desde 7 hasta menos de 9.
     * Sobresaliente: igual o superior a 9.
     *
     * @param nota Nota del alumno.
     * @return Calificación en formato de texto.
     */
    public static String calificacion(double nota) {
        if (nota < 5) {
            return "Insuficiente";
        } else if (nota < 6) {
            return "Suficiente";
        } else if (nota < 7) {
            return "Bien";
        } else if (nota < 9) {
            return "Notable";
        } else {
            return "Sobresaliente";
        }
    }

    /**
     * Calcula la nota final restando 0.1 puntos por cada falta.
     * Si el resultado es negativo, devuelve 0.
     * Por ejemplo, notaFinal(0.5, 10) devuelve 0.0
     * porque al restar un punto a 0.5 se obtiene -0.5
     * y no se permiten notas finales negativas.
     *
     * @param media Nota media del alumno.
     * @param faltas Número de faltas de asistencia.
     * @return Nota final después de aplicar la penalización.
     */
    public static double notaFinal(double media, int faltas) {
        double nota = media - faltas * 0.1;
        if (nota < 0) {
            nota = 0;
        }
        return nota;
    }

    /**
     * Muestra el nombre, la nota y la calificación del alumno.
     *
     * @param nombre Nombre del alumno.
     * @param nota Nota del alumno.
     */
    public static void mostrarBoletin(String nombre, double nota) {
        System.out.println(nombre + ": " + nota
                + " (" + calificacion(nota) + ")");
    }

    /**
     * Método principal que ejecuta las pruebas de la clase.
     *
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        double m = media(6, 7.5, 9);
        System.out.println("Media: " + m);
        System.out.println("¿Aprobado? " + estaAprobado(m));
        System.out.println("Nota final con 4 faltas: " + notaFinal(m, 4));
        mostrarBoletin("Lucía", 8.5);

        System.out.println(notaFinal(0.5, 10));
        /**
        *Devuelve 0,0
        *El método resta 0,1 puntos por cada falta de asistencia 
        *pero no puedes tener nota negativa porque el programa no lo permite, por eso sale 0.0          
        */
    }
}
