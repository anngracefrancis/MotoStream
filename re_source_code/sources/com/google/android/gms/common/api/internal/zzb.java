package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
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
public final class zzb extends Fragment implements LifecycleFragment {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final WeakHashMap f11887f = new WeakHashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Map f11888g = Collections.synchronizedMap(new c.e.a());

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f11889h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Bundle f11890i;

    public static zzb f(Activity activity) {
        zzb zzbVar;
        WeakHashMap weakHashMap = f11887f;
        WeakReference weakReference = (WeakReference) weakHashMap.get(activity);
        if (weakReference != null && (zzbVar = (zzb) weakReference.get()) != null) {
            return zzbVar;
        }
        try {
            zzb zzbVar2 = (zzb) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
            if (zzbVar2 == null || zzbVar2.isRemoving()) {
                zzbVar2 = new zzb();
                activity.getFragmentManager().beginTransaction().add(zzbVar2, "LifecycleFragmentImpl").commitAllowingStateLoss();
            }
            weakHashMap.put(activity, new WeakReference(zzbVar2));
            return zzbVar2;
        } catch (ClassCastException e2) {
            throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e2);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final void a(String str, LifecycleCallback lifecycleCallback) {
        if (this.f11888g.containsKey(str)) {
            throw new IllegalArgumentException("LifecycleCallback with tag " + str + " already added to this fragment.");
        }
        this.f11888g.put(str, lifecycleCallback);
        if (this.f11889h > 0) {
            new zzi(Looper.getMainLooper()).post(new x0(this, lifecycleCallback, str));
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final <T extends LifecycleCallback> T b(String str, Class<T> cls) {
        return cls.cast(this.f11888g.get(str));
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final Activity c() {
        return getActivity();
    }

    @Override // android.app.Fragment
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        Iterator it = this.f11888g.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).a(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // android.app.Fragment
    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        Iterator it = this.f11888g.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).d(i2, i3, intent);
        }
    }

    @Override // android.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f11889h = 1;
        this.f11890i = bundle;
        for (Map.Entry entry : this.f11888g.entrySet()) {
            ((LifecycleCallback) entry.getValue()).e(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f11889h = 5;
        Iterator it = this.f11888g.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).f();
        }
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f11889h = 3;
        Iterator it = this.f11888g.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).g();
        }
    }

    @Override // android.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle == null) {
            return;
        }
        for (Map.Entry entry : this.f11888g.entrySet()) {
            Bundle bundle2 = new Bundle();
            ((LifecycleCallback) entry.getValue()).h(bundle2);
            bundle.putBundle((String) entry.getKey(), bundle2);
        }
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        this.f11889h = 2;
        Iterator it = this.f11888g.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).i();
        }
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        this.f11889h = 4;
        Iterator it = this.f11888g.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).j();
        }
    }
}
