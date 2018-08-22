import org.junit.Test;

import com.alibaba.fastjson.JSON;

import xyz.oilpea.wechat.sale.core.util.JsonUtils;
import net.sf.json.JSONObject;

public class apitest {
	@Test
	public void apitest() {
		System.out.println("test");
		// String response = "aa";
		JsonUtils jsonUtils = new JsonUtils();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", "11");

		System.out.println(jsonObject.toString());
	}
}
