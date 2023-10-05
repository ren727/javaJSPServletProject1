package bean;

import java.util.ArrayList;
import java.io.Serializable;

// テーブルのなかの全件分を格納するクラス（DTO）
public class animalDto implements Serializable{
    private ArrayList<animalBean> list;

    public animalDto(){
        list = new ArrayList<animalBean>();  //only studentbean class items can be accepted.
    }

    public void add(animalBean ab){
        list.add(ab);
    }

    public animalBean get(int i){
        return list.get(i);
    }

    public int size(){
        return list.size();
    }

}
