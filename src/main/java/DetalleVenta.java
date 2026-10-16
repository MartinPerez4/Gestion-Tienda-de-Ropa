public class DetalleVenta {
    private Inventario inventario;
    private int cantidad;
    private double precioUnitarioFinal;
    private double subtotal;

    public DetalleVenta(Inventario inventario, int cantidad, double precioUnitarioFinal, double subtotal) {
        this.inventario = inventario;
        this.cantidad = cantidad;
        this.precioUnitarioFinal = precioUnitarioFinal;
        this.subtotal = subtotal;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitarioFinal() {
        return precioUnitarioFinal;
    }

    public void setPrecioUnitarioFinal(double precioUnitarioFinal) {
        this.precioUnitarioFinal = precioUnitarioFinal;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    public double calcularPrecioUnitarioFinal(double descuento) {
        double conRecargo = inventario.getPrenda().calcularPrecioConRecargo();
        return conRecargo * (1 - descuento);
    }
}
