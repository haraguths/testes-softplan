package enums;

import model.NotaFiscal;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public enum ENotaFiscal {

    UM(new NotaFiscal(1, new BigDecimal("10.00"))),
    DOIS(new NotaFiscal(2, new BigDecimal("35.00"))),
    TRES(new NotaFiscal(3, new BigDecimal("5.00"))),
    QUATRO(new NotaFiscal(4, new BigDecimal("1500.00"))),
    CINCO(new NotaFiscal(5, new BigDecimal("0.30"))),
    SEIS(new NotaFiscal(6, new BigDecimal("30.00"))),
    SETE(new NotaFiscal(7, new BigDecimal("3700.00"))),
    OITO(new NotaFiscal(8, new BigDecimal("366.00")));

    private final NotaFiscal notaFiscal;

    private ENotaFiscal(NotaFiscal notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public NotaFiscal getNotaFiscal() {
        return notaFiscal;
    }

    public static List<ENotaFiscal> retornaListaENotaFiscal() {
        return Arrays.asList(
                ENotaFiscal.UM,
                ENotaFiscal.DOIS,
                ENotaFiscal.TRES,
                ENotaFiscal.QUATRO,
                ENotaFiscal.CINCO,
                ENotaFiscal.SEIS,
                ENotaFiscal.SETE,
                ENotaFiscal.OITO
        );
    }
}
