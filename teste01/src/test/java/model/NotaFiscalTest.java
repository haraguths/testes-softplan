package model;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class NotaFiscalTest {

    private NotaFiscal notaFiscal;

    @Test
    public void quandoValorForNuloFormatarComoZero() {
        notaFiscal = new NotaFiscal(1, null);
        Assert.assertEquals("R$ 0,00",notaFiscal.getValorFormatado());
    }

    @Test
    public void deveRetornaValorFormatado() {
        notaFiscal = new NotaFiscal(1, new BigDecimal("1366.00"));
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        Assert.assertEquals(numberFormat.format(notaFiscal.getValor()),notaFiscal.getValorFormatado());
    }

}
