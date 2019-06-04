package pt.componentes.fileusage;

/**
 *FileUsage salva os dados importantes do programa em execução em um arquivo texto,
 *a fim de que os dados não sejam processados novamente.
 *O componente pode ser adaptado para casos particulares.
 *
 *@author SerodioJ
*/

import pt.componentes.node.Tree;

public interface IFileUsage{
	public void save();
	public String[] readDiseases();
	public String[][] readFrequency();
	public Tree readTree();
}