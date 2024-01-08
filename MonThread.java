import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MonThread extends Thread {
    private Mapper map;

    private String text;

    public Map<String, Integer> shuffleResults;


    public MonThread(Mapper map, String text) {
        this.map = map;
        this.text = text;

    }

    public Map<String, Integer> getMapResult(){
        return this.shuffleResults;
    }




    @Override
    public void run() {

        ArrayList<String> mapResult = map.mapping(text);

    }


}
