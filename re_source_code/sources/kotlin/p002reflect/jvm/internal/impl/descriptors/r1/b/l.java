package kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.u;
import kotlin.collections.v;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.j0;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.m1;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.y.internal.j0.d.a.n0.d0;
import kotlin.reflect.y.internal.j0.d.a.n0.j;
import kotlin.reflect.y.internal.j0.d.a.n0.w;
import kotlin.sequences.n;

/* JADX INFO: compiled from: ReflectJavaClass.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class l extends p implements kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b.h, v, kotlin.reflect.y.internal.j0.d.a.n0.g {
    private final Class<?> a;

    /* JADX INFO: compiled from: ReflectJavaClass.kt */
    /* synthetic */ class a extends i implements Function1<Member, Boolean> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f25349h = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.internal.c, kotlin.reflect.KCallable
        /* JADX INFO: renamed from: getName */
        public final String getM() {
            return "isSynthetic";
        }

        @Override // kotlin.jvm.internal.c
        public final KDeclarationContainer getOwner() {
            return g0.b(Member.class);
        }

        @Override // kotlin.jvm.internal.c
        public final String getSignature() {
            return "isSynthetic()Z";
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Member member) {
            m.f(member, "p0");
            return Boolean.valueOf(member.isSynthetic());
        }
    }

    /* JADX INFO: compiled from: ReflectJavaClass.kt */
    /* synthetic */ class b extends i implements Function1<Constructor<?>, o> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final b f25350h = new b();

        b() {
            super(1);
        }

        @Override // kotlin.jvm.internal.c, kotlin.reflect.KCallable
        /* JADX INFO: renamed from: getName */
        public final String getM() {
            return "<init>";
        }

        @Override // kotlin.jvm.internal.c
        public final KDeclarationContainer getOwner() {
            return g0.b(o.class);
        }

        @Override // kotlin.jvm.internal.c
        public final String getSignature() {
            return "<init>(Ljava/lang/reflect/Constructor;)V";
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public final o invoke(Constructor<?> constructor) {
            m.f(constructor, "p0");
            return new o(constructor);
        }
    }

    /* JADX INFO: compiled from: ReflectJavaClass.kt */
    /* synthetic */ class c extends i implements Function1<Member, Boolean> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final c f25351h = new c();

        c() {
            super(1);
        }

        @Override // kotlin.jvm.internal.c, kotlin.reflect.KCallable
        /* JADX INFO: renamed from: getName */
        public final String getM() {
            return "isSynthetic";
        }

        @Override // kotlin.jvm.internal.c
        public final KDeclarationContainer getOwner() {
            return g0.b(Member.class);
        }

        @Override // kotlin.jvm.internal.c
        public final String getSignature() {
            return "isSynthetic()Z";
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Member member) {
            m.f(member, "p0");
            return Boolean.valueOf(member.isSynthetic());
        }
    }

    /* JADX INFO: compiled from: ReflectJavaClass.kt */
    /* synthetic */ class d extends i implements Function1<Field, r> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final d f25352h = new d();

        d() {
            super(1);
        }

        @Override // kotlin.jvm.internal.c, kotlin.reflect.KCallable
        /* JADX INFO: renamed from: getName */
        public final String getM() {
            return "<init>";
        }

        @Override // kotlin.jvm.internal.c
        public final KDeclarationContainer getOwner() {
            return g0.b(r.class);
        }

        @Override // kotlin.jvm.internal.c
        public final String getSignature() {
            return "<init>(Ljava/lang/reflect/Field;)V";
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public final r invoke(Field field) {
            m.f(field, "p0");
            return new r(field);
        }
    }

    /* JADX INFO: compiled from: ReflectJavaClass.kt */
    static final class e extends Lambda implements Function1<Class<?>, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final e f25353f = new e();

        e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Class<?> cls) {
            String simpleName = cls.getSimpleName();
            m.e(simpleName, "it.simpleName");
            return Boolean.valueOf(simpleName.length() == 0);
        }
    }

    /* JADX INFO: compiled from: ReflectJavaClass.kt */
    static final class f extends Lambda implements Function1<Class<?>, kotlin.reflect.y.internal.j0.f.f> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final f f25354f = new f();

        f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final kotlin.reflect.y.internal.j0.f.f invoke(Class<?> cls) {
            String simpleName = cls.getSimpleName();
            if (!kotlin.reflect.y.internal.j0.f.f.A(simpleName)) {
                simpleName = null;
            }
            if (simpleName != null) {
                return kotlin.reflect.y.internal.j0.f.f.x(simpleName);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: ReflectJavaClass.kt */
    static final class g extends Lambda implements Function1<Method, Boolean> {
        g() {
            super(1);
        }

        /* JADX WARN: Code duplicated, block: B:4:0x0008  */
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Method method) {
            boolean z = true;
            if (method.isSynthetic()) {
                z = false;
            } else if (l.this.B()) {
                l lVar = l.this;
                m.e(method, "method");
                if (lVar.a0(method)) {
                    z = false;
                }
            }
            return Boolean.valueOf(z);
        }
    }

    /* JADX INFO: compiled from: ReflectJavaClass.kt */
    /* synthetic */ class h extends i implements Function1<Method, u> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final h f25356h = new h();

        h() {
            super(1);
        }

        @Override // kotlin.jvm.internal.c, kotlin.reflect.KCallable
        /* JADX INFO: renamed from: getName */
        public final String getM() {
            return "<init>";
        }

        @Override // kotlin.jvm.internal.c
        public final KDeclarationContainer getOwner() {
            return g0.b(u.class);
        }

        @Override // kotlin.jvm.internal.c
        public final String getSignature() {
            return "<init>(Ljava/lang/reflect/Method;)V";
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public final u invoke(Method method) {
            m.f(method, "p0");
            return new u(method);
        }
    }

    public l(Class<?> cls) {
        m.f(cls, "klass");
        this.a = cls;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean a0(Method method) {
        String name = method.getName();
        if (m.a(name, "values")) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            m.e(parameterTypes, "method.parameterTypes");
            if (parameterTypes.length == 0) {
                return true;
            }
        } else if (m.a(name, "valueOf")) {
            return Arrays.equals(method.getParameterTypes(), new Class[]{String.class});
        }
        return false;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.g
    public boolean B() {
        return this.a.isEnum();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b.v
    public int E() {
        return this.a.getModifiers();
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.g
    public boolean H() {
        return this.a.isInterface();
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.g
    public d0 I() {
        return null;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.g
    public Collection<j> N() throws IllegalAccessException, InvocationTargetException {
        Class<?>[] clsArrC = kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b.b.a.c(this.a);
        if (clsArrC == null) {
            return u.j();
        }
        ArrayList arrayList = new ArrayList(clsArrC.length);
        for (Class<?> cls : clsArrC) {
            arrayList.add(new n(cls));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.s
    public boolean Q() {
        return v.a.d(this);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.d
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b.e l(kotlin.reflect.y.internal.j0.f.c cVar) {
        return kotlin.reflect.jvm.internal.impl.descriptors.r1.b.h.a.a(this, cVar);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.d
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public List<kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b.e> getAnnotations() {
        return kotlin.reflect.jvm.internal.impl.descriptors.r1.b.h.a.b(this);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.g
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public List<o> k() {
        Constructor<?>[] declaredConstructors = this.a.getDeclaredConstructors();
        m.e(declaredConstructors, "klass.declaredConstructors");
        return n.A(n.u(n.m(kotlin.collections.n.r(declaredConstructors), a.f25349h), b.f25350h));
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b.h
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public Class<?> w() {
        return this.a;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.g
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public List<r> D() {
        Field[] declaredFields = this.a.getDeclaredFields();
        m.e(declaredFields, "klass.declaredFields");
        return n.A(n.u(n.m(kotlin.collections.n.r(declaredFields), c.f25351h), d.f25352h));
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.g
    /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] */
    public List<kotlin.reflect.y.internal.j0.f.f> K() {
        Class<?>[] declaredClasses = this.a.getDeclaredClasses();
        m.e(declaredClasses, "klass.declaredClasses");
        return n.A(n.v(n.m(kotlin.collections.n.r(declaredClasses), e.f25353f), f.f25354f));
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.g
    /* JADX INFO: renamed from: Y, reason: merged with bridge method [inline-methods] */
    public List<u> M() {
        Method[] declaredMethods = this.a.getDeclaredMethods();
        m.e(declaredMethods, "klass.declaredMethods");
        return n.A(n.u(n.l(kotlin.collections.n.r(declaredMethods), new g()), h.f25356h));
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.g
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public l i() {
        Class<?> declaringClass = this.a.getDeclaringClass();
        if (declaringClass != null) {
            return new l(declaringClass);
        }
        return null;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.g
    public Collection<j> a() {
        if (m.a(this.a, Object.class)) {
            return u.j();
        }
        j0 j0Var = new j0(2);
        Type genericSuperclass = this.a.getGenericSuperclass();
        j0Var.a(genericSuperclass != null ? genericSuperclass : Object.class);
        Type[] genericInterfaces = this.a.getGenericInterfaces();
        m.e(genericInterfaces, "klass.genericInterfaces");
        j0Var.b(genericInterfaces);
        List listM = u.m(j0Var.d(new Type[j0Var.c()]));
        ArrayList arrayList = new ArrayList(v.u(listM, 10));
        Iterator it = listM.iterator();
        while (it.hasNext()) {
            arrayList.add(new n((Type) it.next()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.g
    public kotlin.reflect.y.internal.j0.f.c d() {
        kotlin.reflect.y.internal.j0.f.c cVarB = kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b.d.a(this.a).b();
        m.e(cVarB, "klass.classId.asSingleFqName()");
        return cVarB;
    }

    public boolean equals(Object obj) {
        return (obj instanceof l) && m.a(this.a, ((l) obj).a);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.t
    public kotlin.reflect.y.internal.j0.f.f getName() {
        kotlin.reflect.y.internal.j0.f.f fVarX = kotlin.reflect.y.internal.j0.f.f.x(this.a.getSimpleName());
        m.e(fVarX, "identifier(klass.simpleName)");
        return fVarX;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.z
    public List<a0> getTypeParameters() {
        TypeVariable<Class<?>>[] typeParameters = this.a.getTypeParameters();
        m.e(typeParameters, "klass.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Class<?>> typeVariable : typeParameters) {
            arrayList.add(new a0(typeVariable));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.s
    public m1 getVisibility() {
        return v.a.a(this);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.s
    public boolean isAbstract() {
        return v.a.b(this);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.s
    public boolean isFinal() {
        return v.a.c(this);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.g
    public Collection<w> j() {
        Object[] objArrD = kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b.b.a.d(this.a);
        if (objArrD == null) {
            objArrD = new Object[0];
        }
        ArrayList arrayList = new ArrayList(objArrD.length);
        for (Object obj : objArrD) {
            arrayList.add(new y(obj));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.d
    public boolean m() {
        return kotlin.reflect.jvm.internal.impl.descriptors.r1.b.h.a.c(this);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.g
    public boolean o() throws IllegalAccessException, InvocationTargetException {
        Boolean boolF = kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b.b.a.f(this.a);
        if (boolF != null) {
            return boolF.booleanValue();
        }
        return false;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.g
    public boolean r() {
        return this.a.isAnnotation();
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.g
    public boolean t() throws IllegalAccessException, InvocationTargetException {
        Boolean boolE = kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b.b.a.e(this.a);
        if (boolE != null) {
            return boolE.booleanValue();
        }
        return false;
    }

    public String toString() {
        return l.class.getName() + ": " + this.a;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.g
    public boolean u() {
        return false;
    }
}
