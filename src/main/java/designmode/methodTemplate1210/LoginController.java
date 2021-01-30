package designmode.methodTemplate1210;

/**
 * description：
 * author：dingyawu
 * date：created in 18:55 2020-12-10
 * history:
 */

public class LoginController extends AbstractTemplate {

		@Override
		public Result execute() {
				return super.execute();
		}
		@Override
		public void parseRequestParameters() {
				System.out.println("解析登录参数");
		}

		@Override
		public void checkRequestParameters() {
				System.out.println("校验登录用户名是否为空，密码是否为空");
		}

		@Override
		public Object doBusiness() {
				System.out.println("通过用户名查询是否存在此用户");
				System.out.println("校验用户密码是否正确");
				System.out.println("登录成功");
				User user = new User();
				user.setName("小田哥");
				user.setId(1);
				user.setAge(20);
				user.setSex("man");
				return user;
		}

		@Override
		public Result assembleResponseParameters(Object object) {
				System.out.println("*****返回参数*****");
				Result result = new Result("200", "登录成功");
				result.setData(object);
				return result;
		}
}
