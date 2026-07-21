package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/* JADX INFO: compiled from: SavedStateViewModelFactory.java */
/* JADX INFO: loaded from: classes.dex */
public final class v extends y.c {
    private static final Class<?>[] a = {Application.class, u.class};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Class<?>[] f1772b = {u.class};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Application f1773c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final y.b f1774d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Bundle f1775e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final g f1776f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final SavedStateRegistry f1777g;

    @SuppressLint({"LambdaLast"})
    public v(Application application, androidx.savedstate.c cVar, Bundle bundle) {
        this.f1777g = cVar.getSavedStateRegistry();
        this.f1776f = cVar.getLifecycle();
        this.f1775e = bundle;
        this.f1773c = application;
        this.f1774d = application != null ? y.a.c(application) : y.d.b();
    }

    private static <T> Constructor<T> d(Class<T> cls, Class<?>[] clsArr) {
        for (Object obj : cls.getConstructors()) {
            Constructor<T> constructor = (Constructor<T>) obj;
            if (Arrays.equals(clsArr, constructor.getParameterTypes())) {
                return constructor;
            }
        }
        return null;
    }

    @Override // androidx.lifecycle.y.c, androidx.lifecycle.y.b
    public <T extends x> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) c(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // androidx.lifecycle.y.e
    void b(x xVar) {
        SavedStateHandleController.b(xVar, this.f1777g, this.f1776f);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0046 A[Catch: InvocationTargetException -> 0x005a, InstantiationException -> 0x0076, IllegalAccessException -> 0x0093, TryCatch #2 {IllegalAccessException -> 0x0093, InstantiationException -> 0x0076, InvocationTargetException -> 0x005a, blocks: (B:13:0x0030, B:15:0x0034, B:17:0x0054, B:16:0x0046), top: B:28:0x0030 }] */
    @Override // androidx.lifecycle.y.c
    public <T extends x> T c(String str, Class<T> cls) {
        T t;
        boolean zIsAssignableFrom = a.class.isAssignableFrom(cls);
        Constructor constructorD = (!zIsAssignableFrom || this.f1773c == null) ? d(cls, f1772b) : d(cls, a);
        if (constructorD == null) {
            return (T) this.f1774d.a(cls);
        }
        SavedStateHandleController savedStateHandleControllerD = SavedStateHandleController.d(this.f1777g, this.f1776f, str, this.f1775e);
        if (zIsAssignableFrom) {
            try {
                Application application = this.f1773c;
                if (application != null) {
                    t = (T) constructorD.newInstance(application, savedStateHandleControllerD.e());
                } else {
                    t = (T) constructorD.newInstance(savedStateHandleControllerD.e());
                }
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Failed to access " + cls, e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("A " + cls + " cannot be instantiated.", e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("An exception happened in constructor of " + cls, e4.getCause());
            }
        } else {
            t = (T) constructorD.newInstance(savedStateHandleControllerD.e());
        }
        t.e("androidx.lifecycle.savedstate.vm.tag", savedStateHandleControllerD);
        return t;
    }
}
