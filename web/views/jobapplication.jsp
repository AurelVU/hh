<%@ page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>

    ${button}

    <p>
        <a class="btn btn-primary  ml-1 mt-1" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
            Поиск по параметрам
        </a>
    </p>
    <div class="collapse" id="collapseExample">
        <div class="card card-body">
            <form action="/jobapplication">
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="basic-addon3">ID создателя</span>
                    </div>
                    <input type="text" class="form-control" name="userId" id="basic-url" aria-describedby="basic-addon3">
                </div>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="basic-addon">Минимальная дата начала работы</span>
                    </div>
                    <input type="date" class="form-control" id="mindatestart" name="minDesiredStartTime" placeholder="Минимальная дата начала работы" required>
                </div>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="basic-addon1">Максимальная дата начала работы</span>
                    </div>
                    <input type="date" class="form-control" id="maxDateStart" name="maxDesiredStartTime" placeholder="Максимальная дата начала работы" required>
                </div>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="basic-addon2">Минимальная дата окончания работы</span>
                    </div>
                    <input type="date" class="form-control" id="mindatefinish" name="minDesiredFinishTime" placeholder="Минимальная дата окончания работы" required>
                </div>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="basic-addon4">Максимальная дата окончания работы</span>
                    </div>
                    <input type="date" class="form-control" id="maxdatefinish" name="maxDesiredFinishTime" placeholder="Максимальная дата окончания работы" required>
                </div>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="basic-addon5">Минимальная оплата</span>
                    </div>
                    <input class="form-control" type="text" name="minDesiredWage" id="mindesiredWage" >
                </div>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="basic-addon6">Максимальная оплата</span>
                    </div>
                    <input class="form-control" type="text" name="maxDesiredWage" id="maxdesiredWage" >
                </div>
                <button class="btn btn-dark" type="submit">Найти</button>
            </form>
        </div>
    </div>



    <table>
        <thead class="thead-inverse">
        <tr><th>ID</th><th>Тип услуги</th><th>ID работника</th><th>Время начала работы</th><th>Время окончания работы</th><th>Оплата</th><th>Дата размещения</th></tr>
        </thead>
            ${cont}
    </table>
</t:wrapper>