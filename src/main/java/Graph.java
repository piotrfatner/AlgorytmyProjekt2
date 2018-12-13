import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<Integer>[] g;

    public Graph(int numberOfVertices) {
        g = new List[numberOfVertices];
        for (int i=0; i<numberOfVertices; i++){
            g[i] = new ArrayList<Integer>();
        }
    }

    public void addEgde(int x, int y){
        g[x].add(y);
    }

    public void removeEdge(int x, int y){
        g[x].remove(y);
    }

    public List<Integer>[] getG() {
        return g;
    }
}
