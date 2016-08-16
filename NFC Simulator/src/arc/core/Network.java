package arc.core;
import java.util.HashSet;

import edu.uci.ics.jung.graph.DirectedSparseGraph;
import arc.functions.TargetFunction;

public class Network{
	private TargetFunction targetFunction;
	private DirectedSparseGraph<Vertex, Edge> graph;
    
    public Network(TargetFunction targetFunction, DirectedSparseGraph<Vertex, Edge> graph){
	super();
	this.targetFunction = targetFunction;
	this.graph = graph;
    }
    
    public TargetFunction getTargetFunction() {
		return targetFunction;
	}

	public void setTargetFunction(TargetFunction targetFunction) {
		this.targetFunction = targetFunction;
	}
	
	public String results() {
		 String results = "";
		int correct_result = this.getTargetFunction().direct_compute(this.getSources());
		for (Sink s : this.getSinks()){
			if (s.getInput() == correct_result){	
				results += s.getLabel() +":"+ Integer.toString(s.getInput()) + " Correct \n";
			}
			else{
				results += s.getLabel() +":"+ Integer.toString(s.getInput()) + " Error, should be " + correct_result + "\n";
			}
	    }
		return results;
	}
	

    public HashSet<Source> getSources(){
	HashSet<Source> sources = new HashSet<Source>();
	for(Vertex vertex : this.graph.getVertices()){
	    if(vertex instanceof Source){
	    	sources.add((Source)vertex);
	    }
	}
	return sources;
    }
    
    public HashSet<Sink> getSinks(){
	HashSet<Sink> sinks = new HashSet<Sink>();
	for(Vertex vertex : this.graph.getVertices()){
	    if(vertex instanceof Sink){
	    	sinks.add((Sink)vertex);
	    }
	}
	return sinks;
    }

	@Override
	public String toString() {
		return "Network [targetFunction=" + targetFunction + ", graph=" + graph
				+ "]";
	}

	public DirectedSparseGraph<Vertex, Edge> getGraph() {
		return graph;
	}

	public void setGraph(DirectedSparseGraph<Vertex, Edge> graph) {
		this.graph = graph;
	}
    
}