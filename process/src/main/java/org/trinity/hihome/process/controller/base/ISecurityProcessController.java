package org.trinity.hihome.process.controller.base;

import org.trinity.common.exception.IException;
import org.trinity.hihome.common.message.dto.domain.SecurityDto;
import org.trinity.process.controller.IProcessController;

public interface ISecurityProcessController extends IProcessController {
    SecurityDto authenticate(String tokenName, String username, String password) throws IException;

    SecurityDto logout(String tokenName) throws IException;

    void register(SecurityDto securityDto) throws IException;

    void registerVerify(SecurityDto user) throws IException;
}
