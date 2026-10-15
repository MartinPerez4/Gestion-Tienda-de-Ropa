class Chaqueta extends Prenda {
    public Chaqueta(String c, String n, String m, double p) {
        super(c, n, m, p, CategoriaPrenda.CHAQUETA);
    }
    @Override
    public double calcularPrecioConRecargo() {
        return precioBase * 1.15;} // 15% de recargo
}