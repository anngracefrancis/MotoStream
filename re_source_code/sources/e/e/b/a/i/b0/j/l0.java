package e.e.b.a.i.b0.j;

import android.content.Context;
import javax.inject.Named;
import javax.inject.Singleton;

/* JADX INFO: compiled from: EventStoreModule.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class l0 {
    @Named
    static String a() {
        return "com.google.android.datatransport.events";
    }

    @Singleton
    @Named
    static String b(Context context) {
        return context.getPackageName();
    }

    @Named
    static int c() {
        return t0.f20799g;
    }

    static k0 d() {
        return k0.a;
    }
}
