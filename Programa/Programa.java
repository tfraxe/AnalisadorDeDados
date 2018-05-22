import gerenciamento.Gerenciador;

/* Tecnicas de Programacao 1 - 2018.1
   Equipe: 
   Abner Lima - 398067
   Anderson Nobre - 352132
   Edealcia Regina - 372164
   Francisco Tiago Fontenele - 393944
   Thiago Fraxe - 397796 */
   
/* Todo o controle da logica de execucao do programa e feito atraves das classes do pacote gerenciamento. 
   Essas classes sao responsaveis por criar as classes de view, model e controller, fazendo o view trabalhar
   com o model atraves do padrao de projeto observer, e instanciando esse mesmo model para o controller 
   controla-lo. */

public class Programa
{
    public static void main(String[] args)
    {
        Gerenciador gerenciador = new Gerenciador();
        gerenciador.iniciar();
    }
}