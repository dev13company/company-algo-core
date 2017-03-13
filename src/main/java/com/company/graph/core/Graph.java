package com.company.graph.core;

import java.util.Random;

public class Graph {

	private static final String NEWLINE = System.getProperty("line.separator");
	
	private final Integer V;
	private Integer E;
	private Bag<Integer>[] adj;
	public Graph(Integer v) {
		if( v < 0) throw new IllegalArgumentException("# of vertices cannot be less than zero");
		this.V = v;
		this.E = 0;
		adj = (Bag<Integer>[])new Bag[v];
		for(int i=0; i< V; i++)
			adj[i] = new Bag<Integer>();
	}
	public Integer getE() {
		return E;
	}
	public void setE(Integer e) {
		E = e;
	}
	public Integer getV() {
		return V;
	}

	public void addEdge(int v, int w) {
		E++;
		adj[v].add(w);
		adj[w].add(v);
	}
	public int degree(int v){
		if(v < 0 || v >= V) throw new IllegalArgumentException("invalid");
		return adj[v].size();
	}
	
	public int maxdegree(){
		int max = 0;
		for(int i=0; i< V; i ++){
			if(max < adj[i].size())
				max = adj[i].size();
		}
		return max;
	}
	
	public int selfLoops(){
		int count = 0;
		for(int i=0; i< V; i++){
			for(int w : adj[i]){
				if(i == w)
					count++;
			}
		}
		return count/2;
	}

	public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
	
	public static void main(String[] args) {
		Graph graph = new Graph(13);
		int edges = 13;
		int E = 13;
		Random rand = new Random();
		for(int j=0; j< edges; j++){
			graph.addEdge(rand.nextInt(13), rand.nextInt(13));
		}
		System.out.println(" "+graph.toString() +" degree "+graph.maxdegree() +" self loops "+graph.selfLoops());
	}


}
