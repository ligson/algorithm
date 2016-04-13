package org.ligson.classloader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;

public class MyClassLoader extends ClassLoader {

	private String key;

	public MyClassLoader(String key) {
		super();
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	@Override
	protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
		System.out.println("load class-----" + name);
		return super.loadClass(name, resolve);
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("load class-----" + name);
		return super.findClass(name);
	}

	@Override
	protected URL findResource(String name) {
		// TODO Auto-generated method stub
		System.out.println("load class-----" + name);
		return super.findResource(name);
	}

	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("load class-----" + name);
		return super.loadClass(name);
	}

	@Override
	public URL getResource(String name) {
		// TODO Auto-generated method stub
		System.out.println("load class-----" + name);
		return super.getResource(name);
	}

	@Override
	public Enumeration<URL> getResources(String name) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("load class-----" + name);
		return super.getResources(name);
	}

	@Override
	protected Enumeration<URL> findResources(String name) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("load class-----" + name);
		return super.findResources(name);
	}

	@Override
	public InputStream getResourceAsStream(String name) {
		// TODO Auto-generated method stub
		System.out.println("load class-----" + name);
		return super.getResourceAsStream(name);
	}

}
