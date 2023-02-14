package business;

import business.exception.RegistroJaExistenteException;
import model.Cliente;
import model.ClientePF;
import model.TipoDocumento;
import model.TipoVeiculo;
import persistence.Repository;

import java.util.List;
import java.util.stream.Collectors;

public class GerenciadorDeClientePF extends GerenciadorDeCliente{

    public GerenciadorDeClientePF(Repository<Cliente> repositoryDeCliente) {
        super(repositoryDeCliente);
    }

    @Override
    public Cliente adicionarCliente(String nome, String cpf, String celular) {

        if (existeCliente(cpf)) {
            throw new RegistroJaExistenteException(ClIENTE_DESCRICAO_CLASSE, cpf);
        }

        Cliente novoCliente = new ClientePF(nome, cpf, celular);
        Cliente clienteSalvo = getRepositoryDeCliente().salvar(novoCliente);
        return clienteSalvo;
    }

    @Override
    public List<Cliente> listarTodosPorTipoPessoa() {
        return listarTodos().stream().
                filter(cliente -> cliente.getTipoDocumento().equals(TipoDocumento.CPF)).
                collect(Collectors.toList());
    }


}
