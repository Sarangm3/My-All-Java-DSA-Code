package OOPs.Collage.Extra;

public class Today {
    public static void main(String[] args) {
        go:
        for (int i = 1; i <= 10; i++) {

            System.out.println(i);
            for (int j = 1; j <= 10; j++) {
                if(j==5)
                    continue go;
                System.out.print(j);
            }
        }
    }
}
