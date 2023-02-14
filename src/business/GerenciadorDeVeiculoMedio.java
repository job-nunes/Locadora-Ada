package business;

import business.exception.RegistroJaExistenteException;
import model.TipoVeiculo;
import model.Veiculo;
import model.VeiculoMedio;
import model.VeiculoSUV;
import persistence.Repository;

import java.util.List;
import java.util.stream.Collectors;

public class GerenciadorDeVeiculoMedio extends GerenciadorDeVeiculo{
    public GerenciadorDeVeiculoMedio(Repository<Veiculo> repositoryDeVeiculo) {
        super(repositoryDeVeiculo);
    }

    @Override
    public Veiculo adicionarVeiculo(String placa, String modelo) {
        if (existeVeiculo(placa)) {
            throw new RegistroJaExistenteException(VEICULO_DESCRICAO_CLASSE, placa);
        }

        Veiculo novoVeiculo = new VeiculoMedio(placa,modelo);
        Veiculo veiculoSalvo = getRepositoryDeVeiculo().salvar(novoVeiculo);
        return veiculoSalvo;
    }

    @Override
    public List<Veiculo> listarTodosComTipoVeiculo() {
        return listarTodos().stream().
                filter(veiculo -> veiculo.getTipoVeiculo().equals(TipoVeiculo.MEDIO)).
                collect(Collectors.toList());
    }
}
