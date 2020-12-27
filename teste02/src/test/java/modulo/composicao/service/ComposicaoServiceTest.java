package modulo.composicao.service;

import exception.ErrosComposicaoDTOException;
import modulo.composicao.dto.ComposicaoDTO;
import modulo.composicao.enums.ETipoItem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ComposicaoServiceTest {

    private ComposicaoService composicaoService;

    @Before
    public void setUp() {
        this.composicaoService = new ComposicaoService();
    }

    @Test
    public void quandoComposicaoDTOListaForNulaRetornaErro() {
        List<ComposicaoDTO> composicaoDTOList = null;
        Assert.assertThrows("Não foi possível realizar cálculo das composições.",
                ErrosComposicaoDTOException.class, () -> { this.composicaoService.calcularComposicoes(composicaoDTOList); });
    }

    @Test
    public void quandoComposicaoDTOListaForNulaRetornaErro2() {
        List<ComposicaoDTO> composicaoDTOList = composicaoDTOList();
        Assert.assertThrows("Não foi possível realizar cálculo das composições.",
                ErrosComposicaoDTOException.class, () -> { this.composicaoService.calcularComposicoes(composicaoDTOList); });
    }

    @Test
    public void deveCalcularComposicoes() {
        List<ComposicaoDTO> composicaoDTOList = composicaoDTOListParaCalcularValores();
        Assert.assertNotNull("Deve retorna calculo em String", this.composicaoService.calcularComposicoes(composicaoDTOList));
    }

    @Test
    public void deveCalcularComposicoesCompostas() {
        List<ComposicaoDTO> composicaoDTOList = composicaoDTOListParaCalcularValoresComposicao();
        Assert.assertNotNull("Deve retorna calculo em String", this.composicaoService.calcularComposicoes(composicaoDTOList));
    }

    private List<ComposicaoDTO> composicaoDTOList() {
        return Arrays.asList(
                criarComposicaoDTOParaCalculosComposicao("Teste 01"),
                criarComposicaoDTOParaCalculosComposicao("Teste 02"),
                criarComposicaoDTOParaCalculosComposicao("Teste 03")
        );
    }

    private ComposicaoDTO criarComposicaoDTOParaCalculosComposicao(String descricaoComposicao) {
        ComposicaoDTO composicaoDTO = new ComposicaoDTO();
        composicaoDTO.setDescricaoComposicao(descricaoComposicao);
        return composicaoDTO;
    }

    private List<ComposicaoDTO> composicaoDTOListParaCalcularValores() {
        return Arrays.asList(
                criarComposicaoDTOParaCalculosComposicao(
                        50050,
                        "Teste 50050",
                        "M2",
                        new BigDecimal("8.50"),
                        new BigDecimal("2.50"),
                        ETipoItem.INSUMO,
                        531),
                criarComposicaoDTOParaCalculosComposicao(
                        50050,
                        "Teste 50050",
                        "M2",
                        new BigDecimal("18.50"),
                        new BigDecimal("2.50"),
                        ETipoItem.INSUMO,
                        46222)
        );
    }

    private List<ComposicaoDTO> composicaoDTOListParaCalcularValoresComposicao() {
        return Arrays.asList(
                criarComposicaoDTOParaCalculosComposicao(
                        46222,
                        "Teste 10050",
                        "M3",
                        new BigDecimal("0.50"),
                        new BigDecimal("1.50"),
                        ETipoItem.INSUMO,
                        123),
                criarComposicaoDTOParaCalculosComposicao(
                        50050,
                        "Teste 50050",
                        "M2",
                        new BigDecimal("8.50"),
                        new BigDecimal("2.50"),
                        ETipoItem.INSUMO,
                        531),
                criarComposicaoDTOParaCalculosComposicao(
                        50050,
                        "Teste 50050",
                        "M2",
                        new BigDecimal("18.50"),
                        null,
                        ETipoItem.COMPOSICAO,
                        46222)
        );
    }

    private ComposicaoDTO criarComposicaoDTOParaCalculosComposicao(Integer codigoComposicao,
                                                                   String descricaoComposicao,
                                                                   String unidadeComposicao,
                                                                   BigDecimal quantidadeComposicao,
                                                                   BigDecimal valorUnitario,
                                                                   ETipoItem tipoItem,
                                                                   Integer codigoItem) {
        ComposicaoDTO composicaoDTO = new ComposicaoDTO();
        composicaoDTO.setCodigoComposicao(codigoComposicao);
        composicaoDTO.setDescricaoComposicao(descricaoComposicao);
        composicaoDTO.setUnidadeComposicao(unidadeComposicao);
        composicaoDTO.setQuantidadeComposicao(quantidadeComposicao);
        composicaoDTO.setValorUnitario(valorUnitario);
        composicaoDTO.setTipoItem(tipoItem);
        composicaoDTO.setCodigoItem(codigoItem);
        return composicaoDTO;
    }
}
