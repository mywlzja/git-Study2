<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>${initParam.appName}</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
</HEAD>

<FRAMESET cols="130,*" frameborder=yes bordercolor=silver>
	<FRAME SRC="${pageContext.request.contextPath}/admin/outlook.action" NAME="Links" SCROLLING="No">
	<FRAME SRC="${pageContext.request.contextPath}/dept/list.action" NAME="main" SCROLLING="AUTO">
</FRAMESET>

<NOFRAMES>
	<BODY>
	</BODY>

</NOFRAMES>

</HTML>


