// Main.java
public class Main {
    public static void main(String[] args) {
        // Ejercicio 1
        Equipo equipo = new Equipo("Los Titanes", "Entrenador Juan Pérez");

        Jugador jugador1 = new Jugador("Carlos López");
        Jugador jugador2 = new Jugador("María Gómez");
        Jugador jugador3 = new Jugador("Luis Fernández");
        Jugador jugador4 = new Jugador("Ana Martínez");

        System.out.println("\n--- Agregando Jugadores ---");
        equipo.agregarJugador(jugador1);
        equipo.agregarJugador(jugador2);
        equipo.agregarJugador(jugador3);
        equipo.agregarJugador(jugador4);

        System.out.println("\n--- Intentando Agregar un Jugador Existente ---");
        equipo.agregarJugador(jugador2);

        System.out.println("\n--- Lista de Jugadores ---");
        equipo.mostrarJugadores();

        System.out.println("\n--- Buscando Jugador: Luis Fernández ---");
        Jugador jugadorBuscado = equipo.buscarJugador("Luis Fernández");
        if (jugadorBuscado != null) {
            jugadorBuscado.mostrarInfo();
        } else {
            System.out.println("Jugador no encontrado.");
        }

        System.out.println("\n--- Eliminando Jugador: María Gómez ---");
        equipo.eliminarJugador(jugador2);

        System.out.println("\n--- Lista de Jugadores Después de la Eliminación ---");
        equipo.mostrarJugadores();

        System.out.println("\n--- Eliminando Todos los Jugadores ---");
        equipo.eliminarTodosLosJugadores();

        System.out.println("\n--- Lista de Jugadores Después de Eliminar Todos ---");
        equipo.mostrarJugadores();

        System.out.println();
        System.out.println();

        // Ejercicio 2
        Casa miCasa = new Casa("Calle Falsa 123");

        // Crear algunas puertas
        Puerta puerta1 = new Puerta("Modelo A", "Blanca", "Madera");
        Puerta puerta2 = new Puerta("Modelo B", "Negra", "Metal");
        Puerta puerta3 = new Puerta("Modelo C", "Roja", "Vidrio");

        System.out.println("\n--- Agregando Puertas ---");
        miCasa.agregarPuerta(puerta1);
        miCasa.agregarPuerta(puerta2);
        miCasa.agregarPuerta(puerta3);

        System.out.println("\n--- Intentando Agregar una Puerta Existente ---");
        miCasa.agregarPuerta(puerta2);

        System.out.println("\n--- Lista de Puertas ---");
        miCasa.mostrarPuertas();

        System.out.println("\n--- Buscando Puerta: Modelo B ---");
        Puerta buscada = miCasa.buscarPuerta("Modelo B");
        if (buscada != null) {
            buscada.mostrarInfo();
        } else {
            System.out.println("Puerta no encontrada.");
        }

        System.out.println("\n--- Eliminando Puerta: Modelo B ---");
        try {
            miCasa.eliminarPuerta(puerta2);
        } catch (PuertaException e) {
            System.out.println("Error al eliminar puerta: " + e.getMessage());
        }

        System.out.println("\n--- Lista de Puertas Después de la Eliminación ---");
        miCasa.mostrarPuertas();

        System.out.println("\n--- Intentando Eliminar Puerta: Modelo A y Modelo C ---");
        try {
            miCasa.eliminarPuerta(puerta1);
            miCasa.eliminarPuerta(puerta3); // Esto debería lanzar una excepción
        } catch (PuertaException e) {
            System.out.println("Error al eliminar puerta: " + e.getMessage());
        }

        System.out.println("\n--- Lista de Puertas Final ---");
        miCasa.mostrarPuertas();

        System.out.println("\n--- Intentando Eliminar Todas las Puertas ---");
        try {
            miCasa.eliminarTodasLasPuertas();
        } catch (PuertaException e) {
            System.out.println("Error al eliminar todas las puertas: " + e.getMessage());
        }

        System.out.println();
        System.out.println();

        // Ejercicio 3
        Persona persona1 = new Persona("Carlos López", 30);
        Persona persona2 = new Persona("María Gómez", 28);
        Persona persona3 = new Persona("Luis Fernández", 35);
        Persona persona4 = new Persona("Ana Martínez", 25);

        Evento evento1 = new Evento("Boda de Juan y Luisa", "12/06/2024", "Hotel Paraíso");
        Evento evento2 = new Evento("Aniversario de Empresa", "15/09/2024", "Centro de Convenciones");
        Evento evento3 = new Evento("Fiesta de Graduación", "20/12/2024", "Salón de Eventos");

        System.out.println("\n--- Información Inicial ---");
        persona1.mostrarInfo();
        persona2.mostrarInfo();
        persona3.mostrarInfo();
        persona4.mostrarInfo();
        evento1.mostrarInfo();
        evento2.mostrarInfo();
        evento3.mostrarInfo();

        System.out.println("\n--- Participaciones en Eventos ---");
        persona1.participarEnEvento(evento1, "Novio");
        persona2.participarEnEvento(evento1, "Novia");
        persona3.participarEnEvento(evento2, "Director General");
        persona4.participarEnEvento(evento3, "Graduada");

        System.out.println("\n--- Intentando Participar en un Evento ya Asignado ---");
        persona1.participarEnEvento(evento1, "Novio");

        System.out.println("\n--- Información Después de las Asignaciones ---");
        persona1.mostrarInfo();
        persona2.mostrarInfo();
        persona3.mostrarInfo();
        persona4.mostrarInfo();
        evento1.mostrarInfo();
        evento2.mostrarInfo();
        evento3.mostrarInfo();

        System.out.println("\n--- Buscando Participación: María Gómez en 'Boda de Juan y Luisa' ---");
        Matrimonio matrimonioBuscado = null;
        for (Matrimonio matrimonio : persona2.getMatrimonios()) {
            if (matrimonio.getEvento().equals(evento1)) {
                matrimonioBuscado = matrimonio;
                break;
            }
        }
        if (matrimonioBuscado != null) {
            matrimonioBuscado.mostrarAsignacion();
        } else {
            System.out.println("Participación no encontrada.");
        }

        System.out.println("\n--- Abandonando Evento: 'Fiesta de Graduación' por Ana Martínez ---");
        persona4.abandonarEvento(evento3);

        System.out.println("\n--- Información Después de Abandonar el Evento ---");
        persona4.mostrarInfo();
        evento3.mostrarInfo();

        System.out.println("\n--- Intentando Abandonar un Evento no Asignado ---");
        persona4.abandonarEvento(evento1);
    }
}
