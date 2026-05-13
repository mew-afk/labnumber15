import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ip-адресс");
        String text = sc.nextLine();
        String reg = "(25[0-5]|2[0-4]\\d|[0-1]?\\d\\d?)";
        String reg1 = "\\b" + reg + "\\." + reg + "\\." + reg + "\\." + reg + "\\b";
        Pattern p = Pattern.compile(reg1);
        Matcher m = p.matcher(text);
        if (m.find()) {
            try (FileWriter fw = new FileWriter("file.txt")){
                fw.write("Ip-адресс: " + m.group());
                System.out.println("Файл создан");
            }
            catch (IOException ex) {
                System.out.println("Ошибка, файл не создан");
            }
        }
        else{
            System.out.println("Ip адресс неправильный");
        }
    }
}