<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <c:import url="RE_Header.jsp"/>
</head>
<body>
<c:import url="RE_MenuBanner.jsp"/>

<br>

<center>
<div class="jumbotron">

    <h1>How about "${name}" ?</h1>
    <%--<p class="lead">Select your module from the Nav bar above.</p>--%>
    <p class="lead">"${text}"</p>
    <p class="lead">Ratings: ${ratings}</p>

    <br>

    <p> <a class="btn btn-primary btn-lg" href="lunch" role="button">Not impressed? Spin me!</a> </p>
    <p> <a class="btn btn-primary btn-lg" href="${url}" role="button">or Go to ${url}</a> </p>

    <c:set var="origin" scope="session" value="1+Meridian+Boulevard,+Reading,+PA"/>
    <%--<c:set var="dest" scope="session" value="2725+Meridian+Blvd+Wyomissing,+PA+19610"/>--%>
    <c:set var="dest" scope="session" value="${url}"/>
    <c:set var="mode" scope="session" value="directions"/>
    <c:set var="maptype" scope="session" value="satellite"/>
    <c:set var="screenWidth" scope="session" value="${document.documentElement.clientWidth}"/>
    <c:set var="screenHeight" scope="session" value="${document.documentElement.clientHeight}"/>

</div>
    <div>
        <%--<iframe width="500" height="200" frameborder="1" style="border:1" src="https://www.google.com/maps/embed/v1/place?key=AIzaSyAzkPixJ63ho41tYBMET9D0Z-a8HQCK9RY&q=Railroad+House,Reading+PA"/>--%>
        <%--<iframe width="500" height="200" frameborder="1" style="border:1" src="https://www.google.com/maps/embed/v1/directions?key=AIzaSyAzkPixJ63ho41tYBMET9D0Z-a8HQCK9RY&origin=Oslo+Norway&destination=Telemark+Norway&avoid=tolls|highways"/>--%>
        <%--<iframe width="800" height="600" frameborder="0" style="border:0" src="https://www.google.com/maps/embed/v1/directions?key=AIzaSyAzkPixJ63ho41tYBMET9D0Z-a8HQCK9RY&origin=${origin}&destination=${dest}&mode=driving"/>--%>
            <iframe width="800" height="600" frameborder="0" style="border:0" src="https://www.google.com/maps/embed/v1/${mode}?key=AIzaSyAzkPixJ63ho41tYBMET9D0Z-a8HQCK9RY&origin=${origin}&destination=${dest}&mode=driving&maptype=${maptype}"/>
            <%--<iframe width="${screenWidth}" height="${screenHeight}" frameborder="0" style="border:0" src="https://www.google.com/maps/embed/v1/${mode}?key=AIzaSyAzkPixJ63ho41tYBMET9D0Z-a8HQCK9RY&origin=${origin}&destination=${dest}&mode=driving&maptype=${maptype}"/>--%>
            <p> <a class="btn btn-primary btn-lg" href="lunch" role="button">Don't like it? Spin me!</a> </p>
    </div>
    <br>
    <br>
    <br>
    <br>





<%--<iframe src="https://www.google.com/maps/embed/v1/place?key=AIzaSyAzkPixJ63ho41tYBMET9D0Z-a8HQCK9RY&q=Fisht+Olympic+Stadium,Sochi+Russia"/>--%>
<%--<div>--%>
<%--</div>--%>
</center>

<c:import url="RE_FooterForLoadFaster.jsp"/>
</body>
</html>