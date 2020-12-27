package repository;

import model.NotaFiscal;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class NotaFiscalRepositoryTest {

    private NotaFiscalRepository notaFiscalRepository;

    @Before
    public void setUp() {
        this.notaFiscalRepository = new NotaFiscalRepository();
    }

    @Test
    public void quandoNotaFiscalNaoForEncontradaRetornaErro() {
        Assert.assertThrows(RuntimeException.class, () -> {
            this.notaFiscalRepository.findById(9);
        });
    }

    @Test
    public void deveRetornaNotaFiscal() {
        NotaFiscal notaFiscal = this.notaFiscalRepository.findById(1);
        Assert.assertTrue(notaFiscal.getId() == 1);
        Assert.assertEquals(notaFiscal.getValor(), new BigDecimal("10.00"));
    }

}
