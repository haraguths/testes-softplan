package modulo.composicao.dto;

import exception.DescricaoComposicaoNaoEncontradaException;
import exception.UnidadeComposicaoNaoEncontradaException;
import modulo.composicao.enums.ETipoItem;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Objects;

public class GrupoComposicaoDTO {

    private Integer codigoComposicao;

    private String unidadeComposicao;

    private String descricaoComposicao;

    private List<ComposicaoDTO> composicaoDTOList;

    public GrupoComposicaoDTO() {
    }

    public GrupoComposicaoDTO(Integer codigoComposicao, List<ComposicaoDTO> composicoesList) {
        this.codigoComposicao = codigoComposicao;
        this.descricaoComposicao = getDescricaoComposicao(composicoesList);
        this.unidadeComposicao = getUnidadeComposicao(composicoesList);
        this.composicaoDTOList = composicoesList;
    }

    public String calcularValores() {
        return this.getCodigoComposicao() + " " + this.getDescricaoComposicao() + " " + this.getUnidadeComposicao()
                + " " + formataValor(calculaValor(this.getCodigoComposicao()));
    }

    private BigDecimal calculaValor(Integer codigoComposicao) {
        return this.getComposicaoDTOList()
                .stream()
                .filter(composicaoDTO -> composicaoDTO.getCodigoComposicao().equals(codigoComposicao))
                .map(composicaoDTO -> {
                    return defineFluxoInsumoComposicao(composicaoDTO);
                })
                .reduce(BigDecimal.ZERO,BigDecimal::add);
    }

    private BigDecimal defineFluxoInsumoComposicao(ComposicaoDTO composicaoDTO) {
        if(ETipoItem.INSUMO.equals(composicaoDTO.getTipoItem())) {
            return composicaoDTO.getValor();
        }

        if(ETipoItem.COMPOSICAO.equals(composicaoDTO.getTipoItem())) {
            return calculaValor(composicaoDTO.getCodigoItem())
                    .multiply(composicaoDTO.getQuantidadeComposicao())
                    .setScale(2, RoundingMode.DOWN);
        }

        return new BigDecimal("0.00");
    }

    private String formataValor(BigDecimal resultado) {
        if(Objects.nonNull(resultado)) {
            NumberFormat formatter = new DecimalFormat("#,##0.00");
            return formatter.format(resultado);
        }
        return "0,00";
    }

    private String getDescricaoComposicao(List<ComposicaoDTO> composicaoDTOList) {
        return composicaoDTOList
                .stream()
                .filter(composicaoDTO -> this.getCodigoComposicao().equals(composicaoDTO.getCodigoComposicao()))
                .filter(composicaoDTO -> Objects.nonNull(composicaoDTO.getDescricaoComposicao()))
                .findFirst()
                .orElseThrow(() -> new DescricaoComposicaoNaoEncontradaException()).getDescricaoComposicao();
    }

    private String getUnidadeComposicao(List<ComposicaoDTO> composicaoDTOList) {
        return composicaoDTOList
                .stream()
                .filter(composicaoDTO -> this.getCodigoComposicao().equals(composicaoDTO.getCodigoComposicao()))
                .filter(composicaoDTO -> Objects.nonNull(composicaoDTO.getUnidadeComposicao()))
                .findFirst()
                .orElseThrow(() -> new UnidadeComposicaoNaoEncontradaException()).getUnidadeComposicao();
    }

    public Integer getCodigoComposicao() {
        return codigoComposicao;
    }

    public void setCodigoComposicao(Integer codigoComposicao) {
        this.codigoComposicao = codigoComposicao;
    }

    public String getUnidadeComposicao() {
        return unidadeComposicao;
    }

    public void setUnidadeComposicao(String unidadeComposicao) {
        this.unidadeComposicao = unidadeComposicao;
    }

    public String getDescricaoComposicao() {
        return descricaoComposicao;
    }

    public void setDescricaoComposicao(String descricaoComposicao) {
        this.descricaoComposicao = descricaoComposicao;
    }

    public List<ComposicaoDTO> getComposicaoDTOList() {
        return composicaoDTOList;
    }

    public void setComposicaoDTOList(List<ComposicaoDTO> composicaoDTOList) {
        this.composicaoDTOList = composicaoDTOList;
    }
}
