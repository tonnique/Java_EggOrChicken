
public class EggOrChicken {
	
	private voiceOpinion eggOpinion;
	private voiceOpinion chickenOpinion;
	private String desision;
	
	
	public static void main(String[] args) {
		
		EggOrChicken question = new EggOrChicken();
		
		question.eggOpinion = new voiceOpinion("яйцо!", question );
		question.chickenOpinion = new voiceOpinion(" урица!", question );
		Thread eggThread = new Thread(question.eggOpinion );
		Thread chickenThread = new Thread(question.chickenOpinion);
		
		System.out.println("—пор начат...");
		eggThread.start();
		chickenThread.start();
		
		if (eggThread.isAlive()) {
			try {
				eggThread.join();
			}
			catch (InterruptedException ex) {ex.printStackTrace();}
			
		}
		
		if (chickenThread.isAlive()) {			
			try {
				chickenThread.join();
			}
			catch (InterruptedException ex) {ex.printStackTrace();}			
		}
		
		if (question.desision.equals("яйцо!")) {
			System.out.println("ѕервой по€вилось €йцо");
		} else  {
			System.out.println("ѕервой по€вилась курица");
		}		
		System.out.println("—пор закончен!");		
	}
	
	public synchronized void giveOpinion(String opinion) {
		this.desision = opinion;
	} 
}
