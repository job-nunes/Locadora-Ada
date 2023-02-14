package model;

import java.math.BigDecimal;

public class VeiculoMedio extends Veiculo{
    private static final long serialVersionUID = 1L;
    public VeiculoMedio(String placa, String modelo) {
        super(placa, modelo, TipoVeiculo.MEDIO, BigDecimal.valueOf(150));
    }
}
