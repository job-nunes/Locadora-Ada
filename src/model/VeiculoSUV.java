package model;

import java.math.BigDecimal;

public class VeiculoSUV extends Veiculo{
    private static final long serialVersionUID = 1L;
    public VeiculoSUV(String placa, String modelo) {
        super(placa, modelo, TipoVeiculo.SUV, BigDecimal.valueOf(200));
    }
}
