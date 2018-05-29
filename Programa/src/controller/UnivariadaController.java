package controller;

import model.univariada.CalculoUnivariada;
import view.paginas.UnivariadaView;

public class UnivariadaController
{
    private CalculoUnivariada model;

    public void setModel(CalculoUnivariada model)
    {
        this.model = model;
    }

    public void executar(int coluna)
    {
        if(model != null && coluna >= 0)
            model.calcularValor(coluna);
    }
}