package montacargas;

import agent.Agent;
import java.io.File;
import java.io.IOException;

public class MontaCargasAgent extends Agent<MontaCargasState>{
    
    protected MontaCargasState initialEnvironment;    
    
    public MontaCargasAgent(MontaCargasState environemt) {
        super(environemt);
        initialEnvironment = (MontaCargasState) environemt.clone();
        heuristics.add(new HeuristicTileDistance());
        heuristics.add(new HeuristicTilesOutOfPlace());
        heuristic = heuristics.get(0);
    }
            
    public MontaCargasState resetEnvironment(){
        environment = (MontaCargasState) initialEnvironment.clone();
        return environment;
    }
                 
    public MontaCargasState readInitialStateFromFile(File file) throws IOException {
        java.util.Scanner scanner = new java.util.Scanner(file);
        int tamanho = scanner.nextInt();
        int[][] matrix = new int [tamanho][tamanho];
       
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                matrix[i][j] = scanner.nextInt();
            }
            scanner.nextLine();
        }
        initialEnvironment = new MontaCargasState(matrix);
        resetEnvironment();
        return environment;
    }
}
