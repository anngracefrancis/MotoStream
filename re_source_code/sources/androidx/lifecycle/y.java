package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: ViewModelProvider.java */
/* JADX INFO: loaded from: classes.dex */
public class y {
    private final b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final z f1784b;

    /* JADX INFO: compiled from: ViewModelProvider.java */
    public static class a extends d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static a f1785b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Application f1786c;

        public a(Application application) {
            this.f1786c = application;
        }

        public static a c(Application application) {
            if (f1785b == null) {
                f1785b = new a(application);
            }
            return f1785b;
        }

        @Override // androidx.lifecycle.y.d, androidx.lifecycle.y.b
        public <T extends x> T a(Class<T> cls) {
            if (!androidx.lifecycle.a.class.isAssignableFrom(cls)) {
                return (T) super.a(cls);
            }
            try {
                return cls.getConstructor(Application.class).newInstance(this.f1786c);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("Cannot create an instance of " + cls, e3);
            } catch (NoSuchMethodException e4) {
                throw new RuntimeException("Cannot create an instance of " + cls, e4);
            } catch (InvocationTargetException e5) {
                throw new RuntimeException("Cannot create an instance of " + cls, e5);
            }
        }
    }

    /* JADX INFO: compiled from: ViewModelProvider.java */
    public interface b {
        <T extends x> T a(Class<T> cls);
    }

    /* JADX INFO: compiled from: ViewModelProvider.java */
    static abstract class c extends e implements b {
        c() {
        }

        public <T extends x> T a(Class<T> cls) {
            throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementaions of KeyedFactory");
        }

        public abstract <T extends x> T c(String str, Class<T> cls);
    }

    /* JADX INFO: compiled from: ViewModelProvider.java */
    public static class d implements b {
        private static d a;

        static d b() {
            if (a == null) {
                a = new d();
            }
            return a;
        }

        @Override // androidx.lifecycle.y.b
        public <T extends x> T a(Class<T> cls) {
            try {
                return cls.newInstance();
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("Cannot create an instance of " + cls, e3);
            }
        }
    }

    /* JADX INFO: compiled from: ViewModelProvider.java */
    static class e {
        e() {
        }

        void b(x xVar) {
        }
    }

    public y(z zVar, b bVar) {
        this.a = bVar;
        this.f1784b = zVar;
    }

    public <T extends x> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return (T) b("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public <T extends x> T b(String str, Class<T> cls) {
        T t = (T) this.f1784b.b(str);
        if (cls.isInstance(t)) {
            Object obj = this.a;
            if (obj instanceof e) {
                ((e) obj).b(t);
            }
            return t;
        }
        b bVar = this.a;
        T t2 = bVar instanceof c ? (T) ((c) bVar).c(str, cls) : (T) bVar.a(cls);
        this.f1784b.d(str, t2);
        return t2;
    }
}
