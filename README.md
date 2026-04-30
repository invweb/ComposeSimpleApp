EN:

The simplest application is planned, the Basic one. An attempt to adequately implement MVI. Used Kotlin Compose. Navigation added.

Key properties of StateFlow
It always has the current value. Unlike regular Flow, StateFlow always has the "last known value", which the new subscriber receives immediately upon subscription.
Hot flows. StateFlow exists independently of subscribers (collectors). The data continues to be updated, even if no one is listening.
The issue is only when it is changed. The new value is sent to subscribers only if it differs from the previous one (comparison via equals).
Guarantees consistency. Updates come in the order in which they were installed.

RUS:

Планируется самое простое приложение, базовое. Попытка адекватно реализовать MVI. Используется Kotlin Compose. Добавлена навигация.

Ключевые свойства StateFlow
Всегда имеет текущее значение. В отличие от обычного Flow, у StateFlow всегда есть «последнее известное значение», которое новый подписчик получает сразу при подписке.

Горячие потоки (hot flow). StateFlow существует независимо от подписчиков (collectors). Данные продолжают обновляться, даже если никто не слушает.

Эмиссия только при изменении. Новое значение отправляется подписчикам лишь если оно отличается от предыдущего (сравнение через equals).

Гарантирует последовательность. Обновления приходят в том порядке, в котором они были установлены.