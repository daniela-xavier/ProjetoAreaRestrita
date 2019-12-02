package br.com.arearestrita.view.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Description the class Log4J2PropertiesConf - xxxxx
 *
 * @author Daniela Xavier Conceicao - sistemas@fozadvogados.com.br
 * @version  $Revision: 1
 * @since Build 0.1 02/12/019
 */
public class Log4J2PropertiesConf {

    private static final Logger logger = LogManager.getLogger();

    /**
     * Perform Some Task Log4J.
     */
    public void performSomeTask() {
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
        logger.fatal("This is a fatal message");
    }
}
