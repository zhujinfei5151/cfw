<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
</script>
<title>用户登陆</title>
</head>
<body>
	<img class="yzm_img" align="middle" id="validateImage" src="../../../../img/checkcode_init.action" width="150" height="40" onclick="this.src='../../../../../img/checkcode_init.action?time-'+(new Date()).getTime();"/>
	<s:textfield name="validateCode"  id="validateCode" cssClass="yzm_input"></s:textfield>
	<div class="text_left t1">
		<p class="t1">
			<span id="vcodeValidMsg">请输入图片中的四个字母。</span>
			<a href="javascript:;" onclick="document.getElementById('validateImage').src='../../../../img/checkcode_init.action?time-'+(new Date()).getTime();">看不清，再换一张</a>
		</p>
		<span id="numberInfo" style="color:red">
			<s:property value="errors['validateCode']"/>&nbsp;
		</span>
	</div>
</body>
</html>