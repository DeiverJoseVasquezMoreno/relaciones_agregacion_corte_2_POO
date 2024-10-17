import java.util.ArrayList;
import java.util.List;

public class Persona {

    private String nombre;
    private int edad;
    private List<Matrimonio> matrimonios; // Lista de matrimonios asociados

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.matrimonios = new ArrayList<>();
    }

    public void participarEnEvento(Evento evento, String rol) {
        Matrimonio matrimonio = new Matrimonio(this, evento, rol);
        if (!matrimonios.contains(matrimonio)) {
            matrimonios.add(matrimonio);
            evento.agregarMatrimonio(matrimonio);
            System.out.println(this.nombre + " ha participado en el evento \"" + evento.getNombre() + "\" como " + rol + ".");
        } else {
            System.out.println(this.nombre + " ya está participando en el evento \"" + evento.getNombre() + "\".");
        }
    }

    public void abandonarEvento(Evento evento) {
        Matrimonio matrimonioAEliminar = null;
        for (Matrimonio matrimonio : matrimonios) {
            if (matrimonio.getEvento().equals(evento)) {
                matrimonioAEliminar = matrimonio;
                break;
            }
        }
        if (matrimonioAEliminar != null) {
            matrimonios.remove(matrimonioAEliminar);
            evento.removerMatrimonio(matrimonioAEliminar);
            System.out.println(this.nombre + " ha abandonado el evento \"" + evento.getNombre() + "\".");
        } else {
            System.out.println(this.nombre + " no está participando en el evento \"" + evento.getNombre() + "\".");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<Matrimonio> getMatrimonios() {
        return matrimonios;
    }

    public void setMatrimonios(List<Matrimonio> matrimonios) {
        this.matrimonios = matrimonios;
    }

    public void mostrarInfo() {
        System.out.println("Información de la Persona:");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad + " años");
        if (matrimonios.isEmpty()) {
            System.out.println("Participaciones en Eventos: Ninguna");
        } else {
            System.out.println("Participaciones en Eventos:");
            for (Matrimonio matrimonio : matrimonios) {
                System.out.println("- Evento: " + matrimonio.getEvento().getNombre() + ", Rol: " + matrimonio.getRol());
            }
        }
        System.out.println("---------------------------");
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Persona persona = (Persona) o;

        return nombre != null ? nombre.equals(persona.nombre) : persona.nombre == null;
    }

    @Override
    public int hashCode() {
        return nombre != null ? nombre.hashCode() : 0;
    }
}
