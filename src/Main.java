import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String AutomatPath = "C:\\3 ����\\Automat.txt";
        Scanner in = new Scanner(System.in);
        System.out.println(
                "w0 ���������, ���������� �� w0 ���� ���� ����� ����� w=w1w0,\n" +
                        "�� ����������� ���������\n" +
                "w1 ���� ���� ������ ������,��� w=w0 \n");
        while(true) {
            System.out.print("Input word w0: ");
            String word = in.next();
            char[] w0 = word.toCharArray();
            Automat automat = new Automat(AutomatPath, w0);
            System.out.println(automat.checkW0());
        }
    }
}

