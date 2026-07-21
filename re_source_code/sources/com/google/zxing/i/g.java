package com.google.zxing.i;

import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: Code93Reader.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g extends m {
    private static final char[] a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".toCharArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final int[] f20388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f20389c;

    static {
        int[] iArr = {276, 328, 324, 322, 296, 292, 290, 336, 274, 266, 424, 420, 418, 404, 402, 394, 360, 356, 354, StatusLine.HTTP_PERM_REDIRECT, 282, 344, 332, 326, 300, 278, 436, 434, 428, 422, 406, 410, 364, 358, 310, 314, 302, 468, 466, 458, 366, 374, 430, 294, 474, 470, 306, 350};
        f20388b = iArr;
        f20389c = iArr[47];
    }
}
