package com.demo.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * jh
 * 2019年05月05日  13：59
 */
public class Demo {
    public static List<Dish> getMenu() {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));
        return menu;
    }

    /**
     * simple demo
     */
    public static void demo1() {
        List<Dish> menu = getMenu();
        List<String> threeHighCaloricDishNames =
                menu.stream()
                        //首先选出高热量的菜肴
                        .filter(d -> d.getCalories() > 300)
                        //获取菜名
                        .map(Dish::getName)
                        //选前三个
                        .limit(3)
                        .collect(toList());
        System.out.println(threeHighCaloricDishNames);
    }


    /**
     * distinct
     */
    public static void distinctDemo(){
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i%2==0)
                .distinct()
                .forEach(System.out::println);
    }


    /**
     * limit skip
     * skip(n)方法，返回一个扔掉了前n个元素的流。如果流中元素不足n个，则返回一 个空流。请注意，limit(n)和skip(n)是互补的!
     */
    public static void limit_skip(){
        List<Dish> menu = getMenu();
        //limit
        List<Dish> dishes = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .limit(3)
                .collect(toList());
        //skip
        List<Dish> dishes2 = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)
                .collect(toList());
    }









    public static void main(String[] args) {
        distinctDemo();
    }



}






















