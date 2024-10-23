import java.io.FileNotFoundException;
import java.io.FileReader;

public class Booking {
        FileReader reader;
    {
        try {
            reader = new FileReader("src//appointments.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}

