package cm.aptoide.pt.dataprovider.cache;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseCache<K, V, Tout> implements Cache<K, V> {
    final KeyAlgorithm<K, Tout> keyAlgorithm;

    public BaseCache(KeyAlgorithm<K, Tout> keyAlgorithm) {
        this.keyAlgorithm = keyAlgorithm;
    }
}
