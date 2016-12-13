
public class EggOrChicken {
	
	private voiceOpinion eggOpinion;
	private voiceOpinion chickenOpinion;
	private String desision;
	
	
	public static void main(String[] args) {
		
		EggOrChicken question = new EggOrChicken();
		
		question.eggOpinion = new voiceOpinion("����!", question );
		question.chickenOpinion = new voiceOpinion("������!", question );
		Thread eggThread = new Thread(question.eggOpinion );
		Thread chickenThread = new Thread(question.chickenOpinion);
		
		System.out.println("���� �����...");
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
		
		if (question.desision.equals("����!")) {
			System.out.println("������ ��������� ����");
		} else  {
			System.out.println("������ ��������� ������");
		}		
		System.out.println("���� ��������!");		
	}
	
	public synchronized void giveOpinion(String opinion) {
		this.desision = opinion;
	} 
}
