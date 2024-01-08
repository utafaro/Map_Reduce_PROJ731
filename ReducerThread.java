import java.util.ArrayList;
import java.util.Map;

public class ReducerThread extends Thread {

    private Reducer reducer;

    private Map<String, Integer> reducerResults;



    private ArrayList<String> mapResult;

    public Map<String, Integer> getReducerResults() {
        return reducerResults;
    }

    public ReducerThread(Reducer reducer, ArrayList<String> mapResult){
        this.reducer = reducer;
        this.mapResult = mapResult;
    }

    @Override
    public void run() {
        this.reducerResults = reducer.reducing(mapResult);

    }
}
