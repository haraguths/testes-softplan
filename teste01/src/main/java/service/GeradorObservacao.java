package service;

import model.NotaFiscal;
import org.apache.commons.collections.CollectionUtils;
import repository.NotaFiscalRepository;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.List;

public class GeradorObservacao {

    NotaFiscalRepository notaFiscalRepository = new NotaFiscalRepository();

    public String geraObservacaoSimples(List lista) {
        if (CollectionUtils.isNotEmpty(lista)) {
            return defineTextoInicial(lista) + constroiConteudoSimples(lista);
        }
        return "";
    }

    public String geraObservacaoComposta(List lista) {
        if (CollectionUtils.isNotEmpty(lista)) {
            return defineTextoInicial(lista) + constroiConteudoComposto(lista);
        }
        return "";
    }

    private String defineTextoInicial(List lista) {
        return lista.size() >= 2 ? "Fatura das notas fiscais de simples remessa: "
                : "Fatura da nota fiscal de simples remessa: ";
    }

    private String retornaSeparador(Iterator<Integer> iterator, StringBuilder frase) {
        if(frase.toString().length() <= 0) {
            return "";
        }

        if(iterator.hasNext()) {
            return ", ";
        }

        return " e ";
    }

    private String constroiConteudoSimples(List lista) {
        StringBuilder frase = new StringBuilder();
        for (Iterator<Integer> iterator = lista.iterator(); iterator.hasNext();) {
            Integer codigo = iterator.next();
            frase.append(retornaSeparador(iterator, frase) + codigo);
        }
        return frase.append(".").toString();
    }

    private String constroiConteudoComposto(List lista) {
        StringBuilder frase = new StringBuilder();
        BigDecimal soma = BigDecimal.ZERO;
        for (Iterator<Integer> iterator = lista.iterator(); iterator.hasNext();) {
            Integer codigo = iterator.next();
            NotaFiscal notaFiscal = notaFiscalRepository.findById(codigo);
            soma = soma.add(notaFiscal.getValor());
            frase.append(retornaSeparador(iterator, frase) + codigo + " cuja valor é " + notaFiscal.getValorFormatado());
        }
        return frase.append(".").append(" Total = ").append(formataValorTotal(soma)).append(".").toString();
    }

    private String formataValorTotal(BigDecimal soma) {
        return NumberFormat.getCurrencyInstance().format(soma);
    }
}
