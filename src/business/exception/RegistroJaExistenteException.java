package business.exception;

public class RegistroJaExistenteException extends RuntimeException {

    public RegistroJaExistenteException(String tipo, String id) {
        super("Já existe um registro do tipo "+ tipo+" %s com o id "+id+".");
    }
}