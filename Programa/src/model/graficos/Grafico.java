package model.graficos;

import javax.swing.JFrame;

import model.ColunaIncompativelException;

public interface Grafico
{
    public JFrame calcular(int coluna) throws ColunaIncompativelException;

    public JFrame calcular(int coluna1, int coluna2) throws ColunaIncompativelException;
}