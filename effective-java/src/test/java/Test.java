import java.io.IOException;

/**
 * Created by Administrator on 2018/9/22.
 */
public class Test {
    /*
    It will be a compile time error
    as The exception IOException is already caught by the alternative Exception.
     */
    public static void main(String[] args) {
        try {
            throw new IOException("Hello");
        }catch(IOException | Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
