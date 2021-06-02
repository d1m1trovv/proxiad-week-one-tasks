package proxiad;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class Main {

    public static void main(String[] args) {
        //arrayManipulation();
        //stringManipulation();
    }

    private static void arrayManipulation(){
        Scanner s = new Scanner(System.in);

        System.out.println("Enter array length: ");
        int n = s.nextInt();

        HashMap<Integer, Integer> integersMap = new HashMap<>();
        List<Integer> repeatedOnce = new ArrayList<>();
        List<Integer> repeatedMoreThanOnce = new ArrayList<>();

        System.out.println("Enter the values of the array: ");

        int crr;

        for(int i = 0; i < n; i++){
            crr = s.nextInt();
            if(integersMap.containsKey(crr)){
                integersMap.replace(crr, integersMap.get(crr) + 1 );
                continue;
            }
            integersMap.put(crr, 1);
        }
        s.close();

        for(Integer temp : integersMap.keySet()){
            if(integersMap.get(temp) == 1){
                repeatedOnce.add(temp);
            }
            else{
                repeatedMoreThanOnce.add(temp);
            }
        }

        System.out.println(integersMap.keySet());
        System.out.println(repeatedOnce.size() + " elements repeated once: " + repeatedOnce);
        System.out.println(repeatedMoreThanOnce.size() + " elements repeated more than once: " + repeatedMoreThanOnce);
    }

    private static void stringManipulation(){
        Scanner s = new Scanner(System.in);

        System.out.println("Enter string to manipulate: ");
        String str = s.nextLine().toLowerCase();

        String[] words = str.split("[^\\w-\\u0400-\\u04FF]+");
        HashMap<String, Integer> wordsMap = new HashMap<>();

        for(String word : words){
            if(wordsMap.containsKey(word)){
                wordsMap.replace(word, wordsMap.get(word) + 1);
                continue;
            }
            wordsMap.put(word, 1);
        }

        Map<String, Integer> mostFrequentOrder = wordsMap.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(toMap(Map.Entry::getKey,
                               Map.Entry::getValue, (o1, o2) -> o1, LinkedHashMap::new));

        int counter = 0;

        for(String key : mostFrequentOrder.keySet()){
            if(counter < 3){
                System.out.println(key + " -> " + mostFrequentOrder.get(key));
            }
            counter++;
        }
    }
}
