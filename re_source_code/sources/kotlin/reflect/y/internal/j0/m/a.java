package kotlin.reflect.y.internal.j0.m;

import cm.aptoide.pt.database.room.RoomNotification;
import java.util.Iterator;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: ArrayMapOwner.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a<K, V> implements Iterable<V>, KMappedMarker {

    /* JADX INFO: renamed from: kotlin.f0.y.e.j0.m.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ArrayMapOwner.kt */
    public static abstract class AbstractC0401a<K, V, T extends V> {
        private final KClass<? extends K> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f24887b;

        public AbstractC0401a(KClass<? extends K> kClass, int i2) {
            m.f(kClass, RoomNotification.KEY);
            this.a = kClass;
            this.f24887b = i2;
        }

        protected final T c(a<K, V> aVar) {
            m.f(aVar, "thisRef");
            return aVar.c().get(this.f24887b);
        }
    }

    protected abstract c<V> c();

    protected abstract s<K, V> f();

    public final boolean isEmpty() {
        return c().c() == 0;
    }

    @Override // java.lang.Iterable
    public final Iterator<V> iterator() {
        return c().iterator();
    }
}
