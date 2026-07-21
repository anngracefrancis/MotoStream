package io.sentry.util;

/* JADX INFO: compiled from: ClassLoaderUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h {
    public static ClassLoader a(ClassLoader classLoader) {
        return classLoader == null ? ClassLoader.getSystemClassLoader() : classLoader;
    }
}
