/**
 * @作者 leokkzhang
 * @创建时间 2020/4/30 0:36
 */
package com.lin.missyou.core;

import com.lin.missyou.model.User;

import java.util.HashMap;
import java.util.Map;

public class LocalUser {

    private static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<>();

    public static User getUser() {
        Map<String, Object> map = LocalUser.threadLocal.get();
        return (User) map.get("user");
    }

    public static Integer getScope(){
        Map<String, Object> map = LocalUser.threadLocal.get();
        return (Integer) map.get("scope");
    }

    public static void setUser(User user, Integer scope) {
        Map<String, Object> map = new HashMap<>();
        map.put("user", user);
        map.put("scope", scope);
        LocalUser.threadLocal.set(map);
    }

    public static void clear(){
        LocalUser.threadLocal.remove();
    }
}
