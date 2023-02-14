package business.exception;

public class RegistroNaoEncontradoException extends RuntimeException {

    public RegistroNaoEncontradoException(String tipo, String id) {
        super("Não existe um registro do tipo "+ tipo+" %s com o id "+id+".");
    }
}