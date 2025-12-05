public interface Reducer<T> {
    T reduce(T accumulator, T value);
}
