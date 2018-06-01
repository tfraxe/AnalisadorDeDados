package controller;

import model.graficos.CalculoGrafico;

public class GraficosController
{
    private CalculoGrafico model;

    public void setModel(CalculoGrafico model)
    {
        this.model = model;
    }

    public void executar(int coluna)
    {
        if(model != null && coluna >= 0)
            model.calcularGrafico(coluna);
    }

    public void executar(int coluna1, int coluna2)
    {
        if(model != null && coluna1 >= 0 && coluna2 >= 0)
            model.calcularGrafico(coluna1, coluna2);
    }
}