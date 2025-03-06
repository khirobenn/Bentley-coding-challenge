
import java.util.HashMap;

public class HashMapStringInt {
    private HashMap<String, Integer> myHashMap;
    
    public HashMapStringInt(){
        this.myHashMap = new HashMap<String, Integer>();
    }

    public void addOne(String key){
        if(this.myHashMap.containsKey(key)){
            this.myHashMap.put(key, this.myHashMap.get(key)+1);
        }
        else{
            this.myHashMap.put(key, 1);
        }
    }

    public void remove(String key){
        if(this.myHashMap.containsKey(key)){
            this.myHashMap.remove(key);
        }
    }

    public String getMax(){
        int max = -1;
        String maxStr = "";
        for(String str : this.myHashMap.keySet()){
            int occurence = this.myHashMap.get(str);
            if(occurence > max){
                max = occurence;
                maxStr = str;
            }
        }

        this.myHashMap.remove(maxStr);
        return (new StringIntCouple(maxStr, max).toString());
    }
}
