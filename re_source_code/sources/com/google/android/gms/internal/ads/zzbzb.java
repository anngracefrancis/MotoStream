package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface zzbzb {
    void G0(zzaag zzaagVar);

    void W();

    void a(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener);

    void b(Bundle bundle);

    void c(View view);

    void d();

    void d0(zzagd zzagdVar);

    void destroy();

    void e(View view, Map<String, WeakReference<View>> map);

    void e0(zzaak zzaakVar);

    void f(Bundle bundle);

    void g(View view, MotionEvent motionEvent, View view2);

    void h(View view, View view2, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z);

    void i(String str);

    void j(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2);

    void j0();

    void k(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z);

    void l();

    boolean m(Bundle bundle);

    void n();
}
