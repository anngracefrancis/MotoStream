package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfd;
import com.google.android.gms.internal.measurement.zzfd.zzb;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzfd<MessageType extends zzfd<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzdl<MessageType, BuilderType> {
    private static Map<Object, zzfd<?, ?>> zzd = new ConcurrentHashMap();
    protected zzhy zzb = zzhy.a();
    private int zzc = -1;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
    static final class a implements zzey<a> {
        @Override // com.google.android.gms.internal.measurement.zzey
        public final int a() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzey
        public final zzim b() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzey
        public final zzip c() {
            throw new NoSuchMethodError();
        }

        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzey
        public final boolean d() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzey
        public final boolean e() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzey
        public final zzgn o(zzgn zzgnVar, zzgo zzgoVar) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzey
        public final zzgt z(zzgt zzgtVar, zzgt zzgtVar2) {
            throw new NoSuchMethodError();
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
    public static class zza<T extends zzfd<T, ?>> extends zzdp<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final T f17393b;

        public zza(T t) {
            this.f17393b = t;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
    public static abstract class zzb<MessageType extends zzfd<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzdn<MessageType, BuilderType> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final MessageType f17394f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        protected MessageType f17395g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f17396h = false;

        protected zzb(MessageType messagetype) {
            this.f17394f = messagetype;
            this.f17395g = (MessageType) messagetype.p(zze.f17399d, null, null);
        }

        private static void q(MessageType messagetype, MessageType messagetype2) {
            l3.a().c(messagetype).j(messagetype, messagetype2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.google.android.gms.internal.measurement.zzdn
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public final BuilderType k(zzeg zzegVar, zzeq zzeqVar) throws IOException {
            t();
            try {
                l3.a().c(this.f17395g).i(this.f17395g, z1.P(zzegVar), zzeqVar);
                return this;
            } catch (RuntimeException e2) {
                if (e2.getCause() instanceof IOException) {
                    throw ((IOException) e2.getCause());
                }
                throw e2;
            }
        }

        private final BuilderType s(byte[] bArr, int i2, int i3, zzeq zzeqVar) throws zzfo {
            t();
            try {
                l3.a().c(this.f17395g).d(this.f17395g, bArr, 0, i3 + 0, new m1(zzeqVar));
                return this;
            } catch (zzfo e2) {
                throw e2;
            } catch (IOException e3) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e3);
            } catch (IndexOutOfBoundsException unused) {
                throw zzfo.a();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.measurement.zzdn
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zzb zzbVar = (zzb) this.f17394f.p(zze.f17400e, null, null);
            zzbVar.j((zzfd) x());
            return zzbVar;
        }

        @Override // com.google.android.gms.internal.measurement.zzgq
        public final /* synthetic */ zzgo d() {
            return this.f17394f;
        }

        @Override // com.google.android.gms.internal.measurement.zzdn
        public final /* synthetic */ zzdn l(byte[] bArr, int i2, int i3) throws zzfo {
            return s(bArr, 0, i3, zzeq.a());
        }

        @Override // com.google.android.gms.internal.measurement.zzdn
        public final /* synthetic */ zzdn m(byte[] bArr, int i2, int i3, zzeq zzeqVar) throws zzfo {
            return s(bArr, 0, i3, zzeqVar);
        }

        @Override // com.google.android.gms.internal.measurement.zzdn
        /* JADX INFO: renamed from: o */
        public final /* synthetic */ zzdn clone() {
            return (zzb) clone();
        }

        @Override // com.google.android.gms.internal.measurement.zzdn
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public final BuilderType j(MessageType messagetype) {
            t();
            q(this.f17395g, messagetype);
            return this;
        }

        protected final void t() {
            if (this.f17396h) {
                MessageType messagetype = (MessageType) this.f17395g.p(zze.f17399d, null, null);
                q(messagetype, this.f17395g);
                this.f17395g = messagetype;
                this.f17396h = false;
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzgn
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public MessageType x() {
            if (this.f17396h) {
                return this.f17395g;
            }
            MessageType messagetype = this.f17395g;
            l3.a().c(messagetype).f(messagetype);
            this.f17396h = true;
            return this.f17395g;
        }

        @Override // com.google.android.gms.internal.measurement.zzgn
        /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
        public final MessageType y() {
            MessageType messagetype = (MessageType) x();
            if (messagetype.b()) {
                return messagetype;
            }
            throw new zzhw(messagetype);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
    public static abstract class zzd<MessageType extends zzd<MessageType, BuilderType>, BuilderType> extends zzfd<MessageType, BuilderType> implements zzgq {
        protected h2<a> zzc = h2.c();

        final h2<a> B() {
            if (this.zzc.n()) {
                this.zzc = (h2) this.zzc.clone();
            }
            return this.zzc;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
    public static final enum zze {
        public static final int a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f17397b = 2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f17398c = 3;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f17399d = 4;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f17400e = 5;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f17401f = 6;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f17402g = 7;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f17404i = 1;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f17405j = 2;
        public static final int l = 1;
        public static final int m = 2;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final /* synthetic */ int[] f17403h = {1, 2, 3, 4, 5, 6, 7};

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final /* synthetic */ int[] f17406k = {1, 2};
        private static final /* synthetic */ int[] n = {1, 2};

        public static int[] a() {
            return (int[]) f17403h.clone();
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
    public static class zzf<ContainingType extends zzgo, Type> extends zzer<ContainingType, Type> {
    }

    protected static <E> zzfl<E> A() {
        return o3.h();
    }

    static <T extends zzfd<?, ?>> T m(Class<T> cls) {
        zzfd<?, ?> zzfdVar = zzd.get(cls);
        if (zzfdVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzfdVar = zzd.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (zzfdVar == null) {
            zzfdVar = (T) ((zzfd) k4.c(cls)).p(zze.f17401f, null, null);
            if (zzfdVar == null) {
                throw new IllegalStateException();
            }
            zzd.put(cls, zzfdVar);
        }
        return (T) zzfdVar;
    }

    protected static <E> zzfl<E> n(zzfl<E> zzflVar) {
        int size = zzflVar.size();
        return zzflVar.d(size == 0 ? 10 : size << 1);
    }

    protected static zzfm o(zzfm zzfmVar) {
        int size = zzfmVar.size();
        return zzfmVar.d(size == 0 ? 10 : size << 1);
    }

    protected static Object q(zzgo zzgoVar, String str, Object[] objArr) {
        return new n3(zzgoVar, str, objArr);
    }

    static Object r(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    protected static <T extends zzfd<?, ?>> void s(Class<T> cls, T t) {
        zzd.put(cls, t);
    }

    protected static final <T extends zzfd<T, ?>> boolean t(T t, boolean z) {
        byte bByteValue = ((Byte) t.p(zze.a, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zE = l3.a().c(t).e(t);
        if (z) {
            t.p(zze.f17397b, zE ? t : null, null);
        }
        return zE;
    }

    protected static zzfj w() {
        return n2.g();
    }

    protected static zzfm z() {
        return w2.f();
    }

    @Override // com.google.android.gms.internal.measurement.zzgq
    public final boolean b() {
        return t(this, true);
    }

    @Override // com.google.android.gms.internal.measurement.zzgq
    public final /* synthetic */ zzgo d() {
        return (zzfd) p(zze.f17401f, null, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzgo
    public final /* synthetic */ zzgn e() {
        zzb zzbVar = (zzb) p(zze.f17400e, null, null);
        zzbVar.j(this);
        return zzbVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (((zzfd) p(zze.f17401f, null, null)).getClass().isInstance(obj)) {
            return l3.a().c(this).g(this, (zzfd) obj);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzgo
    public final /* synthetic */ zzgn f() {
        return (zzb) p(zze.f17400e, null, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzgo
    public final void g(zzen zzenVar) throws IOException {
        l3.a().c(this).h(this, c2.P(zzenVar));
    }

    public int hashCode() {
        int i2 = this.zza;
        if (i2 != 0) {
            return i2;
        }
        int iC = l3.a().c(this).c(this);
        this.zza = iC;
        return iC;
    }

    @Override // com.google.android.gms.internal.measurement.zzgo
    public final int i() {
        if (this.zzc == -1) {
            this.zzc = l3.a().c(this).b(this);
        }
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    final int k() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    final void l(int i2) {
        this.zzc = i2;
    }

    protected abstract Object p(int i2, Object obj, Object obj2);

    public String toString() {
        return f3.a(this, super.toString());
    }

    protected final <MessageType extends zzfd<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> BuilderType u() {
        return (BuilderType) p(zze.f17400e, null, null);
    }

    public final BuilderType v() {
        BuilderType buildertype = (BuilderType) p(zze.f17400e, null, null);
        buildertype.j(this);
        return buildertype;
    }
}
