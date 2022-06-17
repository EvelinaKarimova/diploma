<!DOCTYPE html>
<html lang="ru">
<head>
    <#import "header.ftlh" as header>
    <meta charset="UTF-8">
    <!--meta name="_csrf" th:content="${_csrf.token}"/-->
    <title>Войти</title>

    <!--meta http-equiv="Content-type" content="text/html" charset="utf-8"/-->

    <link rel="preconnect" href="https://fonts.googleapis.com"/>
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin/>
    <link
            href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
            rel="stylesheet"
    />

    <link rel="stylesheet" href="../css/style.css"/>
    <link rel="stylesheet" type="text/css" href="../css/index_style.css"/>
</head>

<body>
<@header.header/>
<div class="wrapper">
    <div class="wrapper__form">
        <div class="sign-up">
            <h1 class="form__title title">Рады видеть вас!</h1>
            <form action="/login" method="post" class="sign-up__form form">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                <div class="form__input">
                <label for="username">Логин:</label>
                <input type="text" id="username" name="username" autofocus="autofocus" /> <br />
                </div>
                <div class="form__input">
                <label for="password">Пароль:</label>
                <input type="password" id="password" name="password" /> <br />
                </div>
                <div class="checkbox">
                    <input id="remember-me" type="checkbox" name="remember-me"> Запомнить меня
                </div>
                <div class="form__input">
                    <button type="submit">Войти</button>
                </div>
            </form>
            <p class="sign-up__hint">Нет аккаунта? <a href="/signup">Зарегистрироваться</a></p>
        </div>
    </div>
</div>
</body>
</html>
