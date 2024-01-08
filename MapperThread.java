import java.util.ArrayList;
import java.util.Map;

public class MapperThread extends Thread {
    private Mapper map;

    private String text;

    private ArrayList<String> mapResults;


    public MapperThread(Mapper map, String text) {
        this.map = map;
        this.text = text;

    }

    public ArrayList<String> getMapResult(){
        return this.mapResults;
    }


    public ArrayList<String> getMapResults() {
        return mapResults;
    }

    @Override
    public void run() {

        this.mapResults = map.mapping(text);

    }


}
