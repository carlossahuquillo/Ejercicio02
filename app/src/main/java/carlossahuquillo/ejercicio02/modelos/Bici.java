package carlossahuquillo.ejercicio02.modelos;

public class Bici {
    private String marca;
    private String pulgadas;

    public Bici() {
    }

    public Bici(String marca, String pulgadas) {
        this.marca = marca;
        this.pulgadas = pulgadas;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(String pulgadas) {
        this.pulgadas = pulgadas;
    }

    @Override
    public String toString() {
        return "marca: " + marca + ", pulgadas: " + pulgadas;
    }
}
