package pt.componentes.dataorganizer;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leonardolivraremartins
 */
public class DataFilter implements IDataFilter{
    
    public List<String> diseaseFilter(String[][] instances) {
        List<String> diseases = new ArrayList<>();
        int indexDisease;

        for (String[] instance : instances) {
            indexDisease = (instance.length) - 1;
            if (diseases.indexOf(instance[indexDisease]) == -1) {
                diseases.add(instance[indexDisease]);
            }
        }
        
        return diseases;
    }
    
    public int[][] symptomFilter(String[][] instances, List diseases) {
        int[][] frequencyMatrix = new int[instances[0].length - 1][diseases.size() + 1];
        int index, diseaseIndex = instances[0].length-1;
        
        for (int j=0; j<(instances[0].length-1); j++)
            for (String[] instance : instances)
                if (instance[j].equals("1") || instance[j].equals("t")) {
                    index = diseases.indexOf(instance[diseaseIndex]);
                    frequencyMatrix[j][index] += 1;
                    frequencyMatrix[j][diseases.size()] += 1;
                }
        
        return frequencyMatrix;
    }
}
