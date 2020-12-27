package service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class GeradorObservacaoTest {

    private GeradorObservacao geradorObservacao;

    @Before
    public void setUp() {
        this.geradorObservacao = new GeradorObservacao();
    }

    @Test
    public void quandoListaForNulaRetornaVazioObservacaoSimples() {
        Assert.assertEquals("", this.geradorObservacao.geraObservacaoSimples(null));
    }

    @Test
    public void quandoListaForNulaRetornaVazioObservacaoComposta() {
        Assert.assertEquals("", this.geradorObservacao.geraObservacaoComposta(null));
    }

    @Test
    public void deveRetornaUmaObservacaoComposta() {
        Assert.assertEquals("Fatura da nota fiscal de simples remessa: 1 cuja valor é R$ 10,00. " +
                        "Total = R$ 10,00.",
                this.geradorObservacao.geraObservacaoComposta(Arrays.asList(1)));
    }

    @Test
    public void deveRetornaUmaObservacaoSimples() {
        Assert.assertEquals("Fatura da nota fiscal de simples remessa: 2.",
                this.geradorObservacao.geraObservacaoSimples(Arrays.asList(2)));
    }

    @Test
    public void deveRetornaVariosElementosObservacaoComposta() {
        Assert.assertEquals("Fatura das notas fiscais de simples remessa: 1, 2 e 3.",
                this.geradorObservacao.geraObservacaoSimples(Arrays.asList(1,2,3)));
    }

    @Test
    public void deveRetornaVariosElementosObservacaoSimples() {
        Assert.assertEquals("Fatura das notas fiscais de simples remessa: 1 cuja valor é R$ 10,00, 2 cuja " +
                        "valor é R$ 35,00 e 3 cuja valor é R$ 5,00. Total = R$ 50,00.",
                this.geradorObservacao.geraObservacaoComposta(Arrays.asList(1,2,3)));
    }

    @Test
    public void quandoNotaFiscalNaoForEncontradaRetornaErro() {
        Assert.assertThrows(RuntimeException.class, () -> {
            this.geradorObservacao.geraObservacaoComposta(Arrays.asList(9));
        });
    }

}
