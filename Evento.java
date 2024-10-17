import java.util.ArrayList;
import java.util.List;

public class Evento {

    private String nombre;
    private String fecha;
    private String ubicacion;
    private List<Matrimonio> matrimonios; // Lista de matrimonios asociados

    public Evento(String nombre, String fecha, String ubicacion) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.matrimonios = new ArrayList<>();
    }

    public void agregarMatrimonio(Matrimonio matrimonio) {
        if (!matrimonios.contains(matrimonio)) {
            matrimonios.add(matrimonio);
        }
    }

    public void removerMatrimonio(Matrimonio matrimonio) {
        matrimonios.remove(matrimonio);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<Matrimonio> getMatrimonios() {
        return matrimonios;
    }

    public void setMatrimonios(List<Matrimonio> matrimonios) {
        this.matrimonios = matrimonios;
    }

    public void mostrarInfo() {
        System.out.println("Información del Evento:");
        System.out.println("Nombre: " + nombre);
        System.out.println("Fecha: " + fecha);
        System.out.println("Ubicación: " + ubicacion);
        if (matrimonios.isEmpty()) {
            System.out.println("Participantes: Ninguno");
        } else {
            System.out.println("Participantes:");
            for (Matrimonio matrimonio : matrimonios) {
                System.out.println("- Persona: " + matrimonio.getPersona().getNombre() + ", Rol: " + matrimonio.getRol());
            }
        }
        System.out.println("---------------------------");
    }

    @Override
    public String toString() {
        return "Evento{" +
                "nombre='" + nombre + '\'' +
                ", fecha='" + fecha + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Evento evento = (Evento) o;

        return nombre != null ? nombre.equals(evento.nombre) : evento.nombre == null;
    }

    @Override
    public int hashCode() {
        return nombre != null ? nombre.hashCode() : 0;
    }
}
