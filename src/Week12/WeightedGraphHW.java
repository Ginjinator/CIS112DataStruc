package Week12;

import ch02.stacks.*;
import ch04.queues.*;
import ch09.priorityQueues.*;
import ch10.graphs.*;
import support.Flight;
import java.util.PriorityQueue;

public class WeightedGraphHW<T> implements WeightedGraphInterface<T>
{
    public static final int NULL_EDGE = 0;
    private static final int DEFCAP = 50;  // default capacity
    private int numVertices;
    private int maxVertices;
    private T[] vertices;
    private int[][] edges;
    private boolean[] marks;  // marks[i] is mark for vertices[i]

    public WeightedGraphHW()
    // Instantiates a graph with capacity DEFCAP vertices.
    {
        numVertices = 0;
        maxVertices = DEFCAP;
        vertices = (T[]) new Object[DEFCAP];
        marks = new boolean[DEFCAP];
        edges = new int[DEFCAP][DEFCAP];
    }

    public WeightedGraphHW(int maxV)
    // Instantiates a graph with capacity maxV.
    {
        numVertices = 0;
        maxVertices = maxV;
        vertices = (T[]) new Object[maxV];
        marks = new boolean[maxV];
        edges = new int[maxV][maxV];
    }

    public boolean isEmpty()
    // Returns true if this graph is empty; otherwise, returns false.
    {
        return numVertices == 0;
    }

    public boolean isFull()
    // Returns true if this graph is full; otherwise, returns false.
    {
        return (numVertices == maxVertices);
    }

    public void addVertex(T vertex)
    // Preconditions:   This graph is not full.
    //                  vertex is not already in this graph.
    //                  vertex is not null.
    //
    // Adds vertex to this graph.
    {
        vertices[numVertices] = vertex;
        for (int index = 0; index < numVertices; index++)
        {
            edges[numVertices][index] = NULL_EDGE;
            edges[index][numVertices] = NULL_EDGE;
        }
        numVertices++;
    }

    public boolean hasVertex(T vertex)
    // Returns true if this graph contains vertex; otherwise, returns false.
    {
        for (int i = 0; i < numVertices; i++) {
            if(vertex.equals(vertices[i])){
                return true;
            }
        }
        return false;
    }

    private int indexIs(T vertex)
    // Returns the index of vertex in vertices.
    {
        int index = 0;
        while (!vertex.equals(vertices[index]))
            index++;
        return index;
    }

    public void addEdge(T fromVertex, T toVertex, int weight)
    // Adds an edge with the specified weight from fromVertex to toVertex.
    {
        int row;
        int column;

        row = indexIs(fromVertex);
        column = indexIs(toVertex);
        edges[row][column] = weight;
    }

    public int weightIs(T fromVertex, T toVertex)
    // If edge from fromVertex to toVertex exists, returns the weight of edge;
    // otherwise, returns a special �null-edge� value.
    {
        int row;
        int column;

        row = indexIs(fromVertex);
        column = indexIs(toVertex);
        return edges[row][column];
    }

    public QueueInterface<T> getToVertices(T vertex)
    // Returns a queue of the vertices that vertex is adjacent to.
    {
        QueueInterface<T> adjVertices = new LinkedQueue<T>();
        int fromIndex;
        int toIndex;
        fromIndex = indexIs(vertex);
        for (toIndex = 0; toIndex < numVertices; toIndex++)
            if (edges[fromIndex][toIndex] != NULL_EDGE)
                adjVertices.enqueue(vertices[toIndex]);
        return adjVertices;
    }

    public void clearMarks()
    // Unmarks all vertices.
    {
        for (int i = 0; i < numVertices; i++) {
            marks[i] = false;
        }
    }

    public void markVertex(T vertex)
    // Marks vertex.
    {
        marks[indexIs(vertex)] = true;
    }

    public boolean isMarked(T vertex)
    // Returns true if vertex is marked; otherwise, returns false.
    {
        return marks[indexIs(vertex)];
    }

    public T getUnmarked()
    // Returns an unmarked vertex if any exist; otherwise, returns null.
    {
        for (int i = 0; i < numVertices; i++) {
            if(marks[i] == false){
                return vertices[i];
            }
        }
        return null;
    }

    // Returns true if a path exists on graph, from startVertex to endVertex;
    // otherwise returns false. Uses breadth-first search algorithm.
    private boolean isPathBF(T startVertex, T endVertex){
        QueueInterface<T> queue = new LinkedQueue<>();
        QueueInterface<T> vertexQueue = new LinkedQueue<>();

        boolean found = false;
        T currVertex;      // vertex being processed
        T adjVertex;       // adjacent to currVertex

        clearMarks();
        markVertex(startVertex);
        queue.enqueue(startVertex);

        do {
            currVertex = queue.dequeue();
            System.out.println(currVertex);
            if (currVertex.equals(endVertex))
                found = true;
            else {
                vertexQueue = getToVertices(currVertex);
                while (!vertexQueue.isEmpty()) {
                    adjVertex = vertexQueue.dequeue();
                    if (!isMarked(adjVertex)) {
                        markVertex(adjVertex);
                        queue.enqueue(adjVertex);
                    }
                }
            }
        } while (!queue.isEmpty() && !found);

        return found;
    }

    //Question 20 p.615
    public int connects(T a, T b){
        int count = 0;
        for (int i = 0; i < numVertices; i++) {
            if ((!vertices[i].equals(a) || !vertices[i].equals(b) &&
                    (isPathBF(vertices[i], a) && isPathBF(vertices[i], b)))) {
                count++;
            }
        }
        return count;
    }

    //Question 19 p.615
    public boolean edgeExists(T vertex1, T vertex2)
    // Preconditions:  vertex1 and vertex2 are in the set of vertices
    //
    // Return value = (vertex1, vertex2) is in the set of edges
    {
        return (edges[indexIs(vertex1)][indexIs(vertex2)] != NULL_EDGE);
    }

    public boolean removeEdge(T vertex1, T vertex2)
    // Preconditions:  vertex1 and vertex2 are in the set of vertices
    //
    // Return value = true if edge was in the graph (and has been removed)
    //              = false if edge was not in the graph
    {
        boolean existed = edgeExists(vertex1, vertex2);
        edges[indexIs(vertex1)][indexIs(vertex2)] = NULL_EDGE;
        return existed;
    }

    //Question 42 p.618
    public int minEdges(T vertex1, T vertex2){
        Path<T> path;
        Path<T> savePath;
        int minEdge;
        int newEdge;
        int minDistance;
        int newDistance;

        PriQueueInterface<Path> pq = new HeapPriQ<Path>(20);
        T vertex;
        QueueInterface<T> vertexQueue = new LinkedQueue<>();

        clearMarks();
        savePath = new Path(vertex1, vertex2, 0, 0);
        pq.enqueue(savePath);

        //while the priq has things in it
        while(!pq.isEmpty()){
            path = pq.dequeue();
            //if the path to the vertex is not marked
            if(!isMarked(path.getToVertex())){
                markVertex(path.getToVertex());
                path.setFromVertex(path.getToVertex());
                minDistance = path.getDistance();
                minEdge = path.getNumEdges();
                vertexQueue = getToVertices(path.getFromVertex());
                while(!vertexQueue.isEmpty()){
                    vertex = vertexQueue.dequeue();
                    //if that vertex is not marked
                    if(!isMarked(vertex)){
                        newDistance = minDistance + weightIs(path.getFromVertex(),  vertex);
                        newEdge = minEdge + 1;
                        savePath = new Path(path.getFromVertex(), vertex, newDistance, newEdge);
                        pq.enqueue(savePath);
                        if(vertex.equals(vertex2)){
                            return savePath.getNumEdges();
                        }
                    }
                }

            }
        }
        return -1;
    }
}