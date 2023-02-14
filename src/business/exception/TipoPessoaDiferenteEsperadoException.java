package business.exception;

public class TipoPessoaDiferenteEsperadoException extends RuntimeException {

    public TipoPessoaDiferenteEsperadoException(String tipoEsperado, String tipoCliente, String gerenciador) {
        super("O cliente informado não é do tipo esperado. Tipo Esperado: "+tipoEsperado+" Tipo Pessoa Cliente: "+tipoCliente+". Usar o Gerenciador: "+ gerenciador+".");
    }
}
