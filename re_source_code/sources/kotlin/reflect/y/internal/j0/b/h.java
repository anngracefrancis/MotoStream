package kotlin.reflect.y.internal.j0.b;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.g0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.k0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.p0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.p1.x;
import kotlin.p002reflect.jvm.internal.impl.descriptors.s;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.u0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.k.g;
import kotlin.reflect.y.internal.j0.k.i;
import kotlin.reflect.y.internal.j0.k.n;
import kotlin.reflect.y.internal.j0.l.b1;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.e1;
import kotlin.reflect.y.internal.j0.l.f0;
import kotlin.reflect.y.internal.j0.l.i1;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.n1;
import kotlin.reflect.y.internal.j0.l.r1;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: KotlinBuiltIns.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class h {
    public static final f a = f.D("<built-ins module>");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private x f23159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private i<x> f23160c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final i<e> f23161d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final i<Collection<p0>> f23162e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final g<f, kotlin.p002reflect.jvm.internal.impl.descriptors.e> f23163f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final n f23164g;

    /* JADX INFO: compiled from: KotlinBuiltIns.java */
    class a implements Function0<Collection<p0>> {
        a() {
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Collection<p0> invoke() {
            return Arrays.asList(h.this.r().N(k.r), h.this.r().N(k.t), h.this.r().N(k.u), h.this.r().N(k.s));
        }
    }

    /* JADX INFO: compiled from: KotlinBuiltIns.java */
    class b implements Function0<e> {
        b() {
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public e invoke() {
            EnumMap enumMap = new EnumMap(i.class);
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            for (i iVar : i.values()) {
                m0 m0VarQ = h.this.q(iVar.v().k());
                m0 m0VarQ2 = h.this.q(iVar.q().k());
                enumMap.put(iVar, m0VarQ2);
                map.put(m0VarQ, m0VarQ2);
                map2.put(m0VarQ2, m0VarQ);
            }
            return new e(enumMap, map, map2, null);
        }
    }

    /* JADX INFO: compiled from: KotlinBuiltIns.java */
    class c implements Function1<f, kotlin.p002reflect.jvm.internal.impl.descriptors.e> {
        c() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public kotlin.p002reflect.jvm.internal.impl.descriptors.e invoke(f fVar) {
            kotlin.p002reflect.jvm.internal.impl.descriptors.h hVarF = h.this.s().f(fVar, kotlin.reflect.y.internal.j0.c.b.d.FROM_BUILTINS);
            if (hVarF == null) {
                throw new AssertionError("Built-in class " + k.r.c(fVar) + " is not found");
            }
            if (hVarF instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.e) {
                return (kotlin.p002reflect.jvm.internal.impl.descriptors.e) hVarF;
            }
            throw new AssertionError("Must be a class descriptor " + fVar + ", but was " + hVarF);
        }
    }

    /* JADX INFO: compiled from: KotlinBuiltIns.java */
    class d implements Function0<Void> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ x f23168f;

        d(x xVar) {
            this.f23168f = xVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void invoke() {
            if (h.this.f23159b == null) {
                h.this.f23159b = this.f23168f;
                return null;
            }
            throw new AssertionError("Built-ins module is already set: " + h.this.f23159b + " (attempting to reset to " + this.f23168f + ")");
        }
    }

    /* JADX INFO: compiled from: KotlinBuiltIns.java */
    private static class e {
        public final Map<i, m0> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<e0, m0> f23170b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<m0, m0> f23171c;

        /* synthetic */ e(Map map, Map map2, Map map3, a aVar) {
            this(map, map2, map3);
        }

        private static /* synthetic */ void a(int i2) {
            Object[] objArr = new Object[3];
            if (i2 == 1) {
                objArr[0] = "primitiveKotlinTypeToKotlinArrayType";
            } else if (i2 != 2) {
                objArr[0] = "primitiveTypeToArrayKotlinType";
            } else {
                objArr[0] = "kotlinArrayTypeToPrimitiveKotlinType";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$Primitives";
            objArr[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        private e(Map<i, m0> map, Map<e0, m0> map2, Map<m0, m0> map3) {
            if (map == null) {
                a(0);
            }
            if (map2 == null) {
                a(1);
            }
            if (map3 == null) {
                a(2);
            }
            this.a = map;
            this.f23170b = map2;
            this.f23171c = map3;
        }
    }

    protected h(n nVar) {
        if (nVar == null) {
            a(0);
        }
        this.f23164g = nVar;
        this.f23162e = nVar.d(new a());
        this.f23161d = nVar.d(new b());
        this.f23163f = nVar.h(new c());
    }

    private static e0 A(e0 e0Var, g0 g0Var) {
        kotlin.reflect.y.internal.j0.f.b bVarG;
        kotlin.reflect.y.internal.j0.f.b bVarA;
        kotlin.p002reflect.jvm.internal.impl.descriptors.e eVarA;
        if (e0Var == null) {
            a(71);
        }
        if (g0Var == null) {
            a(72);
        }
        kotlin.p002reflect.jvm.internal.impl.descriptors.h hVarC = e0Var.O0().c();
        if (hVarC == null) {
            return null;
        }
        o oVar = o.a;
        if (!oVar.b(hVarC.getName()) || (bVarG = kotlin.reflect.y.internal.j0.i.t.a.g(hVarC)) == null || (bVarA = oVar.a(bVarG)) == null || (eVarA = kotlin.p002reflect.jvm.internal.impl.descriptors.x.a(g0Var, bVarA)) == null) {
            return null;
        }
        return eVarA.s();
    }

    public static boolean A0(m mVar) {
        if (mVar == null) {
            a(10);
        }
        while (mVar != null) {
            if (mVar instanceof k0) {
                return ((k0) mVar).d().i(k.q);
            }
            mVar = mVar.b();
        }
        return false;
    }

    public static boolean B0(e0 e0Var) {
        if (e0Var == null) {
            a(142);
        }
        return l0(e0Var, k.a.f23205f);
    }

    public static boolean C0(e0 e0Var) {
        if (e0Var == null) {
            a(132);
        }
        return w0(e0Var) || z0(e0Var) || x0(e0Var) || y0(e0Var);
    }

    public static i N(e0 e0Var) {
        if (e0Var == null) {
            a(92);
        }
        kotlin.p002reflect.jvm.internal.impl.descriptors.h hVarC = e0Var.O0().c();
        if (hVarC == null) {
            return null;
        }
        return P(hVarC);
    }

    public static i P(m mVar) {
        if (mVar == null) {
            a(77);
        }
        if (k.a.H0.contains(mVar.getName())) {
            return k.a.J0.get(kotlin.reflect.y.internal.j0.i.d.m(mVar));
        }
        return null;
    }

    private kotlin.p002reflect.jvm.internal.impl.descriptors.e Q(i iVar) {
        if (iVar == null) {
            a(16);
        }
        return p(iVar.v().k());
    }

    public static i S(m mVar) {
        if (mVar == null) {
            a(76);
        }
        if (k.a.G0.contains(mVar.getName())) {
            return k.a.I0.get(kotlin.reflect.y.internal.j0.i.d.m(mVar));
        }
        return null;
    }

    private static /* synthetic */ void a(int i2) {
        String str;
        int i3;
        switch (i2) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 13:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 68:
            case 69:
            case 70:
            case 74:
            case 81:
            case 84:
            case 86:
            case 87:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 9:
            case 10:
            case 12:
            case 14:
            case 16:
            case 17:
            case 46:
            case 53:
            case 67:
            case 71:
            case 72:
            case 73:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 82:
            case 83:
            case 85:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 13:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 68:
            case 69:
            case 70:
            case 74:
            case 81:
            case 84:
            case 86:
            case 87:
                i3 = 2;
                break;
            case 9:
            case 10:
            case 12:
            case 14:
            case 16:
            case 17:
            case 46:
            case 53:
            case 67:
            case 71:
            case 72:
            case 73:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 82:
            case 83:
            case 85:
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
            case 72:
                objArr[0] = "module";
                break;
            case 2:
                objArr[0] = "computation";
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 13:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 68:
            case 69:
            case 70:
            case 74:
            case 81:
            case 84:
            case 86:
            case 87:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
                break;
            case 9:
            case 10:
            case 76:
            case 77:
            case 89:
            case 96:
            case 103:
            case 107:
            case 108:
            case 145:
            case 146:
            case 148:
            case 156:
            case 157:
            case 158:
            case 159:
                objArr[0] = "descriptor";
                break;
            case 12:
            case 98:
            case 100:
            case 102:
            case 104:
            case 106:
            case 135:
                objArr[0] = "fqName";
                break;
            case 14:
                objArr[0] = "simpleName";
                break;
            case 16:
            case 17:
            case 53:
            case 88:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 97:
            case 99:
            case 105:
            case 109:
            case 110:
            case 111:
            case 113:
            case 114:
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
            case 121:
            case 122:
            case 123:
            case 124:
            case 125:
            case WebSocketProtocol.PAYLOAD_SHORT /* 126 */:
            case 127:
            case 128:
            case 129:
            case 130:
            case 131:
            case 132:
            case 133:
            case 134:
            case 136:
            case 137:
            case 138:
            case 139:
            case 140:
            case 141:
            case 142:
            case 143:
            case 144:
            case 147:
            case 149:
            case 150:
            case 151:
            case 152:
            case 153:
            case 154:
            case 155:
            case 161:
                objArr[0] = "type";
                break;
            case 46:
                objArr[0] = "classSimpleName";
                break;
            case 67:
                objArr[0] = "arrayType";
                break;
            case 71:
                objArr[0] = "notNullArrayType";
                break;
            case 73:
                objArr[0] = "primitiveType";
                break;
            case 75:
                objArr[0] = "kotlinType";
                break;
            case 78:
            case 82:
                objArr[0] = "projectionType";
                break;
            case 79:
            case 83:
            case 85:
                objArr[0] = "argument";
                break;
            case 80:
                objArr[0] = "annotations";
                break;
            case 101:
                objArr[0] = "typeConstructor";
                break;
            case 112:
                objArr[0] = "classDescriptor";
                break;
            case 160:
                objArr[0] = "declarationDescriptor";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        switch (i2) {
            case 3:
                objArr[1] = "getAdditionalClassPartsProvider";
                break;
            case 4:
                objArr[1] = "getPlatformDependentDeclarationFilter";
                break;
            case 5:
                objArr[1] = "getClassDescriptorFactories";
                break;
            case 6:
                objArr[1] = "getStorageManager";
                break;
            case 7:
                objArr[1] = "getBuiltInsModule";
                break;
            case 8:
                objArr[1] = "getBuiltInPackagesImportedByDefault";
                break;
            case 9:
            case 10:
            case 12:
            case 14:
            case 16:
            case 17:
            case 46:
            case 53:
            case 67:
            case 71:
            case 72:
            case 73:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 82:
            case 83:
            case 85:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
                break;
            case 11:
                objArr[1] = "getBuiltInsPackageScope";
                break;
            case 13:
                objArr[1] = "getBuiltInClassByFqName";
                break;
            case 15:
                objArr[1] = "getBuiltInClassByName";
                break;
            case 18:
                objArr[1] = "getSuspendFunction";
                break;
            case 19:
                objArr[1] = "getKFunction";
                break;
            case 20:
                objArr[1] = "getKSuspendFunction";
                break;
            case 21:
                objArr[1] = "getKClass";
                break;
            case 22:
                objArr[1] = "getKCallable";
                break;
            case 23:
                objArr[1] = "getKProperty";
                break;
            case 24:
                objArr[1] = "getKProperty0";
                break;
            case 25:
                objArr[1] = "getKProperty1";
                break;
            case 26:
                objArr[1] = "getKProperty2";
                break;
            case 27:
                objArr[1] = "getKMutableProperty0";
                break;
            case 28:
                objArr[1] = "getKMutableProperty1";
                break;
            case 29:
                objArr[1] = "getKMutableProperty2";
                break;
            case 30:
                objArr[1] = "getIterator";
                break;
            case 31:
                objArr[1] = "getIterable";
                break;
            case 32:
                objArr[1] = "getMutableIterable";
                break;
            case 33:
                objArr[1] = "getMutableIterator";
                break;
            case 34:
                objArr[1] = "getCollection";
                break;
            case 35:
                objArr[1] = "getMutableCollection";
                break;
            case 36:
                objArr[1] = "getList";
                break;
            case 37:
                objArr[1] = "getMutableList";
                break;
            case 38:
                objArr[1] = "getSet";
                break;
            case 39:
                objArr[1] = "getMutableSet";
                break;
            case 40:
                objArr[1] = "getMap";
                break;
            case 41:
                objArr[1] = "getMutableMap";
                break;
            case 42:
                objArr[1] = "getMapEntry";
                break;
            case 43:
                objArr[1] = "getMutableMapEntry";
                break;
            case 44:
                objArr[1] = "getListIterator";
                break;
            case 45:
                objArr[1] = "getMutableListIterator";
                break;
            case 47:
                objArr[1] = "getBuiltInTypeByClassName";
                break;
            case 48:
                objArr[1] = "getNothingType";
                break;
            case 49:
                objArr[1] = "getNullableNothingType";
                break;
            case 50:
                objArr[1] = "getAnyType";
                break;
            case 51:
                objArr[1] = "getNullableAnyType";
                break;
            case 52:
                objArr[1] = "getDefaultBound";
                break;
            case 54:
                objArr[1] = "getPrimitiveKotlinType";
                break;
            case 55:
                objArr[1] = "getNumberType";
                break;
            case 56:
                objArr[1] = "getByteType";
                break;
            case 57:
                objArr[1] = "getShortType";
                break;
            case 58:
                objArr[1] = "getIntType";
                break;
            case 59:
                objArr[1] = "getLongType";
                break;
            case 60:
                objArr[1] = "getFloatType";
                break;
            case 61:
                objArr[1] = "getDoubleType";
                break;
            case 62:
                objArr[1] = "getCharType";
                break;
            case 63:
                objArr[1] = "getBooleanType";
                break;
            case 64:
                objArr[1] = "getUnitType";
                break;
            case 65:
                objArr[1] = "getStringType";
                break;
            case 66:
                objArr[1] = "getIterableType";
                break;
            case 68:
            case 69:
            case 70:
                objArr[1] = "getArrayElementType";
                break;
            case 74:
                objArr[1] = "getPrimitiveArrayKotlinType";
                break;
            case 81:
            case 84:
                objArr[1] = "getArrayType";
                break;
            case 86:
                objArr[1] = "getEnumType";
                break;
            case 87:
                objArr[1] = "getAnnotationType";
                break;
        }
        switch (i2) {
            case 1:
                objArr[2] = "setBuiltInsModule";
                break;
            case 2:
                objArr[2] = "setPostponedBuiltinsModuleComputation";
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 13:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 68:
            case 69:
            case 70:
            case 74:
            case 81:
            case 84:
            case 86:
            case 87:
                break;
            case 9:
                objArr[2] = "isBuiltIn";
                break;
            case 10:
                objArr[2] = "isUnderKotlinPackage";
                break;
            case 12:
                objArr[2] = "getBuiltInClassByFqName";
                break;
            case 14:
                objArr[2] = "getBuiltInClassByName";
                break;
            case 16:
                objArr[2] = "getPrimitiveClassDescriptor";
                break;
            case 17:
                objArr[2] = "getPrimitiveArrayClassDescriptor";
                break;
            case 46:
                objArr[2] = "getBuiltInTypeByClassName";
                break;
            case 53:
                objArr[2] = "getPrimitiveKotlinType";
                break;
            case 67:
                objArr[2] = "getArrayElementType";
                break;
            case 71:
            case 72:
                objArr[2] = "getElementTypeForUnsignedArray";
                break;
            case 73:
                objArr[2] = "getPrimitiveArrayKotlinType";
                break;
            case 75:
                objArr[2] = "getPrimitiveArrayKotlinTypeByPrimitiveKotlinType";
                break;
            case 76:
            case 93:
                objArr[2] = "getPrimitiveType";
                break;
            case 77:
                objArr[2] = "getPrimitiveArrayType";
                break;
            case 78:
            case 79:
            case 80:
            case 82:
            case 83:
                objArr[2] = "getArrayType";
                break;
            case 85:
                objArr[2] = "getEnumType";
                break;
            case 88:
                objArr[2] = "isArray";
                break;
            case 89:
            case 90:
                objArr[2] = "isArrayOrPrimitiveArray";
                break;
            case 91:
                objArr[2] = "isPrimitiveArray";
                break;
            case 92:
                objArr[2] = "getPrimitiveArrayElementType";
                break;
            case 94:
                objArr[2] = "isPrimitiveType";
                break;
            case 95:
                objArr[2] = "isPrimitiveTypeOrNullablePrimitiveType";
                break;
            case 96:
                objArr[2] = "isPrimitiveClass";
                break;
            case 97:
            case 98:
            case 99:
            case 100:
                objArr[2] = "isConstructedFromGivenClass";
                break;
            case 101:
            case 102:
                objArr[2] = "isTypeConstructorForGivenClass";
                break;
            case 103:
            case 104:
                objArr[2] = "classFqNameEquals";
                break;
            case 105:
            case 106:
                objArr[2] = "isNotNullConstructedFromGivenClass";
                break;
            case 107:
                objArr[2] = "isSpecialClassWithNoSupertypes";
                break;
            case 108:
            case 109:
                objArr[2] = "isAny";
                break;
            case 110:
            case 112:
                objArr[2] = "isBoolean";
                break;
            case 111:
                objArr[2] = "isBooleanOrNullableBoolean";
                break;
            case 113:
                objArr[2] = "isNumber";
                break;
            case 114:
                objArr[2] = "isChar";
                break;
            case 115:
                objArr[2] = "isCharOrNullableChar";
                break;
            case 116:
                objArr[2] = "isInt";
                break;
            case 117:
                objArr[2] = "isByte";
                break;
            case 118:
                objArr[2] = "isLong";
                break;
            case 119:
                objArr[2] = "isLongOrNullableLong";
                break;
            case 120:
                objArr[2] = "isShort";
                break;
            case 121:
                objArr[2] = "isFloat";
                break;
            case 122:
                objArr[2] = "isFloatOrNullableFloat";
                break;
            case 123:
                objArr[2] = "isDouble";
                break;
            case 124:
                objArr[2] = "isUByte";
                break;
            case 125:
                objArr[2] = "isUShort";
                break;
            case WebSocketProtocol.PAYLOAD_SHORT /* 126 */:
                objArr[2] = "isUInt";
                break;
            case 127:
                objArr[2] = "isULong";
                break;
            case 128:
                objArr[2] = "isUByteArray";
                break;
            case 129:
                objArr[2] = "isUShortArray";
                break;
            case 130:
                objArr[2] = "isUIntArray";
                break;
            case 131:
                objArr[2] = "isULongArray";
                break;
            case 132:
                objArr[2] = "isUnsignedArrayType";
                break;
            case 133:
                objArr[2] = "isDoubleOrNullableDouble";
                break;
            case 134:
            case 135:
                objArr[2] = "isConstructedFromGivenClassAndNotNullable";
                break;
            case 136:
                objArr[2] = "isNothing";
                break;
            case 137:
                objArr[2] = "isNullableNothing";
                break;
            case 138:
                objArr[2] = "isNothingOrNullableNothing";
                break;
            case 139:
                objArr[2] = "isAnyOrNullableAny";
                break;
            case 140:
                objArr[2] = "isNullableAny";
                break;
            case 141:
                objArr[2] = "isDefaultBound";
                break;
            case 142:
                objArr[2] = "isUnit";
                break;
            case 143:
                objArr[2] = "isUnitOrNullableUnit";
                break;
            case 144:
                objArr[2] = "isBooleanOrSubtype";
                break;
            case 145:
                objArr[2] = "isMemberOfAny";
                break;
            case 146:
            case 147:
                objArr[2] = "isEnum";
                break;
            case 148:
            case 149:
                objArr[2] = "isComparable";
                break;
            case 150:
                objArr[2] = "isCollectionOrNullableCollection";
                break;
            case 151:
                objArr[2] = "isListOrNullableList";
                break;
            case 152:
                objArr[2] = "isSetOrNullableSet";
                break;
            case 153:
                objArr[2] = "isMapOrNullableMap";
                break;
            case 154:
                objArr[2] = "isIterableOrNullableIterable";
                break;
            case 155:
                objArr[2] = "isThrowableOrNullableThrowable";
                break;
            case 156:
                objArr[2] = "isThrowable";
                break;
            case 157:
                objArr[2] = "isKClass";
                break;
            case 158:
                objArr[2] = "isNonPrimitiveArray";
                break;
            case 159:
                objArr[2] = "isCloneable";
                break;
            case 160:
                objArr[2] = "isDeprecated";
                break;
            case 161:
                objArr[2] = "isNotNullOrNullableFunctionSupertype";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i2) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 13:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 68:
            case 69:
            case 70:
            case 74:
            case 81:
            case 84:
            case 86:
            case 87:
                throw new IllegalStateException(str2);
            case 9:
            case 10:
            case 12:
            case 14:
            case 16:
            case 17:
            case 46:
            case 53:
            case 67:
            case 71:
            case 72:
            case 73:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 82:
            case 83:
            case 85:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public static boolean a0(kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar) {
        if (eVar == null) {
            a(108);
        }
        return e(eVar, k.a.f23201b);
    }

    public static boolean b0(e0 e0Var) {
        if (e0Var == null) {
            a(139);
        }
        return g0(e0Var, k.a.f23201b);
    }

    public static boolean c0(e0 e0Var) {
        if (e0Var == null) {
            a(88);
        }
        return g0(e0Var, k.a.f23208i);
    }

    public static boolean d0(kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar) {
        if (eVar == null) {
            a(89);
        }
        return e(eVar, k.a.f23208i) || P(eVar) != null;
    }

    private static boolean e(kotlin.p002reflect.jvm.internal.impl.descriptors.h hVar, kotlin.reflect.y.internal.j0.f.d dVar) {
        if (hVar == null) {
            a(103);
        }
        if (dVar == null) {
            a(104);
        }
        return hVar.getName().equals(dVar.i()) && dVar.equals(kotlin.reflect.y.internal.j0.i.d.m(hVar));
    }

    public static boolean e0(e0 e0Var) {
        if (e0Var == null) {
            a(90);
        }
        return c0(e0Var) || p0(e0Var);
    }

    public static boolean f0(m mVar) {
        if (mVar == null) {
            a(9);
        }
        return kotlin.reflect.y.internal.j0.i.d.r(mVar, kotlin.reflect.y.internal.j0.b.b.class, false) != null;
    }

    private static boolean g0(e0 e0Var, kotlin.reflect.y.internal.j0.f.d dVar) {
        if (e0Var == null) {
            a(97);
        }
        if (dVar == null) {
            a(98);
        }
        return v0(e0Var.O0(), dVar);
    }

    private static boolean h0(e0 e0Var, kotlin.reflect.y.internal.j0.f.d dVar) {
        if (e0Var == null) {
            a(134);
        }
        if (dVar == null) {
            a(135);
        }
        return g0(e0Var, dVar) && !e0Var.P0();
    }

    public static boolean i0(e0 e0Var) {
        if (e0Var == null) {
            a(141);
        }
        return o0(e0Var);
    }

    public static boolean j0(m mVar) {
        if (mVar == null) {
            a(160);
        }
        if (mVar.a().getAnnotations().R0(k.a.y)) {
            return true;
        }
        if (!(mVar instanceof t0)) {
            return false;
        }
        t0 t0Var = (t0) mVar;
        boolean zJ0 = t0Var.j0();
        u0 getter = t0Var.getGetter();
        v0 setter = t0Var.getSetter();
        if (getter != null && j0(getter)) {
            if (!zJ0) {
                return true;
            }
            if (setter != null && j0(setter)) {
                return true;
            }
        }
        return false;
    }

    public static boolean k0(kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar) {
        if (eVar == null) {
            a(157);
        }
        return e(eVar, k.a.i0);
    }

    private static boolean l0(e0 e0Var, kotlin.reflect.y.internal.j0.f.d dVar) {
        if (e0Var == null) {
            a(105);
        }
        if (dVar == null) {
            a(106);
        }
        return !e0Var.P0() && g0(e0Var, dVar);
    }

    public static boolean m0(e0 e0Var) {
        if (e0Var == null) {
            a(136);
        }
        return n0(e0Var) && !n1.l(e0Var);
    }

    public static boolean n0(e0 e0Var) {
        if (e0Var == null) {
            a(138);
        }
        return g0(e0Var, k.a.f23202c);
    }

    public static boolean o0(e0 e0Var) {
        if (e0Var == null) {
            a(140);
        }
        return b0(e0Var) && e0Var.P0();
    }

    private kotlin.p002reflect.jvm.internal.impl.descriptors.e p(String str) {
        if (str == null) {
            a(14);
        }
        kotlin.p002reflect.jvm.internal.impl.descriptors.e eVarInvoke = this.f23163f.invoke(f.x(str));
        if (eVarInvoke == null) {
            a(15);
        }
        return eVarInvoke;
    }

    public static boolean p0(e0 e0Var) {
        if (e0Var == null) {
            a(91);
        }
        kotlin.p002reflect.jvm.internal.impl.descriptors.h hVarC = e0Var.O0().c();
        return (hVarC == null || P(hVarC) == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public m0 q(String str) {
        if (str == null) {
            a(46);
        }
        m0 m0VarS = p(str).s();
        if (m0VarS == null) {
            a(47);
        }
        return m0VarS;
    }

    public static boolean q0(kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar) {
        if (eVar == null) {
            a(96);
        }
        return S(eVar) != null;
    }

    public static boolean r0(e0 e0Var) {
        if (e0Var == null) {
            a(94);
        }
        return !e0Var.P0() && s0(e0Var);
    }

    public static boolean s0(e0 e0Var) {
        if (e0Var == null) {
            a(95);
        }
        kotlin.p002reflect.jvm.internal.impl.descriptors.h hVarC = e0Var.O0().c();
        return (hVarC instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.e) && q0((kotlin.p002reflect.jvm.internal.impl.descriptors.e) hVarC);
    }

    public static boolean t0(kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar) {
        if (eVar == null) {
            a(107);
        }
        return e(eVar, k.a.f23201b) || e(eVar, k.a.f23202c);
    }

    public static boolean u0(e0 e0Var) {
        return e0Var != null && l0(e0Var, k.a.f23207h);
    }

    public static boolean v0(e1 e1Var, kotlin.reflect.y.internal.j0.f.d dVar) {
        if (e1Var == null) {
            a(101);
        }
        if (dVar == null) {
            a(102);
        }
        kotlin.p002reflect.jvm.internal.impl.descriptors.h hVarC = e1Var.c();
        return (hVarC instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.e) && e(hVarC, dVar);
    }

    public static boolean w0(e0 e0Var) {
        if (e0Var == null) {
            a(128);
        }
        return h0(e0Var, k.a.C0.j());
    }

    public static boolean x0(e0 e0Var) {
        if (e0Var == null) {
            a(130);
        }
        return h0(e0Var, k.a.E0.j());
    }

    public static boolean y0(e0 e0Var) {
        if (e0Var == null) {
            a(131);
        }
        return h0(e0Var, k.a.F0.j());
    }

    public static boolean z0(e0 e0Var) {
        if (e0Var == null) {
            a(129);
        }
        return h0(e0Var, k.a.D0.j());
    }

    public m0 B() {
        m0 m0VarR = R(i.FLOAT);
        if (m0VarR == null) {
            a(60);
        }
        return m0VarR;
    }

    public kotlin.p002reflect.jvm.internal.impl.descriptors.e C(int i2) {
        return p(k.b(i2));
    }

    public m0 D() {
        m0 m0VarR = R(i.INT);
        if (m0VarR == null) {
            a(58);
        }
        return m0VarR;
    }

    public void D0(x xVar) {
        if (xVar == null) {
            a(1);
        }
        this.f23164g.e(new d(xVar));
    }

    public kotlin.p002reflect.jvm.internal.impl.descriptors.e E() {
        kotlin.p002reflect.jvm.internal.impl.descriptors.e eVarO = o(k.a.i0.l());
        if (eVarO == null) {
            a(21);
        }
        return eVarO;
    }

    public m0 F() {
        m0 m0VarR = R(i.LONG);
        if (m0VarR == null) {
            a(59);
        }
        return m0VarR;
    }

    public kotlin.p002reflect.jvm.internal.impl.descriptors.e G() {
        return p("Nothing");
    }

    public m0 H() {
        m0 m0VarS = G().s();
        if (m0VarS == null) {
            a(48);
        }
        return m0VarS;
    }

    public m0 I() {
        m0 m0VarV0 = i().S0(true);
        if (m0VarV0 == null) {
            a(51);
        }
        return m0VarV0;
    }

    public m0 J() {
        m0 m0VarV0 = H().S0(true);
        if (m0VarV0 == null) {
            a(49);
        }
        return m0VarV0;
    }

    public kotlin.p002reflect.jvm.internal.impl.descriptors.e K() {
        return p("Number");
    }

    public m0 L() {
        m0 m0VarS = K().s();
        if (m0VarS == null) {
            a(55);
        }
        return m0VarS;
    }

    protected kotlin.p002reflect.jvm.internal.impl.descriptors.o1.c M() {
        kotlin.reflect.jvm.internal.impl.descriptors.o1.c.b bVar = kotlin.reflect.jvm.internal.impl.descriptors.o1.c.b.a;
        if (bVar == null) {
            a(4);
        }
        return bVar;
    }

    public m0 O(i iVar) {
        if (iVar == null) {
            a(73);
        }
        m0 m0Var = this.f23161d.invoke().a.get(iVar);
        if (m0Var == null) {
            a(74);
        }
        return m0Var;
    }

    public m0 R(i iVar) {
        if (iVar == null) {
            a(53);
        }
        m0 m0VarS = Q(iVar).s();
        if (m0VarS == null) {
            a(54);
        }
        return m0VarS;
    }

    public m0 T() {
        m0 m0VarR = R(i.SHORT);
        if (m0VarR == null) {
            a(57);
        }
        return m0VarR;
    }

    protected n U() {
        n nVar = this.f23164g;
        if (nVar == null) {
            a(6);
        }
        return nVar;
    }

    public kotlin.p002reflect.jvm.internal.impl.descriptors.e V() {
        return p("String");
    }

    public m0 W() {
        m0 m0VarS = V().s();
        if (m0VarS == null) {
            a(65);
        }
        return m0VarS;
    }

    public kotlin.p002reflect.jvm.internal.impl.descriptors.e X(int i2) {
        kotlin.p002reflect.jvm.internal.impl.descriptors.e eVarO = o(k.f23199j.c(f.x(k.d(i2))));
        if (eVarO == null) {
            a(18);
        }
        return eVarO;
    }

    public kotlin.p002reflect.jvm.internal.impl.descriptors.e Y() {
        return p("Unit");
    }

    public m0 Z() {
        m0 m0VarS = Y().s();
        if (m0VarS == null) {
            a(64);
        }
        return m0VarS;
    }

    protected void f(boolean z) {
        x xVar = new x(a, this.f23164g, this, null);
        this.f23159b = xVar;
        xVar.T0(kotlin.reflect.y.internal.j0.b.a.a.a().a(this.f23164g, this.f23159b, v(), M(), g(), z));
        x xVar2 = this.f23159b;
        xVar2.Z0(xVar2);
    }

    protected kotlin.p002reflect.jvm.internal.impl.descriptors.o1.a g() {
        kotlin.p002reflect.jvm.internal.impl.descriptors.o1.a.C0408a c0408a = kotlin.p002reflect.jvm.internal.impl.descriptors.o1.a.C0408a.a;
        if (c0408a == null) {
            a(3);
        }
        return c0408a;
    }

    public kotlin.p002reflect.jvm.internal.impl.descriptors.e h() {
        return p("Any");
    }

    public m0 i() {
        m0 m0VarS = h().s();
        if (m0VarS == null) {
            a(50);
        }
        return m0VarS;
    }

    public kotlin.p002reflect.jvm.internal.impl.descriptors.e j() {
        return p("Array");
    }

    public e0 k(e0 e0Var) {
        e0 e0VarA;
        if (e0Var == null) {
            a(67);
        }
        if (c0(e0Var)) {
            if (e0Var.M0().size() != 1) {
                throw new IllegalStateException();
            }
            e0 type = e0Var.M0().get(0).getType();
            if (type == null) {
                a(68);
            }
            return type;
        }
        e0 e0VarN = n1.n(e0Var);
        m0 m0Var = this.f23161d.invoke().f23171c.get(e0VarN);
        if (m0Var != null) {
            return m0Var;
        }
        g0 g0VarI = kotlin.reflect.y.internal.j0.i.d.i(e0VarN);
        if (g0VarI != null && (e0VarA = A(e0VarN, g0VarI)) != null) {
            return e0VarA;
        }
        throw new IllegalStateException("not array: " + e0Var);
    }

    public m0 l(r1 r1Var, e0 e0Var) {
        if (r1Var == null) {
            a(82);
        }
        if (e0Var == null) {
            a(83);
        }
        m0 m0VarM = m(r1Var, e0Var, kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g.f25179c.b());
        if (m0VarM == null) {
            a(84);
        }
        return m0VarM;
    }

    public m0 m(r1 r1Var, e0 e0Var, kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g gVar) {
        if (r1Var == null) {
            a(78);
        }
        if (e0Var == null) {
            a(79);
        }
        if (gVar == null) {
            a(80);
        }
        m0 m0VarG = f0.g(b1.b(gVar), j(), Collections.singletonList(new i1(r1Var, e0Var)));
        if (m0VarG == null) {
            a(81);
        }
        return m0VarG;
    }

    public m0 n() {
        m0 m0VarR = R(i.BOOLEAN);
        if (m0VarR == null) {
            a(63);
        }
        return m0VarR;
    }

    public kotlin.p002reflect.jvm.internal.impl.descriptors.e o(kotlin.reflect.y.internal.j0.f.c cVar) {
        if (cVar == null) {
            a(12);
        }
        kotlin.p002reflect.jvm.internal.impl.descriptors.e eVarC = s.c(r(), cVar, kotlin.reflect.y.internal.j0.c.b.d.FROM_BUILTINS);
        if (eVarC == null) {
            a(13);
        }
        return eVarC;
    }

    public x r() {
        if (this.f23159b == null) {
            this.f23159b = this.f23160c.invoke();
        }
        x xVar = this.f23159b;
        if (xVar == null) {
            a(7);
        }
        return xVar;
    }

    public kotlin.reflect.y.internal.j0.i.w.h s() {
        kotlin.reflect.y.internal.j0.i.w.h hVarQ = r().N(k.r).q();
        if (hVarQ == null) {
            a(11);
        }
        return hVarQ;
    }

    public m0 t() {
        m0 m0VarR = R(i.BYTE);
        if (m0VarR == null) {
            a(56);
        }
        return m0VarR;
    }

    public m0 u() {
        m0 m0VarR = R(i.CHAR);
        if (m0VarR == null) {
            a(62);
        }
        return m0VarR;
    }

    protected Iterable<kotlin.p002reflect.jvm.internal.impl.descriptors.o1.b> v() {
        List listSingletonList = Collections.singletonList(new kotlin.reflect.y.internal.j0.b.p.a(this.f23164g, r()));
        if (listSingletonList == null) {
            a(5);
        }
        return listSingletonList;
    }

    public kotlin.p002reflect.jvm.internal.impl.descriptors.e w() {
        kotlin.p002reflect.jvm.internal.impl.descriptors.e eVarO = o(k.a.U);
        if (eVarO == null) {
            a(34);
        }
        return eVarO;
    }

    public kotlin.p002reflect.jvm.internal.impl.descriptors.e x() {
        return p("Comparable");
    }

    public m0 y() {
        m0 m0VarI = I();
        if (m0VarI == null) {
            a(52);
        }
        return m0VarI;
    }

    public m0 z() {
        m0 m0VarR = R(i.DOUBLE);
        if (m0VarR == null) {
            a(61);
        }
        return m0VarR;
    }
}
