package com.cy.student.modules.utils;

import com.cy.student.modules.config.SystemConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Controller公共组件
 */
public abstract class AbstractController {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private com.cy.student.modules.config.SystemConfig SystemConfig;

//	/**
//	 * 获取当前登录用户信息
//	 * @return
//	 */
//	protected SysUserEntity getUser() {
//		return (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
//	}
//
//	/**
//	 * 获取当前登录用户ID
//	 * @return
//	 */
//	protected String getUserId() {
//		return getUser().getUserId();
//	}
//	/**
//	 * 获取当前登录用户ID
//	 * @return
//	 */
//	protected String getId() {
//		return getUser().getId().toString();
//	}
//	/**
//	 * 获取当前登录用户账号
//	 * @return
//	 */
//	protected String getUserName() {
//		return getUser().getUsername();
//	}	/**
//	 * 获取当前登录用户账号姓名
//	 * @return
//	 */
//	protected String getPersonName() {
//
//		return getUser().getPersonName();
//	}
//
//	/**
//	 * 获取用户当前登录部门
//	 * @return
//	 */
//	protected String getUserDept(){
//		return GlobalVariable.USER_DEPT.get(getUserId());
//	}
//
//	/**
//	 * 获取用户当前登录岗位
//	 * @return
//	 */
//	protected Integer getUserQuarters(){
//		return GlobalVariable.USER_QUARTERS.get(getUserId());
//	}
//
//	/**
//	 * 设置用户当前登录岗位
//	 * @return
//	 */
//	protected void setUserQuarters(Integer quartersid ,String userId){
//
//		GlobalVariable.USER_QUARTERS.put( userId ,quartersid);
//	}
//
//	/**
//	 * 设置用户当前登录部门
//	 * @return
//	 */
//	protected void setUserDept(String deptid ,String userId){
//		GlobalVariable.USER_DEPT.put( userId , deptid );
//	}
//
//
//	public R validParam(BindingResult bindingResult){
//		List<ObjectError> list = bindingResult.getAllErrors();
//		List<String> errors = new ArrayList<>();
//		for (ObjectError error : list) {
//			errors.add(error.getDefaultMessage());
//		}
//		return R.error().put("errors",errors);
//	}
//
//
//	protected  PageUtils getpage(Map<String, Object> params){
//		PageUtils PageUtils=null;
//		try{
//			Object page = params.get("currentpagecount");
//			PageUtils=new PageUtils();
//			PageUtils.setCurrPage(Integer.valueOf(page.toString()));
//			PageUtils.setPageSize(Integer.valueOf(SystemConfig.getPagenumber()));
//		}catch (Exception e){
//			e.printStackTrace();
//			return null;
//		}
//		return PageUtils;
//	}


	protected HttpSession getSession(){
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		return request.getSession();
	}


	/**
	 * 获取前端参数 get
	 * @return
	 */
	protected Map<String,Object> GetParameterValues(){
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		try {
			Map<String,Object> stringMap=new HashMap<>();
			Enumeration<String> names = request.getParameterNames();
			while(names.hasMoreElements()) {
				//获取每一个文本域的name
				String name = names.nextElement();
				//根据name获得参数的值
				//为了保证获取到所有的值  因为表单可能是单值  也可能是多值
				String[] values = request.getParameterValues(name);
				//输出参数名和参数值
				if(values!=null && values.length>=1){
					if(values.length>1){
						stringMap.put(name,values);
					}else {
						stringMap.put(name,values[0]);
					}
				}
			}
			return stringMap;
		}catch (Exception e){
			e.printStackTrace();
			return new HashMap<>();
		}
	}


	protected void ajaxRequestTable(HttpServletResponse response, PageUtils page ) throws IOException {
		response.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		writer.print(ConvertJson.ToJson(page.getRows(),page.getTotal()));
		writer.flush();
		writer.close();
	}

	protected void ajaxRequest(HttpServletResponse response, String request) throws IOException {
		response.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		writer.print(request);
		writer.flush();
		writer.close();
	}

}
