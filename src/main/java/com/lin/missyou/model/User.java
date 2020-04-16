/**
 * @作者 leokkzhang
 * @创建时间 2020/4/15 0:09
 */
package com.lin.missyou.model;

import com.lin.missyou.util.MapAndJson;
import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.Map;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "delete_time is null")
public class User extends BaseEntity{
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String openid;
    private String nickname;
    private Long unifyUid;
    private String email;
    private String password;
    private String mobile;

    @Convert(converter = MapAndJson.class)
    private Map<String,Object> wxProfile;
}
