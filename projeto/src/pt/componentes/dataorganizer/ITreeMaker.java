package pt.componentes.dataorganizer;

/**
 *ITreeMaker tem como função construir uma árvore binária a partir dos dados filtrados da tabela.
 *
 *@author SerodioJ
*/

import pt.componentes.node.Tree;

public interface ITreeMaker{
	Tree treeMaker(String[] diseases, String[][] symptomFrequency);
}