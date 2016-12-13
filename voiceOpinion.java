public class voiceOpinion implements Runnable {
	String opinion;
	EggOrChicken voice;
	
	public voiceOpinion(String op, EggOrChicken v) {
		opinion = op;
		voice = v;
	}
	
	@Override
	public void run() {
		
		for (int i = 0; i < 5; i++) {			
			
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException ex) {ex.printStackTrace();}
			
			System.out.println(opinion);
			voice.giveOpinion(opinion);
			
			
		}		
	}	
}
