## Двоичное дерево поиска
> * оба поддерева — левое и правое — являются двоичными деревьями поиска;
  * у всех узлов левого поддерева произвольного узла X значения ключей данных меньше либо равны, нежели значение ключа данных самого узла X;
  * у всех узлов правого поддерева произвольного узла X значения ключей данных больше, нежели значение ключа данных самого узла X.
  Очевидно, данные в каждом узле должны обладать ключами, на которых определена операция сравнения меньше.
  Как правило, информация, представляющая каждый узел, является записью, а не единственным полем данных. Однако это касается реализации, а не природы двоичного дерева поиска.
  Для целей реализации двоичное дерево поиска можно определить так:
  * Двоичное дерево состоит из узлов (вершин) — записей вида (data, left, right), где data — некоторые данные, привязанные к узлу, left и right — ссылки на узлы, 
    являющиеся детьми данного узла — левый и правый сыновья соответственно. Для оптимизации алгоритмов конкретные реализации предполагают также определения поля parent 
    в каждом узле (кроме корневого) — ссылки на родительский элемент.
  * Данные (data) обладают ключом (key), на котором определена операция сравнения «меньше». В конкретных реализациях это может быть пара (key, value) — (ключ и значение), 
    или ссылка на такую пару, или простое определение операции сравнения на необходимой структуре данных или ссылке на неё.
  * Для любого узла X выполняются свойства дерева поиска: key[left[X]] < key[X] ≤ key[right[X]], то есть ключи данных родительского узла больше ключей данных 
    левого сына и нестрого меньше ключей данных правого.


