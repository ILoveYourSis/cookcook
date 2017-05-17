package Util;

public class Logger
{
    public static void log(Object arg)
    {
    	System.out.println("[LOG]" + arg.toString());
    }
    
    public static void error(Object err)
    {
    	System.out.println("[ERROR]" + err);
    }
}
