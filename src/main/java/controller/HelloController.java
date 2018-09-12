package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @program: SpringMVC02
 * @Date: 2018/9/11 20:22
 * @Author: Mr.Zhang
 * @Description:如何写一个处理器：
 * 1：不用实现Controller
 * 2：可以在处理器当中，添加多个方法，每一个方法处理一种类型的请求
 * 3：方法名不做要求，返回类型可以是ModelAndView也可以是String
 * 4：使用@Controller，将该处理器纳入容器进行管理
 * 5：使用@RequestMapping()，请求路径与处理器的方法的对应关系
 */
@Controller
public class HelloController {
    @RequestMapping("/hello.do")
    public String HelloController(){
        System.out.println("Hello()");
        return "hello";
    }
    @RequestMapping("/login.do")
    //读取请求参数的第一种方式：
    //使用request.getParameter()方法
    public String login(HttpServletRequest request){
        System.out.println("login()");
        String adminCode = request.getParameter("adminCode");
        String password = request.getParameter("password");
        System.out.println("账号:"+adminCode+"\n密码:"+password);
        return "index";
    }
    @RequestMapping("/login1.do")
    //读取请求参数的第二种方式：
    //使用@RequestParam注解
    public String login1(@RequestParam("adminCode") String adminCode,@RequestParam("password") String pwd){
        System.out.println("login1()");
        System.out.println("账号:"+adminCode+"\n密码:"+pwd);
        return "index";
    }
    @RequestMapping("/login2.do")
    //读取请求参数的第三种方式：
    //将请求封装成一个javabean
    public String login2(AdminParam adminParam){
        System.out.println("login2()");
        System.out.println("账号:"+adminParam.getAdminCode()+"\n密码:"+adminParam.getPassword());
        return "index";
    }
    @RequestMapping("/login3.do")
    //向页面传值的第一种方式：
    //使用request
    public String login3(AdminParam adminParam,HttpServletRequest request){
        System.out.println("login3()");
        String adminCode = adminParam.getAdminCode();
        request.setAttribute("adminCode",adminCode);
        return "index";
    }
    @RequestMapping("/login4.do")
    //向页面传值的第二种方式：
    //使用ModelAndView
    public ModelAndView login4(AdminParam adminParam){
        System.out.println("login4()");
        String adminCode = adminParam.getAdminCode();
//        Map<String,Object> data = new HashMap<String, Object>();
//        data.put("adminCode",adminCode);
//        ModelAndView modelAndView = new ModelAndView("index",data);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("adminCode",adminCode);
        return modelAndView;
    }
    @RequestMapping("/login5.do")
    //向页面传值的第三种方式：
    //使用ModelMap
    public String login5(AdminParam adminParam, ModelMap modelMap){
        System.out.println("login5()");
        String adminCode = adminParam.getAdminCode();
        //相当于request。setAttribute...
        modelMap.addAttribute("adminCode",adminCode);
        return "index";
    }
    @RequestMapping("/login6.do")
    //向页面传值的第四种方式：
    //使用session
    public String login6(AdminParam adminParam, HttpSession session){
        System.out.println("login6()");
        String adminCode = adminParam.getAdminCode();
        session.setAttribute("adminCode",adminCode);
        return "index";
    }


}
