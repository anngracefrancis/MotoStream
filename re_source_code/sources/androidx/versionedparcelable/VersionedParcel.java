package androidx.versionedparcelable;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class VersionedParcel {
    protected final c.e.a<String, Method> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final c.e.a<String, Method> f2238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final c.e.a<String, Class> f2239c;

    public static class ParcelException extends RuntimeException {
    }

    public VersionedParcel(c.e.a<String, Method> aVar, c.e.a<String, Method> aVar2, c.e.a<String, Class> aVar3) {
        this.a = aVar;
        this.f2238b = aVar2;
        this.f2239c = aVar3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void N(b bVar) {
        try {
            I(c(bVar.getClass()).getName());
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException(bVar.getClass().getSimpleName() + " does not have a Parcelizer", e2);
        }
    }

    private Class c(Class<? extends b> cls) throws ClassNotFoundException {
        Class cls2 = this.f2239c.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
        this.f2239c.put(cls.getName(), cls3);
        return cls3;
    }

    private Method d(String str) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = this.a.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, VersionedParcel.class.getClassLoader()).getDeclaredMethod("read", VersionedParcel.class);
        this.a.put(str, declaredMethod);
        return declaredMethod;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Method e(Class cls) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = this.f2238b.get(cls.getName());
        if (method != null) {
            return method;
        }
        Class clsC = c(cls);
        System.currentTimeMillis();
        Method declaredMethod = clsC.getDeclaredMethod("write", cls, VersionedParcel.class);
        this.f2238b.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    protected abstract void A(byte[] bArr);

    public void B(byte[] bArr, int i2) {
        w(i2);
        A(bArr);
    }

    protected abstract void C(CharSequence charSequence);

    public void D(CharSequence charSequence, int i2) {
        w(i2);
        C(charSequence);
    }

    protected abstract void E(int i2);

    public void F(int i2, int i3) {
        w(i3);
        E(i2);
    }

    protected abstract void G(Parcelable parcelable);

    public void H(Parcelable parcelable, int i2) {
        w(i2);
        G(parcelable);
    }

    protected abstract void I(String str);

    public void J(String str, int i2) {
        w(i2);
        I(str);
    }

    protected <T extends b> void K(T t, VersionedParcel versionedParcel) {
        try {
            e(t.getClass()).invoke(null, t, versionedParcel);
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e2);
        } catch (IllegalAccessException e3) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e4);
        } catch (InvocationTargetException e5) {
            if (!(e5.getCause() instanceof RuntimeException)) {
                throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e5);
            }
            throw ((RuntimeException) e5.getCause());
        }
    }

    protected void L(b bVar) {
        if (bVar == null) {
            I(null);
            return;
        }
        N(bVar);
        VersionedParcel versionedParcelB = b();
        K(bVar, versionedParcelB);
        versionedParcelB.a();
    }

    public void M(b bVar, int i2) {
        w(i2);
        L(bVar);
    }

    protected abstract void a();

    protected abstract VersionedParcel b();

    public boolean f() {
        return false;
    }

    protected abstract boolean g();

    public boolean h(boolean z, int i2) {
        return !m(i2) ? z : g();
    }

    protected abstract byte[] i();

    public byte[] j(byte[] bArr, int i2) {
        return !m(i2) ? bArr : i();
    }

    protected abstract CharSequence k();

    public CharSequence l(CharSequence charSequence, int i2) {
        return !m(i2) ? charSequence : k();
    }

    protected abstract boolean m(int i2);

    protected <T extends b> T n(String str, VersionedParcel versionedParcel) {
        try {
            return (T) d(str).invoke(null, versionedParcel);
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e2);
        } catch (IllegalAccessException e3) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e4);
        } catch (InvocationTargetException e5) {
            if (e5.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e5.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e5);
        }
    }

    protected abstract int o();

    public int p(int i2, int i3) {
        return !m(i3) ? i2 : o();
    }

    protected abstract <T extends Parcelable> T q();

    public <T extends Parcelable> T r(T t, int i2) {
        return !m(i2) ? t : (T) q();
    }

    protected abstract String s();

    public String t(String str, int i2) {
        return !m(i2) ? str : s();
    }

    protected <T extends b> T u() {
        String strS = s();
        if (strS == null) {
            return null;
        }
        return (T) n(strS, b());
    }

    public <T extends b> T v(T t, int i2) {
        return !m(i2) ? t : (T) u();
    }

    protected abstract void w(int i2);

    public void x(boolean z, boolean z2) {
    }

    protected abstract void y(boolean z);

    public void z(boolean z, int i2) {
        w(i2);
        y(z);
    }
}
