package utils;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 16:26 2021-02-06
 */
public enum Calculator {

  /** 除 */
  ADDITION {
    @Override
    public Double execute(Double x, Double y) {
      return x + y; // 加法
    }
  },

  /** 减法 */
  SUBTRACTION {
    @Override
    public Double execute(Double x, Double y) {
      return x - y; // 减法
    }
  },
  /** 乘法 */
  MULTIPLICATION {
    @Override
    public Double execute(Double x, Double y) {
      return x * y; // 乘法
    }
  },
  /** 除法 */
  DIVISION {
    @Override
    public Double execute(Double x, Double y) {
      return x / y; // 除法
    }
  };

  public abstract Double execute(Double x, Double y);
}
