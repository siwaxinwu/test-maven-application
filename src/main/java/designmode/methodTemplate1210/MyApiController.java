package designmode.methodTemplate1210;

/**
 * description：
 * author：dingyawu
 * date：created in 18:56 2020-12-10
 * history:
 */

public class MyApiController extends AbstractTemplate {

		@Override
		public Result execute() {
				return super.execute();
		}

		@Override
		public void parseRequestParameters() {
				System.out.println("*****解析参数*****");
		}

		@Override
		public void checkRequestParameters() {
				System.out.println("*****校验参数*****");
		}

		@Override
		public Object doBusiness() {
				System.out.println("*****处理业务*****");
				// TODO: 2018/11/17 调用service处理业务
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
				Result result = new Result("200", "处理成功");
				result.setData(object);
				return result;
		}
}
