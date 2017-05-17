package montacargas;

import agent.Action;
import agent.Problem;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MontaCargasProblem extends Problem<MontaCargasState> {

    private MontaCargasState goalState;
     
    
    public MontaCargasProblem(MontaCargasState initialState) {
        super(initialState,new ArrayList<Action>());
        
        actions.add(new ActionUp());
        actions.add(new ActionRight());
        actions.add(new ActionDown());
        actions.add(new ActionLeft());
        
        this.goalState = new MontaCargasState(MontaCargasState.goalMatrix);
    }

    @Override
    public boolean isGoal(MontaCargasState state) {
        return state.equals(goalState);
    }

    @Override
    public List<MontaCargasState> executeActions(MontaCargasState state) {
        List<MontaCargasState> successors = new LinkedList<MontaCargasState>();
       
        for(Action a: actions){
            if (a.isValid(state)){
                MontaCargasState sucessor = (MontaCargasState) state.clone();
                
                a.execute(sucessor);
                //ou sucessor.executeAction(a);
                successors.add(sucessor);
            }
        }
        return successors;
    }

    @Override
    public double computePathCost(List<Action> path) {
        return path.size();
    }

    
}
