//Estos son import's explicitos
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.io.IOException;

//Este es un import implicito
//import java.util.*

//static imports
//import static java.awt.color.ColorSpace.CS_GRAY;
import static java.util.Locale.*;

public class TestClass {
    public static void main(String[] args) throws IOException {
        new File("logs").mkdir();
        DateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
        Date now = new Date();
        String date = df.format(now);
        
        String logFileName = "logs\\testlog-" + date + ".txt";
        FileHandler myFileHandler = new FileHandler(logFileName);
        myFileHandler.setFormatter(new SimpleFormatter());
        
        Logger ocajLogger = Logger.getLogger("OCAJ Logger");
        ocajLogger.setLevel(Level.ALL);
        ocajLogger.addHandler(myFileHandler);
        
        ocajLogger.info("This is a logged information message " + CANADA);
        
        myFileHandler.close();
    }
}
