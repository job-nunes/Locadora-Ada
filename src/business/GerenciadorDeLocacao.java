package business;

import business.exception.RegistroJaExistenteException;
import model.*;
import persistence.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public abstract class GerenciadorDeLocacao {
    public static final String LOCACAO_DESCRICAO_CLASSE = "Locacao";

    private final Repository<Locacao> repositoryDeLocacao;


    public GerenciadorDeLocacao(Repository<Locacao> repositoryDeLocacao) {
        this.repositoryDeLocacao = repositoryDeLocacao;
    }

    public abstract Locacao adicionarLocacao(Veiculo veiculo, Cliente cliente, LocalDateTime dataInicioAlocacao, LocalDateTime dataFinalAlocacao);
    public abstract Locacao adicionarLocacao(Veiculo veiculo, Cliente cliente, LocalDateTime dataFinalAlocacao);

    public List<Locacao> consultarAlocacaoPorVeiculo(Veiculo veiculoBuscado) {
        return listarTodos().stream().
                filter(alocacao -> alocacao.getVeiculo().equals(veiculoBuscado)).
                collect(Collectors.toList());
    }
    public List<Locacao> consultarAlocacaoPorCliente(Cliente clienteBuscado){
        return listarTodos().stream().
                filter(alocacao -> alocacao.getCliente().equals(clienteBuscado)).
                collect(Collectors.toList());
    }

    public boolean existeLocacaoNoPeriodo(Veiculo veiculo, LocalDateTime dataInicioAlocacao, LocalDateTime dataFinalAlocacao) {
        return veiculoAlocadoNaData(veiculo, dataInicioAlocacao) || veiculoAlocadoNaData(veiculo, dataFinalAlocacao);
    }

    public List<Locacao> listarTodos() {
        return repositoryDeLocacao.listarTodos();
    }

    private boolean veiculoAlocadoNaData(Veiculo veiculo, LocalDateTime data) {
        Integer locacoesNaData = consultarAlocacaoPorVeiculo(veiculo).stream()
                .filter(locacao -> locacao.verificarDataNoPeriodoLocacao(data))
                .collect(Collectors.toList())
                .size();
        boolean existeLocacaoNaData = locacoesNaData > 0;
        return existeLocacaoNaData;
    }
    public abstract void verificaTipoPessoaCliente(Cliente cliente);
    public Repository<Locacao> getRepositoryDeLocacao() {
        return repositoryDeLocacao;
    }

}
