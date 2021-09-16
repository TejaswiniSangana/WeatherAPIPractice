package com.weatherapi.utility;
import org.apache.log4j.*;


public class LogUtility {
    private LogUtility(){}
    public static final Logger logger = Logger.getLogger(LogUtility.class);
    public static void logInfo(String message){
        logger.info(message);
    }
    public static void logDebug(String message){
        logger.debug(message);
    }
    public static void logError(String message){
        logger.error(message);
    }
    public static void logWarn(String message){
        logger.warn(message);
    }
}
