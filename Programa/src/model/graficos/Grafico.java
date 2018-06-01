package model.graficos;

import org.jfree.ui.ApplicationFrame;

import model.ColunaIncompativelException;

public interface Grafico
{
    public ApplicationFrame calcular(int coluna) throws ColunaIncompativelException;

    public ApplicationFrame calcular(int coluna1, int coluna2) throws ColunaIncompativelException;
}