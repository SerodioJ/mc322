package pt.componentes.dataorganizer;

/**
 *ITreeMaker tem como fun��o construir uma �rvore bin�ria a partir dos dados filtrados da tabela.
 *
 *@author SerodioJ
*/

import pt.componentes.node.Tree;

public interface ITreeMaker{
	Tree treeMaker(String[] diseases, String[][] symptomFrequency);
}