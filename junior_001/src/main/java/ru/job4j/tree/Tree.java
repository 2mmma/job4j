package ru.job4j.tree;

import java.util.*;

/**
 * @author tumen.garmazhapov (gtb-85@yandex.ru)
 * @since 06.2020
 */
class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    /**
     * метод проверяет элементы и если это возможно,
     * добавляет элемент в дерево
     *
     * @param parent - элемент parent
     * @param child  - добавляемый элемент child
     * @return - true/false
     */
    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        Optional<Node<E>> parentNode = findBy(parent);
        if (findBy(child).isEmpty() && parentNode.isPresent()) {
            parentNode.get().children.add(new Node<>(child));
            rsl = true;
        }
        return rsl;
    }

    /**
     * метод проверяет, является ли дерево бинарным
     *
     * @return - true/false
     */
    @Override
    public boolean isBinary() {
        boolean result = true;
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.children.size() > 2) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * метод ищет значение в дереве
     *
     * @param value - значение, которое надо найти в дереве
     * @return - возвращает значение
     */
    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.value.equals(value)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
}