package controller;

import model.multivariada.CalculoMultivariada;
import view.paginas.MultivariadaView;

public class MultivariadaController
{
    private CalculoMultivariada model;

    public void setModel(CalculoMultivariada model)
    {
        this.model = model;
    }

    public void executar(int coluna1, int coluna2)
    {
        if(model != null && coluna1 >= 0 && coluna2 >= 0)
            model.calcularValor(coluna1, coluna2);
    }
}