<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>${initParam.appName}</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link href="${pageContext.request.contextPath }/style/oa.css"
	rel="stylesheet" type="text/css">
<script language="javascript"
	src="${pageContext.request.contextPath }/script/public.js"></script>
	
<script type="text/javascript">
	function del(id,deptname,parentId){
		var dd=window.confirm('是否要删除'+deptname+'?');
		if(dd){
			var url="${pageContext.request.contextPath}/dept/delete.action?id="+id+"&parent.id="+parentId;
			location.href=url;
		}
	}
	function save(parentId){
		var url="${pageContext.request.contextPath}/dept/toadd.action?parent.id="+parentId;
		location.href=url;
	}
</script>
<title>人员管理</title>
</head>
<BODY bgColor=#dee7ff leftMargin=0 background="" topMargin=0
	marginheight="0" marginwidth="0">
	<center>
		<TABLE width="778" border=0 cellPadding=0 cellSpacing=0
			borderColor=#ffffff bgColor=#dee7ff style="FONT-SIZE: 10pt">
			<TBODY>
				<TR height=35>
					<TD align=middle width=20
						background=${pageContext.request.contextPath}/images/title_left.gif
						bgColor=#dee7ff></TD>
					<TD align=middle width=120
						background=${pageContext.request.contextPath}/images/title_left.gif
						bgColor=#dee7ff><FONT color=#f7f7f7> 人员管理<font
							color="#FFFFFF">&nbsp;</font></FONT></TD>
					<TD align=middle width=11
						background=${pageContext.request.contextPath}/images/title_middle.gif
						bgColor=#dee7ff><FONT color=#f7f7f7>&nbsp;</FONT></TD>
					<TD align=middle
						background=${pageContext.request.contextPath}/images/title_right.gif
						bgColor=#dee7ff><FONT color=#f7f7f7>&nbsp;</FONT></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE width="778" border=0 align=center cellPadding=0 cellSpacing=0
			borderColor=#ffffff style="FONT-SIZE: 10pt">
			<TBODY>
				<TR>
					<TD width="82%" height=14 align=right vAlign=center noWrap></TD>
					<TD width="18%" align=right vAlign=center noWrap>
						${sessionScope.msg }
						<s:set var="msg" scope="session" value=""></s:set>
					</TD>
				</TR>
				<TR>
					<TD height=14 align=right vAlign=center noWrap>
						<!-- 在这里插入查询表单 -->
					</TD>
					<TD height=14 align="left" vAlign=center noWrap>
						<%
							/**
							 * 在这里定义“添加”，“查询”等按钮
							 * <input type="image" name="find" value="find" src="${pageContext.request.contextPath}/images/cz.gif">
							 * &nbsp;&nbsp;&nbsp;&nbsp; 
							 * <a href="#" onClick="BeginOut('document.do?method=addInput','470')">
							 * <img src="${pageContext.request.contextPath}/images/addpic.gif" border=0 align=absMiddle style="CURSOR: hand"></a>
							 */
						%> <a href="#"
						onclick="openWin('person.do?method=addInput','addperson',600,200);">添加机构信息</a>
						<s:if test="#parent!=null">
							<s:url var="u1" action="list">
								<s:param name="parent.id" value="#parent.parent.id" />
							</s:url>
							<s:a href="%{#u1}">返回</s:a>						
						</s:if>
					</TD>
				</TR>
				<TR>
					<TD height=28 colspan="2" align=right vAlign=center noWrap
						background=${pageContext.request.contextPath}/images/list_middle.jpg>&nbsp;&nbsp;
						<!-- 可以在这里插入分页导航条 -->

					</TD>
				</TR>
			</TBODY>
		</TABLE>
		<table width="778" border="0" cellPadding="0" cellSpacing="1"
			bgcolor="#6386d6">
			<!-- 列表标题栏 -->
			<tr bgcolor="#EFF3F7" class="TableBody1">
				<td width="11%" height="37" align="center"><b>序号</b></td>
				<td width="30%" height="37" align="center"><B>机构名称</B></td>
				<td width="15%" height="37" align="center"><b>机构编号</b></td>
				<td width="28%" height="37" align="center"><b>父机构名称</b></td>
				<td width="16%" height="37" align="center"><b>相关操作</b></td>
			</tr>
			<!-- 列表数据栏 -->
			<s:if test="#deptList!=null and #deptList.size()>0">
				<s:iterator value="#deptList" status="xx">
					<tr bgcolor="#EFF3F7" class="TableBody1"
						onmouseover="this.bgColor = '#DEE7FF';"
						onmouseout="this.bgColor='#EFF3F7';">
						<td align="center" vAlign="center"><s:property
								value="#xx.count" /></td>
						<td align="center" vAlign="center"><s:if test="true==leaf">
								<s:property value="deptname" />
							</s:if> <s:else>
								<s:url var="u1" action="list">
									<s:param name="parent.id" value="id" />
								</s:url>
								<s:a href="%{#u1}">
									<s:property value="deptname" />
								</s:a>
							</s:else></td>
						<td align="center" vAlign="center"><s:property value="showId" /></td>
						<td align="center" vAlign="center"><s:property
								value="parent.deptname" /></td>
						<td align="center" vAlign="center">
							<a href="javascript:void(0);"onclick="save('<s:property value="parent.id"/>');">新增</a>
							<s:if test="true==leaf">
							<a href="javascript:void(0);" 
							onclick="del('<s:property value="id"/>','<s:property value="deptname"/>','<s:property value="parent.id"/>');">删除</a>
							</s:if>
							</td>
					</tr>
				</s:iterator>
			</s:if>
			<!-- 在列表数据为空的时候，要显示的提示信息 -->
			<s:else>
				<tr>
					<td colspan="7" align="center" bgcolor="#EFF3F7" class="TableBody1"
						onmouseover="this.bgColor = '#DEE7FF';"
						onmouseout="this.bgColor='#EFF3F7';">没有找到相应的记录</td>
				</tr>
			</s:else>
		</table>
		<TABLE width="778" border=0 align=center cellPadding=0 cellSpacing=0
			borderColor=#ffffff style="FONT-SIZE: 10pt">
			<TBODY>
				<TR>
					<TD height=28 align=right vAlign=center noWrap
						background=${pageContext.request.contextPath}/images/list_middle.jpg>&nbsp;&nbsp;
						<!-- 可以在这里插入分页导航条 --> 
						<s:if test="page!=null and page.maxPage>1">
							<s:url var="u1" action="list">
								<s:param name="pageNum" value="1" />
								<s:param name="parent.id" value="parent.id" />
							</s:url>
							<s:a href="%{#u1}">首页</s:a>
							<s:if test="page.lastPage>0">
								<s:url var="u1" action="list">
									<s:param name="pageNum" value="page.lastPage" />
									<s:param name="parent.id" value="parent.id" />
								</s:url>
								<s:a href="%{#u1}">上一页</s:a>
							</s:if>
							<s:if test="page.maxPage>=page.nextPage">
								<s:url var="u1" action="list">
									<s:param name="pageNum" value="page.nextPage" />
									<s:param name="parent.id" value="parent.id" />
								</s:url>
								<s:a href="%{#u1}">下一页</s:a>
							</s:if>
							<s:url var="u1" action="list">
								<s:param name="pageNum" value="page.maxPage" />
								<s:param name="parent.id" value="parent.id" />
							</s:url>
							<s:a href="%{#u1}">尾页</s:a>
						</s:if>
						&nbsp;&nbsp;&nbsp;
					</TD>
				</TR>
			</TBODY>
		</TABLE>
	</center>

</body>

</html>


