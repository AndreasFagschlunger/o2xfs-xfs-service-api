package at.o2xfs.xfs.service.api;

import java.util.ServiceLoader;

public abstract class XfsServiceManagerFactory {

	public abstract XfsServiceManager getServiceManager();

	public static XfsServiceManager create() {
		XfsServiceManagerFactory factory = ServiceLoader.load(XfsServiceManagerFactory.class).findFirst().orElse(null);
		return factory.getServiceManager();
	}
}
