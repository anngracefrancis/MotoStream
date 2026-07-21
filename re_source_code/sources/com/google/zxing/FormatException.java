package com.google.zxing;

/* JADX INFO: loaded from: classes2.dex */
public final class FormatException extends ReaderException {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final FormatException f20292h;

    static {
        FormatException formatException = new FormatException();
        f20292h = formatException;
        formatException.setStackTrace(ReaderException.f20295g);
    }

    private FormatException() {
    }

    public static FormatException a() {
        return ReaderException.f20294f ? new FormatException() : f20292h;
    }
}
