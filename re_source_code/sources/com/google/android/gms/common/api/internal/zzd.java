package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import com.google.android.gms.internal.common.zzi;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzd extends Fragment implements LifecycleFragment {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final WeakHashMap f11891f = new WeakHashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Map f11892g = Collections.synchronizedMap(new c.e.a());

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f11893h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Bundle f11894i;

    public static zzd f(androidx.fragment.app.d dVar) {
        zzd zzdVar;
        WeakHashMap weakHashMap = f11891f;
        WeakReference weakReference = (WeakReference) weakHashMap.get(dVar);
        if (weakReference != null && (zzdVar = (zzd) weakReference.get()) != null) {
            return zzdVar;
        }
        try {
            zzd zzdVar2 = (zzd) dVar.getSupportFragmentManager().j0("SupportLifecycleFragmentImpl");
            if (zzdVar2 == null || zzdVar2.isRemoving()) {
                zzdVar2 = new zzd();
                dVar.getSupportFragmentManager().m().e(zzdVar2, "SupportLifecycleFragmentImpl").j();
            }
            weakHashMap.put(dVar, new WeakReference(zzdVar2));
            return zzdVar2;
        } catch (ClassCastException e2) {
            throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e2);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final void a(String str, LifecycleCallback lifecycleCallback) {
        if (this.f11892g.containsKey(str)) {
            throw new IllegalArgumentException("LifecycleCallback with tag " + str + " already added to this fragment.");
        }
        this.f11892g.put(str, lifecycleCallback);
        if (this.f11893h > 0) {
            new zzi(Looper.getMainLooper()).post(new y0(this, lifecycleCallback, str));
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final <T extends LifecycleCallback> T b(String str, Class<T> cls) {
        return cls.cast(this.f11892g.get(str));
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final /* synthetic */ Activity c() {
        return getActivity();
    }

    @Override // androidx.fragment.app.Fragment
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        Iterator it = this.f11892g.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).a(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        Iterator it = this.f11892g.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).d(i2, i3, intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f11893h = 1;
        this.f11894i = bundle;
        for (Map.Entry entry : this.f11892g.entrySet()) {
            ((LifecycleCallback) entry.getValue()).e(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f11893h = 5;
        Iterator it = this.f11892g.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).f();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f11893h = 3;
        Iterator it = this.f11892g.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).g();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle == null) {
            return;
        }
        for (Map.Entry entry : this.f11892g.entrySet()) {
            Bundle bundle2 = new Bundle();
            ((LifecycleCallback) entry.getValue()).h(bundle2);
            bundle.putBundle((String) entry.getKey(), bundle2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        this.f11893h = 2;
        Iterator it = this.f11892g.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).i();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        this.f11893h = 4;
        Iterator it = this.f11892g.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).j();
        }
    }
}
