import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class HashMapWordFreq {
    public static void main(String[] args) throws IOException {
        if(args.length <= 1 || args.length >= 3){
            System.err.println("Please put two arguments");
            System.exit(1);
        }
        
        try{
            int k = Integer.valueOf(args[1]);
            FileReader myFile = new FileReader(args[0]);
            BufferedReader buffer = new BufferedReader(myFile);
            String str = "";
            HashMapStringInt  map = new HashMapStringInt();
            
            while((str = buffer.readLine()) != null){
                str = str.toLowerCase().replaceAll("[^a-zA-Z]", " ").trim().replaceAll("\\s+", " "); 
                if(!str.equals("")){
                    String [] myWords = str.split(" ");
                    for(String word : myWords){
                        map.addOne(word.trim());
                    }
                }
            }

	        buffer.close();

            for(int i = 0; i < k; i++){
                System.out.println(map.getMax());
            }

        } catch(FileNotFoundException err){
            System.err.println("\"" + args[0] + "\"" + " not found!");
            System.err.println("Please make sure the file exists.");
        }
    }
}