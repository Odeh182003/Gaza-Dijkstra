package application;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GraphWeighted<T> {
    List<VertixCity> vertices = new ArrayList<>();
    List<List<Edge<T>>> edges = new ArrayList<>();
    static int i = 0;

    public GraphWeighted() {
    }
    public void addVertices(T data) {
        VertixCity vertixCity = (VertixCity) data;
        vertixCity.setNum(i++);
        vertices.add(vertixCity);
        edges.add(new LinkedList<>());
    }

    public void addEdge(T from, T to, double weight) {
        int indexFrom = vertices.indexOf(from);
        int indexTo = vertices.indexOf(to);

        if (indexFrom != -1 && indexTo != -1) {
            edges.get(indexFrom).add(new Edge<>(to, weight));
        } else {
            System.out.println("Error: Vertices not found when adding edge.");
        }
    }

    private VertixCity findVertix(T vertixCity) {
        for (VertixCity vertix : vertices) {
            if (vertix.getName().equals(((VertixCity) vertixCity).getName())) {
                return vertix;
            }
        }
        return null;
    }

    public void removeEdge(T from, T to) {
        int indexFrom = vertices.indexOf(from);
        int indexTo = vertices.indexOf(to);

        if (indexFrom != -1 && indexTo != -1) {
            edges.get(indexFrom).removeIf(edge -> edge.getConnectedVertex().equals(to));
        }
    }

    public void removeVertix(T data) {
        int indexToRemove = vertices.indexOf(data);

        if (indexToRemove != -1) {
            vertices.remove(indexToRemove);
            edges.remove(indexToRemove);

            for (List<Edge<T>> edgeList : edges) {
                edgeList.removeIf(edge -> edge.getConnectedVertex().equals(data));
            }
        }
    }

    public boolean hasNode(T data) {
        return findVertix(data) != null;
    }

    public boolean hasEdge(T from, T to) {
        int indexFrom = vertices.indexOf(from);
        int indexTo = vertices.indexOf(to);

        if (indexFrom != -1 && indexTo != -1) {
            List<Edge<T>> edgeList = edges.get(indexFrom);
            for (Edge<T> edge : edgeList) {
                if (edge.getConnectedVertex().equals(to)) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < vertices.size(); i++) {
            result.append(vertices.get(i)).append(": ");
            List<Edge<T>> edgeList = edges.get(i);

            for (Edge<T> edge : edgeList) {
                result.append("(").append(edge.getConnectedVertex()).append("; ").append(edge.getWeight()).append(") ");
            }

            result.append("\n");
        }

        return result.toString();
    }
}
