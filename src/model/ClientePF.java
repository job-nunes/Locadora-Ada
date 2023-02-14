package model;

public class ClientePF extends Cliente{
    private static final long serialVersionUID = 1L;
    public ClientePF(String nome, String documento, String celular) {
        super(nome, documento, celular, TipoDocumento.CPF, TipoPessoa.FISICA);
    }
}
