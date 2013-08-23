import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PracticeVolatile {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Task t1 = new Task(); // 创建一个线程类：Task的对象
		t1.start(); // 开始线程

		// 挂起程序，用户输入回车后，继续运行
		new Scanner(System.in).next();

		t1.shutdown(); // 结束线程

	}
}

class Task extends Thread {
	private static final Logger logger = LoggerFactory.getLogger(Task.class);

	private volatile boolean running = true;

	public void run() {
		while (running) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			logger.debug("运行中");
		}
	}

	public void shutdown() {
		running = false;
	}
}
