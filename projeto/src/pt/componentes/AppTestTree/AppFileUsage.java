/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.componentes.AppTestTree;


import java.util.List;
import pt.componentes.dataorganizer.DataOrganizer;
import pt.componentes.dataset.*;
import pt.componentes.fileusage.*;
import pt.componentes.node.*;


/**
 *
 * @author leonardolivraremartins
 */
public class AppFileUsage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IFileUsage fileUsage = new FileUsage();

        DataOrganizer dataOr = new DataOrganizer();
        DataSetComponent dataset = new DataSetComponent();
        dataset.setDataSource("projeto\\db\\zombie-health-new-cases500.csv");
        String[][] instances = dataset.requestInstances();
        List<String> diseases = dataOr.diseaseFilter(instances);
        int[][] symptomFrequency = dataOr.symptomFilter(instances, diseases);

        Tree tree = dataOr.treeMaker(diseases, symptomFrequency, instances);

        tree.serializa("arvore.txt");
    }
}
    

