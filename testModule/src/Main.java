import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer[] a = new Integer[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        List<Integer> list = Arrays.stream(a).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println(list);
    }
}