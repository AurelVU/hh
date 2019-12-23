<%@ page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>

    <table>
        <thead class="thead-inverse">
        <tr><th>ID</th><th>Логин</th><th>Рейтинг</th><th>Работодатели</th><th>Опыт работы</th></tr>
        </thead>
            ${cont}
    </table>
</t:wrapper>