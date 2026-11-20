import java.util.ArrayList;

public class SLSorter {
    private final ArrayList<String> list = new ArrayList<>();

    public int binarySearch(String targetText){
        int low = 0;
        int high = list.size() - 1;
        while(low <= high){
            int middle = low + (high - low) / 2;
            int comparrison = targetText.compareTo(list.get(middle));
            if(comparrison == 0){
                return middle;
            } else if(comparrison < 0){
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -(low) - 1;
    }

    public int add(String text){
        int result = binarySearch(text);
        int index = (result >= 0) ? result : -(result +1);
        list.add(index, text);
        return index;
    }

    public boolean contains(String targetText){
        return binarySearch(targetText) > 0;
    }

    public int locationOf(String targetText){
        int result = binarySearch(targetText);
        return (result >= 0) ? result : -(result + 1);
    }

    public String get(int index){
        return list.get(index);
    }

    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public void clear(){
        list.clear();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list.size(); i++){
            sb.append(String.format(" [%d] %s%n", i, list.get(i)));
        }
        return sb.toString();
    }
}
