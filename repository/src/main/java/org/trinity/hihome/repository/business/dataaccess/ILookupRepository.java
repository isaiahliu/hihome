package org.trinity.hihome.repository.business.dataaccess;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.trinity.hihome.common.message.lookup.Language;
import org.trinity.hihome.common.message.lookup.LookupType;
import org.trinity.hihome.repository.business.entity.Lookup;

public interface ILookupRepository extends CrudRepository<Lookup, Long> {
    List<Lookup> findAllByCategory(LookupType category);

    List<Lookup> findAllByLanguage(Language language);

    Lookup findOneByLanguageAndCategoryAndCode(Language language, LookupType category, String code);
}
