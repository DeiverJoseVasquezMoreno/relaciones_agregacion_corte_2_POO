import java.util.ArrayList;
import java.util.List;

public class Equipo {

    private String nombre;
    private String entrenador;
    private List<Jugador> jugadores; // Lista de Jugadores (Agregación)

    public Equipo() {
        this.jugadores = new ArrayList<>();
    }

    public Equipo(String nombre, String entrenador) {
        this.nombre = nombre;
        this.entrenador = entrenador;
        this.jugadores = new ArrayList<>();
    }

    public void agregarJugador(Jugador jugador) {
        if (jugadores.contains(jugador)) {
            System.out.println("El jugador \"" + jugador.getNombre() + "\" ya está en el equipo \"" + nombre + "\".");
        } else {
            jugadores.add(jugador);
            System.out.println("Jugador \"" + jugador.getNombre() + "\" agregado al equipo \"" + nombre + "\".");
        }
    }

    public Jugador buscarJugador(String nombre) {
        return jugadores.stream()
                .filter(jugador -> jugador.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }

    public boolean eliminarJugador(Jugador jugador) {
        if (jugadores.remove(jugador)) {
            System.out.println("Jugador \"" + jugador.getNombre() + "\" eliminado del equipo \"" + nombre + "\".");
            return true;
        } else {
            System.out.println("El jugador \"" + jugador.getNombre() + "\" no se encuentra en el equipo \"" + nombre + "\".");
            return false;
        }
    }

    public void eliminarTodosLosJugadores() {
        jugadores.clear();
        System.out.println("Todos los jugadores han sido eliminados del equipo \"" + nombre + "\".");
    }

    public void mostrarJugadores() {
        System.out.println("Equipo: " + nombre);
        System.out.println("Entrenador: " + entrenador);
        System.out.println("Lista de Jugadores:");
        System.out.println("---------------------------");
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores en el equipo.");
        } else {
            for (Jugador jugador : jugadores) {
                jugador.mostrarInfo();
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "nombre='" + nombre + '\'' +
                ", entrenador='" + entrenador + '\'' +
                ", jugadores=" + jugadores.size() +
                '}';
    }
}
