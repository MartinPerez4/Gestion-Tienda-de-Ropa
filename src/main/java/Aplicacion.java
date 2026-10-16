import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Aplicacion {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int seleccion = 0;
        do {

            System.out.println("\n======SISTEMA MODASTYLE=======");
            System.out.println("1. Registrar Prenda en el Catálogo");
            System.out.println("2. Registrar Persona (Cliente o Vendedor)");
            System.out.println("3. Registrar Sucursal");
            System.out.println("4. Registrar Existencias de Prenda en Sucursal");
            System.out.println("5. Consultar Prendas Disponibles en Sucursal");
            System.out.println("6. Registrar Venta (con verificación de stock y descuentos)");
            System.out.println("7. Consultar Prendas Agotadas en Sucursal");
            System.out.println("8. Consultar Historial de Compras de un Cliente");
            System.out.println("9. Consultar Historial de Ventas de un Vendedor");
            System.out.println("10. Calcular Ingresos Totales de una Sucursal");
            System.out.println("11. Identificar Prenda Más Vendida en la Empresa");
            System.out.println("12. Salir");
            System.out.print("Seleccione una opción: ");

            seleccion = sc.nextInt();
            sc.nextLine();

            switch (seleccion) {
                case 1:
                    System.out.print("Código: ");
                    String codigoPrenda = sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombrePrenda = sc.nextLine();
                    System.out.print("Marca: ");
                    String marcaPrenda = sc.nextLine();
                    System.out.print("Precio base unitario: ");
                    double precioBasePrenda = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Seleccione Categoría\n 1. CAMISETA\n 2. PANTALON\n 3. VESTIDO\n 4. CHAQUETA\n 5. CALZADO");
                    int categoriaOpcion = sc.nextInt();
                    sc.nextLine();
                    CategoriaPrenda categoriaPrenda = CategoriaPrenda.CAMISETA;
                    if (categoriaOpcion == 2) categoriaPrenda = CategoriaPrenda.PANTALON;
                    else if (categoriaOpcion == 3) categoriaPrenda = CategoriaPrenda.VESTIDO;
                    else if (categoriaOpcion == 4) categoriaPrenda = CategoriaPrenda.CHAQUETA;
                    else if (categoriaOpcion == 5) categoriaPrenda = CategoriaPrenda.CALZADO;

                    Prenda.registrar(new Prenda(codigoPrenda, nombrePrenda, marcaPrenda, precioBasePrenda, categoriaPrenda));
                    break;

                case 2:
                    System.out.print("Tipo de persona \n1. Cliente \n2. Vendedor: ");
                    int tipoPersona = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Documento de identidad: ");
                    String documentoIdentidad = sc.nextLine();
                    System.out.print("Nombre completo: ");
                    String nombreCompleto = sc.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = sc.nextLine();
                    System.out.print("Correo electrónico: ");
                    String correoElectronico = sc.nextLine();
                    if (tipoPersona == 1) {
                        System.out.print("Código de afiliación: ");
                        String codigoAfiliacion = sc.nextLine();
                        System.out.println("Categoría cliente \n1: BRONCE - 5% \n2: PLATA - 10% \n3: ORO - 15%");
                        int categoriaClienteOpcion = sc.nextInt();
                        sc.nextLine();
                        CategoriaCliente categoriaCliente = CategoriaCliente.BRONCE;
                        if (categoriaClienteOpcion == 2) {
                            categoriaCliente = CategoriaCliente.PLATA;
                        } else if (categoriaClienteOpcion == 3) {
                            categoriaCliente = CategoriaCliente.ORO;
                        }
                        Persona.registrar(new Cliente(documentoIdentidad, nombreCompleto, telefono, correoElectronico, codigoAfiliacion, categoriaCliente));
                    } else {
                        System.out.print("Código de empleado: ");
                        String codigoEmpleado = sc.nextLine();
                        System.out.print("Salario básico: ");
                        double salarioBasico = sc.nextDouble();
                        sc.nextLine();
                        System.out.print("Código de la Sucursal donde labora: ");
                        String codigoSucursalLaboral = sc.nextLine();
                        Sucursal sucursalLaboral = Sucursal.buscarPorCodigo(codigoSucursalLaboral);
                        if (sucursalLaboral != null) {
                            Persona.registrar(new Vendedor(documentoIdentidad, nombreCompleto, telefono, correoElectronico, codigoEmpleado, LocalDate.now(), salarioBasico, sucursalLaboral));
                        } else {
                            System.out.println("Sucursal no encontrada.");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Código de Sucursal: ");
                    String codigoSucursal = sc.nextLine();
                    System.out.print("Nombre de Sucursal: ");
                    String nombreSucursal = sc.nextLine();
                    System.out.print("Dirección: ");
                    String direccionSucursal = sc.nextLine();
                    System.out.print("Ciudad: ");
                    String ciudadSucursal = sc.nextLine();

                    Sucursal.registrar(new Sucursal(codigoSucursal, nombreSucursal, direccionSucursal, ciudadSucursal));
                    break;

                case 4:
                    System.out.print("Código de la sucursal: ");
                    String codigoSucursalInventario = sc.nextLine();
                    Sucursal sucursalInventario = Sucursal.buscarPorCodigo(codigoSucursalInventario);

                    if (sucursalInventario == null) {
                        System.out.println("Sucursal no encontrada.");
                        break;
                    }

                    System.out.print("Código de la prenda en catálogo: ");
                    String codigoPrendaInventario = sc.nextLine();
                    Prenda prendaInventario = Prenda.buscarPorCodigo(codigoPrendaInventario);

                    if (prendaInventario == null) {
                        System.out.println("Prenda no encontrada en el catálogo.");
                        break;
                    }

                    System.out.print("Talla (XS, S, M, L, XL o número entre 35 y 44 para calzado): ");
                    String tallaInventario = sc.nextLine();

                    boolean tallaValida = false;
                    if (prendaInventario.getCategoriaPrenda() == CategoriaPrenda.CALZADO) {
                        for (int numero = 35; numero <= 44; numero++) {
                            if (tallaInventario.equals(String.valueOf(numero))) {
                                tallaValida = true;
                            }
                        }
                    } else {
                        tallaValida = tallaInventario.equalsIgnoreCase("XS") || tallaInventario.equalsIgnoreCase("S")
                                || tallaInventario.equalsIgnoreCase("M") || tallaInventario.equalsIgnoreCase("L")
                                || tallaInventario.equalsIgnoreCase("XL");
                    }
                    if (!tallaValida) {
                        System.out.println("Talla no válida para esta prenda.");
                        break;
                    }
                    System.out.print("Color: ");
                    String colorInventario = sc.nextLine();

                    boolean existeInventario = false;
                    for (Inventario inv : sucursalInventario.getInventarios()) {
                        if (inv.getPrenda().getCodigo().equalsIgnoreCase(codigoPrendaInventario)
                                && inv.getTalla().equalsIgnoreCase(tallaInventario)
                                && inv.getColor().equalsIgnoreCase(colorInventario)) {
                            existeInventario = true;
                            break;
                        }
                    }

                    if (existeInventario) {
                        System.out.println("Ya existe inventario de esa prenda, talla y color en la sucursal.");
                        break;
                    }

                    System.out.print("Cantidad disponible: ");
                    int cantidadInventario = sc.nextInt();
                    sc.nextLine();

                    if (cantidadInventario < 0) {
                        System.out.println("La cantidad no puede ser negativa.");
                        break;
                    }

                    sucursalInventario.getInventarios().add(new Inventario(sucursalInventario, prendaInventario, tallaInventario, colorInventario, cantidadInventario));
                    System.out.println("Inventario registrado con éxito.");
                    break;

                case 5:
                    System.out.print("Código de la sucursal a consultar: ");
                    String codigoSucursalConsulta = sc.nextLine();
                    Sucursal sucursalConsulta = Sucursal.buscarPorCodigo(codigoSucursalConsulta);

                    if (sucursalConsulta != null) {
                        System.out.println("\nPrendas disponibles en la sucursal " + sucursalConsulta.getNombre());
                        boolean hayDisponibles = false;

                        for (Inventario inv : sucursalConsulta.getInventarios()) {
                            if (inv.getCantidadDisp() > 0) {
                                System.out.println("Ref: " + inv.getPrenda().getCodigo()
                                        + " Prenda: " + inv.getPrenda().getNombre()
                                        + "  Talla: " + inv.getTalla()
                                        + " Color: " + inv.getColor()
                                        + "  Stock: " + inv.getCantidadDisp());
                                hayDisponibles = true;
                            }
                        }
                        if (!hayDisponibles) {
                            System.out.println("No hay prendas disponibles en esta sucursal.");
                        }
                    } else {
                        System.out.println("Sucursal no encontrada.");
                    }
                    break;

                case 6:
                    System.out.print("Código de la sucursal donde se realiza la venta: ");
                    String codigoSucursalVenta = sc.nextLine();
                    Sucursal sucursalVenta = Sucursal.buscarPorCodigo(codigoSucursalVenta);

                    if (sucursalVenta == null) {
                        System.out.println("Sucursal no encontrada.");
                        break;
                    }

                    System.out.print("Documento del cliente: ");
                    String documentoCliente = sc.nextLine();
                    Persona personaCliente = Persona.buscarPorDocumento(documentoCliente);

                    System.out.print("Documento del vendedor: ");
                    String documentoVendedor = sc.nextLine();
                    Persona personaVendedor = Persona.buscarPorDocumento(documentoVendedor);

                    if (!(personaCliente instanceof Cliente) || !(personaVendedor instanceof Vendedor)) {
                        System.out.println("Cliente o vendedor no válidos o no encontrados.");
                        break;
                    }

                    Cliente clienteActual = (Cliente) personaCliente;
                    Vendedor vendedorActual = (Vendedor) personaVendedor;

                    if (!vendedorActual.getSucursal().getCodigo().equalsIgnoreCase(sucursalVenta.getCodigo())) {
                        System.out.println("El vendedor no trabaja en esta sucursal.");
                        break;
                    }

                    ArrayList<DetalleVenta> listaDetalles = new ArrayList<>();
                    boolean ventaValida = true;
                    String respuesta = "s";

                    while (respuesta.equalsIgnoreCase("s")) {
                        System.out.print("Código de prenda: ");
                        String codigoPrendaVenta = sc.nextLine();
                        System.out.print("Talla: ");
                        String tallaVenta = sc.nextLine();
                        System.out.print("Color: ");
                        String colorVenta = sc.nextLine();
                        System.out.print("Cantidad deseada: ");
                        int cantidadDeseada = sc.nextInt();
                        sc.nextLine();

                        if (cantidadDeseada <= 0) {
                            System.out.println("La cantidad debe ser mayor que cero.");
                        } else {
                            Inventario inventarioEncontrado = null;
                            for (Inventario inventario : sucursalVenta.getInventarios()) {
                                if (inventario.getPrenda().getCodigo().equalsIgnoreCase(codigoPrendaVenta)
                                        && inventario.getTalla().equalsIgnoreCase(tallaVenta)
                                        && inventario.getColor().equalsIgnoreCase(colorVenta)) {
                                    inventarioEncontrado = inventario;
                                    break;
                                }
                            }

                            if (inventarioEncontrado == null) {
                                System.out.println("No existe inventario con esa combinación en esta sucursal.");
                                ventaValida = false;
                            } else {
                                int yaAgregadas = 0;
                                for (DetalleVenta det : listaDetalles) {
                                    if (det.getInventario() == inventarioEncontrado) {
                                        yaAgregadas += det.getCantidad();
                                    }
                                }
                                int disponibles = inventarioEncontrado.getCantidadDisp() - yaAgregadas;

                                if (disponibles >= cantidadDeseada) {
                                    double descuento = clienteActual.obtenerDescuento();
                                    double precioConRecargo = inventarioEncontrado.getPrenda().calcularPrecioConRecargo();
                                    double precioUnitarioFinal = precioConRecargo * (1 - descuento);
                                    double subtotal = precioUnitarioFinal * cantidadDeseada;

                                    listaDetalles.add(new DetalleVenta(inventarioEncontrado, cantidadDeseada, precioUnitarioFinal, subtotal));
                                    System.out.println("Prenda agregada a la venta.");
                                } else {
                                    System.out.println("Stock insuficiente. Disponibles: " + disponibles);
                                    ventaValida = false;
                                }
                            }
                        }

                        if (ventaValida) {
                            System.out.print("¿Agregar otra prenda a esta venta? (s/n): ");
                            respuesta = sc.nextLine();
                        } else {
                            respuesta = "n";
                        }
                    }

                    if (!ventaValida) {
                        System.out.println("La venta no se puede confirmar. No se descontó ninguna unidad.");
                    } else if (listaDetalles.isEmpty()) {
                        System.out.println("Venta cancelada: no se agregó ninguna prenda.");
                    } else {
                        for (DetalleVenta det : listaDetalles) {
                            Inventario inventarioVendido = det.getInventario();
                            inventarioVendido.setCantidadDisp(inventarioVendido.getCantidadDisp() - det.getCantidad());
                            inventarioVendido.agregarDetalle(det);
                        }

                        Venta nuevaVenta = new Venta("V-" + System.currentTimeMillis(), LocalDate.now(), sucursalVenta, vendedorActual, clienteActual, listaDetalles);
                        sucursalVenta.getVentas().add(nuevaVenta);
                        System.out.println("Venta registrada. Valor total a pagar: " + nuevaVenta.calcularTotal());
                    }
                    break;

                case 7:
                    System.out.print("Código de la sucursal: ");
                    String codigoSucursalAgotados = sc.nextLine();
                    Sucursal sucursalAgotados = Sucursal.buscarPorCodigo(codigoSucursalAgotados);

                    if (sucursalAgotados != null) {
                        System.out.println("\nPrendas agotadas en la sucursal " + sucursalAgotados.getNombre());
                        boolean hayAgotados = false;

                        for (Inventario inv : sucursalAgotados.getInventarios()) {
                            if (inv.getCantidadDisp() == 0) {
                                System.out.println(inv.getPrenda().getNombre() + " (Talla: " + inv.getTalla() + ", Color: " + inv.getColor() + ")");
                                hayAgotados = true;
                            }
                        }
                        if (!hayAgotados) {
                            System.out.println("No hay productos agotados en esta sucursal.");
                        }
                    } else {
                        System.out.println("Sucursal no encontrada.");
                    }
                    break;

                case 8:
                    System.out.print("Documento del cliente: ");
                    String documentoClienteConsulta = sc.nextLine();
                    int contadorComprasCliente = 0;

                    for (Sucursal sucursalActual : Sucursal.getListaSucursales()) {
                        for (Venta ventaActual : sucursalActual.getVentas()) {
                            if (ventaActual.getCliente() != null && ventaActual.getCliente().getDocumento().equalsIgnoreCase(documentoClienteConsulta)) {
                                contadorComprasCliente++;
                                System.out.println("Venta " + ventaActual.getCodigo() + " | " + ventaActual.getFecha() + " | Total: " + ventaActual.calcularTotal());
                            }
                        }
                    }
                    System.out.println("El cliente con documento " + documentoClienteConsulta + " ha realizado un total de " + contadorComprasCliente + " compras.");
                    break;

                case 9:
                    System.out.print("Documento del vendedor: ");
                    String documentoVendedorConsulta = sc.nextLine();
                    int contadorVentasVendedor = 0;

                    for (Sucursal sucursalActual : Sucursal.getListaSucursales()) {
                        for (Venta ventaActual : sucursalActual.getVentas()) {
                            if (ventaActual.getVendedor() != null && ventaActual.getVendedor().getDocumento().equalsIgnoreCase(documentoVendedorConsulta)) {
                                contadorVentasVendedor++;
                                System.out.println("Venta " + ventaActual.getCodigo() + " | " + ventaActual.getFecha() + " | Total: " + ventaActual.calcularTotal());
                            }
                        }
                    }
                    System.out.println("El vendedor con documento " + documentoVendedorConsulta + " ha realizado un total de " + contadorVentasVendedor + " ventas.");
                    break;

                case 10:
                    System.out.print("Código de la sucursal: ");
                    String codigoSucursalIngresos = sc.nextLine();
                    Sucursal sucursalIngresos = Sucursal.buscarPorCodigo(codigoSucursalIngresos);

                    if (sucursalIngresos != null) {
                        System.out.println("Ingresos totales de la sucursal " + sucursalIngresos.getNombre() + ": "
                                + sucursalIngresos.calcularIngresos());
                    } else {
                        System.out.println("Sucursal no encontrada.");
                    }
                    break;

                case 11:
                    Prenda prendaMasVendida = null;
                    int maxUnidades = 0;

                    for (Prenda prendaCatalogo : Prenda.getListaPrendas()) {
                        int unidadesVendidas = 0;
                        for (Sucursal sucursalActual : Sucursal.getListaSucursales()) {
                            for (Venta ventaActual : sucursalActual.getVentas()) {
                                for (DetalleVenta det : ventaActual.getDetalles()) {
                                    if (det.getInventario().getPrenda().getCodigo().equalsIgnoreCase(prendaCatalogo.getCodigo())) {
                                        unidadesVendidas += det.getCantidad();
                                    }
                                }
                            }
                        }
                        if (unidadesVendidas > maxUnidades) {
                            maxUnidades = unidadesVendidas;
                            prendaMasVendida = prendaCatalogo;
                        }
                    }

                    if (prendaMasVendida == null) {
                        System.out.println("Aún no hay ventas registradas.");
                    } else {
                        System.out.println("Prenda más vendida: " + prendaMasVendida.getCodigo() + " - " + prendaMasVendida.getNombre()
                                + " con " + maxUnidades + " unidades vendidas.");
                    }
                    break;

                case 12:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (seleccion != 12);

        sc.close();
    }
}
