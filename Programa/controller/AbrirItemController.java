package controller;

import gerenciamento.Gerenciador;
import controller.ItemController;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.Tabela;
import observer.TabelaObservador;
import view.paginas.TabelaListener;

import java.io.File;
import java.io.IOException;

//Controlador da execucao do item abrir da barra de menu
public class AbrirItemController implements ItemController
{   
    private Tabela leitor;
    private TabelaObservador tabela_observador;
    
    public AbrirItemController()
    {
        leitor = new Tabela();
        tabela_observador = new TabelaListener();
        leitor.adicionarTabelaObservador(tabela_observador);
    }

    public Tabela getTabela()
    {
        return leitor;
    }

    public void executar(String texto)
    {
        if(texto == "Abrir")
        {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(".csv", "csv");
            fileChooser.setFileFilter(filter);
            int retorno = fileChooser.showOpenDialog(Gerenciador.getJanela().getFrame());
            if(retorno == JFileChooser.APPROVE_OPTION) 
            {
                File arquivo = fileChooser.getSelectedFile();
                Tabela.setArquivo(arquivo);
                try
                {
                    leitor.lerArquivo();
                }
                catch(IOException nexc)
                {

                }
            }
        } 
    }
}