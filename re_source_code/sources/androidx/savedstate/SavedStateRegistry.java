package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.lifecycle.g;
import androidx.lifecycle.i;
import androidx.lifecycle.k;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedApi"})
public final class SavedStateRegistry {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Bundle f2232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f2233c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Recreator.a f2234d;
    private c.b.a.b.b<String, b> a = new c.b.a.b.b<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f2235e = true;

    public interface a {
        void a(c cVar);
    }

    public interface b {
        Bundle a();
    }

    SavedStateRegistry() {
    }

    public Bundle a(String str) {
        if (!this.f2233c) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        Bundle bundle = this.f2232b;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle.getBundle(str);
        this.f2232b.remove(str);
        if (this.f2232b.isEmpty()) {
            this.f2232b = null;
        }
        return bundle2;
    }

    void b(g gVar, Bundle bundle) {
        if (this.f2233c) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        if (bundle != null) {
            this.f2232b = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
        }
        gVar.a(new i() { // from class: androidx.savedstate.SavedStateRegistry.1
            @Override // androidx.lifecycle.i
            public void a(k kVar, g.b bVar) {
                if (bVar == g.b.ON_START) {
                    SavedStateRegistry.this.f2235e = true;
                } else if (bVar == g.b.ON_STOP) {
                    SavedStateRegistry.this.f2235e = false;
                }
            }
        });
        this.f2233c = true;
    }

    void c(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.f2232b;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        c.b.a.b.b<String, b>.d dVarH = this.a.h();
        while (dVarH.hasNext()) {
            Map.Entry next = dVarH.next();
            bundle2.putBundle((String) next.getKey(), ((b) next.getValue()).a());
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }

    public void d(String str, b bVar) {
        if (this.a.o(str, bVar) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    public void e(Class<? extends a> cls) {
        if (!this.f2235e) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.f2234d == null) {
            this.f2234d = new Recreator.a(this);
        }
        try {
            cls.getDeclaredConstructor(new Class[0]);
            this.f2234d.b(cls.getName());
        } catch (NoSuchMethodException e2) {
            throw new IllegalArgumentException("Class" + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e2);
        }
    }
}
