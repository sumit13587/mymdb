package org.sumits.mymdbapi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name = "language_role")
public class LanguageRole {

    @Id
    @Column(name = "role_id")
    private int roleId;

    @Column(name = "language_role")
    private String languageRole;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getLanguageRole() {
        return languageRole;
    }

    public void setLanguageRole(String languageRole) {
        this.languageRole = languageRole;
    }
}
