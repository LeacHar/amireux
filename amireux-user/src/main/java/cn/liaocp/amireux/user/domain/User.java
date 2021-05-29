package cn.liaocp.amireux.user.domain;

import cn.liaocp.amireux.core.domain.BaseDomain;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;
import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

/**
 * @author Chunping.Liao
 * @date 2021/5/15
 */
@Data
@Entity
@Table(name = "system_user")
@EqualsAndHashCode(callSuper = true)
public class User extends BaseDomain {

    @Id
    @GeneratedValue(generator = "userId")
    @GenericGenerator(name = "userId", strategy = "uuid2")
    private String id;

    /**
     * login account
     */
    @Column(nullable = false)
    @NotBlank(message = "username must not be blank")
    private String username;

    /**
     * login password
     */
    @Column(nullable = false)
    @NotBlank(message = "password must not be blank")
    private String password;

    private String email;

    @Column(length = 11)
    private String phone;

    @Column(name = "is_enable", columnDefinition = "tinyint", length = 1, nullable = false)
    private Boolean enable;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "system_user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    @ApiModelProperty(hidden = true)
    private Set<Role> roles;
}
