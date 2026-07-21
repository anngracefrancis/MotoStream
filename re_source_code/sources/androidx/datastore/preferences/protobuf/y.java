package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.y;
import androidx.datastore.preferences.protobuf.y.a;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: GeneratedMessageLite.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class y<MessageType extends y<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends androidx.datastore.preferences.protobuf.a<MessageType, BuilderType> {
    private static Map<Object, y<?, ?>> defaultInstanceMap = new ConcurrentHashMap();
    protected m1 unknownFields = m1.e();
    protected int memoizedSerializedSize = -1;

    /* JADX INFO: compiled from: GeneratedMessageLite.java */
    public static abstract class a<MessageType extends y<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends androidx.datastore.preferences.protobuf.a.AbstractC0032a<MessageType, BuilderType> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final MessageType f1447f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        protected MessageType f1448g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        protected boolean f1449h = false;

        protected a(MessageType messagetype) {
            this.f1447f = messagetype;
            this.f1448g = (MessageType) messagetype.s(f.NEW_MUTABLE_INSTANCE);
        }

        private void v(MessageType messagetype, MessageType messagetype2) {
            b1.a().e(messagetype).a(messagetype, messagetype2);
        }

        @Override // androidx.datastore.preferences.protobuf.q0.a
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public final MessageType c() {
            MessageType messagetype = (MessageType) J0();
            if (messagetype.isInitialized()) {
                return messagetype;
            }
            throw androidx.datastore.preferences.protobuf.a.AbstractC0032a.n(messagetype);
        }

        @Override // androidx.datastore.preferences.protobuf.q0.a
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public MessageType J0() {
            if (this.f1449h) {
                return this.f1448g;
            }
            this.f1448g.B();
            this.f1449h = true;
            return this.f1448g;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public BuilderType clone() {
            c.l.b.h.a aVar = (BuilderType) b().f();
            aVar.u(J0());
            return aVar;
        }

        protected void r() {
            if (this.f1449h) {
                MessageType messagetype = (MessageType) this.f1448g.s(f.NEW_MUTABLE_INSTANCE);
                v(messagetype, this.f1448g);
                this.f1448g = messagetype;
                this.f1449h = false;
            }
        }

        @Override // androidx.datastore.preferences.protobuf.r0
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public MessageType b() {
            return this.f1447f;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.datastore.preferences.protobuf.a.AbstractC0032a
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public BuilderType l(MessageType messagetype) {
            return (BuilderType) u(messagetype);
        }

        public BuilderType u(MessageType messagetype) {
            r();
            v(this.f1448g, messagetype);
            return this;
        }
    }

    /* JADX INFO: compiled from: GeneratedMessageLite.java */
    protected static class b<T extends y<T, ?>> extends androidx.datastore.preferences.protobuf.b<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final T f1450b;

        public b(T t) {
            this.f1450b = t;
        }

        @Override // androidx.datastore.preferences.protobuf.y0
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public T b(j jVar, p pVar) throws InvalidProtocolBufferException {
            return (T) y.G(this.f1450b, jVar, pVar);
        }
    }

    /* JADX INFO: compiled from: GeneratedMessageLite.java */
    public static abstract class c<MessageType extends c<MessageType, BuilderType>, BuilderType> extends y<MessageType, BuilderType> implements r0 {
        protected u<d> extensions = u.h();

        u<d> J() {
            if (this.extensions.o()) {
                this.extensions = this.extensions.clone();
            }
            return this.extensions;
        }

        @Override // androidx.datastore.preferences.protobuf.y, androidx.datastore.preferences.protobuf.r0
        public /* bridge */ /* synthetic */ q0 b() {
            return super.b();
        }

        @Override // androidx.datastore.preferences.protobuf.y, androidx.datastore.preferences.protobuf.q0
        public /* bridge */ /* synthetic */ q0.a d() {
            return super.d();
        }

        @Override // androidx.datastore.preferences.protobuf.y, androidx.datastore.preferences.protobuf.q0
        public /* bridge */ /* synthetic */ q0.a f() {
            return super.f();
        }
    }

    /* JADX INFO: compiled from: GeneratedMessageLite.java */
    static final class d implements u.b<d> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final a0.d<?> f1451f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final int f1452g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final r1.b f1453h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final boolean f1454i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final boolean f1455j;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.datastore.preferences.protobuf.u.b
        public q0.a B(q0.a aVar, q0 q0Var) {
            return ((a) aVar).u((y) q0Var);
        }

        @Override // androidx.datastore.preferences.protobuf.u.b
        public int f() {
            return this.f1452g;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public int compareTo(d dVar) {
            return this.f1452g - dVar.f1452g;
        }

        @Override // androidx.datastore.preferences.protobuf.u.b
        public boolean h() {
            return this.f1454i;
        }

        @Override // androidx.datastore.preferences.protobuf.u.b
        public r1.b j() {
            return this.f1453h;
        }

        public a0.d<?> k() {
            return this.f1451f;
        }

        @Override // androidx.datastore.preferences.protobuf.u.b
        public r1.c l() {
            return this.f1453h.g();
        }

        @Override // androidx.datastore.preferences.protobuf.u.b
        public boolean m() {
            return this.f1455j;
        }
    }

    /* JADX INFO: compiled from: GeneratedMessageLite.java */
    public static class e<ContainingType extends q0, Type> extends n<ContainingType, Type> {
        final q0 a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final d f1456b;

        public r1.b a() {
            return this.f1456b.j();
        }

        public q0 b() {
            return this.a;
        }

        public int c() {
            return this.f1456b.f();
        }

        public boolean d() {
            return this.f1456b.f1454i;
        }
    }

    /* JADX INFO: compiled from: GeneratedMessageLite.java */
    public enum f {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    protected static final <T extends y<T, ?>> boolean A(T t, boolean z) {
        byte bByteValue = ((Byte) t.s(f.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zG = b1.a().e(t).g(t);
        if (z) {
            t.t(f.SET_MEMOIZED_IS_INITIALIZED, zG ? t : null);
        }
        return zG;
    }

    protected static <E> a0.i<E> C(a0.i<E> iVar) {
        int size = iVar.size();
        return iVar.J(size == 0 ? 10 : size * 2);
    }

    protected static Object E(q0 q0Var, String str, Object[] objArr) {
        return new d1(q0Var, str, objArr);
    }

    protected static <T extends y<T, ?>> T F(T t, InputStream inputStream) throws InvalidProtocolBufferException {
        return (T) q(G(t, j.f(inputStream), p.b()));
    }

    static <T extends y<T, ?>> T G(T t, j jVar, p pVar) throws InvalidProtocolBufferException {
        T t2 = (T) t.s(f.NEW_MUTABLE_INSTANCE);
        try {
            f1 f1VarE = b1.a().e(t2);
            f1VarE.e(t2, k.P(jVar), pVar);
            f1VarE.f(t2);
            return t2;
        } catch (IOException e2) {
            if (e2.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e2.getCause());
            }
            throw new InvalidProtocolBufferException(e2.getMessage()).i(t2);
        } catch (RuntimeException e3) {
            if (e3.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e3.getCause());
            }
            throw e3;
        }
    }

    protected static <T extends y<?, ?>> void H(Class<T> cls, T t) {
        defaultInstanceMap.put(cls, t);
    }

    private static <T extends y<T, ?>> T q(T t) throws InvalidProtocolBufferException {
        if (t == null || t.isInitialized()) {
            return t;
        }
        throw t.m().a().i(t);
    }

    protected static <E> a0.i<E> v() {
        return c1.g();
    }

    static <T extends y<?, ?>> T w(Class<T> cls) {
        y<?, ?> yVar = defaultInstanceMap.get(cls);
        if (yVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                yVar = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (yVar == null) {
            yVar = (T) ((y) p1.i(cls)).b();
            if (yVar == null) {
                throw new IllegalStateException();
            }
            defaultInstanceMap.put(cls, yVar);
        }
        return (T) yVar;
    }

    static Object y(Method method, Object obj, Object... objArr) {
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

    protected void B() {
        b1.a().e(this).f(this);
    }

    @Override // androidx.datastore.preferences.protobuf.q0
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public final BuilderType f() {
        return (BuilderType) s(f.NEW_BUILDER);
    }

    @Override // androidx.datastore.preferences.protobuf.q0
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public final BuilderType d() {
        BuilderType buildertype = (BuilderType) s(f.NEW_BUILDER);
        buildertype.u(this);
        return buildertype;
    }

    @Override // androidx.datastore.preferences.protobuf.q0
    public int e() {
        if (this.memoizedSerializedSize == -1) {
            this.memoizedSerializedSize = b1.a().e(this).i(this);
        }
        return this.memoizedSerializedSize;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (b().getClass().isInstance(obj)) {
            return b1.a().e(this).b(this, (y) obj);
        }
        return false;
    }

    @Override // androidx.datastore.preferences.protobuf.q0
    public final y0<MessageType> g() {
        return (y0) s(f.GET_PARSER);
    }

    public int hashCode() {
        int i2 = this.memoizedHashCode;
        if (i2 != 0) {
            return i2;
        }
        int iD = b1.a().e(this).d(this);
        this.memoizedHashCode = iD;
        return iD;
    }

    @Override // androidx.datastore.preferences.protobuf.q0
    public void i(CodedOutputStream codedOutputStream) throws IOException {
        b1.a().e(this).h(this, l.P(codedOutputStream));
    }

    @Override // androidx.datastore.preferences.protobuf.r0
    public final boolean isInitialized() {
        return A(this, true);
    }

    @Override // androidx.datastore.preferences.protobuf.a
    int j() {
        return this.memoizedSerializedSize;
    }

    @Override // androidx.datastore.preferences.protobuf.a
    void n(int i2) {
        this.memoizedSerializedSize = i2;
    }

    Object p() throws Exception {
        return s(f.BUILD_MESSAGE_INFO);
    }

    protected final <MessageType extends y<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> BuilderType r() {
        return (BuilderType) s(f.NEW_BUILDER);
    }

    protected Object s(f fVar) {
        return u(fVar, null, null);
    }

    protected Object t(f fVar, Object obj) {
        return u(fVar, obj, null);
    }

    public String toString() {
        return s0.e(this, super.toString());
    }

    protected abstract Object u(f fVar, Object obj, Object obj2);

    @Override // androidx.datastore.preferences.protobuf.r0
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public final MessageType b() {
        return (MessageType) s(f.GET_DEFAULT_INSTANCE);
    }
}
