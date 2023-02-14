package model;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Veiculo implements Entidade{
    private static final long serialVersionUID = 1L;
    private final String placa;
    private final String modelo;
    private final TipoVeiculo tipoVeiculo;
    private BigDecimal valorAlocacaoVeiculo;
    public Veiculo(String placa, String modelo, TipoVeiculo tipoVeiculo, BigDecimal valorAlocacaoVeiculo) {
        this.placa = placa;
        this.modelo = modelo;
        this.tipoVeiculo = tipoVeiculo;
        this.valorAlocacaoVeiculo = valorAlocacaoVeiculo;
    }
    @Override
    public String getId() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public TipoVeiculo getTipoVeiculo() {
        return tipoVeiculo;
    }

    public BigDecimal getValorVeiculo() {
        return valorAlocacaoVeiculo;
    }

    public void setValorVeiculo(BigDecimal valorVeiculo) {
        this.valorAlocacaoVeiculo = valorVeiculo;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "placa='" + placa + '\'' +
                ", modelo='" + modelo + '\'' +
                ", tipoVeiculo=" + tipoVeiculo +
                ", valorVeiculo=" + valorAlocacaoVeiculo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return Objects.equals(placa, veiculo.placa) && Objects.equals(modelo, veiculo.modelo) && tipoVeiculo == veiculo.tipoVeiculo && Objects.equals(valorAlocacaoVeiculo, veiculo.valorAlocacaoVeiculo);
    }

}
