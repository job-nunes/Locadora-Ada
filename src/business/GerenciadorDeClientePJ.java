package business;

import business.exception.RegistroJaExistenteException;
import model.Cliente;
import model.ClientePJ;
import model.TipoDocumento;
import persistence.Repository;

import java.util.List;
import java.util.stream.Collectors;

public class GerenciadorDeClientePJ extends GerenciadorDeCliente{

    public GerenciadorDeClientePJ(Repository<Cliente> repositoryDeCliente) {
        super(repositoryDeCliente);
    }

    @Override
    public Cliente adicionarCliente(String nome, String documentoPJ, String celular) {

        if (existeCliente(documentoPJ)) {
            throw new RegistroJaExistenteException(ClIENTE_DESCRICAO_CLASSE, documentoPJ);
        }

        Cliente novoCliente = new ClientePJ(nome, documentoPJ, celular);
        Cliente clienteSalvo = getRepositoryDeCliente().salvar(novoCliente);
        return clienteSalvo;
    }

    @Override
    public List<Cliente> listarTodosPorTipoPessoa() {
        return listarTodos().stream().
                filter(cliente -> cliente.getTipoDocumento().equals(TipoDocumento.CNPJ)).
                collect(Collectors.toList());
    }
}
