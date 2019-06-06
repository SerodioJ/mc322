/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author leonardolivraremartins
 */
public class FileUsage implements IFileUsage{

    @Override
    public void save(List diseases, int[][] symptomFrequency, Tree tree) {
        serialize(diseases, "diseases.txt");
        serialize(symptomFrequency, "symptomFrequency.txt");
        serialize(tree, "tree.txt");
    }
    
    @Override
    public void save(Tree tree) {
        serialize(tree, "tree.txt");
    }

    @Override
    public List getDiseases() {
        List<String> diseases;
        diseases = (ArrayList<String>) deserialize("diseases.txt");
        
        return diseases;
    }

    @Override
    public int[][] getFrequency() {
        int[][] symptomFrequency;
        symptomFrequency = (int[][]) deserialize("symptomFrequency.txt");
        
        return symptomFrequency;
    }

    @Override
    public Tree getTree() {
        Tree tree;
        tree = (Tree) deserialize("tree.txt");
        
        return tree;
    }
    
    public void serialize(Object obj, String arqName) {
        File arq = new File(arqName);
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
    
    public Object deserialize(String arqName) {
        Object obj = null;
        try {
            File arq = new File(arqName);
            
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
