EASY

Создай простое Spring-приложение, в котором:

Есть интерфейс GreetingService с методом sayHello().

Есть два класса-реализации: EnglishGreetingService, RussianGreetingService.
Сконфигурируй их как Spring-бины через Java-based конфигурацию (@Configuration)

В Main-классе внедри нужный бин через @Autowired и вызови метод sayHello()


MEDIUM

Добавь новый способ оплаты через криптомонеты Bitcoin и PlovCoin (BitcoinPaymentProcessor и PlovCoinPaymentProcessor).  
Добавь в Main тест вызова новых способов оплат.

HARD

Изучи аннотацию @Qualifier и cделай так, чтобы в OrderService можно было выбирать между VisaCardPaymentProcessor, MasterCardPaymentProcessor, BitcoinPaymentProcessor и PlovCoinPaymentProcessor через @Qualifier (их надо добавить рядом с @Autowired)
Выбери один процессор по умолчанию и убедись, что он используется.

В Main вызови context.getBean(OrderService.class) дважды и сравни ссылки. Выведи System.out.println(orderService == orderServiceSecond).