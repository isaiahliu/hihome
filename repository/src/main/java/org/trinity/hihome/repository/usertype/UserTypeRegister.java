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
        @TypeDef(typeClass = MessageUserType.class, parameters = @Parameter(name = "class", value = "org.trinity.hihome.common.message.lookup.RecordStatus"), defaultForType = RecordStatus.class),
        @TypeDef(typeClass = MessageUserType.class, parameters = @Parameter(name = "class", value = "org.trinity.hihome.common.message.lookup.Language"), defaultForType = Language.class),
        @TypeDef(typeClass = MessageUserType.class, parameters = @Parameter(name = "class", value = "org.trinity.hihome.common.message.lookup.LookupType"), defaultForType = LookupType.class),
        @TypeDef(typeClass = MessageUserType.class, parameters = @Parameter(name = "class", value = "org.trinity.hihome.common.message.lookup.SystemAttributeKey"), defaultForType = SystemAttributeKey.class),
        @TypeDef(typeClass = MessageUserType.class, parameters = @Parameter(name = "class", value = "org.trinity.hihome.common.message.lookup.UserStatus"), defaultForType = UserStatus.class),
        @TypeDef(typeClass = MessageUserType.class, parameters = @Parameter(name = "class", value = "org.trinity.hihome.common.message.lookup.TokenStatus"), defaultForType = TokenStatus.class),
        @TypeDef(typeClass = MessageUserType.class, parameters = @Parameter(name = "class", value = "org.trinity.hihome.common.message.lookup.AccessRight"), defaultForType = AccessRight.class) })
@MappedSuperclass
public class UserTypeRegister {
}
