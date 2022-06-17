<!DOCTYPE html>
<html lang="ru">
<head>
    <#import "header.ftlh" as header>
    <meta charset="UTF-8">
    <title>Регистрация</title>

    <meta http-equiv="Content-type" content="text/html" charset="utf-8"/>

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
            <form action="/signup" method="post" class="sign-up__form form">
                <h1 class="form__title title">Добро пожаловать!</h1>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                <div class="form__input">
                    <label for="username">Логин:</label>
                    <input type="text" name="username"/>
                </div>
                <div class="form__input">
                    <label for="firstName">Имя:</label>
                    <input type="text" name="firstName"/>
                    <!--@spring.formInput "userForm.firstname" "placeholder='Firstname'"/>
                    <!@spring.showErrors "<br>" "error"/-->
                </div>
                <div class="form__input">
                    <label for="lastName">Фамилия:</label>
                    <input type="text" name="lastName"/>
                    <!--@spring.formInput "userForm.lastname" "placeholder='Lastname'"/>
                    <!@spring.showErrors "<br>" "error"/-->
                </div>
                <!--#if namesErrorMessage??-->
                <!--p class="errorMessage">{namesErrorMessage}</p-->
                <!--/#if-->
                <div class="form__input">
                    <label for="patronymic">Отчество:</label>
                    <input type="text" name="patronymic"/>
                </div>
                <div class="form__input">
                    <label for="email">Электронная почта:</label>
                    <input type="email" name="email"/>
                    <!--@spring.formInput "userForm.email" "placeholder='Email'"/>
                    <1@spring.showErrors "<br>" "error"/-->
                </div>
                <div class="form__input">
                    <label for="password">Пароль:</label>
                    <input type="password" name="password"/>
                    <!--@spring.formPasswordInput "userForm.password" "placeholder='Password'"/>
                    <-@spring.showErrors "<br>" "error"/-->
                </div>
                <div class="form__input">
                    <label for="passwordRep">Повторите пароль:</label>
                    <input type="password" name="passwordRep"/>
                    <!--@spring.formPasswordInput "userForm.passwordRep" "placeholder='Password repeat'"/>
                    <-@spring.showErrors "<br>" "error"/-->
                </div>
                <!--#if passwordMatchErrorMessage??-->
                <!--p class="passwordMatchErrorMessage">{passwordMatchErrorMessage}</p-->
                <!--/#if-->
                <div class="form__input">
                    <button type="submit">Зарегистрироваться</button>
                </div>
            </form>
            <p class="sign-up__hint">Уже есть аккаунт? <a href="/login">Войти</a></p>
        </div>
    </div>
</div>
</body>
</html>
