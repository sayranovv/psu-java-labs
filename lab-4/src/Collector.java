public interface Collector<T, P> {
    void collect(P collection, T element);
}
