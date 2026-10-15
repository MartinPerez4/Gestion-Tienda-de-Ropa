class Calzado extends Prenda {
    public Calzado(String c, String n, String m, double p) {
        super(c, n, m, p, CategoriaPrenda.CALZADO); }
    @Override
    public double calcularPrecioConRecargo() {
        return precioBase * 1.05; } // 5% de recargo
}