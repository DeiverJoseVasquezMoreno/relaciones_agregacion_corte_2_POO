public class Puerta {

    private String modelo;
    private String color;
    private String material;

    public Puerta(String modelo, String color, String material) {
        this.modelo = modelo;
        this.color = color;
        this.material = material;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void mostrarInfo() {
        System.out.println("Modelo de Puerta: " + modelo);
        System.out.println("Color: " + color);
        System.out.println("Material: " + material);
        System.out.println("---------------------------");
    }

    @Override
    public String toString() {
        return "Puerta{" +
                "modelo='" + modelo + '\'' +
                ", color='" + color + '\'' +
                ", material='" + material + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Puerta puerta = (Puerta) o;

        return modelo != null ? modelo.equals(puerta.modelo) : puerta.modelo == null;
    }

    @Override
    public int hashCode() {
        return modelo != null ? modelo.hashCode() : 0;
    }
}
