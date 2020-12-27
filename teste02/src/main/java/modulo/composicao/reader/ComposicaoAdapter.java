package modulo.composicao.reader;

import com.google.gson.*;
import exception.ProblemasLeituraArquivoException;
import exception.TipoItemNaoEncontradaException;
import modulo.composicao.dto.ComposicaoDTO;
import modulo.composicao.enums.ETipoItem;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Objects;

public class ComposicaoAdapter implements JsonDeserializer<ComposicaoDTO> {

    private static final TipoItemNaoEncontradaException TIPO_ITEM_NAO_ENCONTRADO = new TipoItemNaoEncontradaException();

    @Override
    public ComposicaoDTO deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        return new ComposicaoDTO(
                validaJsonElement(jsonObject, "codigoComposicao").getAsInt(),
                validaJsonElement(jsonObject, "descricaoComposicao").getAsString(),
                validaJsonElement(jsonObject, "unidadeComposicao").getAsString(),
                retornaEtipoItem(validaJsonElement(jsonObject, "tipoItem")),
                validaJsonElement(jsonObject, "codigoItem").getAsInt(),
                validaJsonElement(jsonObject, "descricaoItemComposicao").getAsString(),
                retornaBigDecimal(jsonObject.get("quantidadeComposicao")),
                retornaBigDecimal(jsonObject.get("valorUnitario"))
        );
    }

    private JsonElement validaJsonElement(JsonObject jsonObject, String atributo) {
        if(Objects.isNull(jsonObject.get(atributo))) {
            throw new ProblemasLeituraArquivoException();
        }
        return jsonObject.get(atributo);
    }

    private BigDecimal retornaBigDecimal(JsonElement jsonElement) {
        if(jsonElement.getAsString().isEmpty()) {
            return new BigDecimal("0.00");
        }
        return new BigDecimal(jsonElement.getAsString().replace(",", "."));
    }

    private ETipoItem retornaEtipoItem(JsonElement jsonElement) {
        return ETipoItem.retornaListaETipoItem().stream()
                .filter(tipoItem -> tipoItem.toString().equals(jsonElement.getAsString()))
                .findAny()
                .orElseThrow(() -> TIPO_ITEM_NAO_ENCONTRADO);
    }

}