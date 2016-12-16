//Cleaned
package org.trinity.hihome.repository.business.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;

import org.trinity.hihome.common.message.lookup.AccessRight;
import org.trinity.hihome.common.message.lookup.UserStatus;
import org.trinity.repository.entity.AbstractAuditableEntity;

/**
 * The persistent class for the user database table.
 *
 */
@Entity
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User extends AbstractAuditableEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "User_PK_IdGenerator")
    @TableGenerator(name = "User_PK_IdGenerator", table = "id_table", pkColumnName = "type", pkColumnValue = "User_PK", valueColumnName = "value", initialValue = 1, allocationSize = 1)
    private Long id;

    private String password;

    private UserStatus status;

    private String username;

    private String cellphone;

    private String email;

    // bi-directional many-to-one association to Token
    @OneToMany(mappedBy = "user")
    private List<Token> tokens;

    // bi-directional many-to-many association to UserGroup
    @ElementCollection
    @CollectionTable(name = "user_accessright", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "accessright")
    private List<AccessRight> accessrights;

    public User() {
    }

    public Token addToken(final Token token) {
        getTokens().add(token);
        token.setUser(this);

        return token;
    }

    public List<AccessRight> getAccessrights() {
        return this.accessrights;
    }

    public String getCellphone() {
        return cellphone;
    }

    public String getEmail() {
        return email;
    }

    public Long getId() {
        return this.id;
    }

    public String getPassword() {
        return this.password;
    }

    public UserStatus getStatus() {
        return this.status;
    }

    public List<Token> getTokens() {
        return this.tokens;
    }

    public String getUsername() {
        return this.username;
    }

    public Token removeToken(final Token token) {
        getTokens().remove(token);
        token.setUser(null);

        return token;
    }

    public void setAccessrights(final List<AccessRight> accessrights) {
        this.accessrights = accessrights;
    }

    public void setCellphone(final String cellphone) {
        this.cellphone = cellphone;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public void setStatus(final UserStatus status) {
        this.status = status;
    }

    public void setTokens(final List<Token> tokens) {
        this.tokens = tokens;
    }

    public void setUsername(final String username) {
        this.username = username;
    }
}
