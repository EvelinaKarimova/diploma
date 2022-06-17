<!DOCTYPE html>
<html lang="ru">
<head>
    <#import "header.ftlh" as header>
    <meta charset="UTF-8">
    <title>Задание</title>
    <link rel="stylesheet" type="text/css" href="../css/index_style.css"/>
    <link rel="stylesheet" type="text/css" href="../css/task.css"/>
</head>
<body>
<@header.header/>
<a href="/tasks" class="go_back"> < Назад к списку заданий</a>
<div class="task">
    <div>
        <h1>${task.getName()}</h1>
    </div>
    <div>
        <h2>${task.getDescription()}</h2>
    </div>
    <#if task.getType() == "SELECT_ONE">

        <h3>Варианты ответа:</h3>
        <form action="/answer" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            <#list task.getHints() as hint>
                <div class="answers_list">
                    <input name="ans" type="radio" value="${hint}">${hint}
                </div>
            </#list>
            <button type="submit">Отправить</button>
        </form>
    <#elseif task.getType() == "SELECT_SOME">

        <h4>Варианты ответа:</h4>
        <form action="/answer" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            <#list task.getHints() as hint>
                <div class="answers_list">
                    <input name="ans" type="checkbox" value="${hint}">${hint}
                </div>
            </#list>
            <button type="submit">Отправить</button>
        </form>
    <#elseif  task.getType() == "SEQUENCE">

        <div class="hints">
            <h4>Варианты ответа:</h4>
            <div class="answers_list">
                <#list task.getHints() as hint>
                    <p>${hint}</p>
                </#list>
            </div>
        </div>
        <form action="/answer" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            <label for="ans">Введите ответ:</label>
            <input id="ans" class="string_input" name="ans" type="text">
            <button type="submit">Отправить</button>
        </form>
    <#elseif  task.getType() == "TEXT">
        <div class="hint_image">
            <#if task.getImg_src() != "">
                <img src="${task.getImg_src()}" alt="">
            </#if>
        </div>
        <div class="hints">
            <h4>Подсказки:</h4>
            <div class="answers_list">
                <#list task.getHints() as hint>
                    <p>-${hint}</p>
                </#list>
            </div>
        </div>
        <form action="/answer" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            <div class="answers_list">
                <label for="ans">Введите ответ:</label>
                <input id="ans" class="text_input" name="ans" type="text">
            </div>
            <button type="submit">Отправить</button>
        </form>
    <#elseif  task.getType() == "STRING">

        <form action="/answer" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            <div class="answers_list">
                <label for="ans">Введите ответ:</label>
                <input id="ans" class="string_input" name="ans" type="text">
            </div>
            <button type="submit">Отправить</button>
        </form>
    </#if>
    <#if passed??>
        <h2>
            ${passed}
        </h2>
    </#if>
</div>
</body>
</html>