package modulo.composicao.reader;

import com.google.gson.*;
import exception.ProblemasLeituraArquivoException;
import exception.TipoItemNaoEncontradaException;
import modulo.composicao.dto.ComposicaoDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class ComposicaoAdapterTest {

    private ComposicaoAdapter composicaoAdapter;

    @Before
    public void setUp() {
        this.composicaoAdapter = new ComposicaoAdapter();
    }

    @Test
    public void deveRetornaComposicaoDTO() {
        ComposicaoDTO composicaoDTO = this.composicaoAdapter.deserialize(jsonElementCorreto(), null, null);
        Assert.assertNotNull(composicaoDTO);
    }

    @Test
    public void deveRetornaComposicaoDTOComValoresBigDecimaisAdaptados() {
        ComposicaoDTO composicaoDTO = this.composicaoAdapter.deserialize(jsonElementQuantidadeComposicaoValorUnitarioForaDoPadrao(),
                null, null);
        Assert.assertEquals(new BigDecimal("0.00"), composicaoDTO.getQuantidadeComposicao());
        Assert.assertEquals(new BigDecimal("9.40"), composicaoDTO.getValorUnitario());
    }

    @Test
    public void deveRetornaErroComTipoItemInvalido() {
        Assert.assertThrows("Tipo item não encontrada.", TipoItemNaoEncontradaException.class, () -> {
            this.composicaoAdapter.deserialize(jsonElementTipoItemInvalido(), null,
                    null);
        });
    }

    @Test
    public void deveRetornaErroSemCodigoComposicao() {
        Assert.assertThrows("Código composição não foi encontrado.", ProblemasLeituraArquivoException.class, () -> {
            this.composicaoAdapter.deserialize(jsonElementComCodigoSemCodigoComposicao(), null,
                    null);
        });
    }

    @Test
    public void deveRetornaErroSemDescricaoComposicao() {
        Assert.assertThrows("Descrição composição não foi encontrado.", ProblemasLeituraArquivoException.class, () -> {
            this.composicaoAdapter.deserialize(jsonElementComCodigoSemDescricaoComposicao(), null,
                    null);
        });
    }

    private JsonElement jsonElementCorreto() {
        String json = "{"
                + "'codigoComposicao': 94793, "
                + "'descricaoComposicao': 'REGISTRO DE GAVETA BRUTO',"
                + "'unidadeComposicao': 'UN',"
                + "'tipoItem': 'INSUMO',"
                + "'codigoItem': 3148,"
                + "'descricaoItemComposicao': 'FITA VEDA ROSCA',"
                + "'quantidadeComposicao': '0,0190000',"
                + "'valorUnitario': '9,40'"
                + "}";
        Gson gson = new Gson();
        JsonElement element = gson.fromJson(json, JsonElement.class);
        return element;
    }

    private JsonElement jsonElementQuantidadeComposicaoValorUnitarioForaDoPadrao() {
        String json = "{"
                + "'codigoComposicao': 94793, "
                + "'descricaoComposicao': 'REGISTRO DE GAVETA BRUTO',"
                + "'unidadeComposicao': 'UN',"
                + "'tipoItem': 'INSUMO',"
                + "'codigoItem': 3148,"
                + "'descricaoItemComposicao': 'FITA VEDA ROSCA',"
                + "'quantidadeComposicao': '',"
                + "'valorUnitario': '9.40'"
                + "}";
        Gson gson = new Gson();
        JsonElement element = gson.fromJson(json, JsonElement.class);
        return element;
    }

    private JsonElement jsonElementTipoItemInvalido() {
        String json = "{"
                + "'codigoComposicao': 94793, "
                + "'descricaoComposicao': 'REGISTRO DE GAVETA BRUTO',"
                + "'unidadeComposicao': 'UN',"
                + "'tipoItem': 'INVALIDO',"
                + "'codigoItem': 3148,"
                + "'descricaoItemComposicao': 'FITA VEDA ROSCA',"
                + "'quantidadeComposicao': '0,0190000',"
                + "'valorUnitario': '9,40'"
                + "}";
        Gson gson = new Gson();
        JsonElement element = gson.fromJson(json, JsonElement.class);
        return element;
    }

    private JsonElement jsonElementComCodigoSemCodigoComposicao() {
        String json = "{"
                + "'descricaoComposicao': 'REGISTRO DE GAVETA BRUTO',"
                + "'unidadeComposicao': 'UN',"
                + "'tipoItem': 'INSUMO',"
                + "'codigoItem': 3148,"
                + "'descricaoItemComposicao': 'FITA VEDA ROSCA',"
                + "'quantidadeComposicao': '0,0190000',"
                + "'valorUnitario': '9,40'"
                + "}";
        Gson gson = new Gson();
        JsonElement element = gson.fromJson(json, JsonElement.class);
        return element;
    }

    private JsonElement jsonElementComCodigoSemDescricaoComposicao() {
        String json = "{"
                + "'codigoComposicao': 94793, "
                + "'unidadeComposicao': 'UN',"
                + "'tipoItem': 'INSUMO',"
                + "'codigoItem': 3148,"
                + "'descricaoItemComposicao': 'FITA VEDA ROSCA',"
                + "'quantidadeComposicao': '0,0190000',"
                + "'valorUnitario': '9,40'"
                + "}";
        Gson gson = new Gson();
        JsonElement element = gson.fromJson(json, JsonElement.class);
        return element;
    }
}
