package com.liulishuo.filedownloader.exception;

import android.annotation.TargetApi;
import e.h.a.k0.f;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class FileDownloadOutOfSpaceException extends IOException {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f20455f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f20456g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f20457h;

    @TargetApi(9)
    public FileDownloadOutOfSpaceException(long j2, long j3, long j4, Throwable th) {
        super(f.o("The file is too large to store, breakpoint in bytes:  %d, required space in bytes: %d, but free space in bytes: %d", Long.valueOf(j4), Long.valueOf(j3), Long.valueOf(j2)), th);
        a(j2, j3, j4);
    }

    private void a(long j2, long j3, long j4) {
        this.f20455f = j2;
        this.f20456g = j3;
        this.f20457h = j4;
    }

    public FileDownloadOutOfSpaceException(long j2, long j3, long j4) {
        super(f.o("The file is too large to store, breakpoint in bytes:  %d, required space in bytes: %d, but free space in bytes: %d", Long.valueOf(j4), Long.valueOf(j3), Long.valueOf(j2)));
        a(j2, j3, j4);
    }
}
