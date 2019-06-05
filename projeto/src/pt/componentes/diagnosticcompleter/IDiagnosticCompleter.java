package pt.componentes.diagnosticcompleter;

/**
 *DiagnosticCompleter tem como função completar os nós-folha de uma árvore de diagnóstico
 *que não possuem diagnóstico.
 *
 *@author SerodioJ
 */

import pt.componentes.node.Tree;

public interface IDiagnosticCompleter{
	public Tree dataRunner(Tree treeNode, String[][]symptomFrequency);
	public void dataFiller(Tree treeNode, String[][]symptomFrequency);
}