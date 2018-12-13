import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TarjanAlgorithm {
    private int verticesCount;
    private int counter;
    private int[] low;
    private boolean[] visited;
    private List<Integer>[] graph;
    private List<List<Integer>> componentsList;
    private Stack<Integer> stack;


    public List<List<Integer>> getStronglyConnectedComponents(List<Integer>[] graph) {
        verticesCount = graph.length;
        this.graph = graph;
        low = new int[verticesCount];
        visited = new boolean[verticesCount];
        stack = new Stack<Integer>();
        componentsList = new ArrayList<List<Integer>>();

        for (int v = 0; v < verticesCount; v++) {
            if (!visited[v]) {
                dfs(v);
            }
        }

        return componentsList;
    }


    public void dfs(int v) {
        low[v] = counter++;
        visited[v] = true;
        stack.push(v);
        int min = low[v];
        for (int w : graph[v]) {
            if (!visited[w]) {
                dfs(w);
            }
            if (low[w] < min) {
                min = low[w];
            }
        }
        if (min < low[v]) {
            low[v] = min;
            return;
        }
        List<Integer> component = new ArrayList<Integer>();
        int w;
        do {
            w = stack.pop();
            component.add(w);
            low[w] = verticesCount;
        } while (w != v);
        componentsList.add(component);
    }
}
