package designmode.chain;

/**
 * @description：
 * @author： dingyawu
 * @date： created in 21:41 2021-01-11
 * @history:
 */
public class ErrorLogger extends AbstractLogger {

	public ErrorLogger(int level){
		this.level = level;
	}

	@Override
	protected void write(String message) {
		System.out.println("Error Console::Logger: " + message);
	}
}