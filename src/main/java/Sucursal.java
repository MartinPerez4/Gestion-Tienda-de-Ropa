import java.util.ArrayList;
import java.util.List;

public class Sucursal {
    private String codigo;
    private String nombre;
    private String direccion;
    private String ciudad;

    private List<Inventario> inventarios = new ArrayList<>();
    private List<Venta> ventas = new ArrayList<>();

    // Lista
    private static List<Sucursal> listaSucursales = new ArrayList<>();

    public Sucursal(String codigo, String nombre, String direccion, String ciudad, List<Inventario> inventarios, List<Venta> ventas) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.inventarios = inventarios;
        this.ventas = ventas;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public static List<Sucursal> getListaSucursales() {
        return listaSucursales;
    }

    public static void setListaSucursales(List<Sucursal> listaSucursales) {
        Sucursal.listaSucursales = listaSucursales;
    }

    public List<Inventario> getInventarios() {
        return inventarios;
    }

    public void setInventarios(List<Inventario> inventarios) {
        this.inventarios = inventarios;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    // CRUD
    // 1. CREATE (Registrar con verificación de código único)
    public static boolean registrar(Sucursal nuevaSucursal) {
        // Verificar si ya existe una sucursal con ese mismo código
        for (Sucursal s : listaSucursales) {
            if (s.getCodigo().equalsIgnoreCase(nuevaSucursal.getCodigo())) {
                System.out.println(" Error: Ya existe una sucursal registrada con el código " + nuevaSucursal.getCodigo());
                return false;
            }
        }
        // Si no existe, se añade a la lista
        listaSucursales.add(nuevaSucursal);
        System.out.println(" Sucursal registrada exitosamente.");
        return true;
    }

    // 2. READ (Listar todas las sucursales)
    public static void listar() {
        if (listaSucursales.isEmpty()) {
            System.out.println("No hay sucursales registradas.");
            return;
        }
        for (Sucursal s : listaSucursales) {
            System.out.println(s);
        }
    }

    // Método auxiliar para buscar por código (sirve para actualizar y eliminar)
    public static Sucursal buscarPorCodigo(String codigo) {
        for (Sucursal s : listaSucursales) {
            if (s.getCodigo().equalsIgnoreCase(codigo)) {
                return s;
            }
        }
        return null;
    }

    // 3. UPDATE (Actualizar datos de una sucursal buscándola por su código)
    public static boolean actualizar(String codigo, String nuevoNombre, String nuevaDireccion, String nuevaCiudad) {
        Sucursal sucursalEncontrada = buscarPorCodigo(codigo);
        if (sucursalEncontrada != null) {
            sucursalEncontrada.nombre = nuevoNombre;
            sucursalEncontrada.direccion = nuevaDireccion;
            sucursalEncontrada.ciudad = nuevaCiudad;
            System.out.println(" Sucursal actualizada correctamente.");
            return true;
        }
        System.out.println(" Error: No se encontró una sucursal con el código " + codigo);
        return false;
    }

    // 4. DELETE (Eliminar una sucursal por su código)
    public static boolean eliminar(String codigo) {
        Sucursal sucursalEncontrada = buscarPorCodigo(codigo);
        if (sucursalEncontrada != null) {
            listaSucursales.remove(sucursalEncontrada);
            System.out.println(" Sucursal eliminada correctamente.");
            return true;
        }
        System.out.println(" Error: No se encontró una sucursal con el código " + codigo);
        return false;
    }

    public double calcularIngresos() {
        double total = 0;
        for (Venta venta : ventas) {
            total += venta.calcularTotal();
        }
        return total;
    }
}
