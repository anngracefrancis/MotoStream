package androidx.datastore.preferences.protobuf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import okhttp3.internal.http2.Settings;

/* JADX INFO: compiled from: ExtensionRegistryLite.java */
/* JADX INFO: loaded from: classes.dex */
public class p {
    private static boolean a = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile p f1380c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<a, y.e<?, ?>> f1382e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Class<?> f1379b = c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final p f1381d = new p(true);

    /* JADX INFO: compiled from: ExtensionRegistryLite.java */
    private static final class a {
        private final Object a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f1383b;

        a(Object obj, int i2) {
            this.a = obj;
            this.f1383b = i2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.f1383b == aVar.f1383b;
        }

        public int hashCode() {
            return (System.identityHashCode(this.a) * Settings.DEFAULT_INITIAL_WINDOW_SIZE) + this.f1383b;
        }
    }

    p() {
        this.f1382e = new HashMap();
    }

    public static p b() {
        p pVarA = f1380c;
        if (pVarA == null) {
            synchronized (p.class) {
                pVarA = f1380c;
                if (pVarA == null) {
                    pVarA = a ? o.a() : f1381d;
                    f1380c = pVarA;
                }
            }
        }
        return pVarA;
    }

    static Class<?> c() {
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public <ContainingType extends q0> y.e<ContainingType, ?> a(ContainingType containingtype, int i2) {
        return (y.e) this.f1382e.get(new a(containingtype, i2));
    }

    p(boolean z) {
        this.f1382e = Collections.emptyMap();
    }
}
