package enums;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 10:53 2021-03-19
 */
public interface OptionFactory {
  <R, P> R create(P t);

  <R, P> R update(P t);

  <R, P> R delete(P t);

  <R, P> R read(P t);
}
