import java.util.ArrayList;
import java.util.List;

public class Casa {

    private String direccion;
    private List<Puerta> puertas;

    public Casa(String direccion) {
        this.direccion = direccion;
        this.puertas = new ArrayList<>();
    }

    public void agregarPuerta(Puerta puerta) {
        if (puertas.contains(puerta)) {
            System.out.println("La puerta \"" + puerta.getModelo() + "\" ya existe en la casa.");
        } else {
            puertas.add(puerta);
            System.out.println("Puerta \"" + puerta.getModelo() + "\" agregada a la casa.");
        }
    }

    public Puerta buscarPuerta(String modelo) {
        return puertas.stream()
                .filter(puerta -> puerta.getModelo().equalsIgnoreCase(modelo))
                .findFirst()
                .orElse(null);
    }

    public void eliminarPuerta(Puerta puerta) throws PuertaException {
        if (!puertas.contains(puerta)) {
            throw new PuertaException("La puerta \"" + puerta.getModelo() + "\" no existe en la casa.");
        }
        if (puertas.size() <= 1) {
            throw new PuertaException("No se puede eliminar la puerta. La casa debe tener al menos una puerta.");
        }
        puertas.remove(puerta);
        System.out.println("Puerta \"" + puerta.getModelo() + "\" eliminada de la casa.");
    }

    public void eliminarTodasLasPuertas() throws PuertaException {
        if (puertas.isEmpty()) {
            throw new PuertaException("No hay puertas para eliminar.");
        }
        throw new PuertaException("No se puede eliminar todas las puertas. La casa debe tener al menos una puerta.");
    }

    public void mostrarPuertas() {
        System.out.println("Casa en: " + direccion);
        System.out.println("Lista de Puertas:");
        System.out.println("---------------------------");
        if (puertas.isEmpty()) {
            System.out.println("No hay puertas en la casa.");
        } else {
            for (Puerta puerta : puertas) {
                puerta.mostrarInfo();
            }
        }
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Puerta> getPuertas() {
        return puertas;
    }

    public void setPuertas(List<Puerta> puertas) {
        this.puertas = puertas;
    }

    @Override
    public String toString() {
        return "Casa{" +
                "direccion='" + direccion + '\'' +
                ", puertas=" + puertas.size() +
                '}';
    }
}
