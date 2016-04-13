package org.ligson.classloader;

public class EncodeCodec {
	public void startup() {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		if (classLoader instanceof MyClassLoader) {
			MyClassLoader loader = (MyClassLoader) classLoader;
			if ("password".equals(loader.getKey())) {
				System.out.println("授权成功");
			} else {
				System.out.println("授权失败");
			}
		} else {
			System.err.println("非法破解.........");
			System.exit(0);
		}
	}
}
