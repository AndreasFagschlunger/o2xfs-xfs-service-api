/*
 * Copyright (c) 2017, Andreas Fagschlunger. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package at.o2xfs.xfs.service.api.cdm;

import java.util.List;
import java.util.Optional;

import at.o2xfs.xfs.api.XfsException;
import at.o2xfs.xfs.cdm.Position;
import at.o2xfs.xfs.service.api.XfsFuture;
import at.o2xfs.xfs.service.api.XfsService;
import at.o2xfs.xfs.service.api.cdm.event.DispenseListener;
import at.o2xfs.xfs.service.api.cdm.event.PresentListener;
import at.o2xfs.xfs.service.api.cdm.event.ResetListener;
import at.o2xfs.xfs.v3.cdm.Capabilities3;
import at.o2xfs.xfs.v3.cdm.CashUnitInfo3;
import at.o2xfs.xfs.v3.cdm.CurrencyExp3;
import at.o2xfs.xfs.v3.cdm.Denomination3;
import at.o2xfs.xfs.v3.cdm.Dispense3;
import at.o2xfs.xfs.v3.cdm.ItemPosition3;
import at.o2xfs.xfs.v3.cdm.Status3;

public interface CdmService extends XfsService {

	void addServiceListener(CdmServiceListener listener);

	XfsFuture<? extends Denomination3> dispense(Dispense3 dispense, DispenseListener listener) throws XfsException;

	XfsFuture<? extends Capabilities3> getCapabilities() throws XfsException;

	XfsFuture<? extends CashUnitInfo3> getCashUnitInfo() throws XfsException;

	XfsFuture<List<? extends CurrencyExp3>> getCurrencyExponents() throws XfsException;

	XfsFuture<? extends Status3> getStatus() throws XfsException;

	XfsFuture<Void> present(Position position, PresentListener listener) throws XfsException;

	void removeServiceListener(CdmServiceListener listener);

	XfsFuture<Void> reset(ResetListener listener, Optional<ItemPosition3> resetIn) throws XfsException;

}
