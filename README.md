# Проект автоматизации веб-сайта <a target="_blank" href="https://todoist.com/">todoist.com</a>

*Todoist – популярный таск-менеджер и приложение для ведения списка дел, которому доверяют 30 млн человек и команд во всем мире.*

<p align="center">
  <img src="images/screens/Todoist.png" alt="job" width="800">
</p>

## :notebook:	Содержание

>  :heavy_check_mark: [Технологии и инструменты](#computer-технологии-и-инструменты)
>
>  :heavy_check_mark: [Тестовые проверки API](#clipboard-тестовые-проверки-api)
>
>  :heavy_check_mark: [Запуск тестов из терминала](#computer-запуск-тестов-из-терминала)
>
>  :heavy_check_mark: [Запуск тестов в Jenkins](#computer-запуск-тестов-в-jenkins)
>
>  :heavy_check_mark: [Отчет о результатах тестирования в Allure Report](#-отчет-о-результатах-тестирования-в-allure-report)
>
>  :heavy_check_mark: [Отчет о результатах тестирования в Allure TestOps](#-отчет-о-результатах-тестирования-в-allure-testops)
>
>  :heavy_check_mark: [Интеграция с Allure TestOps](#-интеграция-с-allure-testops)
>
>  :heavy_check_mark: [Уведомления в Telegram с использованием бота Allure Notification](#-уведомления-в-telegram-с-использованием-бота-allure-notification)
>
>  :heavy_check_mark: [Пример визуального отображения работы API тестов в GUI](#-пример-визуального-отображения-работы-api-тестов-в-gui)

## :computer: Технологии и инструменты

<p  align="center"

<code><img width="5%" title="IntelliJ IDEA" src="images/logo/Idea.svg"></code>
<code><img width="5%" title="Java" src="images/logo/Java.svg"></code>
<code><img width="5%" title="Java" src="images/logo/RestAssured.svg"></code>
<code><img width="5%" title="Gradle" src="images/logo/Gradle.svg"></code>
<code><img width="5%" title="Junit5" src="images/logo/Junit5.svg"></code>
<code><img width="5%" title="GitHub" src="images/logo/GitHub.svg"></code>
<code><img width="5%" title="Allure Report" src="images/logo/Allure.svg"></code>
<code><img width="5%" title="Allure TestOps" src="images/logo/Allure_TO.svg"></code>
<code><img width="5%" title="Jenkins" src="images/logo/Jenkins.svg"></code>
<code><img width="5%" title="Telegram" src="images/logo/Telegram.svg"></code>
</p>

> *В данном проекте API-автотесты написаны на <code><strong>*Java*</strong></code> с использованием инструмента тестирования <code><strong>*REST Assured*</strong></code>.*
>
>*Для сборки проекта используется <code><strong>*Gradle*</strong></code>.*
>
>*В качестве фреймворка для тестирования выбран <code><strong>*JUnit 5*</strong></code>.*
>
>*Запуск тестов выполняется с помощью CI <code><strong>*Jenkins*</strong></code>.*
>
>*<code><strong>*Allure Report, Allure TestOps, Telegram Bot*</strong></code> используются для визуализации результатов тестирования.*

## :clipboard: Тестовые проверки API
>- [x] *Создание нового проекта*
>- [x] *Обновление проекта*
>- [x] *Создание новой задачи в проекте*
>- [x] *Создание большого количества задач в проекте и выборочное удаление задачи*
>- [x] *Закрытие задачи и ее переоткрытие*

## :computer: Запуск тестов из терминала

### Локальный запуск тестов

*Пример конфигурационного файла для локального запуска из терминала находится в resourse/config/credentional_example.properties*

```bash
./gradlew clean test
```

### Параметры в конфигурационном файле

> <code>TOKEN_ACCOUNT</code> – токен аккаунта на сайте для авторизации.
>
> <code>URL_WEB_SITE</code> – URL сайта для проведения тестирования (_по умолчанию - <code>todoist.com</code>_).
>
> <code>RESPONSE_TIME</code> – проверяемое время ответа на запрос в "мс" (_по умолчанию - <code>4000</code>_).
>
> <code>TASK</code> – название таски для запуска (_по умолчанию - <code>test</code>_).

## <img width="4%" title="Jenkins" src="images/logo/Jenkins.svg"> Запуск тестов в [Jenkins]([https://jenkins.autotests.cloud/job/todoist_API_test/](https://jenkins.autotests.cloud/job/todoist_API_test/))
*Для запуска сборки необходимо указать значения параметров и нажать кнопку <code><strong>*Собрать*</strong></code>.*

<p align="center">
  <img src="images/screens/JenkinsJob2.png" alt="job" width="800">
</p>

*После выполнения сборки, в блоке <code><strong>*История сборок*</strong></code> напротив номера сборки появятся
значки <img width="2%" title="Allure Report" src="images/logo/Allure.svg"><code><strong>*Allure
Report*</strong></code> и <img width="2%" title="Allure TestOps" src="images/logo/Allure_TO.svg"><code><strong>*Allure
TestOps*</strong></code>, кликнув по которым, откроется страница с сформированным html-отчетом.*

<p align="center">
  <img src="images/screens/JenkinsJob3.png" alt="job" width="1000">
</p>

## <img width="4%" title="Allure Report" src="images/logo/Allure.svg"> Отчет о результатах тестирования в [Allure Report](https://jenkins.autotests.cloud/job/todoist_API_test/allure/)

## <img width="4%" title="Allure Report" src="images/logo/Allure_TO.svg"> Отчет о результатах тестирования в [Allure TestOps](https://allure.autotests.cloud/project/1359/dashboards)

### :pushpin: Общая информация по отчетам о тестировании

*Главная страница Allure-отчета с:*

>- [x] <code><strong>*ALLURE REPORT*</strong></code> - отображает дату и время прохождения теста, общее количество выполненных кейсов, а также диаграмму с указанием процентного отношения и количества успешных, упавших и сломавшихся тестов к общему количеству
>- [x] <code><strong>*TREND*</strong></code> - отображает тренд прохождения тестов от сборки к сборке
>- [x] <code><strong>*SUITES*</strong></code> - отображает распределение результатов тестов по тестовым наборам
>- [x] <code><strong>*ENVIRONMENT*</strong></code> - отображает тестовое окружение, на котором запускались тесты (в данном случае информация не задана)
>- [x] <code><strong>*CATEGORIES*</strong></code> - отображает распределение неуспешно прошедших тестов по видам дефектов
>- [x] <code><strong>*FEATURES BY STORIES*</strong></code> - отображает распределение тестов по функционалу, который они проверяют
>- [x] <code><strong>*EXECUTORS*</strong></code> - отображает исполнителя текущей сборки (ссылка на сборку в Jenkins)

<p align="center">
  <img src="images/screens/AllureReports.png" alt="Allure Report" width="900">
</p>

<p align="center">
  <img src="images/screens/AllureReports2.png" alt="Allure Report" width="900">
</p>

<p align="center">
  <img src="images/screens/AllureReports3.png" alt="Allure Report" width="900">
</p>

## <img width="4%" title="Allure TestOPS" src="images/logo/Allure_TO.svg"> Интеграция с [Allure TestOps](https://allure.autotests.cloud/project/1059/dashboards)

### :pushpin: Основной дашборд

<p align="center">
  <img src="images/screens/AllureTestOps2.png" alt="dashboards" width="900">
</p>

### :pushpin: Тест-кейсы

<p align="center">
  <img src="images/screens/AllureTestOps.png" alt="test cases" width="900">
</p>

## <img width="4%" title="Telegram" src="images/logo/Telegram.svg"> Уведомления в Telegram с использованием бота [Allure Notification](https://github.com/qa-guru/allure-notifications)

> После завершения сборки специальный бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с отчетом о пройденных тестах.

<p align="center">
<img title="Telegram Notifications" src="images/screens/TelegramBot.png">
<img title="Telegram Notifications" src="images/screens/TelegramBot2.png">
</p>

## Пример визуального отображения работы API тестов в GUI

<p align="center">
  <img title="Selenoid Video" src="images/gif/Video-Test.gif">
</p>
