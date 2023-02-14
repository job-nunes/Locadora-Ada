package persistence.arquivo;

import model.Locacao;
import persistence.Repository;

public class LocacaoEmArquivoRepository extends RepositorioEmArquivoGenerico<Locacao> {
    public LocacaoEmArquivoRepository(ManipuladorDeArquivo manipuladorDeArquivo, Repository<Locacao> cache) {
        super(manipuladorDeArquivo, cache);
    }
}