class Vestido extends Prenda {
    public Vestido(String c, String n, String m, double p) {
        super(c, n, m, p, CategoriaPrenda.VESTIDO);
    }

    @Override
    public double calcularPrecioConRecargo() {
        return precioBase * 1.10; } // 10% de  recargo
}