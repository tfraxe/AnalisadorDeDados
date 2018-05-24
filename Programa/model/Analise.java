package model;

import model.ColunaIncompativelException;

public interface Analise
{
	public Double calcular(int coluna) throws ColunaIncompativelException;
}