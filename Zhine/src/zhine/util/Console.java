package zhine.util;

public class Console {
	
	public static void log(Object o) {
		
		log(LogType.INFO, o);
	}
	
	public static void log(LogType type, Object o) {
		
		switch(type) {
		
		case INFO:
			System.out.println("[ZHINE] " + o.toString());
			break;
			
		case WARNING:
			System.out.println("[ZHINE] [WARNING] " + o.toString());
			break;
			
		case SEVERE:
			System.out.println("[ZHINE] [SEVERE] " + o.toString());
			break;
			
		case DEBUG:
			System.out.println("[ZHINE] [DEBUG] " + o.toString());
			break;
		
		default:
			break;
		}
	}
}