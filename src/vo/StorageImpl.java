package vo;

public class StorageImpl<T> implements Storage<T> {
    private T[] array;

    public StorageImpl(int capacity) {
        //타입 파라미터로 배열을 생성할 경우 new T[n]으로 생성할 수 없다.
        this.array = (T[])(new Object[capacity]);
    }

    @Override
    public void add(T item, int index) {
        array[index] = item;
    }

    @Override
    public T get(int index) {
        return array[index];
    }
}
