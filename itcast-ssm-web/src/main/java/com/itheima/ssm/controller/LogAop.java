package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Syslog;
import com.itheima.ssm.service.ISyslogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
public class LogAop {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ISyslogService syslogService;

    private Date visitTime;
    private Class aClass;
    private Method method;

    @Before("execution(* com.itheima.ssm.controller.*.*(..))")
    public void doBefore(JoinPoint joinPoint) throws NoSuchMethodException {

        //访问时间
        visitTime = new Date();

        //访问的类
        aClass = joinPoint.getTarget().getClass();

        //访问的方法
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        if (args == null || args.length == 0){
            method = aClass.getMethod(methodName);
        }else {
            Class[] classArgs = new Class[args.length];
            for (int i=0;i<args.length;i++){
                classArgs[i] = args[i].getClass();
            }
            method = aClass.getMethod(methodName,classArgs);
        }

    }

    @After("execution(* com.itheima.ssm.controller.*.*(..))")
    public void doAfter(JoinPoint joinPoint) throws Exception {

        //访问时长
        long executionTime = new Date().getTime() - visitTime.getTime();

        //访问的URL
        String url = "";
        if (aClass != null && method != null && aClass != LogAop.class){
            RequestMapping classAnnotation = (RequestMapping) aClass.getAnnotation(RequestMapping.class);
            if (classAnnotation != null){
                String[] classValue = classAnnotation.value();
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null){
                    String[] methodValue = methodAnnotation.value();
                    url = classValue[0] + methodValue[0];

                    //访问的IP
                    String ip = request.getRemoteAddr();

                    //访问的用户
                    User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                    String username = user.getUsername();

                    Syslog syslog = new Syslog();
                    syslog.setUsername(username);
                    syslog.setVisitTime(visitTime);
                    syslog.setIp(ip);
                    syslog.setUrl(url);
                    syslog.setMethod("[类名]:"+aClass.getName()+"[方法名]:"+method.getName());
                    syslog.setExecutionTime(executionTime);

                    syslogService.save(syslog);
                }
            }
        }
    }
}
