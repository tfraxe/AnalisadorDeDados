package model.multivariada;

import model.ColunaIncompativelException;

public interface Multivariada
{
	public String calcular(int coluna1, int coluna2) throws ColunaIncompativelException;
}