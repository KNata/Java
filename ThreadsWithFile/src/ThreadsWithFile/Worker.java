package ThreadsWithFile;

public class Worker extends Thread {
	
	private int id;
	private Data data;
	
	public Worker(int anId, Data aData) {
		id = anId;
		data = aData;
		this.start();
	}
	
	
	public void run() {
		synchronized (data) {
			for (int i = 0; i < 4; i++) {
				try {
					while (id != data.getState()) {
						data.wait();
					}
					if (id == 1) {
						data.deletePunctuation();
					
					} else if (id == 2) {
						data.wordsToLoverCase();
					
					} else {
						data.deleteWords();
					}
					data.notifyAll();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
