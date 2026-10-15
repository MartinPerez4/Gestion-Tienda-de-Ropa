public enum CategoriaPrenda {
    CAMISETA(1),
    PANTALON(1),
    VESTIDO( 1.10),
    CHAQUETA(1.15),
    CALZADO(1.05);

    private double recargo;

    CategoriaPrenda(double recargo){
        this.recargo=recargo;
    }

    public double getRecargo(){
        return recargo;
    }
}
