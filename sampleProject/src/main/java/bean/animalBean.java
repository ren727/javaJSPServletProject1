package bean;

import java.io.Serializable;

// テーブルのなかの１件分を格納するクラス（エンティティ）
public class animalBean implements Serializable{
    private int id;
    private String type;
    private String size;
    private String breed;
    private String name;
    private String memo;
    

    // seteer
    public void setNo(int id){
        this.id = id;
    }
    public void setType(String type){
        this.type = type;
    }
    public void setSize(String size){
        this.size = size;
    }
    public void setBreed(String breed){
        this.breed = breed;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setMemo(String memo){
        this.memo = memo;
    }

    // geteer
    public int getNo(){
        return id;
    }
    public String getType(){
        return type;
    }
    public String getSize(){
        return size;
    }
    public String getBreed(){
        return breed;
    }
    public String getName(){
        return name;
    }
    public String getMemo(){
        return memo;
    }
   
}