package it.unibo.generics.graph.impl;

import java.util.Map;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import it.unibo.generics.graph.api.*;

public class BreadthFirstImpl {
    private static <X> void bfsStart(final Graph<X> graph, final Map<X, X> predecessorMap, final Map<X, Color> colorMap) {
        for (X i : graph.nodeSet()) {
            colorMap.put(i, Color.WHITE);
            predecessorMap.put(i, null);
        }
    }

    private static <X> void bfsVisit(final Graph<X> graph, final Map<X, X> predecessorMap, final Map<X, Color> colorMap,
            final X start) {
        Deque<X> myQueue = new ArrayDeque<>();
        X u;
        myQueue.add(start);
        colorMap.replace(start, Color.GRAY);
        while (!myQueue.isEmpty()) {
            u = myQueue.poll();
            for (X v : graph.linkedNodes(u)) {
                if (colorMap.get(v) == Color.WHITE) {
                    colorMap.replace(v, Color.GRAY);
                    predecessorMap.replace(v, u);
                    myQueue.add(v);
                }
            }
        }
    }

    private static <X> void predecessorReverter(final Graph<X> graph, final Map<X, X> predecessorMap,
            final X end,
            final X start, final List<X> path) {
        final X i = end;
        if (i != null) {
            BreadthFirstImpl.predecessorReverter(graph, predecessorMap, predecessorMap.get(i), start, path);
            path.add(i);
        }
    }

    /**
     * Gets one sequence of nodes connecting source to target with BFS.
     * 
     * @param graph
     *              the graph of the path
     * @param start
     *              the source node
     * @param end
     *              the target node
     * @return a sequence of nodes connecting sources and target
     */
    public static <X> List<X> bfs(final Graph<X> graph, final X start, final X end) {
        final Map<X, X> predecessorssMap = new LinkedHashMap<>();
        final Map<X, Color> colorMap = new HashMap<>();
        final List<X> path = new LinkedList<>();
        BreadthFirstImpl.bfsStart(graph,predecessorssMap,colorMap);
        BreadthFirstImpl.bfsVisit(graph,predecessorssMap,colorMap,start);
        BreadthFirstImpl.predecessorReverter(graph, predecessorssMap, end, start, path);
        return path;
    }
}
