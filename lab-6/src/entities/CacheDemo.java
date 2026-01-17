package entities;

import annotations.Cache;

@Cache({"users", "orders", "products"})
public class CacheDemo {
}
