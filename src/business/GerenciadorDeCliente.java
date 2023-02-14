package business;

import business.exception.RegistroJaExistenteException;
import business.exception.RegistroNaoEncontradoException;
import model.Cliente;
import model.ClientePF;
import model.ClientePJ;
import persistence.Repository;

import java.util.List;

public abstract class GerenciadorDeCliente {

    public static final String ClIENTE_DESCRICAO_CLASSE = "Cliente";
    private final Repository<Cliente> repositoryDeCliente;


    public GerenciadorDeCliente(Repository<Cliente> repositoryDeCliente) {
        this.repositoryDeCliente = repositoryDeCliente;
    }

    public abstract Cliente adicionarCliente(String nome, String documento, String celular);

    public Cliente editarCliente(String documento, String celular) {

        Cliente cliente = consultarPorDocumento(documento);
        boolean clienteNaoExiste = cliente == null;

        if (clienteNaoExiste) {
            throw new RegistroNaoEncontradoException(ClIENTE_DESCRICAO_CLASSE, documento);
        }

        cliente.setCelular(celular);
        repositoryDeCliente.atualizar(cliente);
        return cliente;
    }

    public boolean deletarCliente(String documento) {
        return repositoryDeCliente.deletar(documento);
    }

    public Cliente consultarPorDocumento(String documento) {
        return repositoryDeCliente.consultar(documento);
    }

    public boolean existeCliente(String documento) {
        return repositoryDeCliente.consultar(documento) != null;
    }

    public List<Cliente> listarTodos() {
        return repositoryDeCliente.listarTodos();
    }

    public abstract List<Cliente> listarTodosPorTipoPessoa();
    public Repository<Cliente> getRepositoryDeCliente() {
        return repositoryDeCliente;
    }


}