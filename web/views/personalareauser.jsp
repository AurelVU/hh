<%@ page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>

    <form action="/personalarea" method="post">
        <div class="form-group row">
            <label for="role" class="col-sm-2 col-form-label">Роль</label>
            <label id="role" class="col-sm-2 col-form-label">${role}</label>
        </div>
        <div class="form-group row">
            <label for="id" class="col-sm-2 col-form-label">ID</label>
            <label id="id" class="col-sm-2 col-form-label">${id}</label>
        </div>
        <div class="form-group row">
            <label for="login" class="col-sm-2 col-form-label">Логин</label>
            <label id="login" class="col-sm-2 col-form-label">${login}</label>
        </div>
        <div class="form-group row">
            <label for="inputPassword" class="col-sm-2 col-form-label">Пароль</label>
            <div class="col-sm-10">
                <input type="password" name="password" class="form-control" id="inputPassword">
            </div>
        </div>
        <div class="form-group row">
            <label for="textarea" class="col-sm-2 col-form-label">Работодатели</label>
            <textarea class="form-control" name="aboutEmployee" id="textarea" required>${aboutEmployee}</textarea>
        </div>
        <div class="form-group row">
            <label for="textarea2" class="col-sm-2 col-form-label">Направление работы</label>
            <textarea class="form-control" name="lineActivity" id="textarea2" required>${lineActivity}</textarea>
        </div>
        <button class="btn btn-dark" type="submit">Изменить данные</button>
    </form>
</t:wrapper>