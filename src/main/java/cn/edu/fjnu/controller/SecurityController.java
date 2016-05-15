package cn.edu.fjnu.controller;



import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import cn.edu.fjnu.shiro.LoginRealm;






@Controller
@RequestMapping("SecurityVerification")
public class SecurityController {

	@Resource
	public LoginRealm loginRealm;
	
	
	@RequestMapping("login")
	public String Shriologin (HttpServletRequest request) throws Exception{

		System.out.println("我进入登录的方法了");
		//取得登录的用户信息。如果已经登录跳到对应的首页
//		Staff staff = (Staff)request.getSession().getAttribute("staff");
//		System.out.println(staff);
//		if(staff!=null){
//			if(staff.getRole()=="1"){
//				return LoginFormAuthenticationFilter.StaffJsp;
//			}
//			if(staff.getRole()=="2"){
//				return LoginFormAuthenticationFilter.MangerJsp;
//			}
//			if(staff.getRole()=="3"){
//				return LoginFormAuthenticationFilter.SuerpMangerJsp;
//			}
//		}
		String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
//		System.out.println("错误类型："+exceptionClassName);
//		System.out.println(request.getAttribute("username"));
		if(exceptionClassName!=null){
			if(UnknownAccountException.class.getName().equals(exceptionClassName)
					||IncorrectCredentialsException.class.getName().equals(exceptionClassName)||
					"roleError".equals(exceptionClassName)){
				request.setAttribute("msg", "用户名密码错误");
			}else if("randomCodeError".equals(exceptionClassName)){
				request.setAttribute("msg", "验证码错误");
			}else if("disabledAccount".equals(exceptionClassName)||
					DisabledAccountException.class.getName().equals(exceptionClassName)){
				request.setAttribute("msg", "此账号已经被禁止使用");
			}else{
				request.setAttribute("msg", "未知错误");
			}
		}
		//此方法不处理登录成功
		//失败返回登录页面
		return "base/login";
	}
	
	//踢人
	@RequestMapping("kick")
	public String kick(){
		return "kick";
	}
	
	
	@RequestMapping("dept")
	public String dept(){
		return "base/dept";
	}
	@RequestMapping("intype")
	public String intype(){
		return "base/intype";
	}
	@RequestMapping("itemsort")
	public String itemsort(){
		return "base/itemsort";
	}
	@RequestMapping("outtype")
	public String outtype(){
		return "base/outtype";
	}
	@RequestMapping("right_down")
	public String right_down(){
		return "base/right_down";
	}
	@RequestMapping("top")
	public String top(){
		return "base/top";
	}
	@RequestMapping("suptype")
	public String suptype(){
		return "base/suptype";
	}
	@RequestMapping("main")
	public String main(){
		return "base/main";
	}
	@RequestMapping("right_top")
	public String right_top(){
		return "base/right_top";
	}
	
	@RequestMapping("left")
	public String left(){
		return "base/left";
	}
	@RequestMapping("manager")
	public String manager(){
		return "base/manager";
	}
	
	

	


}
