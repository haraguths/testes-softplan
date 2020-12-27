import modulo.composicao.dto.ComposicaoDTO;
import modulo.composicao.reader.ComposicaoReader;
import modulo.composicao.service.ComposicaoService;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String path = "./static/dados-entrada-servicos-composicoes.json";

        ComposicaoReader composicaoReader = new ComposicaoReader();
        List<ComposicaoDTO> composicaoDTOList = composicaoReader.readListFrom(path);

        ComposicaoService composicaoService = new ComposicaoService();
        String resposta = composicaoService.calcularComposicoes(composicaoDTOList);

        System.out.println(resposta);
    }
}
