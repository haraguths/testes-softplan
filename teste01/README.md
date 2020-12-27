#Explicações 

1 - Remoção de comentários. Com nomes de variáveis, metodos coerentes e funções
enxutas que desempenham apenas uma responsabilidade o código se torna autoexplicativo.

2 - Variáveis com nome pouco expressiveis (cod, c, s) foram alteradas para nomes mais 
descritivos (frase, codigo, separador).

3 - Método retornaCodigos estava com mais de uma responsabilidade. Ele foi dividido em tres 
partes sendo defineTextoInicial, retornaSeparador, constroiConteudoSimples/constroiConteudoComposto.

4 - Check de null no segundo if dentro de retornaCodigos não era necessário, pois a variável era
instaciada no início do método.

5 - Os teste foram criados tanto para validar a nova funcionalidade como garantir o funcionamento 
já existente. 