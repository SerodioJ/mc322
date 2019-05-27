/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datafilter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leonardolivraremartins
 */
public class DataFilter implements IDataFilter{
    
    public List diseaseFilter(String[][] instances) {
        List<String> diseases = new ArrayList<>();
        int indexDisease;
        
        for (int i=0; i<instances.length; i++) {
            indexDisease = (instances[i].length)-1;
            if (diseases.indexOf(instances[i][indexDisease]) == -1) {
                diseases.add(instances[i][indexDisease]);
            }
        }
        
        return diseases;
    }
    
    public int[][] symptomFilter(String[][] instances, List diseases) {
        int frequencyMatrix[][] = new int[instances[0].length-1][diseases.size()];
        int index, diseaseIndex = instances[0].length-1;
        
        for (int j=0; j<(instances[0].length-1); j++) {
            for (int i=0; i<instances.length; i++) {
                if (instances[i][j].equals("1") || instances[i][j].equals("t")) {
                    index = diseases.indexOf(instances[i][diseaseIndex]);
                    frequencyMatrix[j][index] += 1;
                }
            }
        }
        
        return frequencyMatrix;
    }
}
