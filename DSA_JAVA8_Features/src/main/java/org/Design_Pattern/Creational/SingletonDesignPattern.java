package org.Design_Pattern.Creational;

/*
Ensures only one instance of a class is created.
Provides global access to that instance.
Common in logging, config management, caching, thread pools, etc.
 */

//Lazy Initialization Singleton (Not Thread-safe)
class ConfigManager {
    private static ConfigManager instance;
    private ConfigManager() {}
    public static ConfigManager getInstance() {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }
}

//Thread-safe Singleton (Synchronized)
class Logger {
    private static Logger instance;
    private Logger() {}
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
}


public class SingletonDesignPattern {

    public static void main(String[] args) {

        ConfigManager configManager1 =ConfigManager.getInstance();
        ConfigManager configManager2 = ConfigManager.getInstance();
        System.out.println(configManager2.equals(configManager1));
        System.out.println(configManager2==configManager1);

        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        System.out.println(logger2==logger1);
    }
}
