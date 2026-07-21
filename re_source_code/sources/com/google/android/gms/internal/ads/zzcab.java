package com.google.android.gms.internal.ads;

import android.view.View;
import android.widget.FrameLayout;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface zzcab extends View.OnClickListener, View.OnTouchListener {
    String A5();

    FrameLayout E0();

    zzua E3();

    void H(String str, View view, boolean z);

    Map<String, WeakReference<View>> S4();

    Map<String, WeakReference<View>> V3();

    View Y4(String str);

    View k0();

    Map<String, WeakReference<View>> y4();
}
