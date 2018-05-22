package gerenciamento;

import view.util.MenuObservador;
import javax.swing.JMenuItem;
import controller.AbrirItemController;
import controller.SalvarItemController;
import controller.FecharItemController;
import controller.ItemController;
import controller.SuporteItemController;
import controller.DesenvolvedoresItemController;
import controller.SobreItemController;
import model.LeitorArquivo;
import java.util.LinkedList;

/* Essa classe e responsavel por observar a selecao do item da barra de menu
   Trabalha com a classe JanelaMenuListener utilizando o padrao de projeto observer. */

public class MenuBarListener implements MenuObservador
{
    private AbrirItemController abrir;
    private SalvarItemController salvar;
    private FecharItemController fechar;
    private SuporteItemController suporte;
    private DesenvolvedoresItemController desenvolvedores;
    private SobreItemController sobre;
    private LinkedList<ItemController> controllers;

    public MenuBarListener()
    {
        controllers = new LinkedList<ItemController>();
        abrir = new AbrirItemController();
        salvar = new SalvarItemController();
        fechar = new FecharItemController();
        suporte = new SuporteItemController();
        desenvolvedores = new DesenvolvedoresItemController();
        sobre = new SobreItemController();
        controllers.add(abrir);
        controllers.add(salvar);
        controllers.add(fechar);
        controllers.add(suporte);
        controllers.add(desenvolvedores);
        controllers.add(sobre);
    }

    public void selecionouMenuItem(JMenuItem item)
    {
        for(ItemController i : controllers)
            i.executar(item.getText());
    }
} 




