package org.trinity.hihome.process.datapermission;

import org.springframework.stereotype.Component;
import org.trinity.common.exception.IException;
import org.trinity.hihome.repository.business.entity.SystemAttribute;

@Component
public class SystemAttributeDataPermissionValidator extends AbstractDataPermissionValidator<SystemAttribute> {
    @Override
    public void checkSpecialPermission() throws IException {
        super.checkSpecialPermission();
    }

    @Override
    protected void validateData(final String username, final Long id) throws IException {
    }
}
