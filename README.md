# Projeto MC322 - Clube do Hardware
196163 - Douglas Daisuke Kaneiwa Yoshioka

204759 - Pedro Strambeck Nogueira 

207267 - Willian Takayuki Ozako

218548 - João Alberto Moreira Seródio

220120 - Leonardo Livrare Martins

220650 - Lucas B. A. Farias

## Componente DataOrganizer
|Campo | Valor|
|------|--------|
|Classe|tbd|
|Autores|João Seródio, Leonardo Livrare|
|Objetivo|Organizar os dados da tabela para facilitar o diagnóstico|
|Interface|IDataFilter, ITreeMaker|


### Interface IDataFilter
|Método| Objetivo|
|------|--------|
|`diseaseFilter`|Recebe como parâmetro a tabela de diagnósticos e retorna as possíveis doenças em forma de vetor|
|`symptomFilter`|O parâmetro é a tabela do componente DataSet e o vetor das doenças da tabela, retorna uma tabela que aparece a frequência de cada sintoma por doença, por exemplo apareceram 3 casos de pacientes com língua amarela que apresentaram a doença bite_deficiet |


### Interface ITreeMaker
|Método| Objetivo|
|------|--------|
|`treeMaker`|Recebe o vetor de doenças e a matriz de frequência de sintomas e retorna uma árvore de diagnóstico, cujos nós internos são perguntas e os nós folhas são os diagnósticos finais.|



## Componente UserInterface
|Campo | Valor|
|------|--------|
|Classe|pt.userinterface|
|Autores|Willian Ozako, Lucas, Douglas Yoshioka|
|Objetivo|Criar animação das interações entre o médico e o paciente|
|Interface|IAnimation|

![](ezgif.com-video-to-gif(1).gif)

### Interface IAnimation
|Método| Objetivo|
|------|--------|
|`story`|Recebe como parâmetro dois vetores, o primeiro que armazena as falas das personagens e o segundo registra quem fala na n-ésima fala. Exemplo: n-ésima posição do 1o vetor - "You have smallpox." - e na n-ésima posição do 2o vetor - "doctor" - logo fica: "Doctor: You have smallpox."**IMPORTANTE:** Para gerar destaque em uma expressão como o nome da doença ou o do sintoma, coloque a expressão entre asteriscos(*). EX: "You have \*smallpox\*." -> "You have **smallpox**." |
|`setWindowName`| Altera/adiciona título da janela da interface. Para isso ele recebe uma String `name` que armazena o nome desejado. |
|`setTempo`|Recebe como parâmetro String `v` que deve ser igual em valor à `slow`,`fast` ou  `default`. Ele configura a velocidade do texto "corrido"|
|`setPacientName`|Recebe como parâmetro a String `pacName` que é o nome do paciente, guarda esse nome para ser impresso na interface gráfica. |
|`setDocName`|Recebe como parâmetro a String `docName` que é o nome do doutor, guardando o nome para ser impresso na interface gráfica. |



## Componente FileUsage
|Campo | Valor|
|------|--------|
|Classe|tdb|
|Autores|Leonardo Livrare,Pedro Strambeck|
|Objetivo|Salva dados obtidos pelo programa como a árvore diagnóstico e tabelas para poderem ser utilizados novamente pelo programa para não ter que reprocessar todos os dados novamente.|
|Interface|IFileUsage|


### Interface IFileUsage
|Método| Objetivo|
|------|--------|
|`save`| Não tem parâmetros, salva as informações importantes do programa |
|`readDiseases`| Lê o arquivo texto e retorna o vetor de doenças |
|`readFrequency`| Lê o arquivo texto e retorna a matriz de frequência dos sintomas|
|`readTree`| Lê o arquivo texto e retorna a árvore de diagnóstico|



## Componente DiagnosticCompleter
|Campo | Valor|
|------|--------|
|Classe|tdb|
|Autores|João Seródio, Willian Ozako|
|Objetivo|Completar os nós folha vazios da árvore|
|Interface|IDiagnosticCompleter|


### Interface IDiagnosticCompleter
|Método| Objetivo|
|------|--------|
|`dataRunner`| Recebe como parâmetros a árvore e a matriz de frequência e percorre a árvore procurando por nós folha sem diagnósticos quando encontra um desses nós chama o método `dataFiller`|
|`dataFiller`|  Recebe como parâmetros a árvore e a matriz de frequência e completa o nó com melhor diagnóstico. |
