package androidx.lifecycle;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class SavedStateHandleController implements i {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1742b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final u f1743c;

    static final class a implements SavedStateRegistry.a {
        a() {
        }

        @Override // androidx.savedstate.SavedStateRegistry.a
        public void a(androidx.savedstate.c cVar) {
            if (!(cVar instanceof a0)) {
                throw new IllegalStateException("Internal error: OnRecreation should be registered only on componentsthat implement ViewModelStoreOwner");
            }
            z viewModelStore = ((a0) cVar).getViewModelStore();
            SavedStateRegistry savedStateRegistry = cVar.getSavedStateRegistry();
            Iterator<String> it = viewModelStore.c().iterator();
            while (it.hasNext()) {
                SavedStateHandleController.b(viewModelStore.b(it.next()), savedStateRegistry, cVar.getLifecycle());
            }
            if (viewModelStore.c().isEmpty()) {
                return;
            }
            savedStateRegistry.e(a.class);
        }
    }

    SavedStateHandleController(String str, u uVar) {
        this.a = str;
        this.f1743c = uVar;
    }

    static void b(x xVar, SavedStateRegistry savedStateRegistry, g gVar) {
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) xVar.c("androidx.lifecycle.savedstate.vm.tag");
        if (savedStateHandleController == null || savedStateHandleController.f()) {
            return;
        }
        savedStateHandleController.c(savedStateRegistry, gVar);
        g(savedStateRegistry, gVar);
    }

    static SavedStateHandleController d(SavedStateRegistry savedStateRegistry, g gVar, String str, Bundle bundle) {
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, u.a(savedStateRegistry.a(str), bundle));
        savedStateHandleController.c(savedStateRegistry, gVar);
        g(savedStateRegistry, gVar);
        return savedStateHandleController;
    }

    private static void g(final SavedStateRegistry savedStateRegistry, final g gVar) {
        g.c cVarB = gVar.b();
        if (cVarB == g.c.INITIALIZED || cVarB.g(g.c.STARTED)) {
            savedStateRegistry.e(a.class);
        } else {
            gVar.a(new i() { // from class: androidx.lifecycle.SavedStateHandleController.1
                @Override // androidx.lifecycle.i
                public void a(k kVar, g.b bVar) {
                    if (bVar == g.b.ON_START) {
                        gVar.c(this);
                        savedStateRegistry.e(a.class);
                    }
                }
            });
        }
    }

    @Override // androidx.lifecycle.i
    public void a(k kVar, g.b bVar) {
        if (bVar == g.b.ON_DESTROY) {
            this.f1742b = false;
            kVar.getLifecycle().c(this);
        }
    }

    void c(SavedStateRegistry savedStateRegistry, g gVar) {
        if (this.f1742b) {
            throw new IllegalStateException("Already attached to lifecycleOwner");
        }
        this.f1742b = true;
        gVar.a(this);
        savedStateRegistry.d(this.a, this.f1743c.b());
    }

    u e() {
        return this.f1743c;
    }

    boolean f() {
        return this.f1742b;
    }
}
