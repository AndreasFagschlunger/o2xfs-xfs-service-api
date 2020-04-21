package at.o2xfs.xfs.service.api;

import java.util.OptionalInt;

import at.o2xfs.xfs.api.ServiceId;
import at.o2xfs.xfs.api.WfsVersion;
import at.o2xfs.xfs.api.XfsException;
import at.o2xfs.xfs.service.api.event.IntermediateListener;
import at.o2xfs.xfs.service.api.event.SystemEventListener;

public interface XfsService {

	void addSystemEventListener(SystemEventListener listener);

	XfsFuture<Void> close() throws XfsException;

	<T> XfsFuture<T> execute(ExecuteCommand<?> command, IntermediateListener listener, Class<T> valueType)
			throws XfsException;

	ServiceId getId();

	<T> XfsFuture<T> getInfo(InfoCommand<?> command, Class<T> valueType) throws XfsException;

	String getLogicalName();

	WfsVersion getSpiVersion();

	WfsVersion getVersion();

	XfsFuture<Void> lock(OptionalInt timeOut) throws XfsException;

	void removeSystemEventListener(SystemEventListener listener);

	XfsFuture<Void> unlock() throws XfsException;
}
