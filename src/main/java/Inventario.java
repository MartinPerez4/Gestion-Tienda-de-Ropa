public class Inventario {
    private Sucursal sucursal;
    private Prenda prenda;
    private String talla;
    private String color;
    private int cantidadDisp;

    public Inventario(Sucursal sucursal, Prenda prenda, String talla, String color, int cantidadDisp) {
        this.sucursal = sucursal;
        this.prenda = prenda;
        this.talla = talla;
        this.color = color;
        this.cantidadDisp = cantidadDisp;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Prenda getPrenda() {
        return prenda;
    }

    public void setPrenda(Prenda prenda) {
        this.prenda = prenda;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCantidadDisp() {
        return cantidadDisp;
    }

    public void setCantidadDisp(int cantidadDisp) {
        this.cantidadDisp = cantidadDisp;
    }
}
