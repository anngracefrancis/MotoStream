package kotlin.reflect.y.internal;

import cm.aptoide.pt.database.room.RoomInstalled;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.k0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t0;
import kotlin.p002reflect.jvm.internal.impl.protobuf.h;
import kotlin.reflect.y.internal.j0.d.a.z;
import kotlin.reflect.y.internal.j0.d.b.k;
import kotlin.reflect.y.internal.j0.e.a0.b.i;
import kotlin.reflect.y.internal.j0.e.n;
import kotlin.reflect.y.internal.j0.e.z.e;
import kotlin.reflect.y.internal.j0.e.z.g;
import kotlin.reflect.y.internal.j0.j.b.g0.f;
import kotlin.reflect.y.internal.j0.j.b.g0.j;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlin.f0.y.e.e, reason: from Kotlin metadata */
/* JADX INFO: compiled from: RuntimeTypeMapper.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0004\u0005\u0006\u0007\bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u0082\u0001\u0004\t\n\u000b\f¨\u0006\r"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmPropertySignature;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "asString", HttpUrl.FRAGMENT_ENCODE_SET, "JavaField", "JavaMethodProperty", "KotlinProperty", "MappedKotlinProperty", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaField;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaMethodProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$KotlinProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature$MappedKotlinProperty;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class JvmPropertySignature {

    /* JADX INFO: renamed from: kotlin.f0.y.e.e$a */
    /* JADX INFO: compiled from: RuntimeTypeMapper.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaField;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "getField", "()Ljava/lang/reflect/Field;", "asString", HttpUrl.FRAGMENT_ENCODE_SET, "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a extends JvmPropertySignature {
        private final Field a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Field field) {
            super(null);
            m.f(field, "field");
            this.a = field;
        }

        @Override // kotlin.reflect.y.internal.JvmPropertySignature
        /* JADX INFO: renamed from: a */
        public String getF23039f() {
            StringBuilder sb = new StringBuilder();
            String name = this.a.getName();
            m.e(name, "field.name");
            sb.append(z.b(name));
            sb.append("()");
            Class<?> type = this.a.getType();
            m.e(type, "field.type");
            sb.append(kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b.d.b(type));
            return sb.toString();
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final Field getA() {
            return this.a;
        }
    }

    /* JADX INFO: renamed from: kotlin.f0.y.e.e$b */
    /* JADX INFO: compiled from: RuntimeTypeMapper.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u000b"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaMethodProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "getterMethod", "Ljava/lang/reflect/Method;", "setterMethod", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "getGetterMethod", "()Ljava/lang/reflect/Method;", "getSetterMethod", "asString", HttpUrl.FRAGMENT_ENCODE_SET, "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b extends JvmPropertySignature {
        private final Method a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Method f23034b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Method method, Method method2) {
            super(null);
            m.f(method, "getterMethod");
            this.a = method;
            this.f23034b = method2;
        }

        @Override // kotlin.reflect.y.internal.JvmPropertySignature
        /* JADX INFO: renamed from: a */
        public String getF23039f() {
            return e0.b(this.a);
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final Method getA() {
            return this.a;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final Method getF23034b() {
            return this.f23034b;
        }
    }

    /* JADX INFO: renamed from: kotlin.f0.y.e.e$c */
    /* JADX INFO: compiled from: RuntimeTypeMapper.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u0019\u001a\u00020\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0016H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmPropertySignature$KotlinProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "proto", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property;", RoomInstalled.SIGNATURE, "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature;", "nameResolver", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/NameResolver;", "typeTable", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/TypeTable;", "(Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;Lorg/jetbrains/kotlin/metadata/jvm/JvmProtoBuf$JvmPropertySignature;Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;)V", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "getNameResolver", "()Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;", "getProto", "()Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;", "getSignature", "()Lorg/jetbrains/kotlin/metadata/jvm/JvmProtoBuf$JvmPropertySignature;", "string", HttpUrl.FRAGMENT_ENCODE_SET, "getTypeTable", "()Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;", "asString", "getManglingSuffix", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c extends JvmPropertySignature {
        private final t0 a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final n f23035b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final kotlin.f0.y.e.j0.e.a0.a.d f23036c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final kotlin.reflect.y.internal.j0.e.z.c f23037d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final g f23038e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final String f23039f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(t0 t0Var, n nVar, kotlin.f0.y.e.j0.e.a0.a.d dVar, kotlin.reflect.y.internal.j0.e.z.c cVar, g gVar) {
            String str;
            super(null);
            m.f(t0Var, "descriptor");
            m.f(nVar, "proto");
            m.f(dVar, RoomInstalled.SIGNATURE);
            m.f(cVar, "nameResolver");
            m.f(gVar, "typeTable");
            this.a = t0Var;
            this.f23035b = nVar;
            this.f23036c = dVar;
            this.f23037d = cVar;
            this.f23038e = gVar;
            if (dVar.G()) {
                str = cVar.getString(dVar.B().x()) + cVar.getString(dVar.B().w());
            } else {
                kotlin.f0.y.e.j0.e.a0.b.d.a aVarD = i.d(i.a, nVar, cVar, gVar, false, 8, null);
                if (aVarD == null) {
                    throw new KotlinReflectionInternalError("No field signature for property: " + t0Var);
                }
                String strD = aVarD.d();
                str = z.b(strD) + c() + "()" + aVarD.e();
            }
            this.f23039f = str;
        }

        private final String c() {
            String string;
            kotlin.p002reflect.jvm.internal.impl.descriptors.m mVarB = this.a.b();
            m.e(mVarB, "descriptor.containingDeclaration");
            if (m.a(this.a.getVisibility(), t.f25367d) && (mVarB instanceof kotlin.reflect.y.internal.j0.j.b.g0.d)) {
                kotlin.reflect.y.internal.j0.e.c cVarC1 = ((kotlin.reflect.y.internal.j0.j.b.g0.d) mVarB).c1();
                h.f<kotlin.reflect.y.internal.j0.e.c, Integer> fVar = kotlin.reflect.y.internal.j0.e.a0.a.f23828i;
                m.e(fVar, "classModuleName");
                Integer num = (Integer) e.a(cVarC1, fVar);
                if (num == null || (string = this.f23037d.getString(num.intValue())) == null) {
                    string = "main";
                }
                return '$' + kotlin.reflect.y.internal.j0.f.g.a(string);
            }
            if (!m.a(this.a.getVisibility(), t.a) || !(mVarB instanceof k0)) {
                return HttpUrl.FRAGMENT_ENCODE_SET;
            }
            t0 t0Var = this.a;
            m.d(t0Var, "null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.descriptors.DeserializedPropertyDescriptor");
            f fVarC0 = ((j) t0Var).c0();
            if (!(fVarC0 instanceof k)) {
                return HttpUrl.FRAGMENT_ENCODE_SET;
            }
            k kVar = (k) fVarC0;
            if (kVar.f() == null) {
                return HttpUrl.FRAGMENT_ENCODE_SET;
            }
            return '$' + kVar.h().k();
        }

        @Override // kotlin.reflect.y.internal.JvmPropertySignature
        /* JADX INFO: renamed from: a, reason: from getter */
        public String getF23039f() {
            return this.f23039f;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final t0 getA() {
            return this.a;
        }

        /* JADX INFO: renamed from: d, reason: from getter */
        public final kotlin.reflect.y.internal.j0.e.z.c getF23037d() {
            return this.f23037d;
        }

        /* JADX INFO: renamed from: e, reason: from getter */
        public final n getF23035b() {
            return this.f23035b;
        }

        /* JADX INFO: renamed from: f, reason: from getter */
        public final kotlin.f0.y.e.j0.e.a0.a.d getF23036c() {
            return this.f23036c;
        }

        /* JADX INFO: renamed from: g, reason: from getter */
        public final g getF23038e() {
            return this.f23038e;
        }
    }

    /* JADX INFO: renamed from: kotlin.f0.y.e.e$d */
    /* JADX INFO: compiled from: RuntimeTypeMapper.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u000b"}, d2 = {"Lkotlin/reflect/jvm/internal/JvmPropertySignature$MappedKotlinProperty;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "getterSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "setterSignature", "(Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;)V", "getGetterSignature", "()Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "getSetterSignature", "asString", HttpUrl.FRAGMENT_ENCODE_SET, "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class d extends JvmPropertySignature {
        private final JvmFunctionSignature.e a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final JvmFunctionSignature.e f23040b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(JvmFunctionSignature.e eVar, JvmFunctionSignature.e eVar2) {
            super(null);
            m.f(eVar, "getterSignature");
            this.a = eVar;
            this.f23040b = eVar2;
        }

        @Override // kotlin.reflect.y.internal.JvmPropertySignature
        /* JADX INFO: renamed from: a */
        public String getF23039f() {
            return this.a.getF23032b();
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final JvmFunctionSignature.e getA() {
            return this.a;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final JvmFunctionSignature.e getF23040b() {
            return this.f23040b;
        }
    }

    private JvmPropertySignature() {
    }

    public /* synthetic */ JvmPropertySignature(kotlin.jvm.internal.g gVar) {
        this();
    }

    /* JADX INFO: renamed from: a */
    public abstract String getF23039f();
}
