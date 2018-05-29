package model.multivariada;

import java.util.ArrayList;
import java.math.BigDecimal;
import java.math.RoundingMode;

import model.univariada.Variancia;
import model.multivariada.Multivariada;
import model.multivariada.Covariancia;
import model.ColunaIncompativelException;
import model.Tabela;

public class Pearson implements Multivariada
{
	public String calcular(int coluna1, int coluna2) throws ColunaIncompativelException
	{
		ArrayList<String[]> tabela = Tabela.getTabela();
        int tamanho_tabela = tabela.size();
		if(tabela != null && tamanho_tabela > 1 && coluna1 >= 0 && coluna2 >= 0)
		{
			try
			{
                BigDecimal covariancia = new BigDecimal(Double.parseDouble(new Covariancia().calcular(coluna1, coluna2)));
                BigDecimal variancia1 = new BigDecimal(Double.parseDouble(new Variancia().calcular(coluna1)));
                BigDecimal variancia2 = new BigDecimal(Double.parseDouble(new Variancia().calcular(coluna2)));
				return covariancia.divide(new BigDecimal(Math.sqrt(variancia1.multiply(variancia2).doubleValue())), 3, RoundingMode.HALF_UP).toString();
            }
            catch(ArithmeticException e)
            {
                throw new ColunaIncompativelException("Nao e possivel calcular o coeficiente de pearson entre essas colunas");
            }
			catch(NumberFormatException e)
			{
				throw new ColunaIncompativelException("Nao e possivel calcular o coeficiente de pearson entre essas colunas");
            }
            catch(ColunaIncompativelException e)
            {
                throw new ColunaIncompativelException("Nao e possivel calcular o coeficiente de pearson entre essas colunas");
            }
		}
		return null;
	}
}