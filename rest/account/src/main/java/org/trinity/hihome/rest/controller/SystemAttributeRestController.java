package org.trinity.hihome.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.trinity.common.dto.response.DefaultResponse;
import org.trinity.common.exception.IException;
import org.trinity.hihome.common.accessright.Authorize;
import org.trinity.hihome.common.message.dto.domain.SystemAttributeDto;
import org.trinity.hihome.common.message.dto.domain.SystemAttributeSearchingDto;
import org.trinity.hihome.common.message.dto.request.SystemAttributeRequest;
import org.trinity.hihome.common.message.dto.response.SystemAttributeResponse;
import org.trinity.hihome.common.message.lookup.AccessRight;
import org.trinity.hihome.process.controller.base.ISystemAttributeProcessController;

@RestController
@RequestMapping("/common/systemattribute")
public class SystemAttributeRestController extends
        AbstractApplicationAwareCrudRestController<SystemAttributeDto, SystemAttributeSearchingDto, ISystemAttributeProcessController, SystemAttributeRequest, SystemAttributeResponse> {

    @RequestMapping(value = "/refresh", method = RequestMethod.PUT)
    @Authorize(AccessRight.SUPER_USER)
    public @ResponseBody ResponseEntity<DefaultResponse> updateAll() throws IException {
        final DefaultResponse response = new DefaultResponse();

        getDomainProcessController().refreshAll();

        return createResponseEntity(response);
    }

    @Override
    protected SystemAttributeResponse createResponseInstance() {
        return new SystemAttributeResponse();
    }
}
