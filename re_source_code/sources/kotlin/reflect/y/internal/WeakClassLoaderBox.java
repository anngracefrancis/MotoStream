package kotlin.reflect.y.internal;

import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlin.f0.y.e.h0, reason: from Kotlin metadata */
/* JADX INFO: compiled from: moduleByClassLoader.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0004¨\u0006\u0017"}, d2 = {"Lkotlin/reflect/jvm/internal/WeakClassLoaderBox;", HttpUrl.FRAGMENT_ENCODE_SET, "classLoader", "Ljava/lang/ClassLoader;", "(Ljava/lang/ClassLoader;)V", "identityHashCode", HttpUrl.FRAGMENT_ENCODE_SET, "getIdentityHashCode", "()I", "ref", "Ljava/lang/ref/WeakReference;", "getRef", "()Ljava/lang/ref/WeakReference;", "temporaryStrongRef", "getTemporaryStrongRef", "()Ljava/lang/ClassLoader;", "setTemporaryStrongRef", "equals", HttpUrl.FRAGMENT_ENCODE_SET, "other", "hashCode", "toString", HttpUrl.FRAGMENT_ENCODE_SET, "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class WeakClassLoaderBox {
    private final WeakReference<ClassLoader> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f23093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ClassLoader f23094c;

    public WeakClassLoaderBox(ClassLoader classLoader) {
        m.f(classLoader, "classLoader");
        this.a = new WeakReference<>(classLoader);
        this.f23093b = System.identityHashCode(classLoader);
        this.f23094c = classLoader;
    }

    public final void a(ClassLoader classLoader) {
        this.f23094c = classLoader;
    }

    public boolean equals(Object other) {
        return (other instanceof WeakClassLoaderBox) && this.a.get() == ((WeakClassLoaderBox) other).a.get();
    }

    /* JADX INFO: renamed from: hashCode, reason: from getter */
    public int getF23093b() {
        return this.f23093b;
    }

    public String toString() {
        String string;
        ClassLoader classLoader = this.a.get();
        return (classLoader == null || (string = classLoader.toString()) == null) ? "<null>" : string;
    }
}
