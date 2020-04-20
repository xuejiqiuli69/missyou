/**
 * @作者 leokkzhang
 * @创建时间 2020/4/20 23:47
 */
package com.lin.missyou.vo;

import com.lin.missyou.model.Activity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ActivityPureVO {
    private Long id;
    private String title;
//    private String name;
//    private String description;
    private Date startTime;
    private Date endTime;
    private Boolean online;
    private String entranceImg;
//    private String internalTopImg;
    private String remark;

    public ActivityPureVO(Activity activity){
        BeanUtils.copyProperties(activity,this);
    }
}
