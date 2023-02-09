import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Tree tree = new Tree();
        tree.insertNode(5);
        tree.insertNode(7);
        tree.insertNode(6);

        Scanner scanner = new Scanner(System.in);
        outMenu();
        int value = scanner.nextInt();
        while (value!=0) {

            switch (value) {
                case 1 -> {
                    System.out.println("Введите значение :");
                    int valueNode = scanner.nextInt();
                    tree.insertNode(valueNode);
                    System.out.println("Добавлено значение : " + valueNode);
                }
                case 2 -> {
                    System.out.println("[*] Высота дерева: " + tree.getHeightTree());
                }
                case 3 -> {
                    System.out.println("[*] Кол-во узлов: " + tree.getCountNodes());
                }
                case 4 -> {
                    System.out.println();
                    System.out.println("[*] Дерево:");
                    tree.printTree();
                }
                case 5 -> {
                    System.out.println();
                    System.out.println("[*] Узлы:");
                    tree.printTreeByNodes();
                }
                case 6 -> {
                    System.out.println("Введите значение :");
                    int valueNode = scanner.nextInt();
                    if (tree.deleteItemByValue(valueNode))
                        System.out.println("Значение " + valueNode + " удалено");
                    else System.out.println("Значение не найдено...");
                }
                case 7 -> {
                    System.out.println("Введите значение :");
                    int valueNode = scanner.nextInt();
                    Node findNode = tree.findElemByValue(valueNode);
                    if (findNode != null) System.out.println(findNode.info());
                    else System.out.println("Значение не найдено...");
                }
                case 8 -> {
                    Node finMinNode = tree.getFindMinElement();
                    if (finMinNode == null) System.out.println("Дерево пустое");
                    else System.out.println(finMinNode.info());
                }
            }

            outMenu();
            value = scanner.nextInt();
        }

    }

    public static void outMenu(){
        System.out.println();
        System.out.println("/*******\t Меню \t*******\\");
        System.out.println("1 - Добавить запись в дерево.");
        System.out.println("2 - Получить высоту дерева.");
        System.out.println("3 - Получить кол-во узлов в дереве.");
        System.out.println("4 - Вывести двоичное дерево поиска.");
        System.out.println("5 - Вывести информацию об узлах в дереве.");
        System.out.println("6 - Удаление узла по значению.");
        System.out.println("7 - Поиск узла по значению.");
        System.out.println("8 - Вывести узел с минимальным значением.");
        System.out.println("0 - Выход.");
        System.out.println();
    }
}