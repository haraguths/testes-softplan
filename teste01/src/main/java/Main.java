import service.GeradorObservacao;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {


        GeradorObservacao geradorObservacao = new GeradorObservacao();

        String respostaSimples = geradorObservacao.geraObservacaoSimples(Arrays.asList(1,2,3,4,5));

        String respostaComposta = geradorObservacao.geraObservacaoComposta(Arrays.asList(1,2,3,4,5));

        System.out.println(respostaSimples);

        System.out.println(respostaComposta);
    }
}
