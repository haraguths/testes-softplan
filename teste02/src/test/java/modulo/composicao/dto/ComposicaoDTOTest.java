package modulo.composicao.dto;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ComposicaoDTOTest {

    @Test
    public void quandoValorUnitarioForNuloRetornaZeroGetValor() {
        ComposicaoDTO composicaoDTO = criaComposicaoComValorUnitarioNulo();
        Assert.assertEquals(BigDecimal.ZERO, composicaoDTO.getValor());
    }

    @Test
    public void quandoQuantidadeComposicaoForNuloRetornaZeroGetValor() {
        ComposicaoDTO composicaoDTO = criaComposicaoComQuantidadeComposicaoNulo();
        Assert.assertEquals(BigDecimal.ZERO, composicaoDTO.getValor());
    }

    @Test
    public void quandoValorUnitarioForNuloRetornaZeroGetValorComposicao() {
        ComposicaoDTO composicaoDTO = criaComposicaoComValorUnitarioNulo();
        Assert.assertEquals(BigDecimal.ZERO, composicaoDTO.getValorComposicao(new BigDecimal("0.00")));
    }

    @Test
    public void quandoQuantidadeComposicaoForNuloRetornaZeroGetValorComposicao() {
        ComposicaoDTO composicaoDTO = criaComposicaoComQuantidadeComposicaoNulo();
        Assert.assertEquals(BigDecimal.ZERO, composicaoDTO.getValorComposicao(new BigDecimal("0.00")));
    }

    @Test
    public void quandoQuantidadeComposicaParametroForNuloRetornaZeroGetValorComposicao() {
        ComposicaoDTO composicaoDTO = criaComposicaoComValores();
        Assert.assertEquals(BigDecimal.ZERO, composicaoDTO.getValorComposicao(null));
    }

    @Test
    public void deveCalcularCorretamenteGetValor() {
        ComposicaoDTO composicaoDTO = criaComposicaoComValores();
        Assert.assertEquals(new BigDecimal("2.00"), composicaoDTO.getValor());
    }

    @Test
    public void deveCalcularCorretamenteGetValorComposicao() {
        ComposicaoDTO composicaoDTO = criaComposicaoComValores();
        Assert.assertEquals(new BigDecimal("3.00"), composicaoDTO.getValorComposicao(new BigDecimal("1.50")));
    }

    private ComposicaoDTO criaComposicaoComValorUnitarioNulo() {
        ComposicaoDTO composicaoDTO = new ComposicaoDTO();
        composicaoDTO.setQuantidadeComposicao(new BigDecimal("1.00"));
        composicaoDTO.setValorUnitario(null);
        return composicaoDTO;
    }

    private ComposicaoDTO criaComposicaoComQuantidadeComposicaoNulo() {
        ComposicaoDTO composicaoDTO = new ComposicaoDTO();
        composicaoDTO.setValorUnitario(new BigDecimal("1.00"));
        composicaoDTO.setQuantidadeComposicao(null);
        return composicaoDTO;
    }

    private ComposicaoDTO criaComposicaoComValores() {
        ComposicaoDTO composicaoDTO = new ComposicaoDTO();
        composicaoDTO.setValorUnitario(new BigDecimal("1.00"));
        composicaoDTO.setQuantidadeComposicao(new BigDecimal("2.00"));
        return composicaoDTO;
    }
}
