package org.trinity.hihome.process.controller.base;

import org.trinity.common.accessright.AuthToken;
import org.trinity.common.exception.IException;
import org.trinity.hihome.common.message.dto.domain.TokenDto;
import org.trinity.process.controller.IProcessController;

public interface ITokenProcessController extends IProcessController {

	TokenDto getToken(String tokenName) throws IException;

	AuthToken preAuth(String token);

	TokenDto refreshToken(String identity, String originalToken);

	void updateAccessTime(String token) throws IException;
}
