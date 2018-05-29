package model.univariada;

import model.ColunaIncompativelException;

public interface Univariada
{
	public String calcular(int coluna) throws ColunaIncompativelException;
}