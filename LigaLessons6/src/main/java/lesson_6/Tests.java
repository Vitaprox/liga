package lesson_6;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Tests {
    public static void main(String[] args) {
        System.out.println();
        Tests test = new Tests();
        test.test_5();
    }

    /**
     * Получить List чисел в виде текстовых элементов
     */
    public void test_1() {
        List<Integer> integerList = getIntList();
        List<String> newIntList = integerList.stream().map(el -> Integer.toString(el)).toList();
        System.out.println(newIntList);
    }

    /**
     * Отсортировать список по убыванию
     */
    public void test_2() {
        List<Integer> integerList = getIntList();
        List<Integer> sortIntList = integerList.stream().sorted(Collections.reverseOrder()).toList();
        System.out.println(sortIntList);
    }

    /**
     * Получить одну строку текста. Каждый элемент должен начинаться с текста "Number - ".
     * Элементы должны разделяться запятой и пробелом.
     * В начале итоговой строки должен быть текст "Number list: "
     * В конце итоговой строки должен быть текст "end of list.".
     */
    public void test_3() {
        List<String> stringList = getStringList();
        String joinList = getStringList().stream().map(el -> "Number - " + el).collect(Collectors.joining(",  ", "Number list: ", " end of list."));
        System.out.println(joinList);
    }

    /**
     * Получить мапу со значениями, ключи которых больше трех и меньше девяти
     */
    public void test_4() {
        Map<Integer, String> map = getMap();
        Map<Integer, String> newMap = map.entrySet().stream().filter(el -> el.getKey() > 3 && el.getKey() < 9).collect(Collectors.toMap(a -> a.getKey(), a -> a.getValue()));
        newMap.entrySet().stream().forEach(el -> System.out.println(el.getKey() + " " + el.getValue()));

    }


    /**
     * (a,b) -> ThreadLocalRandom.current().nextInt(-1, 1)
     * Перемешать все элементы в мапе.
     * Пример результата:
     * Элемент 1: ключ - 5, значение "five"
     * Элемент 2: ключ - 7, значение "seven"
     * Элемент 3: ключ - 2, значение "two"
     * и так далее.
     */
    public void test_5() {
        Map<Integer, String> map = getMap();
        Map<Integer, String> newMap = map.entrySet().stream().sorted((a, b) -> {
            int x = 0;
            if (a.getKey() > b.getKey()) {
                x = 1;
            } else {
                x = -1;
            }
            return x;
        }).collect(Collectors.toMap(a -> a.getKey(), a -> a.getValue()));


        //Попробуем иначе
        //Новый лист
        List<Integer> list = new ArrayList<>();

        map.entrySet().stream().forEach(a -> list.add(a.getKey()));

        //Лист с рандомными значениями
        List<Integer> listReverse = new ArrayList<>();
        Collections.shuffle(list);

        //System.out.println(list); //всё норм
        //Перемешанная мапа из перемешанного лист
        Map<Integer, String> newMap2 = list.stream().collect(Collectors.toMap(a -> a, a -> map.get(a))); //мапа не перемешана
        //newMap2.entrySet().stream().forEach(el -> System.out.println(el.getKey()+" "+el.getValue()));


        //Сделаем без стрима
        LinkedHashMap<Integer, String> newMap3 = new LinkedHashMap<>();

        for (int m : list) {
            newMap3.put(m, map.get(m));
        }
        System.out.println(newMap3);
    }

    /**
     * Установить во всех элементах isDisplayed = true, и оставить в списке только элементы с value NULL.
     */
    public void test_6() {
        List<WebElement> elements = getElements();
        List<WebElement> newElements = elements.stream()
                .peek(el -> el.setDisplayed(true))
                .filter(el -> el.getValue() == null)
                .collect(Collectors.toList());
        newElements.stream().forEach(el -> System.out.println(el.getValue() + " " + el.isDisplayed()));


    }

    /**
     * Инвертировать isDisplayed параметр каждого элемента и отсортировать список по типу элемента
     * со следующим приоритетом:
     * 1. TEXT
     * 2. INPUT_FIELD
     * 3. CHECKBOX
     * 4. BUTTON
     * 5. RADIO_BUTTON
     * 6. IMAGE
     */
    public void test_7() {
        Map<Type, Integer> sort = new HashMap<>();
        sort.put(Type.TEXT, 1);
        sort.put(Type.INPUT_FIELD, 2);
        sort.put(Type.CHECKBOX, 3);
        sort.put(Type.BUTTON, 4);
        sort.put(Type.RADIO_BUTTON, 5);
        sort.put(Type.IMAGE, 6);

        List<WebElement> elements = getElements();
        List<WebElement> newElement = elements.stream().peek(el -> {
            if (el.isDisplayed()) {
                el.setDisplayed(false);
            } else {
                el.setDisplayed(true);
            }
        }).sorted((a, b) -> {
            int aI = sort.get(a.getType());
            int bI = sort.get(b.getType());

            int x = 0;
            if (aI > bI) {
                x = 1;
            } else if (aI < bI) {
                x = -1;
            }
            return x;
        }).toList();
        newElement.stream().forEach(el -> System.out.println(el.getType() + " " + el.isDisplayed()));
    }

    /**
     * Создать мапу:
     * ключ - текст
     * значение - тип элемента
     */
    public void test_8() {
        List<WebElement> elements = getElements();
        Map<String, Type> newEl = elements.stream().filter(el -> el.getText() != null).collect(Collectors.toMap(el -> el.getText(), el -> el.getType()));
        newEl.entrySet().stream().forEach(el -> System.out.println(el.getKey() + " " + el.getValue()));

    }

    /**
     * Получить список элементов, у которых текст или значение оканчивается на число от 500 и более.
     * И отсортировать по увеличению сначала элементы с текстом, а затем по убыванию элементы со значением.
     */
    public void test_9() {
        List<WebElement> elements = getElements();
    }

    public static Map<Integer, String> getMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");
        map.put(10, "ten");
        return map;
    }

    public static List<String> getStringList() {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        list.add("six");
        list.add("seven");
        list.add("one");
        list.add("nine");
        list.add("ten");
        return list;
    }

    public static List<Integer> getIntList() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        return list;
    }

    public static List<WebElement> getElements() {
        List<WebElement> result = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            result.add(new WebElement());
        }
        return result;
    }
}
