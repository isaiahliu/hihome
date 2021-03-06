package org.trinity.hihome.process.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.trinity.common.exception.IException;
import org.trinity.hihome.common.message.dto.domain.SystemAttributeDto;
import org.trinity.hihome.common.message.dto.domain.SystemAttributeSearchingDto;
import org.trinity.hihome.common.message.lookup.RecordStatus;
import org.trinity.hihome.common.message.lookup.SystemAttributeKey;
import org.trinity.hihome.process.controller.base.AbstractAutowiredCrudProcessController;
import org.trinity.hihome.process.controller.base.ISystemAttributeProcessController;
import org.trinity.hihome.repository.business.dataaccess.ISystemAttributeRepository;
import org.trinity.hihome.repository.business.entity.SystemAttribute;

@Service
public class SystemAttributeProcessController extends
        AbstractAutowiredCrudProcessController<SystemAttribute, SystemAttributeDto, SystemAttributeSearchingDto, ISystemAttributeRepository>
        implements ISystemAttributeProcessController {

    @Override
    public String getValue(final SystemAttributeKey key) throws IException {
        final SystemAttribute entity = getDomainEntityRepository().findOneByKey(key);
        if (entity != null) {
            return entity.getValue();
        }
        return key.getDefaultValue();
    }

    @Override
    @Transactional(rollbackOn = IException.class)
    public void refreshAll() throws IException {
        final Iterable<SystemAttribute> allAttributes = getDomainEntityRepository().findAll();

        final List<SystemAttributeKey> allKeys = Arrays.asList(SystemAttributeKey.values());

        final List<SystemAttributeKey> existingKeys = StreamSupport.stream(allAttributes.spliterator(), false).map(item -> item.getKey())
                .collect(Collectors.toList());
        allKeys.removeAll(existingKeys);

        final List<SystemAttribute> attributes = allKeys.stream().map(item -> {
            final SystemAttribute attribute = new SystemAttribute();
            attribute.setFormat("");
            attribute.setKey(item);
            attribute.setStatus(RecordStatus.ACTIVE);
            attribute.setValue("");
            attribute.setValueType("");
            return attribute;
        }).collect(Collectors.toList());

        getDomainEntityRepository().save(attributes);
    }
}
