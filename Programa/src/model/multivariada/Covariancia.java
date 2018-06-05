package model.multivariada;

import java.util.ArrayList;
import java.math.BigDecimal;
import java.math.RoundingMode;

import model.univariada.Media;
import model.multivariada.Multivariada;
import model.ColunaIncompativelException;
import model.Tabela;

public class Covariancia implements Multivariada
{
	public String calcular(int coluna1, int coluna2) throws ColunaIncompativelException
	{
		ArrayList<String[]> tabela = Tabela.getTabela();
        int tamanho_tabela = tabela.size();
		if(tabela != null && tamanho_tabela > 1 && coluna1 >= 0 && coluna2 >= 0)
		{
			try
			{
				BigDecimal media1 = new BigDecimal(Double.parseDouble(new Media().calcular(coluna1)));
				BigDecimal media2 = new BigDecimal(Double.parseDouble(new Media().calcular(coluna2)));
				ArrayList<Double> numeros1 = new ArrayList<Double>();
                ArrayList<Double> numeros2 = new ArrayList<Double>();
				BigDecimal soma = new BigDecimal(0);
				int n_NaN = 0;
				for(int i = 1; i < tamanho_tabela; i++)
				{
					String valor1 = tabela.get(i)[coluna1];
					String valor2 = tabela.get(i)[coluna2];
					if(!valor1.equals("NaN") && !valor2.equals("NaN") && !valor1.equals("") && !valor2.equals(""))
					{
						numeros1.add(Double.parseDouble(valor1));
						numeros2.add(Double.parseDouble(valor2));
					}
					else
						n_NaN++;
				}
				for(int i = 1; i < numeros1.size(); i++)
				{
					BigDecimal xi = new BigDecimal(numeros1.get(i));
					BigDecimal yi = new BigDecimal(numeros2.get(i));
					BigDecimal r1 = xi.subtract(media1);
					BigDecimal r2 = yi.subtract(media2);
					soma = soma.add(r1.multiply(r2));
				}
				return soma.divide(new BigDecimal(tamanho_tabela - n_NaN), 3, RoundingMode.HALF_UP).toString();
			}
			catch(ArithmeticException e)
			{
				throw new ColunaIncompativelException("Nao e possivel calcular covariancia entre essas colunas");
			}
			catch(NumberFormatException e)
			{
				throw new ColunaIncompativelException("Nao e possivel calcular covariancia entre essas colunas");
            }
            catch(ColunaIncompativelException e)
            {
                throw new ColunaIncompativelException("Nao e possivel calcular covariancia entre essas colunas");
            }
		}
		return null;
	}
}