package it.unibo.generics.graph.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import it.unibo.generics.graph.api.*;

public class DepthFirstImpl{

    private static <X> void dfsStart(final Graph<X> graph, final Map<X, Color> color,
            final Map<X, X> predecessors) {
        for (X i : graph.nodeSet()) {
            color.put(i, Color.WHITE);
            predecessors.put(i, null);
        }
    }

    private static <X> void dfsVisit(final Graph<X> graph, final X vertex, final Map<X, Color> color,
            final Map<X, X> predecessors) {
        color.replace(vertex, Color.GRAY);
        for (X v : graph.linkedNodes(vertex)) {
            if (color.get(v) == Color.WHITE) {
                predecessors.replace(v, vertex);
                dfsVisit(graph, v, color, predecessors);
            }
        }
    }

    private static <X> void predecessorReverter(final Graph<X> graph, final Map<X, X> predecessorMap,
            final X end,
            final X start, final List<X> path) {
        final X i = end;
        if (i != null) {
            DepthFirstImpl.predecessorReverter(graph, predecessorMap, predecessorMap.get(i), start, path);
            path.add(i);
        }
    }

    /**
     * Gets one sequence of nodes connecting source to target with DFS.
     * 
     * @param graph
     *              the graph of the path
     * @param start
     *              the source node
     * @param end
     *              the target node
     * @return a sequence of nodes connecting sources and target
     */
    public static final <X> List<X> dfs(final Graph<X> graph, final X start, final X end) {
        final Map<X, X> predecessorssMap = new LinkedHashMap<>();
        final Map<X, Color> colorMap = new HashMap<>();
        final List<X> path = new LinkedList<>();
        DepthFirstImpl.dfsStart(graph, colorMap, predecessorssMap);
        DepthFirstImpl.dfsVisit(graph, start, colorMap, predecessorssMap);
        DepthFirstImpl.predecessorReverter(graph, predecessorssMap, end, start, path);
        return path;
    }

}
