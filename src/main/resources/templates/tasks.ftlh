<!DOCTYPE html>
<html lang="ru">
<head>
    <#import "header.ftlh" as header>
    <meta charset="UTF-8">
    <title>Список заданий</title>
    <link rel="stylesheet" type="text/css" href="../css/index_style.css"/>
</head>
<body>
<@header.header/>
<div class="tasks_list">
    <div class="page_name">
        <h2>Список доступных заданий</h2>
    </div>
    <div>
        <#list blocks as block>
            <div>
                <h2>${block.getName()}</h2>
                <h3>${block.getDescription()}</h3>
            </div>
            <#list block.getTasks() as t>
                <div class="tasks_table">
                    <table cellspacing="20px">
                        <tr>
                            <td width="150px">${t.name}</td>
                            <td width="600px">${t.description}</td>
                            <td>
                                <form action="/select-task/${t.id}">
                                    <button type="submit">Выбрать</button>
                                </form>
                            </td>
                        </tr>
                    </table>
                </div>
            </#list>
        </#list>
    </div>
</div>
</body>
<footer>

</footer>
</html>