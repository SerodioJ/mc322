package pt.componentes.diagnosticcompleter;

/**
 *DiagnosticCompleter tem como fun��o completar os n�s-folha de uma �rvore de diagn�stico
 *que n�o possuem diagn�stico.
 *
 *@author SerodioJ
 */

import pt.componentes.node.Tree;

public interface IDiagnosticCompleter{
	public Tree dataRunner(Tree treeNode, String[][]symptomFrequency);
	public void dataFiller(Tree treeNode, String[][]symptomFrequency);
}