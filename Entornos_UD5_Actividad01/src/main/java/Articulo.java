class Articulo {

    int codigo;
    private String nombre;
    protected Double precioventa;
    public int stockalamacen;
    private int stockminimo;

    int getCodigo(){

        return codigo;

    }

    public String getNombre(){

        return nombre;

    }

    Double calcularPvP(){

        return precioventa;

    }

    private void caluclarStock(){



    }

}
