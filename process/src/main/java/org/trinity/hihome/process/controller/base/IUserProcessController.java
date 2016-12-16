package org.trinity.hihome.process.controller.base;

import java.util.List;

import org.trinity.common.exception.IException;
import org.trinity.hihome.common.message.dto.domain.UserDto;
import org.trinity.hihome.common.message.dto.domain.UserSearchingDto;
import org.trinity.process.controller.ICrudProcessController;

public interface IUserProcessController extends ICrudProcessController<UserDto, UserSearchingDto> {
    void changePassword(Long id, String oldPassword, String newPassword) throws IException;

    List<UserDto> getMe(UserSearchingDto dto) throws IException;
}
