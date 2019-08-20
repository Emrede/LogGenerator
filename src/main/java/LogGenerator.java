
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import java.util.Random;
public class LogGenerator {

    private static final Logger logger = LogManager.getLogger(LogGenerator.class);

    public static void main(String[] args) {
        String server = args[1];
        ThreadContext.push(server);

        while (true) {
            // Obtain a number between [1501 - 3000] ms.
            Random rand1 = new Random();
            int time = rand1.nextInt(3000);
            time+=1501;
            try {
                Thread.sleep(time);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }

            Random rand2 = new Random();
            // Obtain a number between [0 - 4].
            int logLevel = rand2.nextInt(5);
            // Add 1 to the result to get a number from the required range
            // (i.e., [1 - 5]).
            logLevel+=1;

            switch(logLevel){
                case 1:
                    logger.debug("Hello-from-" + server);
                    break;
                case 2:
                    logger.info("Hello-from-" + server);
                    break;
                case 3:
                    logger.warn("Hello-from-" + server);
                    break;
                case 4:
                    logger.error("Hello-from-" + server);
                    break;
                case 5:
                    logger.fatal("Hello-from-" + server);
                    break;
            }
        }
    }
}