<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>error</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">

<script type="text/javascript">
</script>	
</head>
<body>
<table width="80%" height="80%" border="0"  align="center" cellpadding="0" cellspacing="0" id="errorbox">
  <tr>
    <td height="20" align="center" valign="center"  class="errortitle"><span><strong><br>
      <img align="ABSMIDDLE" src="resource/images/errorpic.gif">&nbsp;&nbsp;出 错  提 示 </strong></span> </td>
  </tr>
  <tr>
    <td height="1" width="100%" valign="top" bgcolor="#98C3ED"></td>
  </tr>
  <tr>
    <td>
		<br/>
	   <table width="100%"  border="0" cellpadding="0" cellspacing="0">
        <tr >
          <td width="92%" class="errortitle2">错误内容：</td>
        </tr>
        <tr align="left">
          <td  class="errorbgcolor"><h3 style="color:red">
              <s:property value="%{getText(exception.message)}"/>
            </h3></td>
            
        </tr>
        <tr>
          <td  class="errorbgpic" valign="bottom">
              
            <p class="tpurple">&nbsp;&nbsp;如果要查看详细的错误信息， 
			   <a href="javascript:showErrorMsg()">请单击此处</a>&nbsp;&nbsp;			   
			</p>
            <br>
			</td>
        </tr>
		<tr>
		  <td id="showErrorMsgDiv" style="visibility:hidden">
				<div id="errorMsg">
				<textarea rows="30" cols="120" readonly="true">
				<s:property value="exceptionStack" />
				</textarea>
			</div>
		  </td>
		</tr>
      </table>
	  
	  </td>
  </tr>
</table>
<script language="javascript">
function showErrorMsg(){
  var showErrorMsgDiv = document.getElementById("showErrorMsgDiv");  
  if (showErrorMsgDiv.style.visibility == "hidden"){
  	showErrorMsgDiv.style.visibility="";
  }else{
  	showErrorMsgDiv.style.visibility="hidden";
  }  
}
</script>
</body>
</html>
