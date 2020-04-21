package at.o2xfs.xfs.service.api.event;

import at.o2xfs.xfs.api.WfsResult;

public interface IntermediateListener {

	void onIntermediateEvent(WfsResult wfsResult);
}
