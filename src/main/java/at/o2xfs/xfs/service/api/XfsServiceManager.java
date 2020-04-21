package at.o2xfs.xfs.service.api;

import at.o2xfs.xfs.api.XfsException;

public interface XfsServiceManager {

	<E extends XfsService> XfsFuture<E> open(String logicalName, Class<E> serviceClass) throws XfsException;

	void initialize() throws XfsException;

	void shutdown();
}
