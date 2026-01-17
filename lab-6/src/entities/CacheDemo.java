package entities;

import annotations.Cache;

/**
 * Маркерный класс для демонстрации @Cache: задает кешируемые области.
 */
@Cache({"users", "orders", "products"})
public class CacheDemo {
    /**
     * Логики нет — важна только аннотация на типе.
     */
}
