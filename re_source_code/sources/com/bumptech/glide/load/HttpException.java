package com.bumptech.glide.load;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class HttpException extends IOException {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f9021f;

    public HttpException(int i2) {
        this("Http request failed with status code: " + i2, i2);
    }

    public HttpException(String str) {
        this(str, -1);
    }

    public HttpException(String str, int i2) {
        this(str, i2, null);
    }

    public HttpException(String str, int i2, Throwable th) {
        super(str, th);
        this.f9021f = i2;
    }
}
