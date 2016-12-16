package org.trinity.hihome.process.controller.base;

import org.trinity.common.exception.IException;
import org.trinity.hihome.common.message.dto.domain.SystemAttributeDto;
import org.trinity.hihome.common.message.dto.domain.SystemAttributeSearchingDto;
import org.trinity.hihome.common.message.lookup.SystemAttributeKey;
import org.trinity.process.controller.ICrudProcessController;

public interface ISystemAttributeProcessController extends ICrudProcessController<SystemAttributeDto, SystemAttributeSearchingDto> {
    String getValue(SystemAttributeKey key) throws IException;

    void refreshAll() throws IException;
}
