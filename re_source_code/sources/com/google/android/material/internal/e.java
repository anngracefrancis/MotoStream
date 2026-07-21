package com.google.android.material.internal;

import android.os.Build;
import java.util.Locale;

/* JADX INFO: compiled from: ManufacturerUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {
    public static boolean a() {
        return Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals("meizu");
    }
}
