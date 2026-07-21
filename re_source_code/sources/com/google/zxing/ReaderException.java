package com.google.zxing;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ReaderException extends Exception {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected static final boolean f20294f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected static final StackTraceElement[] f20295g;

    static {
        f20294f = System.getProperty("surefire.test.class.path") != null;
        f20295g = new StackTraceElement[0];
    }

    ReaderException() {
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        return null;
    }
}
