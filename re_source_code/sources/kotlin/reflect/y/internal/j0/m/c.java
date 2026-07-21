package kotlin.reflect.y.internal.j0.m;

import java.util.Iterator;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: compiled from: ArrayMap.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c<T> implements Iterable<T>, KMappedMarker {
    private c() {
    }

    public /* synthetic */ c(g gVar) {
        this();
    }

    public abstract int c();

    public abstract void f(int i2, T t);

    public abstract T get(int i2);

    @Override // java.lang.Iterable
    public abstract Iterator<T> iterator();
}
