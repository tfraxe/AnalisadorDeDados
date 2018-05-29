package gerenciamento;

import java.util.HashMap;

import model.Tabela;
import view.listeners.JanelaMenuListener;
import view.listeners.TabelaListener;
import view.paginas.PaginaInicial;
import controller.AbrirItem;
import controller.SalvarItem;
import controller.FecharItem;
import controller.ItemController;
import controller.SuporteItem;
import controller.DesenvolvedoresItem;
import controller.SobreItem;
import observer.NotificacaoMenu;
import observer.Observador;

public class GerenciadorMenuBar extends Observador
{
    private HashMap<String, ItemController> controllers;

    public GerenciadorMenuBar()
    {
        super();
        controllers = new HashMap<String, ItemController>();
        if(Gerenciador.getPagina() instanceof PaginaInicial)
        {
            AbrirItem abrir = new AbrirItem();
            Tabela tabela = new Tabela();
            TabelaListener listener = new TabelaListener((PaginaInicial)Gerenciador.getPagina());
            tabela.adicionarObservador(listener);
            listener.setObservavel(tabela);
            abrir.setModel(tabela);
            controllers.put("Abrir", abrir);
        }
        controllers.put("Salvar", new SalvarItem());
        controllers.put("Fechar", new FecharItem());
        controllers.put("Suporte", new SuporteItem());
        controllers.put("Desenvolvedores", new DesenvolvedoresItem());
        controllers.put("Sobre", new SobreItem());
    }

    public void update()
    {
        super.update();
        if(super.notificacao instanceof NotificacaoMenu)
        {
            NotificacaoMenu n = (NotificacaoMenu)super.notificacao;
            ItemController item = controllers.get(n.texto);
            if(item != null)
                item.executar();
        }
    }
} 