import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


/**
 * @author crazyne55
 *
 * @author ChatGPT
 */
public class SortingAlgorithms {
    public static <T> List<T> selectionSort(List<T> arr, Comparator<? super T> comp) {
        int n = arr.size();
        for (int i = 0; i < n-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                if (comp.compare(arr.get(j), arr.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                T temp = arr.get(i);
                arr.set(i, arr.get(minIndex));
                arr.set(minIndex, temp);
            }
        }
        return arr;
    }





    public static class comparableEntity implements Comparable<comparableEntity> {
        int value;
        int value2;
        public comparableEntity(int value, int value2) {
            this.value = value;
            this.value2 = value2;
        }
        @Override
        public String toString() {
            return String.format("[%s,%s]", this.value, this.value2);
        }
        @Override
        public int compareTo(comparableEntity other) {
            return Integer.compare(this.value, other.value);
        }
    }


    public static void main(String[] args) {
        Comparator<comparableEntity> customComparator = (ce1, ce2) -> {
            int v = Integer.compare(ce1.value, ce2.value);
            if (v == 0) {
                return Integer.compare(ce1.value2, ce2.value2);
            } else {
                return v;
            }
        };

        List<comparableEntity> CE = new ArrayList<>();
        CE.add(new comparableEntity(15,7));
        CE.add(new comparableEntity(45,15));
        CE.add(new comparableEntity(11,63));

        System.out.println(CE);
        CE = selectionSort(CE, customComparator);
        System.out.println("--------------------------- sorted");
        System.out.println(CE);
    }
}
