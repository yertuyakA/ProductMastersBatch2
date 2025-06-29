**EASY**

Реализовать простой REST API для получения списка фильмов.

Требования: Создать модель Movie с полями:

String title

String director

int year

Создать интерфейс MovieRepository и его реализацию, которая возвращает список заранее созданных фильмов.

Создать сервис MovieService, который использует MovieRepository.

Создать контроллер MovieController, в котором будет GET-метод /api/movies/all.

**MEDIUM**

Добавить фильтрацию фильмов по режиссеру.

Требования: 
Добавить метод в MovieRepository:

List<Movie> findByDirector(String director);

Добавить в MovieService и MovieController соответствующий метод:

GET /api/movies/by-director?name=Christopher+Nolan

Использовать @RequestParam в контроллере.


**HARD**

Добавить возможность добавлять фильмы через POST-запрос.
Требования:

Добавить POST
/api/movies/add с телом запроса:
{
"title": "Interstellar",
"director": "Christopher Nolan",
"year": 2014
}

Хранить добавленные фильмы в List<Movie> внутри MovieRepositoryImpl.
Сделать валидацию:
Год фильма должен быть >= 1900.
Поля title и director не должны быть пустыми.