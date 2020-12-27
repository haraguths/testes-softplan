package model;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Objects;

public class NotaFiscal {

    private Integer id;

    private BigDecimal valor;

    public NotaFiscal(Integer id, BigDecimal valor) {
        this.id = id;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getValorFormatado() {
        if(Objects.nonNull(this.valor)) {
            return NumberFormat.getCurrencyInstance().format(this.valor);
        }
        return "R$ 0,00";
    }
}
