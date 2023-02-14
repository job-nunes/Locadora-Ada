package model;

public class ClientePJ extends Cliente{
    private static final long serialVersionUID = 1L;
    public ClientePJ(String nome, String documento, String celular) {
        super(nome, documento, celular, TipoDocumento.CNPJ, TipoPessoa.JURIDICA);
    }
}
