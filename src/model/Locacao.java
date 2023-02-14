package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Locacao implements Entidade, VerificadorDatasNoPeriodoAlocacao {
    private final Cliente cliente;
    private final Veiculo veiculo;
    private final LocalDateTime dataEHoraLocacao;
    private final LocalDateTime dataEHoraDevolucao;

    public Locacao(Cliente cliente, Veiculo veiculo, LocalDateTime dataEHoraLocacao, LocalDateTime dataEHoraDevolucao) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataEHoraLocacao = dataEHoraLocacao;
        this.dataEHoraDevolucao = dataEHoraDevolucao;
    }

    @Override
    public String getId() {
        return "Locacao{" +
                "cliente=" + cliente +
                ", veiculo=" + veiculo +
                ", dataEHoraLocacao=" + dataEHoraLocacao +
                ", dataEHoraDevolucao=" + dataEHoraDevolucao +
                '}';
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public LocalDateTime getDataEHoraLocacao() {
        return dataEHoraLocacao;
    }

    public LocalDateTime getDataEHoraDevolucao() {
        return dataEHoraDevolucao;
    }

    @Override
    public String toString() {
        return "Locacao{" +
                "cliente=" + cliente +
                ", veiculo=" + veiculo +
                ", dataEHoraLocacao=" + dataEHoraLocacao +
                ", dataEHoraDevolucao=" + dataEHoraDevolucao +
                '}';
    }

    @Override
    public boolean verificarDataNoPeriodoLocacao(LocalDateTime data) {
        return this.dataEHoraLocacao.isBefore(data) && this.dataEHoraDevolucao.isAfter(data);
    }
}
