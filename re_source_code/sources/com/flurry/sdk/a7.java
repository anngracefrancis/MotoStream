package com.flurry.sdk;

import android.os.FileObserver;

/* JADX INFO: loaded from: classes2.dex */
public final class a7 extends FileObserver {
    private y6 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f10627b;

    public a7(String str, y6 y6Var) {
        super(str);
        this.f10627b = str;
        this.a = y6Var;
    }

    @Override // android.os.FileObserver
    public final void onEvent(int i2, String str) {
        if (str == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        if ((i2 & 8) != 0) {
            sb.append(this.f10627b + "/" + str + " is written and closed\n");
            StringBuilder sb2 = new StringBuilder("Observer triggered ");
            sb2.append(sb.toString());
            d1.c(3, "VNodeObserver", sb2.toString());
            this.a.h(str);
        }
    }
}
