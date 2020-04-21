package at.o2xfs.xfs.service.api;

import at.o2xfs.xfs.api.XfsException;

public interface XfsFuture<T> {

	void cancel() throws XfsException;

	T get() throws InterruptedException, XfsException;

}
