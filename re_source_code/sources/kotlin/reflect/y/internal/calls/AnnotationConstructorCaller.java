package kotlin.reflect.y.internal.calls;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.c0;
import kotlin.collections.q0;
import kotlin.collections.v;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b.d;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlin.f0.y.e.i0.a, reason: from Kotlin metadata */
/* JADX INFO: compiled from: AnnotationConstructorCaller.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0002 !B?\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006¢\u0006\u0002\u0010\u000eJ\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00102\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u001eH\u0016¢\u0006\u0002\u0010\u001fR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\""}, d2 = {"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller;", "Lkotlin/reflect/jvm/internal/calls/Caller;", HttpUrl.FRAGMENT_ENCODE_SET, "jClass", "Ljava/lang/Class;", "parameterNames", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "callMode", "Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;", "origin", "Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;", "methods", "Ljava/lang/reflect/Method;", "(Ljava/lang/Class;Ljava/util/List;Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;Ljava/util/List;)V", "defaultValues", HttpUrl.FRAGMENT_ENCODE_SET, "erasedParameterTypes", "member", "getMember", "()Ljava/lang/Void;", "parameterTypes", "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "call", "args", HttpUrl.FRAGMENT_ENCODE_SET, "([Ljava/lang/Object;)Ljava/lang/Object;", "CallMode", "Origin", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AnnotationConstructorCaller implements Caller {
    private final Class<?> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<String> f23107b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f23108c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<Method> f23109d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<Type> f23110e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<Class<?>> f23111f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List<Object> f23112g;

    /* JADX INFO: renamed from: kotlin.f0.y.e.i0.a$a */
    /* JADX INFO: compiled from: AnnotationConstructorCaller.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/String;I)V", "CALL_BY_NAME", "POSITIONAL_CALL", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum a {
        CALL_BY_NAME,
        POSITIONAL_CALL
    }

    /* JADX INFO: renamed from: kotlin.f0.y.e.i0.a$b */
    /* JADX INFO: compiled from: AnnotationConstructorCaller.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/String;I)V", "JAVA", "KOTLIN", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum b {
        JAVA,
        KOTLIN
    }

    public AnnotationConstructorCaller(Class<?> cls, List<String> list, a aVar, b bVar, List<Method> list2) {
        m.f(cls, "jClass");
        m.f(list, "parameterNames");
        m.f(aVar, "callMode");
        m.f(bVar, "origin");
        m.f(list2, "methods");
        this.a = cls;
        this.f23107b = list;
        this.f23108c = aVar;
        this.f23109d = list2;
        ArrayList arrayList = new ArrayList(v.u(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((Method) it.next()).getGenericReturnType());
        }
        this.f23110e = arrayList;
        List<Method> list3 = this.f23109d;
        ArrayList arrayList2 = new ArrayList(v.u(list3, 10));
        Iterator<T> it2 = list3.iterator();
        while (it2.hasNext()) {
            Class<?> returnType = ((Method) it2.next()).getReturnType();
            m.e(returnType, "it");
            Class<?> clsF = d.f(returnType);
            if (clsF != null) {
                returnType = clsF;
            }
            arrayList2.add(returnType);
        }
        this.f23111f = arrayList2;
        List<Method> list4 = this.f23109d;
        ArrayList arrayList3 = new ArrayList(v.u(list4, 10));
        Iterator<T> it3 = list4.iterator();
        while (it3.hasNext()) {
            arrayList3.add(((Method) it3.next()).getDefaultValue());
        }
        this.f23112g = arrayList3;
        if (this.f23108c == a.POSITIONAL_CALL && bVar == b.JAVA && (!c0.l0(this.f23107b, "value").isEmpty())) {
            throw new UnsupportedOperationException("Positional call of a Java annotation constructor is allowed only if there are no parameters or one parameter named \"value\". This restriction exists because Java annotations (in contrast to Kotlin)do not impose any order on their arguments. Use KCallable#callBy instead.");
        }
    }

    @Override // kotlin.reflect.y.internal.calls.Caller
    public List<Type> a() {
        return this.f23110e;
    }

    public void b(Object[] objArr) {
        Caller.a.a(this, objArr);
    }

    public Void c() {
        return null;
    }

    @Override // kotlin.reflect.y.internal.calls.Caller
    public Object call(Object[] args) {
        m.f(args, "args");
        b(args);
        ArrayList arrayList = new ArrayList(args.length);
        int length = args.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            Object obj = args[i2];
            int i4 = i3 + 1;
            Object objL = (obj == null && this.f23108c == a.CALL_BY_NAME) ? this.f23112g.get(i3) : kotlin.reflect.y.internal.calls.b.l(obj, this.f23111f.get(i3));
            if (objL == null) {
                kotlin.reflect.y.internal.calls.b.k(i3, this.f23107b.get(i3), this.f23111f.get(i3));
                throw null;
            }
            arrayList.add(objL);
            i2++;
            i3 = i4;
        }
        return kotlin.reflect.y.internal.calls.b.f(this.a, q0.q(c0.L0(this.f23107b, arrayList)), this.f23109d);
    }

    @Override // kotlin.reflect.y.internal.calls.Caller
    public /* bridge */ /* synthetic */ Member getMember() {
        return (Member) c();
    }

    @Override // kotlin.reflect.y.internal.calls.Caller
    /* JADX INFO: renamed from: getReturnType */
    public Type getF23144c() {
        return this.a;
    }

    public /* synthetic */ AnnotationConstructorCaller(Class cls, List list, a aVar, b bVar, List list2, int i2, g gVar) {
        if ((i2 & 16) != 0) {
            list2 = new ArrayList(v.u(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                list2.add(cls.getDeclaredMethod((String) it.next(), new Class[0]));
            }
        }
        this(cls, list, aVar, bVar, list2);
    }
}
