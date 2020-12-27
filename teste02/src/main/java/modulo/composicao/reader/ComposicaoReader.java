package modulo.composicao.reader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import exception.ArquivoNaoEncontradoException;
import exception.ProblemasLeituraArquivoException;
import modulo.composicao.dto.ComposicaoDTO;

import java.io.IOException;

import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.List;

public class ComposicaoReader {

    public List<ComposicaoDTO> readListFrom(String path) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ComposicaoDTO.class, new ComposicaoAdapter());
        Gson gson = gsonBuilder.create();
        Type collectionType = new TypeToken<List<ComposicaoDTO>>(){}.getType();

        try {
            String jsonText = readJson(path);

            return gson.fromJson(jsonText, collectionType);
        } catch (NoSuchFileException e) {
            throw new ArquivoNaoEncontradoException();
        } catch (IOException | JsonSyntaxException e) {
            throw new ProblemasLeituraArquivoException();
        }

    }

    private String readJson(String path) throws IOException {
        String json = String.join(" ",
                Files.readAllLines(
                        Paths.get(path),
                        StandardCharsets.UTF_8)
        );
        return json;
    }
}
