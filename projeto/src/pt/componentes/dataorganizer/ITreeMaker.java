package pt.componentes.dataorganizer;

/**
 *ITreeMaker tem como fun��o construir uma �rvore bin�ria a partir dos dados filtrados da tabela.
 *
 *@author SerodioJ
*/

import pt.componentes.node.*;
import java.util.List;

public interface ITreeMaker{
	public Tree treeMaker(List<String> diseases, int[][] symptomFrequency, String[][] instances);
}