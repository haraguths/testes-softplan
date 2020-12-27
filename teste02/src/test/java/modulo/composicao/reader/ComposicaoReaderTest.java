package modulo.composicao.reader;

import exception.ArquivoNaoEncontradoException;
import exception.ProblemasLeituraArquivoException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ComposicaoReaderTest {

    private ComposicaoReader composicaoReader;

    @Before
    public void setUp() {
        this.composicaoReader = new ComposicaoReader();
    }

    @Test
    public void quandoNaoEncontraArquivoRetornaErro() {
        String path = "./static/arquivo-nao-existente.json";
        Assert.assertThrows("Arquivo não encontrado.", ArquivoNaoEncontradoException.class, () -> {
            this.composicaoReader.readListFrom(path);
        });
    }

    @Test
    public void quandoArquivoNaoEstaNoPadraoRetornaErro() {
        String path = "./static/dados-entrada-teste-erro-formato.json";
        Assert.assertThrows("Não foi possivel realizar a leitura do arquivo.", ProblemasLeituraArquivoException.class, () -> {
            this.composicaoReader.readListFrom(path);
        });
    }

    @Test
    public void deveProcessarArquivo() {
        String path = "./static/dados-entrada-servicos-composicoes.json";
        Assert.assertNotNull(this.composicaoReader.readListFrom(path));
    }
}
