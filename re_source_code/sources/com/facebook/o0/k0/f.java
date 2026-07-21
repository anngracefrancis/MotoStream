package com.facebook.o0.k0;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import com.facebook.o0.g0;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.text.Regex;
import kotlin.text.u;
import kotlin.text.v;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: MetadataViewObserver.kt */
/* JADX INFO: loaded from: classes.dex */
public final class f implements ViewTreeObserver.OnGlobalFocusChangeListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f10157f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Map<Integer, f> f10158g = new HashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Set<String> f10159h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Handler f10160i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final WeakReference<Activity> f10161j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final AtomicBoolean f10162k;

    /* JADX INFO: compiled from: MetadataViewObserver.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String c(String str, String str2) {
            return m.a("r2", str) ? new Regex("[^\\d.]").c(str2, HttpUrl.FRAGMENT_ENCODE_SET) : str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:21:0x004e  */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public final void d(Map<String, String> map, String str, String str2) {
            switch (str.hashCode()) {
                case 3585:
                    if (str.equals("r3")) {
                        str2 = (u.E(str2, "m", false, 2, null) || u.E(str2, "b", false, 2, null) || u.E(str2, "ge", false, 2, null)) ? "m" : "f";
                    }
                    map.put(str, str2);
                    return;
                case 3586:
                    if (str.equals("r4")) {
                        str2 = new Regex("[^a-z]+").c(str2, HttpUrl.FRAGMENT_ENCODE_SET);
                    }
                    map.put(str, str2);
                    return;
                case 3587:
                    if (str.equals("r5")) {
                        str2 = new Regex("[^a-z]+").c(str2, HttpUrl.FRAGMENT_ENCODE_SET);
                    }
                    map.put(str, str2);
                    return;
                case 3588:
                    if (str.equals("r6") && v.J(str2, "-", false, 2, null)) {
                        Object[] array = new Regex("-").d(str2, 0).toArray(new String[0]);
                        if (array == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                        }
                        str2 = ((String[]) array)[0];
                    }
                    map.put(str, str2);
                    return;
                default:
                    map.put(str, str2);
                    return;
            }
        }

        public final void e(Activity activity) {
            m.f(activity, "activity");
            int iHashCode = activity.hashCode();
            Map map = f.f10158g;
            Integer numValueOf = Integer.valueOf(iHashCode);
            Object fVar = map.get(numValueOf);
            if (fVar == null) {
                fVar = new f(activity, null);
                map.put(numValueOf, fVar);
            }
            ((f) fVar).h();
        }
    }

    private f(Activity activity) {
        this.f10159h = new LinkedHashSet();
        this.f10160i = new Handler(Looper.getMainLooper());
        this.f10161j = new WeakReference<>(activity);
        this.f10162k = new AtomicBoolean(false);
    }

    public /* synthetic */ f(Activity activity, g gVar) {
        this(activity);
    }

    private final void d(final View view) {
        g(new Runnable() { // from class: com.facebook.o0.k0.b
            @Override // java.lang.Runnable
            public final void run() {
                f.e(view, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(View view, f fVar) {
        m.f(view, "$view");
        m.f(fVar, "this$0");
        if (view instanceof EditText) {
            fVar.f(view);
        }
    }

    private final void f(View view) {
        String string = ((EditText) view).getText().toString();
        if (string == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        }
        String string2 = v.O0(string).toString();
        if (string2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = string2.toLowerCase();
        m.e(lowerCase, "(this as java.lang.String).toLowerCase()");
        if ((lowerCase.length() == 0) || this.f10159h.contains(lowerCase) || lowerCase.length() > 100) {
            return;
        }
        this.f10159h.add(lowerCase);
        HashMap map = new HashMap();
        d dVar = d.a;
        List<String> listB = d.b(view);
        List<String> listA = null;
        for (e eVar : e.a.c()) {
            a aVar = f10157f;
            String strC = aVar.c(eVar.c(), lowerCase);
            if (eVar.d().length() > 0) {
                d dVar2 = d.a;
                if (!d.f(strC, eVar.d())) {
                }
            }
            d dVar3 = d.a;
            if (d.e(listB, eVar.b())) {
                aVar.d(map, eVar.c(), strC);
            } else {
                if (listA == null) {
                    listA = d.a(view);
                }
                if (d.e(listA, eVar.b())) {
                    aVar.d(map, eVar.c(), strC);
                }
            }
        }
        g0.a.e(map);
    }

    private final void g(Runnable runnable) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            this.f10160i.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        if (this.f10162k.getAndSet(true)) {
            return;
        }
        com.facebook.o0.q0.g gVar = com.facebook.o0.q0.g.a;
        View viewE = com.facebook.o0.q0.g.e(this.f10161j.get());
        if (viewE == null) {
            return;
        }
        ViewTreeObserver viewTreeObserver = viewE.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnGlobalFocusChangeListener(this);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
    public void onGlobalFocusChanged(View view, View view2) {
        if (view != null) {
            d(view);
        }
        if (view2 != null) {
            d(view2);
        }
    }
}
