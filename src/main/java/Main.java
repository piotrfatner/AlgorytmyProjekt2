import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj liczbe wierzcholkow:");
        int verticesCount = scan.nextInt();
        //int V = 9;
        Graph gg = new Graph(verticesCount);
        System.out.println("Podaj liczbe krawedzi:");
        int edgesCount = scan.nextInt();
        System.out.println("Wprowadz "+ edgesCount+" krawedzi grafu:");
        for (int i = 0; i < edgesCount; i++)
        {
            int x = scan.nextInt();
            int y = scan.nextInt();

            gg.addEgde(x,y);
        }
        /*gg.addEgde(0,1);
        gg.addEgde(1,2);
        gg.addEgde(2,3);
        gg.addEgde(3,8);
        gg.addEgde(8,7);
        gg.addEgde(6,7);
        gg.addEgde(3,0);
        gg.addEgde(5,4);
        gg.addEgde(0,4);
        gg.addEgde(4,6);
        gg.addEgde(6,5);*/
        List<Integer>[]  graphh = gg.getG();

        TarjanAlgorithm t = new TarjanAlgorithm();
        System.out.println("\nMaksymalne grupy nielubienia : ");
        List<List<Integer>> stronglyConnectedComponents = t.getStronglyConnectedComponents(graphh);
        System.out.println(stronglyConnectedComponents);
    }
}
