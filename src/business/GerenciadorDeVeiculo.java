package business;

import business.exception.RegistroJaExistenteException;
import business.exception.RegistroNaoEncontradoException;
import model.Veiculo;
import persistence.Repository;

import java.math.BigDecimal;
import java.util.List;

public abstract class GerenciadorDeVeiculo {

    public static final String VEICULO_DESCRICAO_CLASSE = "Veiculo";
    private final Repository<Veiculo> repositoryDeVeiculo;


    public GerenciadorDeVeiculo(Repository<Veiculo> repositoryDeVeiculo) {
        this.repositoryDeVeiculo = repositoryDeVeiculo;
    }

    public abstract Veiculo adicionarVeiculo(String placa, String modelo);

    public Veiculo editarVeiculo(String documento, BigDecimal valorAlocacaoVeiculo) {

        Veiculo veiculo = consultarPorPlaca(documento);
        boolean veiculoNaoExiste = veiculo == null;

        if (veiculoNaoExiste) {
            throw new RegistroNaoEncontradoException(VEICULO_DESCRICAO_CLASSE, documento);
        }

        veiculo.setValorVeiculo(valorAlocacaoVeiculo);
        repositoryDeVeiculo.atualizar(veiculo);
        return veiculo;
    }

    public boolean deletarVeiculo(String documento) {
        return repositoryDeVeiculo.deletar(documento);
    }

    public Veiculo consultarPorPlaca(String placa) {
        return repositoryDeVeiculo.consultar(placa);
    }

    public boolean existeVeiculo(String placa) {
        return repositoryDeVeiculo.consultar(placa) != null;
    }

    public List<Veiculo> listarTodos() {
        return repositoryDeVeiculo.listarTodos();
    }

    public abstract List<Veiculo> listarTodosComTipoVeiculo();
    public Repository<Veiculo> getRepositoryDeVeiculo() {
        return repositoryDeVeiculo;
    }


}