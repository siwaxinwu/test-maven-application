package designmode.chain;

/**
 * @description：
 * @author： dingyawu
 * @date： created in 21:41 2021-01-11
 * @history:
 */
public class FileLogger extends AbstractLogger {

	public FileLogger(int level){
		this.level = level;
	}

	@Override
	protected void write(String message) {
		System.out.println("File::Logger: " + message);
	}
}