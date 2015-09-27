<%@ include file="/WEB-INF/views/includes/common.jsp" %>
<html>
<head>
    <%-- Page title --%>
    <c:set var="titleKey"><tiles:insertAttribute name="title"/></c:set>
    <title><fmt:message key="${titleKey}"/></title>

    <%-- Bootstrap CSS --%>
    <c:url var="bootstrapCss" value="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${bootstrapCss}" type="text/css"/>
    <c:url var="bootstrapThemeCss" value="css/bootstrap-theme.min.csss"/>
    <link rel="stylesheet" href="${bootstrapThemeCss}" type="text/css"/>


    <%-- Application CSS --%>
    <c:url var="defaultCssUrl" value="/css/default.css"/>
    <link rel="stylesheet" href="${defaultCssUrl}" type="text/css"/>

    <%-- jQuery --%>
    <c:url var="jquery" value="js/jquery-2.1.4.min.js"/>
    <script src="${jquery}"></script>

    <%-- Bootstrap JavaScript --%>
    <c:url var="bootstrapJs" value="js/bootstrap.min.js"/>
    <script src="${bootstrapJs}"></script>

</head>
<body>
<%-- Header --%>
<tiles:insertAttribute name="header"/>
<%-- Body content --%>
<tiles:insertAttribute name="body"/>
<%-- Footer --%>
<tiles:insertAttribute name="footer"/>
</body>
</html>