package montacargas;

import agent.Heuristic;

public class HeuristicTileDistance extends Heuristic<MontaCargasProblem, MontaCargasState>{

    public double compute(MontaCargasState state){
        //TODO        
        return 0;
    }
    
    @Override
    public String toString(){
        return "Tiles distance to final position";
    }
}