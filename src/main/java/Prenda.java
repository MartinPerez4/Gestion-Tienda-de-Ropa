import java.util.ArrayList;
import java.util.List;

public class Prenda {
    private String codigo;
    private String nombre;
    private String marca;
    protected double precioBase;

    private  CategoriaPrenda categoriaPrenda;

    //Lista
    private static List<Prenda> listaPrendas = new ArrayList<>();

    public Prenda(String codigo, String nombre, String marca, double precioBase, CategoriaPrenda categoriaPrenda) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.marca = marca;
        this.precioBase = precioBase;
        this.categoriaPrenda = categoriaPrenda;
        listaPrendas= new ArrayList<>();
    }

    public Prenda() {
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public CategoriaPrenda getCategoriaPrenda() {
        return categoriaPrenda;
    }

    public void setCategoriaPrenda(CategoriaPrenda categoriaPrenda) {
        this.categoriaPrenda = categoriaPrenda;
    }

    public static List<Prenda> getListaPrendas() {
        return listaPrendas;
    }

    public static void setListaPrendas(List<Prenda> listaPrendas) {
        Prenda.listaPrendas = listaPrendas;
    }

    //CRUD

    // 1. CREATE (Registrar con verificación de código único)
    public static boolean registrar(Prenda nuevaPrenda) {
        // Verificar si ya existe una prenda con ese mismo código
        for (Prenda p : listaPrendas) {
            if (p.getCodigo().equalsIgnoreCase(nuevaPrenda.getCodigo())) {
                System.out.println(" Error: Ya existe una prenda con el código " + nuevaPrenda.getCodigo());
                return false;
            }
        }
        // Si no existe, se añade a la lista
        listaPrendas.add(nuevaPrenda);
        System.out.println(" Prenda registrada exitosamente.");
        return true;
    }

    // 2. READ (Listar todas las prendas)
    public static void listar() {
        if (listaPrendas.isEmpty()) {
            System.out.println("No hay prendas registradas.");
            return;
        }
        for (Prenda p : listaPrendas) {
            System.out.println(p);
        }
    }

    // Método auxiliar para buscar por código (sirve para actualizar y eliminar)
    public static Prenda buscarPorCodigo(String codigo) {
        for (Prenda p : listaPrendas) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        return null;
    }

    // 3. UPDATE (Actualizar datos de una prenda buscándola por su código)
    public static boolean actualizar(String codigo, String nuevoNombre, String nuevaMarca, double nuevoPrecioBase) {
        Prenda prendaEncontrada = buscarPorCodigo(codigo);
        if (prendaEncontrada != null) {
            prendaEncontrada.nombre = nuevoNombre;
            prendaEncontrada.marca = nuevaMarca;
            prendaEncontrada.precioBase = nuevoPrecioBase;
            System.out.println(" Prenda actualizada correctamente.");
            return true;
        }
        System.out.println(" Error: No se encontró una prenda con el código " + codigo);
        return false;
    }

    // 4. DELETE (Eliminar una prenda por su código)
    public static boolean eliminar(String codigo) {
        Prenda prendaEncontrada = buscarPorCodigo(codigo);
        if (prendaEncontrada != null) {
            listaPrendas.remove(prendaEncontrada);
            System.out.println(" Prenda eliminada correctamente.");
            return true;
        }
        System.out.println(" Error: No se encontró una prenda con el código " + codigo);
        return false;
    }

    // metodo calcular Recargo
    public double calcularMontoRecargo() {
        return this.precioBase * this.categoriaPrenda.getRecargo();
    }

    public double calcularPrecioConRecargo() {
        double recargo = switch (categoriaPrenda) {
            case VESTIDO  -> 0.10;
            case CHAQUETA -> 0.15;
            case CALZADO  -> 0.05;
            default       -> 0.00; //
        };
        return precioBase * (1 + recargo);
    }
}
