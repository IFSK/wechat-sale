package xyz.oilpea.wechat.app.api.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * 创建mybatis逆向工程工具类
 * @author JMT24
 *
 */
public class GeneratorMybatisMapper {
	/**
	 * 根据默认配置创建逆向工程
	 * 默认配置文件为./src/main/resources/config/generator.xml
	 */
	public static void createMybatisGeneratorProject() {
		createMybatisGeneratorProject("./src/main/resources/generator.xml");
	}

	/**
	 * 根据传入的配置文件路径生成逆向工程
	 * @param genertorConfigPath 配置文件路径
	 */
	public static void createMybatisGeneratorProject(String genertorConfigPath) {
		try {
			List<String> warnings = new ArrayList<String>();
			boolean overwrite = true;
			File configFile = new File(genertorConfigPath);
			ConfigurationParser cp = new ConfigurationParser(warnings);
			Configuration config = cp.parseConfiguration(configFile);
			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
			myBatisGenerator.generate(null);
		} catch (Exception e) { 
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		createMybatisGeneratorProject();
	}
}
