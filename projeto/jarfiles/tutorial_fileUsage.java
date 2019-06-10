package teste.teste1;

import java.util.List;
import pt.clubedohardware.dataorganizer.DataOrganizer;
import pt.clubedohardware.node.Tree;
import pt.clubedohardware.userinterface.AnimationC;
import pt.clubedohardware.userinterface.IAnimationC;
import pt.clubedohardware.dataset.*;
import pt.clubedohardware.fileusage.*;

public class main {


		public static void main(String[] args) {
			//Instanciacao do dataOrganizer
			DataOrganizer dataOr = new DataOrganizer();
			
			//Instanciacao do dataSet (componente feito pelo professor)
			DataSetComponent dataset = new DataSetComponent();
			String dir = INSERIR;//Local onde esta a matriz de instancias na sua maquina
		    dataset.setDataSource(dir);
		    String[][] instances = dataset.requestInstances();
		    
		    //Pega a lista de doencas, a matriz de frequencia e monta a arvore
		    List<String> diseases = dataOr.diseaseFilter(instances);
		    int[][] symptomFrequency = dataOr.symptomFilter(instances, diseases);
		    Tree tree = dataOr.treeMaker(diseases, symptomFrequency, instances);
		    
		    //instanciacao do fileUsage
		    IFileUsage fileUsage = new FileUsage();
		    //salva as doencas, matriz de frequencia e a arvore numa pasta chamada SerializedData na pasta do seu projeto
		    fileUsage.save(diseases, symptomFrequency, tree, dir);
		    //salva so a arvore
		    fileUsage.save(tree, dir);
		    //recupera a arvore
		    tree = fileUsage.getTree("zombie-health-cases500");//Trocar zombie-health-cases500 pelo nome da pasta que vai abrir
		    //recupera a lista de doencas
		    diseases = fileUsage.getDiseases("zombie-health-cases500");
		    //recupera a matriz de frequencia
		    symptomFrequency = fileUsage.getFrequency("zombie-health-cases500");
		    
		    
		}
}
