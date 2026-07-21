package kotlin.p002reflect.jvm.internal.impl.utils;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.u;

/* JADX INFO: compiled from: functions.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    private static final Function1<Object, Object> a = f.f25517f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Function1<Object, Boolean> f25507b = b.f25513f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Function1<Object, Object> f25508c = a.f25512f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Function1<Object, u> f25509d = c.f25514f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Function2<Object, Object, u> f25510e = C0418d.f25515f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Function3<Object, Object, Object, u> f25511f = e.f25516f;

    /* JADX INFO: compiled from: functions.kt */
    static final class a extends Lambda implements Function1 {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f25512f = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Void invoke(Object obj) {
            return null;
        }
    }

    /* JADX INFO: compiled from: functions.kt */
    static final class b extends Lambda implements Function1<Object, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f25513f = new b();

        b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Object obj) {
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: compiled from: functions.kt */
    static final class c extends Lambda implements Function1<Object, u> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f25514f = new c();

        c() {
            super(1);
        }

        public final void b(Object obj) {
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ u invoke(Object obj) {
            b(obj);
            return u.a;
        }
    }

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.utils.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: functions.kt */
    static final class C0418d extends Lambda implements Function2<Object, Object, u> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final C0418d f25515f = new C0418d();

        C0418d() {
            super(2);
        }

        public final void b(Object obj, Object obj2) {
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ u invoke(Object obj, Object obj2) {
            b(obj, obj2);
            return u.a;
        }
    }

    /* JADX INFO: compiled from: functions.kt */
    static final class e extends Lambda implements Function3<Object, Object, Object, u> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final e f25516f = new e();

        e() {
            super(3);
        }

        public final void b(Object obj, Object obj2, Object obj3) {
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ u d(Object obj, Object obj2, Object obj3) {
            b(obj, obj2, obj3);
            return u.a;
        }
    }

    /* JADX INFO: compiled from: functions.kt */
    static final class f extends Lambda implements Function1<Object, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final f f25517f = new f();

        f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return obj;
        }
    }

    public static final <T> Function1<T, Boolean> a() {
        return (Function1<T, Boolean>) f25507b;
    }

    public static final Function3<Object, Object, Object, u> b() {
        return f25511f;
    }
}
