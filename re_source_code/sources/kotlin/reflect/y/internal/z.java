package kotlin.reflect.y.internal;

import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.r1.a.k;
import kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b.d;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: moduleByClassLoader.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\u0010\u0010\u0007\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\bH\u0000\" \u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"moduleByClassLoader", "Ljava/util/concurrent/ConcurrentMap;", "Lkotlin/reflect/jvm/internal/WeakClassLoaderBox;", "Ljava/lang/ref/WeakReference;", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "clearModuleByClassLoaderCache", HttpUrl.FRAGMENT_ENCODE_SET, "getOrCreateModule", "Ljava/lang/Class;", "kotlin-reflection"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class z {
    private static final ConcurrentMap<WeakClassLoaderBox, WeakReference<k>> a = new ConcurrentHashMap();

    public static final k a(Class<?> cls) {
        m.f(cls, "<this>");
        ClassLoader classLoaderE = d.e(cls);
        WeakClassLoaderBox weakClassLoaderBox = new WeakClassLoaderBox(classLoaderE);
        ConcurrentMap<WeakClassLoaderBox, WeakReference<k>> concurrentMap = a;
        WeakReference<k> weakReference = concurrentMap.get(weakClassLoaderBox);
        if (weakReference != null) {
            k kVar = weakReference.get();
            if (kVar != null) {
                return kVar;
            }
            concurrentMap.remove(weakClassLoaderBox, weakReference);
        }
        k kVarA = k.a.a(classLoaderE);
        while (true) {
            try {
                ConcurrentMap<WeakClassLoaderBox, WeakReference<k>> concurrentMap2 = a;
                WeakReference<k> weakReferencePutIfAbsent = concurrentMap2.putIfAbsent(weakClassLoaderBox, new WeakReference<>(kVarA));
                if (weakReferencePutIfAbsent == null) {
                    weakClassLoaderBox.a(null);
                    return kVarA;
                }
                k kVar2 = weakReferencePutIfAbsent.get();
                if (kVar2 != null) {
                    weakClassLoaderBox.a(null);
                    return kVar2;
                }
                concurrentMap2.remove(weakClassLoaderBox, weakReferencePutIfAbsent);
            } catch (Throwable th) {
                weakClassLoaderBox.a(null);
                throw th;
            }
        }
    }
}
