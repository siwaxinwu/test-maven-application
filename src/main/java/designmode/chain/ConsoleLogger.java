package designmode.chain;

/**
 * @description：
 * @author： dingyawu
 * @date： created in 21:40 2021-01-11
 * @history:
 */
public class ConsoleLogger extends AbstractLogger {

	public ConsoleLogger(int level){
		this.level = level;
	}

	@Override
	protected void write(String message) {
		System.out.println("Standard Console::Logger: " + message);
	}
}