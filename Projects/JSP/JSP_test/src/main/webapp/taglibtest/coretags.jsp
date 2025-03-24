<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<c:set var="Amount" value="786.970" />

    <fmt:parseNumber var="j" type="number" value="${Amount}" />
    <p><i>Amount is:</i>  <c:out value="${j}" /></p>

    <fmt:parseNumber var="j" integerOnly="true" type="number" value="${Amount}" />
    <p><i>Amount is:</i>  <c:out value="${j}" /></p>