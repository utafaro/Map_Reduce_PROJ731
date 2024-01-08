import java.util.List;

public class MonThread implements Runnable {
    private Mapper map;

    private String text;


    public MonThread(Mapper map, String text) {
        this.map = map;
        this.text = text;

    }


    @Override
    public void run() {
        map.mapping(text);
    }


}
