package persistence.arquivo;

import model.Veiculo;
import persistence.Repository;

public class VeiculoEmArquivoRepository extends RepositorioEmArquivoGenerico<Veiculo> {
    public VeiculoEmArquivoRepository(ManipuladorDeArquivo manipuladorDeArquivo, Repository<Veiculo> cache) {
        super(manipuladorDeArquivo, cache);
    }
}