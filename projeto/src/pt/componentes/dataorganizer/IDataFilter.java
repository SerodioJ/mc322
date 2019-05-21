package pt.componentes.dataorganizer;

/**
 *DataFilter tem como função filtrar os dados da tabela, retornando um vetor das doenças únicas da tabela
 *e uma matriz de frequência de sintomas, que serão utilizados na construção da árvore.
 *
 *@author SerodioJ
*/

public interface IDataFilter{
	String[] diseaseFilter(String[][] instances);
	int[][] symptomFilter(String[][] instances, String[] diseases);
}