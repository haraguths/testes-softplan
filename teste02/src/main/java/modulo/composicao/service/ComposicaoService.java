package modulo.composicao.service;

import exception.ErrosComposicaoDTOException;
import modulo.composicao.dto.ComposicaoDTO;
import modulo.composicao.dto.GrupoComposicaoDTO;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ComposicaoService {

    private static final ErrosComposicaoDTOException ERROS_COMPOSICAODTO = new ErrosComposicaoDTOException();

    public String calcularComposicoes(List<ComposicaoDTO> composicaoDTOList) {
        List<Integer> codigosComposicaoList = retornaCodigosComposicoes(composicaoDTOList);
        List<GrupoComposicaoDTO> grupoComposicaoDTOList = criarGrupoComposicoes(codigosComposicaoList, composicaoDTOList);
        return realizarCalculo(grupoComposicaoDTOList);
    }

    private List<Integer> retornaCodigosComposicoes(List<ComposicaoDTO> composicaoDTOList) {
        if (CollectionUtils.isEmpty(composicaoDTOList)) {
            throw ERROS_COMPOSICAODTO;
        }

        return composicaoDTOList.stream()
                .filter(composicaoDTO -> Objects.nonNull(composicaoDTO.getCodigoComposicao()))
                .map(ComposicaoDTO::getCodigoComposicao)
                .distinct().collect(Collectors.toList());
    }

    private List<GrupoComposicaoDTO> criarGrupoComposicoes(List<Integer> codigosComposicaoList,
                                                        List<ComposicaoDTO> composicaoDTOList) {
        if (CollectionUtils.isEmpty(codigosComposicaoList)) {
            throw ERROS_COMPOSICAODTO;
        }

        if (CollectionUtils.isEmpty(composicaoDTOList)) {
            throw ERROS_COMPOSICAODTO;
        }

        List<GrupoComposicaoDTO> grupoComposicaoDTOList = codigosComposicaoList
                .stream()
                .map(codigo -> new GrupoComposicaoDTO(codigo, composicaoDTOList))
                .collect(Collectors.toList());
        return grupoComposicaoDTOList;
    }


    private String realizarCalculo(List<GrupoComposicaoDTO> grupoComposicaoDTOList) {
        StringBuilder resposta = new StringBuilder();
        grupoComposicaoDTOList.forEach(grupoComposicaoDTO -> {
            resposta.append(grupoComposicaoDTO.calcularValores()).append(" \n");
        });
        return resposta.toString();
    }

}
