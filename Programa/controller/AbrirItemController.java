package controller;

import gerenciamento.Gerenciador;
import controller.ItemController;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.LeitorArquivo;
import java.io.File;
import java.io.IOException;

//Controlador da execucao do item abrir da barra de menu
public class AbrirItemController implements ItemController
{
    private LeitorArquivo leitor;

    public AbrirItemController(LeitorArquivo leitor)
    {
        this.leitor = leitor;
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
                leitor.setArquivo(arquivo);
                try
                {
                    leitor.ler();
                }
                catch(IOException nexc)
                {

                }
            }
        } 
    }
}