package persistence.arquivo;

import model.Cliente;
import persistence.Repository;

public class ClienteEmArquivoRepository extends RepositorioEmArquivoGenerico<Cliente> {
    public ClienteEmArquivoRepository(ManipuladorDeArquivo manipuladorDeArquivo, Repository<Cliente> cache) {
        super(manipuladorDeArquivo, cache);
    }
}
