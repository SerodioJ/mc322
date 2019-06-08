/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.componentes.AppTestTree;


import java.util.List;
import pt.clubedohardware.dataorganizer.DataOrganizer;
import pt.clubedohardware.dataset.*;
import pt.clubedohardware.fileusage.*;
import pt.clubedohardware.node.*;


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
        String dir = "projeto/db/zombie-health-spreadsheet-ml-training.csv";
        dataset.setDataSource(dir);
        String[][] instances = dataset.requestInstances();
        List<String> diseases = dataOr.diseaseFilter(instances);
        int[][] symptomFrequency = dataOr.symptomFilter(instances, diseases);

        Tree tree = dataOr.treeMaker(diseases, symptomFrequency, instances);
        String[] aux = dir.split("/");

        tree.DAO("arvore-de-"+aux[aux.length-1].replace(".csv", ".txt"));
    }
}
    

