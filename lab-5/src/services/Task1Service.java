package services;

import entities.*;

public class Task1Service {
    public void runTask1() {
        System.out.println("\n\n─── КЭШИРОВАННАЯ ДРОБЬ ───\n");

        FractionCached cachedFraction = new FractionCached(7, 5);
        System.out.println("Создана кэшированная дробь: " + cachedFraction);

        System.out.println("\nПервое обращение к getDecimalValue():");
        double value1 = cachedFraction.getDecimalValue();
        System.out.println("  Вычислено и кэшировано: " + value1);

        System.out.println("\nВторое обращение к getDecimalValue():");
        double value2 = cachedFraction.getDecimalValue();
        System.out.println("  Возвращено из кэша: " + value2);
        System.out.println("  (Вычисление не произведено, использован кэш)");

        System.out.println("\nИзменение числителя с 7 на 14...");
        cachedFraction.setNumerator(14);
        System.out.println("Кэш инвалидирован");

        System.out.println("\nОбращение к getDecimalValue() после изменения:");
        double value3 = cachedFraction.getDecimalValue();
        System.out.println("  Пересчитано и кэшировано: " + value3);
        System.out.println("  Новая дробь: " + cachedFraction);

    }
}