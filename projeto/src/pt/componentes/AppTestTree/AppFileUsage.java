/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appfileusage;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import pt.componentes.dataorganizer.DataOrganizer;
import pt.componentes.dataset.DataSetComponent;
import pt.componentes.dataset.IDataSource;
import pt.componentes.fileusage.FileUsage;
import pt.componentes.fileusage.IFileUsage;
import pt.componentes.node.Node;
import pt.componentes.node.Tree;

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
        dataset.setDataSource("../zombie-health-new-cases500.csv");
        String[][] instances = dataset.requestInstances();
        List<String> diseases = dataOr.diseaseFilter(instances);
        int[][] symptomFrequency = dataOr.symptomFilter(instances, diseases);
                
        Tree tree = dataOr.treeMaker(diseases, symptomFrequency, instances);

        Node node = tree.getRoot();
        //prefixado(node);
        walkLevels(node);
    }
    
    public static void prefixado(Node no) {
    if(no != null){
        System.out.print(no.getSymptom()+ " ");
        prefixado(no.getEsquerdo());
        prefixado(no.getDireito());
        
        }
    }
    public static void walkLevels(Node no) {
        if (no == null) throw new IllegalArgumentException("Tree node cannot be null!");
        Deque<Node> fila = new ArrayDeque<>();
        fila.add(no);
        System.out.print("[");
        while (!fila.isEmpty()) {
            Node atual = fila.removeFirst();
            System.out.printf("%d ", atual.getSymptom());
            if (fila.isEmpty()) {
                System.out.println("]");
                System.out.print("[");
            }
            else if(fila.getFirst().getSymptom() != atual.getSymptom()) {
                System.out.println("]");
                System.out.print("[");
            }
            if (atual.getEsquerdo() != null) fila.add(atual.getEsquerdo());
            if (atual.getDireito() != null) fila.add(atual.getDireito());
        }
    }
    
}
