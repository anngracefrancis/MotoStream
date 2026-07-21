package kotlin.reflect.y.internal.j0.m;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: ArrayMapOwner.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class s<K, V> {
    private final ConcurrentHashMap<KClass<? extends K>, Integer> a = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicInteger f24935b = new AtomicInteger(0);

    /* JADX INFO: compiled from: ArrayMapOwner.kt */
    static final class a extends Lambda implements Function1<KClass<? extends K>, Integer> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ s<K, V> f24936f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(s<K, V> sVar) {
            super(1);
            this.f24936f = sVar;
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Integer invoke(KClass<? extends K> kClass) {
            m.f(kClass, "it");
            return Integer.valueOf(((s) this.f24936f).f24935b.getAndIncrement());
        }
    }

    public abstract <T extends K> int b(ConcurrentHashMap<KClass<? extends K>, Integer> concurrentHashMap, KClass<T> kClass, Function1<? super KClass<? extends K>, Integer> function1);

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends V, KK extends K> n<K, V, T> c(KClass<KK> kClass) {
        m.f(kClass, "kClass");
        return new n<>(kClass, d(kClass));
    }

    public final <T extends K> int d(KClass<T> kClass) {
        m.f(kClass, "kClass");
        return b(this.a, kClass, new a(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Collection<Integer> e() {
        Collection<Integer> collectionValues = this.a.values();
        m.e(collectionValues, "idPerType.values");
        return collectionValues;
    }
}
