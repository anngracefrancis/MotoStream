package com.bumptech.glide.m;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.Fragment;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: RequestManagerRetriever.java */
/* JADX INFO: loaded from: classes.dex */
public class l implements Handler.Callback {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final b f9461f = new a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile com.bumptech.glide.i f9462g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Handler f9465j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final b f9466k;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final Map<FragmentManager, k> f9463h = new HashMap();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final Map<androidx.fragment.app.FragmentManager, o> f9464i = new HashMap();
    private final c.e.a<View, Fragment> l = new c.e.a<>();
    private final c.e.a<View, android.app.Fragment> m = new c.e.a<>();
    private final Bundle n = new Bundle();

    /* JADX INFO: compiled from: RequestManagerRetriever.java */
    class a implements b {
        a() {
        }

        @Override // com.bumptech.glide.m.l.b
        public com.bumptech.glide.i a(com.bumptech.glide.c cVar, h hVar, m mVar, Context context) {
            return new com.bumptech.glide.i(cVar, hVar, mVar, context);
        }
    }

    /* JADX INFO: compiled from: RequestManagerRetriever.java */
    public interface b {
        com.bumptech.glide.i a(com.bumptech.glide.c cVar, h hVar, m mVar, Context context);
    }

    public l(b bVar) {
        this.f9466k = bVar == null ? f9461f : bVar;
        this.f9465j = new Handler(Looper.getMainLooper(), this);
    }

    @TargetApi(17)
    private static void a(Activity activity) {
        if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    @Deprecated
    private com.bumptech.glide.i b(Context context, FragmentManager fragmentManager, android.app.Fragment fragment, boolean z) {
        k kVarI = i(fragmentManager, fragment, z);
        com.bumptech.glide.i iVarD = kVarI.d();
        if (iVarD != null) {
            return iVarD;
        }
        com.bumptech.glide.i iVarA = this.f9466k.a(com.bumptech.glide.c.c(context), kVarI.b(), kVarI.e(), context);
        kVarI.i(iVarA);
        return iVarA;
    }

    private com.bumptech.glide.i g(Context context) {
        if (this.f9462g == null) {
            synchronized (this) {
                if (this.f9462g == null) {
                    this.f9462g = this.f9466k.a(com.bumptech.glide.c.c(context.getApplicationContext()), new com.bumptech.glide.m.b(), new g(), context.getApplicationContext());
                }
            }
        }
        return this.f9462g;
    }

    private k i(FragmentManager fragmentManager, android.app.Fragment fragment, boolean z) {
        k kVar = (k) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (kVar == null && (kVar = this.f9463h.get(fragmentManager)) == null) {
            kVar = new k();
            kVar.h(fragment);
            if (z) {
                kVar.b().d();
            }
            this.f9463h.put(fragmentManager, kVar);
            fragmentManager.beginTransaction().add(kVar, "com.bumptech.glide.manager").commitAllowingStateLoss();
            this.f9465j.obtainMessage(1, fragmentManager).sendToTarget();
        }
        return kVar;
    }

    private o k(androidx.fragment.app.FragmentManager fragmentManager, Fragment fragment, boolean z) {
        o oVar = (o) fragmentManager.j0("com.bumptech.glide.manager");
        if (oVar == null && (oVar = this.f9464i.get(fragmentManager)) == null) {
            oVar = new o();
            oVar.k(fragment);
            if (z) {
                oVar.e().d();
            }
            this.f9464i.put(fragmentManager, oVar);
            fragmentManager.m().e(oVar, "com.bumptech.glide.manager").j();
            this.f9465j.obtainMessage(2, fragmentManager).sendToTarget();
        }
        return oVar;
    }

    private static boolean l(Activity activity) {
        return !activity.isFinishing();
    }

    private com.bumptech.glide.i m(Context context, androidx.fragment.app.FragmentManager fragmentManager, Fragment fragment, boolean z) {
        o oVarK = k(fragmentManager, fragment, z);
        com.bumptech.glide.i iVarG = oVarK.g();
        if (iVarG != null) {
            return iVarG;
        }
        com.bumptech.glide.i iVarA = this.f9466k.a(com.bumptech.glide.c.c(context), oVarK.e(), oVarK.h(), context);
        oVarK.l(iVarA);
        return iVarA;
    }

    public com.bumptech.glide.i c(Activity activity) {
        if (com.bumptech.glide.r.k.q()) {
            return d(activity.getApplicationContext());
        }
        a(activity);
        return b(activity, activity.getFragmentManager(), null, l(activity));
    }

    public com.bumptech.glide.i d(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        if (com.bumptech.glide.r.k.r() && !(context instanceof Application)) {
            if (context instanceof androidx.fragment.app.d) {
                return f((androidx.fragment.app.d) context);
            }
            if (context instanceof Activity) {
                return c((Activity) context);
            }
            if (context instanceof ContextWrapper) {
                return d(((ContextWrapper) context).getBaseContext());
            }
        }
        return g(context);
    }

    public com.bumptech.glide.i e(Fragment fragment) {
        com.bumptech.glide.r.j.e(fragment.getActivity(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (com.bumptech.glide.r.k.q()) {
            return d(fragment.getActivity().getApplicationContext());
        }
        return m(fragment.getActivity(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
    }

    public com.bumptech.glide.i f(androidx.fragment.app.d dVar) {
        if (com.bumptech.glide.r.k.q()) {
            return d(dVar.getApplicationContext());
        }
        a(dVar);
        return m(dVar, dVar.getSupportFragmentManager(), null, l(dVar));
    }

    @Deprecated
    k h(Activity activity) {
        return i(activity.getFragmentManager(), null, l(activity));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Object obj;
        Object objRemove;
        Object obj2;
        int i2 = message.what;
        Object obj3 = null;
        boolean z = true;
        if (i2 != 1) {
            if (i2 != 2) {
                z = false;
                obj2 = null;
            } else {
                obj = (androidx.fragment.app.FragmentManager) message.obj;
                objRemove = this.f9464i.remove(obj);
            }
            if (z && obj3 == null && Log.isLoggable("RMRetriever", 5)) {
                Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj2);
            }
            return z;
        }
        obj = (FragmentManager) message.obj;
        objRemove = this.f9463h.remove(obj);
        Object obj4 = obj;
        obj3 = objRemove;
        obj2 = obj4;
        if (z) {
            Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj2);
        }
        return z;
    }

    o j(androidx.fragment.app.d dVar) {
        return k(dVar.getSupportFragmentManager(), null, l(dVar));
    }
}
