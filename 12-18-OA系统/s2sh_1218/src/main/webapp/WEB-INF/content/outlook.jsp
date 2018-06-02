<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>${initParam.appName}</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<STYLE>
div {
	position: absolute;
}
</STYLE>

<script language="JavaScript"
	src="${pageContext.request.contextPath}/jslib/crossbrowser.js"
	type="text/javascript">
	
</script>
<script language="JavaScript"
	src="${pageContext.request.contextPath}/jslib/outlook.js"
	type="text/javascript">
	
</script>

<SCRIPT>
	var o = new createOutlookBar('Bar', 0, 0, screenSize.width,
			screenSize.height, '#606060', 'white');
	var p;
	p = new createPanel('al', '组织机构');
	p.addButton('${pageContext.request.contextPath}/images/netm.gif', '机构管理',
			'parent.main.location="${pageContext.request.contextPath}/dept/list.action"');
	p.addButton('${pageContext.request.contextPath}/images/news.gif', '人员管理',
			'alert("News")');
	o.addPanel(p);

	p = new createPanel('p', '权限管理');
	p.addButton('${pageContext.request.contextPath}/images/mail.gif', 'Mail 2',
			'alert("Mail2")');
	p.addButton('${pageContext.request.contextPath}/images/peditor.gif',
			'Personal<BR>Editor', 'alert("Personal Editor")');
	p.addButton('${pageContext.request.contextPath}/images/word.gif',
			'Projekte', 'alert("Projekte")');
	o.addPanel(p);
	o.draw(); //draw the OutlookBar
	function resize_op5() {
		if (bt.op5) {
			o.showPanel(o.aktPanel);
			var s = new createPageSize();
			if ((screenSize.width != s.width)
					|| (screenSize.height != s.height)) {
				screenSize = new createPageSize();
				setTimeout("o.resize(0,0,screenSize.width,screenSize.height)",
						100);
			}
			setTimeout("resize_op5()", 100);
		}
	}
	function myOnResize() {
		if (bt.ie4 || bt.ie5 || bt.ns5) {
			var s = new createPageSize();
			o.resize(0, 0, s.width, s.height);
		} else if (bt.ns4)
			location.reload();
	}
</SCRIPT>

</head>
<body onLoad="resize_op5();" onResize="myOnResize();">
</body>
</html>




