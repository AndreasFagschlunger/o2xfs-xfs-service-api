package at.o2xfs.xfs.service.api;

import at.o2xfs.xfs.api.WfsVersion;

public interface OpenFuture<T extends XfsService> extends XfsFuture<T> {

	WfsVersion getServiceVersion();

	WfsVersion getSpiVersion();
}
