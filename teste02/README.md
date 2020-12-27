#Explicações 
 1 - Foi escolhido a nomenclatura DTO para as ComposicaoDto e GrupoComposicaoDto pois acredito que as informações
    não esteja normalizadas para serem models.

 2 - Foi criado um arquivo ComposiçãoAdapter para ser feito desserialização dos campos quantidadeComposicao, 
    valorUnitario para atributos do tipo BigDecimal e unidadeComposicao. Os dois primeiros estão vindo com ',' 
    e seria necessário '.' também teria problemas com o campo valorUnitario que pode ser vazio.

 3 - A lógica de separação da lista inicial composicaoDTOList em sublista agrupadas foi
    primeiramente realizada em menos passos utilizando Map<Integer, List<ComposicaoDTO>>. Porém
    como Map não guarda ordem de entrada não conseguiria simular a saida igual o pedido no enunciado
    do exercício, pois não foi encontrada uma lógica para a ordenação a não ser a ordem recebida.
 
 4 - A princípio foi cogitado a possibilidade de implementar um padrão de projeto para a criação do 
    obejeto GrupoComposicaoDTO. Porém acredito que padrões de projeto criacionais oferecem um recurso
    que não seria aproveitado, como Abstract Factory seria recomendado para familias de objetos o que 
    não é o caso, Builder permite modularizar a criação de objetos oque seria desnecessário pois todos
    os objetos GrupoComposicaoDTO possuem a mesma estrutura e tipos de informações e o Factory Method
    fornece uma alternativa para criação de objetos com diferenças entre si, o que não é o caso. Acredito
    que partir para um padrão de projeto para a criação do GrupoComposicaoDTO iria ao contrario que os 
    conceitos de KISS, YAGNI e DRY pregão. Assim optei pela simplicidade.
 
5 - Para o cálculo final das composições foi usado recursividade, pois indo por outro caminho a complexidade 
    seria bem maior.