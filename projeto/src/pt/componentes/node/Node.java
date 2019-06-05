package pt.componentes.node;

/**
 *Nó da árvore
 *
 *@author SerodioJ
 */

import java.util.List;

public class Node{
	private Node esquerdo, direito;
	private int symptom;
	private boolean diagnostico, filled;
	private List<Integer> diseases;
	private String[] path;
	
	Node(int symptom, String[] path, boolean esq, int previous){
		this.symptom = symptom;
		if(previous == -1)
		    this.path = path;
		else{
		    this.path = path.clone();
		    if (esq)
		        this.path[previous] = "1";
		    else
		        this.path[previous] = "0";
        }
	}
	
	Node (boolean diagnostico, String[] path, boolean esq, int previous){
	    this.diagnostico = diagnostico;
        if(previous == -1)
            this.path = path;
        else{
            this.path = path.clone();
            if (esq)
                this.path[previous] = "1";
            else
                this.path[previous] = "0";
        }
	}
	
	//Gets e sets
	public Node getEsquerdo(){
		return this.esquerdo;
	}

	public Node getDireito(){
		return this.direito;
	}

	public int getSymptom(){
		return this.symptom;
	}

	public boolean getDiagnostico(){
		return this.diagnostico;
	}

	public boolean getFilled(){
		return this.filled;
	}

    public String[] getPath(){ return this.path; }

	public List<Integer> getDiseases(){
		return this.diseases;
	}

	public void setEsquerdo(Node esquerdo){
		this.esquerdo = esquerdo;
	}
 
	public void setDireito(Node direito){
		this.direito = direito;
	}

	public void setSymptom(int symptom){
		this.symptom = symptom;
	}

	public void setDiagnostico(boolean diagnostico){
		this.diagnostico = diagnostico;
	}

	public void setFilled(boolean filled){this.filled = filled;}
	
	public void setDiseases(List<Integer> diseases) {
		this.diseases = diseases;
	}

	public void setPath(String[] path) { this.path = path; }
}