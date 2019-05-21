package pt.componentes.dataorganizer;

/**
 *DataFilter tem como fun��o filtrar os dados da tabela, retornando um vetor das doen�as �nicas da tabela
 *e uma matriz de frequ�ncia de sintomas, que ser�o utilizados na constru��o da �rvore.
 *
 *@author SerodioJ
*/

public interface IDataFilter{
	String[] diseaseFilter(String[][] instances);
	int[][] symptomFilter(String[][] instances, String[] diseases);
}