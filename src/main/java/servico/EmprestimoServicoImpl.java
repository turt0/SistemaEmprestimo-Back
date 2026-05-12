
package servico;

import dao.EmprestimoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import modelo.Emprestimo;
 
/**
 * Implementação do serviço SOAP de Empréstimo.
 */
@WebService(endpointInterface = "servico.EmprestimoServico")
public class EmprestimoServicoImpl implements EmprestimoServico{
    
    private final EmprestimoDAO dao = new EmprestimoDAO();
 
    @Override
    public ArrayList<Emprestimo> listar() {
        System.out.println("EmprestimoServico: executando listar()");
        return new ArrayList<>(dao.getMinhaLista());
    }
 
    @Override
    public boolean inserir(Emprestimo emprestimo) {
        System.out.println("EmprestimoServico: executando inserir(...)");
        if (emprestimo == null
                || emprestimo.getAmigo() == null
                || emprestimo.getFerramenta() == null
                || emprestimo.getDtEmprestimo() == null
                || emprestimo.getDtDevolucaoPrevista() == null) {
            return false;
        }
        return dao.insertEmprestimoBD(emprestimo);
    }
 
    @Override
    public boolean alterar(Emprestimo emprestimo) {
        System.out.println("EmprestimoServico: executando alterar(...)");
        if (emprestimo == null || emprestimo.getId() <= 0) {
            return false;
        }
        return dao.updateEmprestimoBD(emprestimo);
    }
 
    @Override
    public boolean deletar(int id) {
        System.out.println("EmprestimoServico: executando deletar(" + id + ")");
        if (id <= 0) {
            return false;
        }
        return dao.deleteEmprestimoBD(id);
    }
 
    @Override
    public boolean registrarDevolucao(int id) {
        System.out.println("EmprestimoServico: executando registrarDevolucao(" + id + ")");
        if (id <= 0) {
            return false;
        }
        return dao.registrarDevolucaoBD(id);
    }
 
    @Override
    public String gerarResumoRelatorio() {
        System.out.println("EmprestimoServico: executando gerarResumoRelatorio()");
        return dao.gerarResumoRelatorio();
    }
 
    @Override
    public boolean amigoTemPendencia(int idAmigo) {
        System.out.println("EmprestimoServico: executando amigoTemPendencia(" + idAmigo + ")");
        return dao.amigoTemPendencia(idAmigo);
    }
}
