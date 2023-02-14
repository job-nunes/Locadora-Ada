package model;

import java.time.LocalDateTime;

public interface VerificadorDatasNoPeriodoAlocacao {
    boolean verificarDataNoPeriodoLocacao(LocalDateTime data);
}
