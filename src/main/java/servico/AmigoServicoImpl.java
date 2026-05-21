package servico;

import dao.AmigoDAO;
import java.util.ArrayList;
import javax.jws.WebService;
import modelo.Amigo;


@WebService(endpointInterface = "servico.AmigoServico")
public class AmigoServicoImpl implements AmigoServico {
    
    private final AmigoDAO dao = new AmigoDAO();
    
    @Override
    public Amigo[] listar() {
        System.out.println("AmigoServico: executando listar()");
        ArrayList<Amigo> lista = dao.getMinhaLista();
        return lista.toArray(new Amigo[0]);
    }
    
    @Override
    public Amigo carregar(int id) {
        System.out.println("AmigoServico: executando carregar(" + id + ")");
        return dao.carregaAmigo(id);
    }
    
    @Override
    public boolean inserir(Amigo amigo) {
        System.out.println("AmigoServico: executando inserir(" + amigo + ")");
        if (amigo == null) {
            return false;
        }
        // Geração do id é responsabilidade do servidor, não do cliente,
        // para evitar colisões em ambiente distribuído.
        int novoId = dao.maiorID() + 1;
        amigo.setId(novoId);
        return dao.insertAmigoBD(amigo);
    }
    
    @Override
    public boolean alterar(Amigo amigo) {
        System.out.println("AmigoServico: executando alterar(" + amigo + ")");
        if (amigo == null || amigo.getId() <= 0) {
            return false;
        }
        return dao.updateAmigoBD(amigo);
    }
    
    @Override
    public boolean deletar(int id) {
        System.out.println("AmigoServico: executando deletar(" + id + ")");
        if (id <= 0) {
            return false;
        }
        return dao.deleteAmigoBD(id);
    }
}