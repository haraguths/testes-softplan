package modulo.composicao.dto;

import modulo.composicao.enums.ETipoItem;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class ComposicaoDTO {

    private Integer codigoComposicao;

    private String descricaoComposicao;

    private String unidadeComposicao;

    private ETipoItem tipoItem;

    private Integer codigoItem;

    private String descricaoItemComposicao;

    private BigDecimal quantidadeComposicao;

    private BigDecimal valorUnitario;

    public ComposicaoDTO() {
    }

    public ComposicaoDTO(Integer codigoComposicao,
                         String descricaoComposicao,
                         String unidadeComposicao,
                         ETipoItem tipoItem,
                         Integer codigoItem,
                         String descricaoItemComposicao,
                         BigDecimal quantidadeComposicao,
                         BigDecimal valorUnitario) {
        this.codigoComposicao = codigoComposicao;
        this.descricaoComposicao = descricaoComposicao;
        this.unidadeComposicao = unidadeComposicao;
        this.tipoItem = tipoItem;
        this.codigoItem = codigoItem;
        this.descricaoItemComposicao = descricaoItemComposicao;
        this.quantidadeComposicao = quantidadeComposicao;
        this.valorUnitario = valorUnitario;
    }

    public Integer getCodigoComposicao() {
        return codigoComposicao;
    }

    public BigDecimal getValor() {
        if(Objects.isNull(this.getValorUnitario())) {
            return BigDecimal.ZERO;
        }

        if(Objects.isNull(this.getQuantidadeComposicao())) {
            return BigDecimal.ZERO;
        }

        return this.getValorUnitario()
                .multiply(this.getQuantidadeComposicao())
                .setScale(2, RoundingMode.DOWN);
    }

    public BigDecimal getValorComposicao(BigDecimal quantidadeComposicao) {
        if(Objects.isNull(this.getValorUnitario())) {
            return BigDecimal.ZERO;
        }

        if(Objects.isNull(this.getQuantidadeComposicao())) {
            return BigDecimal.ZERO;
        }

        if(Objects.isNull(quantidadeComposicao)) {
            return BigDecimal.ZERO;
        }

        return this.getValorUnitario()
                .multiply(this.getQuantidadeComposicao())
                .multiply(quantidadeComposicao)
                .setScale(2, RoundingMode.HALF_DOWN);
    }

    public void setCodigoComposicao(Integer codigoComposicao) {
        this.codigoComposicao = codigoComposicao;
    }

    public String getDescricaoComposicao() {
        return descricaoComposicao;
    }

    public void setDescricaoComposicao(String descricaoComposicao) {
        this.descricaoComposicao = descricaoComposicao;
    }

    public String getUnidadeComposicao() {
        return unidadeComposicao;
    }

    public void setUnidadeComposicao(String unidadeComposicao) {
        this.unidadeComposicao = unidadeComposicao;
    }

    public ETipoItem getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(ETipoItem tipoItem) {
        this.tipoItem = tipoItem;
    }

    public Integer getCodigoItem() {
        return codigoItem;
    }

    public void setCodigoItem(Integer codigoItem) {
        this.codigoItem = codigoItem;
    }

    public String getDescricaoItemComposicao() {
        return descricaoItemComposicao;
    }

    public void setDescricaoItemComposicao(String descricaoItemComposicao) {
        this.descricaoItemComposicao = descricaoItemComposicao;
    }

    public BigDecimal getQuantidadeComposicao() {
        return quantidadeComposicao;
    }

    public void setQuantidadeComposicao(BigDecimal quantidadeComposicao) {
        this.quantidadeComposicao = quantidadeComposicao;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
}
