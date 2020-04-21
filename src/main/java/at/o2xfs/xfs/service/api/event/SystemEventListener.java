package at.o2xfs.xfs.service.api.event;

import at.o2xfs.xfs.api.AppDisconnect;
import at.o2xfs.xfs.api.DeviceStatus;
import at.o2xfs.xfs.api.HardwareError;
import at.o2xfs.xfs.api.UndeliverableMessage;

public interface SystemEventListener {

	void onAppDisconnect(AppDisconnect appDisconnect);

	void onDeviceStatus(DeviceStatus deviceStatus);

	void onFraudAttempt(HardwareError hardwareError);

	void onHardwareError(HardwareError hardwareError);

	void onLockRequested();

	void onSoftwareError(HardwareError hardwareError);

	void onUndeliverableMessage(UndeliverableMessage undeliverableMessage);

	void onUserError(HardwareError hardwareError);

}
