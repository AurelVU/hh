<%@ page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    <form action="/addjoboffer" method="post">
        <div class="form-group row">
            <label for="datestart" class="col-sm-2 col-form-label">Дата начала работы</label>
            <input type="date" class="form-control" id="datestart" name="desiredStartTime" placeholder="Дата начала работы" required>
        </div>
        <div class="form-group row">
            <label for="datefinish" class="col-sm-2 col-form-label">Дата окончания работы</label>
            <input type="date" class="form-control" id="datefinish" name="desiredFinishTime" placeholder="Дата начала работы" required>
        </div>
        <div class="form-group row">
            <label for="desiredWage" class="col-sm-2 col-form-label">Оплата</label>
            <input class="form-control" type="text" name="desiredWage" id="desiredWage" >
        </div>
        <div class="form-group row">
            <label for="requirements" class="col-sm-2 col-form-label">Требования</label>
            <textarea class="form-control" id="requirements" name="requirements" required></textarea>
        </div>
        <div class="form-group row">
            <label for="other" class="col-sm-2 col-form-label">Прочее</label>
            <textarea class="form-control" id="other" name="other" required></textarea>
        </div>
        <button class="btn btn-dark" type="submit">Создать</button>
    </form>
</t:wrapper>