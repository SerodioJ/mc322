package pt.componentes.fileusage;

/**
 *FileUsage salva os dados importantes do programa em execu��o em um arquivo texto,
 *a fim de que os dados n�o sejam processados novamente.
 *O componente pode ser adaptado para casos particulares.
 *
 *@author SerodioJ
*/

import pt.componentes.node.Tree;

public interface IFileUsage{
	void save();
	String[] readDiseases();
	String[][] readFrequency();
	Tree readTree();
}