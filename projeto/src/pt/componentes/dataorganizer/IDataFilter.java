package pt.componentes.dataorganizer;

import java.util.List;

/**
 *DataFilter tem como função filtrar os dados da tabela, retornando um vetor das doenças únicas da tabela
 *e uma matriz de frequência de sintomas, que serão utilizados na construção da árvore.
 *
 *@author SerodioJ
*/

public interface IDataFilter{
	List diseaseFilter(String[][] instances);
	int[][] symptomFilter(String[][] instances, List diseases);
}
