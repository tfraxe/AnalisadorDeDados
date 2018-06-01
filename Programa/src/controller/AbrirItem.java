package controller;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import controller.gerenciamento.Gerenciador;
import controller.ItemController;
import java.io.File;
import java.io.IOException;
import java.awt.HeadlessException;
import view.listeners.TabelaListener;
import model.Tabela;
import observer.Observador;
import observer.Observavel;

public class AbrirItem implements ItemController
{   
    private Tabela model;

    public void setModel(Tabela model)
    {
        this.model = model;
    }

    public void executar()
    {
        if(model != null)
        {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(".csv", "csv");
            fileChooser.setFileFilter(filter);
            int retorno = fileChooser.showOpenDialog(Gerenciador.getJanela().getFrame());
            if(retorno == JFileChooser.APPROVE_OPTION) 
            {
                File arquivo = fileChooser.getSelectedFile();
                model.setArquivo(arquivo);
                try
                {
                    model.lerArquivo();
                }
                catch(IOException e)
                {
                    JOptionPane.showMessageDialog(null, "Impossivel ler o arquivo");
                }
                catch(HeadlessException e)
                {
                    System.out.println("Headless");
                }
            }
        }
    }
}