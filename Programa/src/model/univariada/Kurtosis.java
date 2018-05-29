package model.univariada;

import java.util.ArrayList;
import java.math.BigDecimal;
import java.math.RoundingMode;

import model.univariada.DesvioPadrao;
import model.univariada.Univariada;
import model.univariada.MomentoCentral;
import model.ColunaIncompativelException;
import model.Tabela;


public class Kurtosis implements Univariada
{
	public String calcular(int coluna) throws ColunaIncompativelException
	{
		ArrayList<String[]> tabela = Tabela.getTabela();
		int tamanho_tabela = tabela.size();
		if(tabela != null && tamanho_tabela > 1 && coluna >= 0)
		{
			try
			{
				BigDecimal desvio_padrao = new BigDecimal(Double.parseDouble(new DesvioPadrao().calcular(coluna)));
				BigDecimal quarto_momento = new MomentoCentral(coluna, 4).calcularMomento();
				return quarto_momento.divide(desvio_padrao.pow(4), 3, RoundingMode.HALF_UP).toString();
			}
			catch(ArithmeticException e)
			{
				throw new ColunaIncompativelException("Nao e possivel calcular kurtosis nessa coluna");
			}
			catch(NumberFormatException e)
			{
				throw new ColunaIncompativelException("Nao e possivel calcular kurtosis nessa coluna");
			}
			catch(ColunaIncompativelException e)
			{
				throw new ColunaIncompativelException("Nao e possivel calcular kurtosis nessa coluna");
			}
		}
		return null;
	}
}