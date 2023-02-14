package model;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

public class LocacaoPF extends Locacao implements Locador{
    public static final double VALOR_DESCONTO_PF = 0.95;

    public LocacaoPF(Cliente cliente, Veiculo veiculo, LocalDateTime dataEHoraLocacao, LocalDateTime dataEHoraDevolucao) {
        super(cliente, veiculo, dataEHoraLocacao, dataEHoraDevolucao);
    }

    @Override
    public BigDecimal calcularAlocacao() {
        Long duracaoDias = Duration.between(getDataEHoraLocacao(),getDataEHoraDevolucao()).toDays() + 1;
        BigDecimal valorSemDesconto = getVeiculo().getValorVeiculo().multiply(BigDecimal.valueOf(duracaoDias));
        if(duracaoDias > 5){
            return valorSemDesconto.multiply(BigDecimal.valueOf(VALOR_DESCONTO_PF));
        }
        return valorSemDesconto;
    }

    @Override
    public String toString() {
        return "Locacao{" +
                "cliente=" + getCliente().getNome() +
                ", veiculo=" + getVeiculo().getId() +
                ", dataEHoraLocacao=" + getDataEHoraLocacao() +
                ", dataEHoraDevolucao=" + getDataEHoraDevolucao() +
                ", Valor=" + calcularAlocacao() +
                '}';
    }
}
