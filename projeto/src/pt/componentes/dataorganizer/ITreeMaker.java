package pt.componentes.dataorganizer;

/**
 *ITreeMaker tem como função construir uma árvore binária a partir dos dados filtrados da tabela.
 *
 *@author SerodioJ
*/

import pt.componentes.node.*;
import java.util.List;

public interface ITreeMaker{
	public Tree treeMaker(List<String> diseases, int[][] symptomFrequency, String[][] instances);
}