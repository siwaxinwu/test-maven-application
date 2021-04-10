package entity;

import java.io.Serializable;

/**
 * @author dingyawu
 * @version 1.0
 * @date created in 13:29 2021-03-30
 */
public class Student implements Serializable {

  private static int startId = 1000;

  private int id;

  public Student() {
    id = startId++;
  }
}
