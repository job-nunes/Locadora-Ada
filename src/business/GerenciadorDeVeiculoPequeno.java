package business;

import business.exception.RegistroJaExistenteException;
import model.TipoVeiculo;
import model.Veiculo;
import model.VeiculoPequeno;
import model.VeiculoSUV;
import persistence.Repository;

import java.util.List;
import java.util.stream.Collectors;

public class GerenciadorDeVeiculoPequeno extends GerenciadorDeVeiculo{
    public GerenciadorDeVeiculoPequeno(Repository<Veiculo> repositoryDeVeiculo) {
        super(repositoryDeVeiculo);
    }

    @Override
    public Veiculo adicionarVeiculo(String placa, String modelo) {
        if (existeVeiculo(placa)) {
            throw new RegistroJaExistenteException(VEICULO_DESCRICAO_CLASSE, placa);
        }

        Veiculo novoVeiculo = new VeiculoPequeno(placa,modelo);
        Veiculo veiculoSalvo = getRepositoryDeVeiculo().salvar(novoVeiculo);
        return veiculoSalvo;
    }

    @Override
    public List<Veiculo> listarTodosComTipoVeiculo() {
        return listarTodos().stream().
                filter(veiculo -> veiculo.getTipoVeiculo().equals(TipoVeiculo.PEQUENO)).
                collect(Collectors.toList());
    }
}
