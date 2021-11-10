import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PhanTU<T extends Comparable<T>> implements Comparable<PhanTU<T>>{
    public T t;

    public void setT(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public boolean isGreaterThan(PhanTU a) {
        if (compareTo(a) > 0 ) return true;
        else return false;
    }
    public static void main(String[] args) {


        try {
            FileWriter writer = new FileWriter("output");

            File file = new File("input");
            Scanner scanner = new Scanner(file);
            int size = scanner.nextInt();
            PhanTU[] phanTu = new PhanTU[size];
            for (int i = 0; i < phanTu.length; i++){
                int temp = scanner.nextInt();
                phanTu[i].setT(temp);
            }
            sort(phanTu);

            for (int i = 0; i < size; i++) {
                writer.write((Integer) phanTu[i].getT());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int compareTo(PhanTU<T> o) {
        return t.compareTo(o.t);
    }

    public static void sort(PhanTU arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j].isGreaterThan(arr[min_idx]) )
                    min_idx = j;
            PhanTU temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
}
