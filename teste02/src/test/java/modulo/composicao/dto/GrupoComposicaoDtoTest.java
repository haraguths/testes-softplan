package modulo.composicao.dto;

import exception.DescricaoComposicaoNaoEncontradaException;
import exception.UnidadeComposicaoNaoEncontradaException;
import modulo.composicao.enums.ETipoItem;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class GrupoComposicaoDtoTest {

    @Test
    public void quandoDescricaoComposicaoNulaRetornaErro() {
        Assert.assertThrows("Descrição composição não encontrada.", DescricaoComposicaoNaoEncontradaException.class, () -> {
            new GrupoComposicaoDTO(10050, composicaoDTOListParaTesteGetDescricaoComposicaoNula());
        });
    }

    @Test
    public void deveEncontrarDescricaoComposicao() {
        GrupoComposicaoDTO grupoComposicaoDTO = new GrupoComposicaoDTO(50050,
                ComposicaoDTOListParaTesteGetDescricaoComposicao());

        Assert.assertEquals("Teste 50050", grupoComposicaoDTO.getDescricaoComposicao());
    }

    @Test
    public void quandoUnidadeComposicaoNulaRetornaErro() {
        Assert.assertThrows("Unidade composição não encontrada.", UnidadeComposicaoNaoEncontradaException.class, () -> {
            new GrupoComposicaoDTO(10050, composicaoDTOListParaTesteGetUnidadeComposicaoNula());
        });
    }

    @Test
    public void deveEncontrarUnidadeComposicao() {
        GrupoComposicaoDTO grupoComposicaoDTO = new GrupoComposicaoDTO(50050,
                ComposicaoDTOListParaTesteGetDescricaoComposicao());

        Assert.assertEquals("M2", grupoComposicaoDTO.getUnidadeComposicao());
    }

    @Test
    public void quandoCalcularValoresComQuantidadeComposicaoNulaProcessaORestante() {
        GrupoComposicaoDTO grupoComposicaoDTO = new GrupoComposicaoDTO(50050,
                composicaoDTOListParaCalcularValoresComQuantidadeComposicaoNula());

        Assert.assertEquals("50050 Teste 50050 M2 13,75", grupoComposicaoDTO.calcularValores());
    }

    @Test
    public void quandoCalcularValoresComValorUnitarioNuloProcessaORestante() {
        GrupoComposicaoDTO grupoComposicaoDTO = new GrupoComposicaoDTO(50050,
                composicaoDTOListParaCalcularValoresComValorUnitarioNula());

        Assert.assertEquals("50050 Teste 50050 M2 13,75", grupoComposicaoDTO.calcularValores());
    }

    @Test
    public void quandoCalcularValoresComValorComposicaoNuloProcessaORestante() {
        GrupoComposicaoDTO grupoComposicaoDTO = new GrupoComposicaoDTO(50050,
                composicaoDTOListParaCalcularValoresComposicaoNula());

        Assert.assertEquals("50050 Teste 50050 M2 21,25", grupoComposicaoDTO.calcularValores());
    }

    @Test
    public void deveCalcularValoresComValorComposicao() {
        GrupoComposicaoDTO grupoComposicaoDTO = new GrupoComposicaoDTO(50050,
                composicaoDTOListParaCalcularValoresComposicao());

        Assert.assertEquals("50050 Teste 50050 M2 35,12", grupoComposicaoDTO.calcularValores());
    }

    private List<ComposicaoDTO> composicaoDTOListParaTesteGetDescricaoComposicaoNula() {
        return Arrays.asList(
                criarComposicaoDTO(10050, null, null),
                criarComposicaoDTO(10050, null, null),
                criarComposicaoDTO(50050, null, null),
                criarComposicaoDTO(50050, null, null)
        );
    }

    private List<ComposicaoDTO> composicaoDTOListParaTesteGetUnidadeComposicaoNula() {
        return Arrays.asList(
                criarComposicaoDTO(10050, "Teste", null),
                criarComposicaoDTO(10050, "Teste", null),
                criarComposicaoDTO(50050, "Teste", null),
                criarComposicaoDTO(50050, "Teste", null)
        );
    }

    private List<ComposicaoDTO> ComposicaoDTOListParaTesteGetDescricaoComposicao() {
        return Arrays.asList(
                criarComposicaoDTO(10050, "Teste 10050", "M3"),
                criarComposicaoDTO(10050, "Teste 10050", "M3"),
                criarComposicaoDTO(50050, "Teste 50050", "M2"),
                criarComposicaoDTO(50050, "Teste 50050", "M2")
        );
    }

    private ComposicaoDTO criarComposicaoDTO(Integer codigoComposicao, String descricaoComposicao, String unidadeComposicao) {
        ComposicaoDTO composicaoDTO = new ComposicaoDTO();
        composicaoDTO.setCodigoComposicao(codigoComposicao);
        composicaoDTO.setDescricaoComposicao(descricaoComposicao);
        composicaoDTO.setUnidadeComposicao(unidadeComposicao);
        return composicaoDTO;
    }

    private List<ComposicaoDTO> composicaoDTOListParaCalcularValoresComQuantidadeComposicaoNula() {
        return Arrays.asList(
                criarComposicaoDTOParaCalculos(
                        10050,
                        "Teste 10050",
                        "M3",
                        new BigDecimal("2.00"),
                        new BigDecimal("2.50"),
                        ETipoItem.INSUMO),
                criarComposicaoDTOParaCalculos(
                        50050,
                        "Teste 50050",
                        "M2",
                        null,
                        new BigDecimal("2.50"),
                        ETipoItem.INSUMO),
                criarComposicaoDTOParaCalculos(
                        50050,
                        "Teste 50050",
                        "M2",
                        new BigDecimal("5.50"),
                        new BigDecimal("2.50"),
                        ETipoItem.INSUMO)
        );
    }

    private List<ComposicaoDTO> composicaoDTOListParaCalcularValoresComValorUnitarioNula() {
        return Arrays.asList(
                criarComposicaoDTOParaCalculos(
                        10050,
                        "Teste 10050",
                        "M3",
                        new BigDecimal("3.00"),
                        new BigDecimal("2.50"),
                        ETipoItem.INSUMO),
                criarComposicaoDTOParaCalculos(
                        50050,
                        "Teste 50050",
                        "M2",
                        new BigDecimal("5.50"),
                        new BigDecimal("2.50"),
                        ETipoItem.INSUMO),
                criarComposicaoDTOParaCalculos(
                        50050,
                        "Teste 50050",
                        "M2",
                        new BigDecimal("5.50"),
                        null,
                        ETipoItem.INSUMO)
        );
    }

    private ComposicaoDTO criarComposicaoDTOParaCalculos(Integer codigoComposicao,
                                                         String descricaoComposicao,
                                                         String unidadeComposicao,
                                                         BigDecimal quantidadeComposicao,
                                                         BigDecimal valorUnitario,
                                                         ETipoItem tipoItem) {
        ComposicaoDTO composicaoDTO = new ComposicaoDTO();
        composicaoDTO.setCodigoComposicao(codigoComposicao);
        composicaoDTO.setDescricaoComposicao(descricaoComposicao);
        composicaoDTO.setUnidadeComposicao(unidadeComposicao);
        composicaoDTO.setQuantidadeComposicao(quantidadeComposicao);
        composicaoDTO.setValorUnitario(valorUnitario);
        composicaoDTO.setTipoItem(tipoItem);
        return composicaoDTO;
    }

    private List<ComposicaoDTO> composicaoDTOListParaCalcularValoresComposicaoNula() {
        return Arrays.asList(
                criarComposicaoDTOParaCalculosComposicao(
                        78963,
                        "Teste 10050",
                        "M3",
                        null,
                        null,
                        ETipoItem.INSUMO,
                        456),
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
                        new BigDecimal("5.50"),
                        null,
                        ETipoItem.COMPOSICAO,
                        78963)
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
