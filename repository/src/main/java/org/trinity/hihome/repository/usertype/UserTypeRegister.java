package org.trinity.hihome.repository.usertype;

import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.trinity.hihome.common.message.lookup.AccessRight;
import org.trinity.hihome.common.message.lookup.Language;
import org.trinity.hihome.common.message.lookup.LookupType;
import org.trinity.hihome.common.message.lookup.RecordStatus;
import org.trinity.hihome.common.message.lookup.SystemAttributeKey;
import org.trinity.hihome.common.message.lookup.TokenStatus;
import org.trinity.hihome.common.message.lookup.UserStatus;
import org.trinity.repository.type.MessageUserType;

@TypeDefs({
        @TypeDef(name = "RecordStatus", defaultForType = RecordStatus.class, typeClass = MessageUserType.class, parameters = @Parameter(name = "class", value = "org.trinity.hihome.common.message.lookup.RecordStatus")),
        @TypeDef(name = "Language", defaultForType = Language.class, typeClass = MessageUserType.class, parameters = @Parameter(name = "class", value = "org.trinity.hihome.common.message.lookup.Language")),
        @TypeDef(name = "LookupType", defaultForType = LookupType.class, typeClass = MessageUserType.class, parameters = @Parameter(name = "class", value = "org.trinity.hihome.common.message.lookup.LookupType")),
        @TypeDef(name = "SystemAttributeKey", defaultForType = SystemAttributeKey.class, typeClass = MessageUserType.class, parameters = @Parameter(name = "class", value = "org.trinity.hihome.common.message.lookup.SystemAttributeKey")),
        @TypeDef(name = "UserStatus", defaultForType = UserStatus.class, typeClass = MessageUserType.class, parameters = @Parameter(name = "class", value = "org.trinity.hihome.common.message.lookup.UserStatus")),
        @TypeDef(name = "TokenStatus", defaultForType = TokenStatus.class, typeClass = MessageUserType.class, parameters = @Parameter(name = "class", value = "org.trinity.hihome.common.message.lookup.TokenStatus")),
        @TypeDef(name = "AccessRight", defaultForType = AccessRight.class, typeClass = MessageUserType.class, parameters = @Parameter(name = "class", value = "org.trinity.hihome.common.message.lookup.AccessRight")) })
@MappedSuperclass
public class UserTypeRegister {
}
