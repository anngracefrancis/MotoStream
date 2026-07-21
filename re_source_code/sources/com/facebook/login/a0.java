package com.facebook.login;

/* JADX INFO: compiled from: NonceUtil.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a0 {
    public static final a0 a = new a0();

    private a0() {
    }

    public static final boolean a(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        return !(kotlin.text.v.V(str, ' ', 0, false, 6, null) >= 0);
    }
}
