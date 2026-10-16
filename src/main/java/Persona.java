import java.util.ArrayList;
import java.util.List;

public abstract class Persona {
    private String documento;
    private String nombre;
    private String correo;
    private String telefono;

    //Lista
    private static List<Persona> listaPersonas = new ArrayList<>();

    public Persona(String documento, String nombre, String telefono, String correo) {
        this.documento = documento;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        listaPersonas=new ArrayList<>();
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public static List<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public static void setListaPersonas(List<Persona> listaPersonas) {
        Persona.listaPersonas = listaPersonas;
    }

    // 1. CREATE (Registrar con verificación de documento único)
    public static boolean registrar(Persona nuevaPersona) {
        // Verificar si ya existe una persona con ese mismo documento
        for (Persona p : listaPersonas) {
            if (p.getDocumento().equalsIgnoreCase(nuevaPersona.getDocumento())) {
                System.out.println(" Error: Ya existe una persona registrada con el documento " + nuevaPersona.getDocumento());
                return false;
            }
        }
        // Si no existe, se añade a la lista
        listaPersonas.add(nuevaPersona);
        System.out.println(" Persona registrada exitosamente.");
        return true;
    }

    // 2. READ (Listar todas las personas)
    public static void listar() {
        if (listaPersonas.isEmpty()) {
            System.out.println("No hay personas registradas.");
            return;
        }
        for (Persona p : listaPersonas) {
            System.out.println(p);
        }
    }

    // Método auxiliar para buscar por documento (sirve para actualizar y eliminar)
    public static Persona buscarPorDocumento(String documento) {
        for (Persona p : listaPersonas) {
            if (p.getDocumento().equalsIgnoreCase(documento)) {
                return p;
            }
        }
        return null;
    }

    // 3. UPDATE (Actualizar datos de una persona buscándola por su documento)
    public static boolean actualizar(String documento, String nuevoNombre, String nuevoCorreo, String nuevoTelefono) {
        Persona personaEncontrada = buscarPorDocumento(documento);
        if (personaEncontrada != null) {
            personaEncontrada.nombre = nuevoNombre;
            personaEncontrada.correo = nuevoCorreo;
            personaEncontrada.telefono = nuevoTelefono;
            System.out.println(" Persona actualizada correctamente.");
            return true;
        }
        System.out.println(" Error: No se encontró una persona con el documento " + documento);
        return false;
    }

    // 4. DELETE (Eliminar una persona por su documento)
    public static boolean eliminar(String documento) {
        Persona personaEncontrada = buscarPorDocumento(documento);
        if (personaEncontrada != null) {
            listaPersonas.remove(personaEncontrada);
            System.out.println(" Persona eliminada correctamente.");
            return true;
        }
        System.out.println(" Error: No se encontró una persona con el documento " + documento);
        return false;
    }
}
