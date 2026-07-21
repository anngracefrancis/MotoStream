package com.liulishuo.filedownloader.exception;

import e.h.a.k0.f;

/* JADX INFO: loaded from: classes2.dex */
public class PathConflictException extends IllegalAccessException {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f20458f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f20459g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f20460h;

    public PathConflictException(int i2, String str, String str2) {
        super(f.o("There is an another running task(%d) with the same downloading path(%s), because of they are with the same target-file-path(%s), so if the current task is started, the path of the file is sure to be written by multiple tasks, it is wrong, then you receive this exception to avoid such conflict.", Integer.valueOf(i2), str, str2));
        this.f20460h = i2;
        this.f20458f = str;
        this.f20459g = str2;
    }
}
