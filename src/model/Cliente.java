package model;

import java.util.Objects;

public abstract class Cliente implements Entidade {
    private static final long serialVersionUID = 1L;
    private final String nome;
    private final String documento;
    private String celular;
    private final TipoDocumento tipoDocumento;
    private final TipoPessoa tipoPessoa;

    protected Cliente(String nome, String documento, String celular, TipoDocumento tipoDocumento, TipoPessoa tipoPessoa) {
        this.nome = nome;
        this.documento = documento;
        this.celular = celular;
        this.tipoDocumento = tipoDocumento;
        this.tipoPessoa = tipoPessoa;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", documento='" + documento + '\'' +
                ", celular='" + celular + '\'' +
                ", tipoDocumento=" + tipoDocumento +
                '}';
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getCelular() {
        return celular;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(nome, cliente.nome) && Objects.equals(documento, cliente.documento) && Objects.equals(celular, cliente.celular) && tipoDocumento == cliente.tipoDocumento && tipoPessoa == cliente.tipoPessoa;
    }

    @Override
    public String getId(){
        return documento;
    };

}
