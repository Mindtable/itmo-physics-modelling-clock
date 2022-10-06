# Моделирование по физике: Часы

## Запуск

### Требования
- На компьютере должна быть установлена ``Java`` версии ``17``

Открыть директорию проекта в командной строке и ввести команду ``gradlew.bat run``

### Начать демонстрацию

Чтобы запустить воспроизведение, нужно нажать на крупную кнопку ``Play``. Повторное нажатие останавливает работу.

## Конфигурация

В корневой директории находится файл конфигурации ``/config/vectors.config``.
Каждый вектор описывается строчкой из двух чисел:
 - Длина (в пикселях)
 - Период (в условных единицах).

### Пример файла конфигурации

    50 100
    75 200
    100 -300

### Ограничения
- При выборе данных для вектора стоит в первую очередь обращать внимание на отношение его периода к периоду первого вектора, так как на данном этапе не реализована поддержка значений периода в реальных единицах времени
- Не стоит ставить слишком маленький период у вектора, чтобы избежать рваного изображения
- На данном этапе обработка файла конфигурации недостаточно устойчива, поэтому не стоит отходить в сторону от предложенного выше формата.
- При записи векторов в конфигурационный файл стоит помнить, что разрешение окна ``800x600``, и следить, чтобы суммарная длина векторов не превышала половины высоты изображения (во избежание "некрасивой картинки" по итогу)
- Нет поддержки динамического изменения конфигурации, при каждом изменении коэффициентов векторов стоит перезагружать приложение

## Архитектура приложения

При разработке использовался язык программирования ``Java`` версии ``17``.
В качестве фреймворка для визуализации использовался ``JavaFX``.
Также было реализовано несколько паттернов проектирования, таких как:
- Chain of Responsibility
- Factory
- Singleton

Архитектурный паттерн - MVC

## Немножко из теории по преобразованию фурье

## Интересные ссылочки
[Видеоролик 3Blue1Brown с более подробным рассказом и визуализацией](https://www.youtube.com/watch?v=r6sGWTCMz2k)
[Статья на Reddit с преобразованием svg-картинки в коэффициенты для ряда Фурье](https://www.reddit.com/r/desmos/comments/u7r5li/how_to_create_images_in_desmos_using_epicycles/)
