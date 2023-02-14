package model;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

public class LocacaoPJ extends Locacao implements Locador {

    public static final double VALOR_DESCONTO_PJ = 0.9;

    public LocacaoPJ(Cliente cliente, Veiculo veiculo, LocalDateTime dataEHoraLocacao, LocalDateTime dataEHoraDevolucao) {
        super(cliente, veiculo, dataEHoraLocacao, dataEHoraDevolucao);
    }

    @Override
    public BigDecimal calcularAlocacao() {
        Long duracaoDias = Duration.between(getDataEHoraLocacao(),getDataEHoraDevolucao()).toDays() + 1;
        BigDecimal valorSemDesconto = getVeiculo().getValorVeiculo().multiply(BigDecimal.valueOf(duracaoDias));
        if(duracaoDias > 3){
            return valorSemDesconto.multiply(BigDecimal.valueOf(VALOR_DESCONTO_PJ));
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
