import java.util.Objects;

public class Matrimonio {

    private Persona persona;
    private Evento evento;
    private String rol; // Rol de la persona en el evento

    public Matrimonio(Persona persona, Evento evento, String rol) {
        this.persona = persona;
        this.evento = evento;
        this.rol = rol;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void mostrarAsignacion() {
        System.out.println(persona.getNombre() + " está participando en el evento \"" + evento.getNombre() + "\" como " + rol + ".");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Matrimonio that = (Matrimonio) o;

        if (!Objects.equals(persona, that.persona)) return false;
        return Objects.equals(evento, that.evento);
    }

    @Override
    public int hashCode() {
        int result = persona != null ? persona.hashCode() : 0;
        result = 31 * result + (evento != null ? evento.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Matrimonio{" +
                "persona=" + persona.getNombre() +
                ", evento=" + evento.getNombre() +
                ", rol='" + rol + '\'' +
                '}';
    }
}
