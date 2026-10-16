import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Venta {
    private String codigo;
    private LocalDate fecha;
    private Sucursal sucursal;
    private Vendedor vendedor;
    private Cliente cliente;
    private List<DetalleVenta> detalles = new ArrayList<>();

    public Venta(String codigo, LocalDate fecha, Sucursal sucursal, Vendedor vendedor, Cliente cliente, List<DetalleVenta> detalles) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.sucursal = sucursal;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.detalles = detalles;
    }
    public Venta(String codigo, LocalDate fecha, Sucursal sucursal, Vendedor vendedor, Cliente cliente, DetalleVenta detalle) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.sucursal = sucursal;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.detalles = new ArrayList<>();
        this.detalles.add(detalle);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<DetalleVenta> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleVenta> detalles) {
        this.detalles = detalles;
    }

    public double calcularTotal() {
        double total = 0;
        for (DetalleVenta detalle : detalles) {
            total += detalle.getCantidad() * detalle.getPrecioUnitarioFinal();
        }
        return total;

    }
}
