package model.univariada;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import model.univariada.DesvioPadrao;
import model.univariada.MomentoCentral;
import model.univariada.Univariada;
import model.ColunaIncompativelException;
import model.Tabela;

public class Skewness implements Univariada
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
				BigDecimal terceiro_momento = new MomentoCentral(coluna, 3).calcularMomento();
				return terceiro_momento.divide(desvio_padrao.pow(3), 3, RoundingMode.HALF_UP).toString();
			}
			catch(ArithmeticException e)
			{
				throw new ColunaIncompativelException("Nao e possivel calcular skewness nessa coluna");
			}
			catch(NumberFormatException e)
			{
				throw new ColunaIncompativelException("Nao e possivel calcular skewness nessa coluna");
			}
			catch(ColunaIncompativelException e)
			{
				throw new ColunaIncompativelException("Nao e possivel calcular skewness nessa coluna");
			}
		}
		return null;
	}
}