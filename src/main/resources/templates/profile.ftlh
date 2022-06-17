<!DOCTYPE html>
<html lang="ru">
<head>
    <#import "header.ftlh" as header>
    <title>Profile Page</title>
    <link rel="stylesheet" type="text/css" href="../css/profile_style.css">
    <link rel="stylesheet" type="text/css" href="../css/index_style.css"/>
    <meta http-equiv="Content-type" content="text/html" charset="utf-8">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
          rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Fira+Sans:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
          rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
          rel="stylesheet">
</head>
<body>
<@header.header/>
<div class="profile">
    <div class="container">

        <div class="profile__row">

            <div class="profile__avatar">
                <img src="${current_user.getProfileImage()}" width="30%" alt="">
                <div class="profile__avatar-change">
                    <a href="">Изменить изображение профиля</a>
                </div>
                <div class="profile__avatar-edit">
                    <a href="/profile-settings">Настройки профиля</a>
                </div>
            </div>

            <table class="profile__data">
                <tr>
                    <td>Логин:</td>
                    <td>${current_user.getUsername()}</td>
                </tr>
                <tr>
                    <td>Имя:</td>
                    <#if current_user.getFirstName() != "">
                        <td>${current_user.getFirstName()}</td>
                    <#else>
                        <td>Пожалуйста, укажите свое имя в настройках профиля</td>
                    </#if>

                </tr>

                <tr>
                    <td>Фамилия:</td>
                    <#if current_user.getLastName() != "">
                        <td>${current_user.getLastName()}</td>
                    <#else>
                        <td>Пожалуйста, укажите свою фамилию в настройках профиля</td>
                    </#if>
                </tr>
                <tr>
                    <td>Отчество:</td>
                    <td>${current_user.getPatronymic()}</td>
                </tr>
                <tr>
                    <td>Электронная почта:</td>
                    <#if current_user.getEmail() != "">
                        <td>${current_user.getEmail()}</td>
                    <#else>
                        <td>Пожалуйста, укажите адрес вашей электронной почты в настройках профиля</td>
                    </#if>
                </tr>

            </table>
        </div>
    </div>
</div>
</body>
</html>
