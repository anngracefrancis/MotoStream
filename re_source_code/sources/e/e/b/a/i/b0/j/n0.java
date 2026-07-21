package e.e.b.a.i.b0.j;

import android.content.Context;
import javax.inject.Provider;

/* JADX INFO: compiled from: EventStoreModule_PackageNameFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public final class n0 implements e.e.b.a.i.x.a.b<String> {
    private final Provider<Context> a;

    public n0(Provider<Context> provider) {
        this.a = provider;
    }

    public static n0 a(Provider<Context> provider) {
        return new n0(provider);
    }

    public static String c(Context context) {
        return (String) e.e.b.a.i.x.a.d.c(l0.b(context), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public String get() {
        return c(this.a.get());
    }
}
