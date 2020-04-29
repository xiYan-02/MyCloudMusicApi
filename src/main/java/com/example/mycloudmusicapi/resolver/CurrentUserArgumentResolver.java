package com.example.mycloudmusicapi.resolver;

import com.example.mycloudmusicapi.annotation.CurrentUser;
import com.example.mycloudmusicapi.domain.User;
import com.example.mycloudmusicapi.service.UserService;
import com.example.mycloudmusicapi.util.Constant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * CurrentUser注解参数解析器
 */
public class CurrentUserArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private UserService userService;

    /**
     * 是否支持参数解析
     *
     * @param parameter
     * @return true:要解析，才会执行resolveArgument；false:不解析
     */
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
//        判断参数类型是否为User和是否有CurrentUser注解
        return parameter.getParameterType().isAssignableFrom(User.class) &&
                parameter.hasParameterAnnotation(CurrentUser.class);
    }

    /**
     * 参数解析方法
     * @param parameter
     * @param mavContainer
     * @param webRequest
     * @param binderFactory
     * @return
     * @throws Exception
     */
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
//        在request中取出User,
//        第一个参数:key
//        第二个参数:在哪个范围内去获取
        User user = (User) webRequest.getAttribute(Constant.CURRENT_USER, RequestAttributes.SCOPE_REQUEST);
//        判断是否找到user
        if(user == null){
//            尝试通过请求头中的userid找到user
            String userid = webRequest.getHeader(Constant.USER);
            if(StringUtils.isNotBlank(userid))
                user = userService.find(userid);
        }
        if(user == null){
//            用户为空
//            可以抛出异常，但这里不抛出，因为有些接口可以不登录查看
        }
        return user;
    }
}
