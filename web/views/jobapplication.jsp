<%@ page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>

    <table>
        <thead class="thead-inverse">
        <tr><th>ID</th><th>Тип услуги</th><th>ID работника</th><th>Время начала работы</th><th>Время окончания работы</th><th>Оплата</th><th>Дата размещения</th></tr>
        </thead>
            ${cont}
    </table>
</t:wrapper>