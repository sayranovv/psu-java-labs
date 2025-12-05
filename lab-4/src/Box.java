public class Box<T> {
    private T content;
    
    private boolean isEmpty;

    public Box() {
        this.content = null;
        this.isEmpty = true;
    }

    public void put(T item) {
        if (!isEmpty) {
            throw new IllegalStateException(
                "Ошибка: коробка не пуста! Сначала извлеките содержимое."
            );
        }
        
        this.content = item;
        this.isEmpty = false;
    }

    public T get() {
        T item = content;
        
        this.content = null;
        
        this.isEmpty = true;
        
        return item;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    @Override
    public String toString() {
        if (isEmpty) {
            return "Box{содержимое=ПУСТО}";
        } else {
            return "Box{содержимое=" + content + "}";
        }
    }
}
