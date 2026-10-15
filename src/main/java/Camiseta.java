public class Camiseta extends Prenda{
    public Camiseta(String c, String n, String m, double p) {
        super(c, n, m, p, CategoriaPrenda.CAMISETA);
    }
    @Override
    public double calcularPrecioConRecargo(){
     return precioBase; } // el recargo es 0
}
