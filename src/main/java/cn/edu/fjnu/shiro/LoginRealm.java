package cn.edu.fjnu.shiro;


import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import cn.edu.fjnu.dao.IManagerDao;
import cn.edu.fjnu.entity.Manager;



public class LoginRealm extends AuthorizingRealm {

	@Resource
	public IManagerDao managerDao;

	@Override
	public void setName(String name) {
		super.setName("LoginRealm");
	}
	
	//清除缓存。在service修改权限后调用
	public void clearCached(){
		PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
		super.clearCache(principals);
	}
	
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		System.out.println("我进来了manager认证。。。。。。");
		String id = (String) token.getPrincipal();
		System.out.println(id);
		if(id==null)return null;
		Manager manager = managerDao.getManagerById(id);
		System.out.println(manager.toString()+1);
		if(manager==null)return null;
		
		String password = manager.getMd5Password();
		String salt = manager.getSalt();
		
		//把密码的信息删除
		manager.setMd5Password("");
		manager.setSalt("");
		
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
				manager, password,ByteSource.Util.bytes(salt), this.getName());
		
		System.out.println("结束认证。。。");
		return simpleAuthenticationInfo;
	}

	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("我进入到了staff授权认证");
		
		//得到身份信息。需跟登录验证类型一致
		Manager manager = new Manager();
		try {
			manager = (Manager) principals.getPrimaryPrincipal();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println("授权认证:"+ manager.getId());
			
		//添加登录授权的身份
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

		Set<String> permissions = new HashSet<String>();
		String[] StringPermission = manager.getPermission().split("-");
		for(int i=0;i<StringPermission.length;i++){
			permissions.add(StringPermission[i]);
		}
		
		simpleAuthorizationInfo.addStringPermissions(permissions);
//		simpleAuthorizationInfo.addStringPermission("1");
		System.out.println("结束授权认证");
		return simpleAuthorizationInfo;

	}

}

