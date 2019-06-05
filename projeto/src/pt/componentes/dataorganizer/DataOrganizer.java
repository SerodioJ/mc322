package pt.componentes.dataorganizer;

/**
 *Plantar um árvore nunca foi tão complicado.
 *
 *@authors SerodioJ,leonardolivraremartins.
 */

import pt.componentes.node.*;
//import pt.componentes.diagnosticcompleter.*;
import java.util.ArrayList;
import java.util.List;

public class DataOrganizer implements ITreeMaker, IDataFilter {

	/* Implementação de IDataFilter */
	public List diseaseFilter(String[][] instances) {
		List<String> diseases = new ArrayList<>();
		int indexDisease;

		for (String[] instance : instances) {
			indexDisease = (instance.length) - 1;
			if (diseases.indexOf(instance[indexDisease]) == -1) {
				diseases.add(instance[indexDisease]);
			}
		}

		return diseases;
	}

	public int[][] symptomFilter(String[][] instances, List diseases) {
		int[][] frequencyMatrix = new int[instances[0].length - 1][diseases.size() + 1];
		int index, diseaseIndex = instances[0].length-1;

		for (int j=0; j<(instances[0].length-1); j++)
			for (String[] instance : instances)
				if (instance[j].equals("1") || instance[j].equals("t")) {
					index = diseases.indexOf(instance[diseaseIndex]);
					frequencyMatrix[j][index] += 1;
					frequencyMatrix[j][diseases.size()] += 1;
				}

		return frequencyMatrix;
	}



	/*Implementação de ITreeMaker*/
	//Retorna uma lista de sintomas característicos de uma doença
	private List<Integer> unique(int[][] symptomFrequency) {
		List<Integer> unique = new ArrayList<>();
		for (int i = 0; i < symptomFrequency.length; i++) {
			for (int j = 0; j < symptomFrequency[0].length-1; j++) {
				if (symptomFrequency[i][j] == 0)
					continue;
				if (symptomFrequency[i][j] == symptomFrequency[i][symptomFrequency.length - 1]) {
					unique.add(i);
					break;
				}
			}
		}
		return unique;
	}
	
	//Método recursivo para construir a árvore de diagnóstico.
	private Node treeSkeleton(int symptoms, int current, int previous, NodeCreator nC, List<Integer> keySymptoms, String[] path, boolean esq) {
		if (current == symptoms)
			return nC.createNode(true, path, esq, previous);
		if (keySymptoms.indexOf(current) != -1)
			return treeSkeleton(symptoms, current+1, previous, nC, keySymptoms, path, esq);
		Node node = nC.createNode(current, path, esq, previous);
		node.setDireito(treeSkeleton(symptoms, current+1, current, nC, keySymptoms, path, false));
		node.setEsquerdo(treeSkeleton(symptoms, current+1, current, nC, keySymptoms, path, true));
		return node;
	}
	
	//Retorna um vetor de ordem de prioridade para os sintomas na hora da busca na tabela.
	private List<Integer> priority(int[][] symptomFrequency, List<Integer> keySymptons) {
	    List<Integer> priorities = new ArrayList<>();
	    int indexSmaller = -1;
	    for (int n = 0; n < (symptomFrequency.length - keySymptons.size()); n++) {
            for (int i = 0; i < symptomFrequency.length; i++) {
                if (keySymptons.indexOf(i) != -1 || priorities.indexOf(i) != -1)
                    continue;
                if (indexSmaller == -1) {
                    indexSmaller = i;
                    continue;
                }
                if (symptomFrequency[i][symptomFrequency[0].length-1] < symptomFrequency[indexSmaller][symptomFrequency[0].length-1])
                    indexSmaller = i;
            }
            priorities.add(indexSmaller);
            indexSmaller = -1;
        }
	    return priorities;
    }
	
	//Método para comparar o caminho da árvore com a tabela de referência. Usando o vetor priority para fazer o menor número de comparações.
	private List<Integer> diagnostic(Tree tree, Node current, String[][] instances){
		List<Integer> diagnostic = new ArrayList<>();
		for (String[] instance : instances)
			if (current.getPath() == instance && diagnostic.indexOf(tree.getDiseases().indexOf(instance[instances[0].length])) == -1)
				diagnostic.add(tree.getDiseases().indexOf(instance[instances[0].length]));
		/*if (diagnostic == null){      Fazer DataCompleter
			current.setFilled(true);
			diagnostic = DiagnosticCompleter.dataFiller();
		}*/
		return diagnostic;

	}
	
	//Percorre a árvore colocando os diagnósticos nos nós-folha
	private Node treeRunner (Node current, Tree tree, String[][] instances) {
		if (current.getDiagnostico()) {
			current.setDiseases(diagnostic(tree, current, instances));
			return current;
		}
		current.setDireito(treeRunner(current.getDireito(), tree, instances));
		current.setEsquerdo(treeRunner(current.getEsquerdo(), tree, instances));
		return current;
	}
	
	//Método de construção da árvore
	public Tree treeMaker(List<String> diseases, int[][] symptomFrequency, String[][] instances) {
		NodeCreator nC = new NodeCreator();
		List<Integer> keySymptoms = unique(symptomFrequency);
        String[] path = new String[symptomFrequency.length];
        for (int symptom : keySymptoms)
        	path[symptom] = "0";
		Tree diagnosticTree = new Tree(treeSkeleton(symptomFrequency.length, 0, -1, nC, keySymptoms, path, false), keySymptoms, diseases, priority(symptomFrequency, keySymptoms));
		diagnosticTree.setRoot(treeRunner(diagnosticTree.getRoot(), diagnosticTree, instances));
		return diagnosticTree;
	}
}
