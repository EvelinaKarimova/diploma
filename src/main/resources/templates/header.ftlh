<#macro header>
    <header>
        <div class="menu">
            <#if authentication??>
                <ul class="menu__list">
                    <#if active_menu_attr == "main">
                        <li class="menu__element menu__element_active"><a href="/main-page">Главная</a></li>
                    <#else>
                        <li class="menu__element"><a href="/main-page">Главная</a></li>
                    </#if>

                    <#if (active_menu_attr == "profile") || (active_menu_attr == "tasks")>
                    <li class="menu__element menu__element_pages"><a href="">Личный кабинет</a>
                    <#else>
                    <li class="menu__element "><a href="">Личный кабинет</a>
                    </#if>
                        <ul class="pages-list">
                                <li class="pages-list__element"><a href="/profile">Профиль</a></li>
                                <li class="pages-list__element"><a href="/tasks">Задания</a></li>
                        </ul>
                    </li>
                    <li class="menu__element_exit"><a href="/logout">Выход</a></li>
                </ul>
            <#else>
                <ul class="menu__list">
                    <#if active_menu_attr == "main">
                        <li class="menu__element menu__element_active"><a href="/main-page">Главная</a></li>
                    <#else>
                        <li class="menu__element"><a href="/main-page">Главная</a></li>
                    </#if>
                    <#if active_menu_attr == "login">
                        <li class="menu__element menu__element_active"><a href="/login">Вход</a></li>
                    <#else>
                        <li class="menu__element"><a href="/login">Вход</a></li>
                    </#if>
                    <#if active_menu_attr == "signup">
                        <li class="menu__element menu__element_active"><a href="/signup">Регистрация</a></li>
                    <#else>
                        <li class="menu__element"><a href="/signup">Регистрация</a></li>
                    </#if>
                </ul>
            </#if>
        </div>
    </header>
</#macro>