package repository;

import enums.ENotaFiscal;
import exception.NaoEncontradoException;
import model.NotaFiscal;

public class NotaFiscalRepository {

    private static final NaoEncontradoException NOTA_FISCAL_NAO_ENCONTRADA
            = new NaoEncontradoException("Nota fiscal não encontrada.");

    public NotaFiscal findById(Integer id) {
        return mockBanco(id);
    }

    private NotaFiscal mockBanco(Integer id) {
        return ENotaFiscal.retornaListaENotaFiscal().stream()
                .filter(notaFiscal -> id.equals(notaFiscal.getNotaFiscal().getId()))
                .findAny()
                .orElseThrow(() -> NOTA_FISCAL_NAO_ENCONTRADA).getNotaFiscal();
    }

}
