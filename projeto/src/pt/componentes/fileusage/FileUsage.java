package pt.componentes.fileusage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import pt.componentes.node.Tree;

/**
 *FileUsage seraliza a arvore junto com os nos.
 *
 * @author leonardolivraremartins
 */

public class FileUsage implements IFileUsage{
    
    //Serializa a lista de doencas, a matriz de frequencia e a arvore de diagnosticos
    @Override
    public void save(List<String> diseases, int[][] symptomFrequency, Tree tree) {
        //cria um novo diretorio chamado serializedData
        boolean ok = new java.io.File("../", "serializedData").mkdirs();
        //Serializa os dados dentro do diretorio criado acima
        serialize(diseases, "diseases.txt");
        serialize(symptomFrequency, "symptomFrequency.txt");
        serialize(tree, "tree.txt");
    }
    
    //Serializa somente a arvore de diagnosticos
    @Override
    public void save(Tree tree) {
        boolean ok = new java.io.File("../", "serializedData").mkdirs();
        serialize(tree, "tree.txt");
    }

    //Deserializa a lista de doencas
    @Override
    @SuppressWarnings("unchecked")
    public List getDiseases() {
        List<String> diseases;
        diseases = (ArrayList<String>) deserialize("diseases.txt");
        
        return diseases;
    }

    //Deserializa a matriz de frequencia
    @Override
    public int[][] getFrequency() {
        int[][] symptomFrequency;
        symptomFrequency = (int[][]) deserialize("symptomFrequency.txt");
        
        return symptomFrequency;
    }

    //Deserializa a arvore de diagnosticos
    @Override
    public Tree getTree() {
        Tree tree;
        tree = (Tree) deserialize("tree.txt");
        
        return tree;
    }
    
    //Metodo de serializacao utilizando o recurso padrao do Java
    private void serialize(Object obj, String arqName) {
        File arq = new File("../serializedData/"+arqName);
        try {
            arq.delete();
            arq.createNewFile();
            
            ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(arq));
            objOutput.writeObject(obj);
            objOutput.close();
        } catch (IOException erro) {
            System.out.printf("Erro: %s", erro.getMessage());
        }
    }
    
    //Metodo de deserializacao utilizando o recurso padrao do Java
    private Object deserialize(String arqName) {
        Object obj = null;
        try {
            File arq = new File("../serializedData/"+arqName);
            
            if (arq.exists()) {
                ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arq));
                obj = objInput.readObject();
                objInput.close();
        }
        } catch(IOException erro1) {
          System.out.printf("Erro: %s", erro1.getMessage());
        } catch(ClassNotFoundException erro2) {
          System.out.printf("Erro: %s", erro2.getMessage());
        }
        return obj;
    }
}
