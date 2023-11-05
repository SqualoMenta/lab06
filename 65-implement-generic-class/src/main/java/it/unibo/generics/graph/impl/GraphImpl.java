package it.unibo.generics.graph.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<X> implements Graph<X> {

    private final Map<X, Set<X>> graph = new HashMap<>();

    @Override
    public void addNode(X node) {
        if (graph.get(node) == null) {
            final Set<X> myEdges = new HashSet<>();
            graph.put(node, myEdges);
        }
    }

    @Override
    public void addEdge(X source, X target) {
        if (graph.containsKey(source)) {
            final Set<X> myEdges = graph.get(source);
            myEdges.add(target);
        }

    }

    @Override
    public Set<X> nodeSet() {
        return new HashSet<X>(graph.keySet());
    }

    @Override
    public Set<X> linkedNodes(X node) {
        return new HashSet<X>(graph.get(node));
    }

    @Override
    public List<X> getPath(X source, X target) {
        if (java.lang.Math.random() > 0.5) {
            return DepthFirstImpl.dfs(this, source, target);
        }
        return BreadthFirstImpl.bfs(this, source, target);
    }
}
