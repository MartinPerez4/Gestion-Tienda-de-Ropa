public class Pantalon extends Prenda {
    public Pantalon(String c, String n, String m, double p) {
    super(c, n, m, p, CategoriaPrenda.PANTALON);
}
    @Override
    public double calcularPrecioConRecargo() {
        return precioBase;// el recargo es 0
    }
}
