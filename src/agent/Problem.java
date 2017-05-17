package agent;

import java.util.List;

public abstract class Problem <S extends State>{

    protected S initialState;
    protected List<Action> actions;
    protected Heuristic heuristic;

    public Problem(S initialState, List<Action> actions) {
        this.initialState = initialState;
        this.actions = actions;
    }
    
    public abstract boolean isGoal(S state);
    
    public abstract List<S> executeActions (S state);

    public S getInitialState() {
        return initialState;
    }

    public Heuristic getHeuristic() {
        return heuristic;
    }

    public void setHeuristic(Heuristic heuristic) {
        this.heuristic = heuristic;
    }
    
    
    public double computePathCost(List<Action> path){
        double cost=0;
        for(Action action: path){
            cost +=action.getCost();
        }
        return cost;
    }
}
