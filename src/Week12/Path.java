package Week12;

public class Path<T> implements Comparable<Path<T>> {
    private T fromVertex;
    private T toVertex;
    private int distance;
    private int numEdges;

    public Path(T start, T finish, int dist, int edges){
        fromVertex = start;
        toVertex = finish;
        distance = dist;
        numEdges = edges;
    }

    public T getFromVertex() {
        return fromVertex;
    }

    public void setFromVertex(T fromVertex) {
        this.fromVertex = fromVertex;
    }

    public T getToVertex() {
        return toVertex;
    }

    public void setToVertex(T toVertex) {
        this.toVertex = toVertex;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getNumEdges() {
        return numEdges;
    }

    public void setNumEdges(int numEdges) {
        this.numEdges = numEdges;
    }

    public int compareDistance(Path other){
        return (other.getDistance() - this.getDistance());
    }

    public int compareEdges(Path other){
        return (other.getNumEdges() - this.getNumEdges());
    }

    @Override
    public int compareTo(Path<T> o) {
        return (o.getNumEdges() - this.getNumEdges());
    }

    @Override
    public String toString() {
        return (fromVertex + "    " + toVertex + "    " + distance + " in " + numEdges + " edges");
    }
}
