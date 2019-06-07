package pt.componentes.fileusage;

/**
 *FileUsage salva os dados importantes do programa em execucao em um arquivo texto,
 *a fim de que os dados n�o sejam processados novamente.
 *O componente pode ser adaptado para casos particulares.
 *
 *@author SerodioJ
*/

import java.util.List;
import pt.componentes.node.Tree;

public interface IFileUsage{
	public void save(List<String> diseases, int[][] symptomFrequency, Tree tree);
        public void save(Tree tree);
	public List getDiseases();
	public int[][] getFrequency();
	public Tree getTree();
}