import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //這裡輸入你要轉換的txt檔案名稱
        String input_file = "1123n.txt";
        //這是輸出CSV檔，名稱可以自定義
        String output_file = "0504.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(input_file));
             FileWriter writer = new FileWriter(output_file)) {

            String contentRead = reader.readLine();

            List<String[]> rows = new ArrayList<>();
            String[] fields;

            while (contentRead != null) {
                                                        //注意不要key成'\r\n'，會出現格式問題，導致無法正確換行
                contentRead = contentRead.replace("\\r\\n", "\n");
                fields = contentRead.split(";");
                rows.add(fields);
                contentRead = reader.readLine();
            }

            for (String[] row : rows) {
                writer.write(String.join(",", row));
                writer.write("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}