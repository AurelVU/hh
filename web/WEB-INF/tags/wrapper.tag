<%@tag description="Simple Wrapper Tag" language="java" pageEncoding="UTF-8"%>

<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<body>
<div class="container">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="/">Биржа труда</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link ${joboffer}" href="/joboffer">Вакансии<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link ${jobapplication}" href="/jobapplication">Услуги</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link ${employer}" href="/employer">Работодатели</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link ${users}" href="/users">Работники</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link ${employment}" href="/employment">Трудоустройства</a>
                </li>
            </ul>
        </div>
        <%
            HttpSession mysession = request.getSession();
            if (mysession.getAttribute("login") == null) { %>
                <button type="button" onclick="location.href = '/registr'" class="btn btn-outline-primary ml-1">Регистрация</button>
                <button type="button" onclick="location.href = '/login'" class="btn btn-outline-primary ml-1">Войти</button>
        <%
            } else {
        %>
        <button type="button" onclick="location.href = '/exit'" class="btn btn-outline-secondary ml-1">Выйти</button>
        <button type="button" class="btn btn-outline-primary ml-1" onclick="location.href = '/personalarea'">Личный кабинет</button>
        <% }%>
    </nav>
    <jsp:doBody/>
</div>

</body></html>