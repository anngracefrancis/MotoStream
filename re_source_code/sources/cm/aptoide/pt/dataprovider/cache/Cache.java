package cm.aptoide.pt.dataprovider.cache;

/* JADX INFO: loaded from: classes.dex */
public interface Cache<K, V> {
    boolean contains(K k2);

    void destroy();

    V get(K k2);

    boolean isValid(K k2);

    void put(K k2, V v);

    void remove(K k2);
}
