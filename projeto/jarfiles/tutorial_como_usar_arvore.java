package teste;

import java.util.List;

import pt.clubedohardware.dataorganizer.DataOrganizer;
import pt.clubedohardware.dataset.DataSetComponent;
import pt.clubedohardware.node.Node;
import pt.clubedohardware.node.Tree;

public class tutorial_como_usar_arvore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Instanciacao do dataOrganizer
		DataOrganizer dataOr = new DataOrganizer();
				
		//Instanciacao do dataSet (componente feito pelo professor para pegar a matriz de instancias)
		DataSetComponent dataset = new DataSetComponent();
		String dir = "../teste.csv";//Local onde esta a matriz de instancias na sua maquina
		dataset.setDataSource(dir);
		String[][] instances = dataset.requestInstances();
			    
		//Pega a lista de doencas, a matriz de frequencia e monta a arvore
		List<String> diseases = dataOr.diseaseFilter(instances);
		int[][] symptomFrequency = dataOr.symptomFilter(instances, diseases);
		Tree tree = dataOr.treeMaker(diseases, symptomFrequency, instances);
		
		/*Serializa a arvore para uma maior visualizacao de cada node dela.
		 *O primeiro parametro eh o nome do arquivo onde vc quer salva-la e o segundo eh
		 *o diretorio que vc quer salvar o arquivo*/
		tree.DAO("tree", "../projetoFinal");
		
		//Retorna a lista(List<String>) das doencas obtidas pelo metodo diseaseFilter(instances)
		tree.getDiseases();
		
		//Retorna a lista(List<String>) de sintomas sao caracteristicos de uma doenca
		tree.getKey();
		
		//Retorna a lista(List<String>) da ordem dos sintomas na arvore
		tree.getPriority();
		
		
		//Pega a raiz da arvore
		Node raiz = tree.getRoot();
		
		/*Retorna o sintoma referente a esse node (o sintoma vem como um inteiro, o qual se refere
		 *a coluna da matriz de instancias, ou seja, na coluna 3 da matriz de instancias temos, por exemplo,
		 *o sintoma lingua amarela, entao se o .getSymptom retornar 3 sabemos que esta se referindo ao sintoma
		 *de lingua amarela)*/
		raiz.getSymptom();
		
		/*Retorna true se o node ja possuir um diagnostico e false se ainda nao possuir um diagnostico.
		 *Todos os nodes folha ja possuem um diagnostico.*/
		raiz.getDiagnostico();
		
		/*Retorna a lista (List<Integer>) de doencas que o paciente possui. Retorna null
		 *se o node retornar false para getDiagnostico().
		 *Cada posicao dessa lista armazena um inteiro, o qual indica o index da doenca
		 *na lista de doencas obtida pelo metodo diseaseFilter, ou seja, se uma posicao
		 *da lista de doencas do paciente der o valor 3, significa que ele possui a doenca
		 *que esta na posicao 3 da lista dada pelo diseaseFilter(variavel diseases declarada na linha 24
		 *desse codigo).*/
		raiz.getDiseases();
		
		/*Retorna o filho direito do node em questao (retorna null se o node for folha)*/
		raiz.getDireito();
		
		/*Retorna o filho esquerdo do node em questao e null se o node for folha*/
		raiz.getEsquerdo();
		
		/*ATENCAO!! Se o paciente possui o sintona que esta em um determinado node, voce deve
		 *ir para o filho esquerdo desse node e, se ele nao possui o sintoma, voce deve ir para
		 *o filho direito! Ou seja, se o cara possui o sintoma vai para a esquerda e se nao possui
		 *va para a direita!*/
	}

}
