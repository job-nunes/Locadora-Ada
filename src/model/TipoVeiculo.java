package model;

import java.math.BigDecimal;

public enum TipoVeiculo {
    PEQUENO(1),
    MEDIO(2),
    SUV(3);

    private final Integer id;
    TipoVeiculo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public static TipoVeiculo buscaTipoVeiculoPeloId(String id){
        Integer index = Integer.parseInt(id);
        TipoVeiculo tipoVeiculoEncontrado = null;
        for (TipoVeiculo tipoVeiculo : values()) {
            if(tipoVeiculo.getId().equals(index)) {
                tipoVeiculoEncontrado = tipoVeiculo;
            }
        }
        return tipoVeiculoEncontrado;
    }
}
