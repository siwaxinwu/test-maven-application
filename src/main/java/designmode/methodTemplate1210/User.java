package designmode.methodTemplate1210;

import java.io.Serializable;

/**
 * description：
 * author：dingyawu
 * date：created in 18:54 2020-12-10
 * history:
 */
public class User implements Serializable {
		//id
		private Integer id;
		//用户姓名
		private String name;
		//性别
		private String sex;
		//年龄
		private int age;

		public User() {
		}

		public User(Integer id, String name, String sex, int age) {
				this.id = id;
				this.name = name;
				this.sex = sex;
				this.age = age;
		}

		public Integer getId() {
				return id;
		}

		public void setId(Integer id) {
				this.id = id;
		}

		public String getName() {
				return name;
		}

		public void setName(String name) {
				this.name = name;
		}

		public String getSex() {
				return sex;
		}

		public void setSex(String sex) {
				this.sex = sex;
		}

		public int getAge() {
				return age;
		}

		public void setAge(int age) {
				this.age = age;
		}
}
