package modulo.composicao.enums;

import java.util.Arrays;
import java.util.List;

public enum ETipoItem {

    INSUMO,COMPOSICAO;

    public static List<ETipoItem> retornaListaETipoItem() {
        return Arrays.asList(
                ETipoItem.INSUMO,
                ETipoItem.COMPOSICAO
        );
    }
}
