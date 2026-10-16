public class Cliente extends Persona{

    private String codigoAfiliacion;
    private CategoriaCliente categoriaCliente;

    public Cliente(String documento, String nombre, String telefono, String correo, CategoriaCliente categoriaCliente) {
        super(documento, nombre, telefono, correo);
        this.categoriaCliente = categoriaCliente;
    }

    public String getCodigoAfiliacion() {
        return codigoAfiliacion;
    }

    public void setCodigoAfiliacion(String codigoAfiliacion) {
        this.codigoAfiliacion = codigoAfiliacion;
    }

    public CategoriaCliente getCategoriaCliente() {
        return categoriaCliente;
    }

    public void setCategoriaCliente(CategoriaCliente categoriaCliente) {
        this.categoriaCliente = categoriaCliente;
    }
    public double obtenerDescuento() {
        return switch (categoriaCliente) {
            case ORO   -> 0.15;
            case PLATA -> 0.10;
            case BRONCE    -> 0.05;
        };
    }
}
