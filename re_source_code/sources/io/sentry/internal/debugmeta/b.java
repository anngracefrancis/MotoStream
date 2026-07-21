package io.sentry.internal.debugmeta;

import java.util.Properties;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: NoOpDebugMetaLoader.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class b implements a {
    private static final b a = new b();

    private b() {
    }

    public static b b() {
        return a;
    }

    @Override // io.sentry.internal.debugmeta.a
    public Properties a() {
        return null;
    }
}
