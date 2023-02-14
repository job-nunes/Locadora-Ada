package model;

import java.math.BigDecimal;

public class VeiculoPequeno extends Veiculo{
    private static final long serialVersionUID = 1L;
    public VeiculoPequeno(String placa, String modelo) {
        super(placa, modelo, TipoVeiculo.PEQUENO, BigDecimal.valueOf(100));
    }
}
