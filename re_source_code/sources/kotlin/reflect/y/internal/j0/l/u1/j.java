package kotlin.reflect.y.internal.j0.l.u1;

import kotlin.jvm.internal.g;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'l' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:399)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:364)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:349)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:315)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:288)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: ErrorTypeKind.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j {
    public static final j A;
    public static final j A0;
    public static final j B;
    public static final j B0;
    public static final j C;
    public static final j C0;
    public static final j D;
    public static final j D0;
    public static final j E;
    public static final j E0;
    public static final j F;
    public static final j F0;
    public static final j G;
    public static final j G0;
    public static final j H;
    public static final j H0;
    public static final j I;
    public static final j I0;
    public static final j J;
    public static final j J0;
    public static final j K;
    public static final j K0;
    public static final j L;
    public static final j M;
    public static final j N;
    public static final j O;
    public static final j P;
    public static final j Q;
    public static final j R;
    public static final j S;
    public static final j T;
    public static final j U;
    public static final j V;
    public static final j W;
    public static final j X;
    public static final j Y;
    public static final j Z;
    public static final j a0;
    public static final j b0;
    public static final j c0;
    public static final j d0;
    public static final j e0;
    public static final j f0;
    public static final j h0;
    public static final j i0;
    public static final j j0;
    public static final j k0;
    public static final j l;
    public static final j l0;
    public static final j m;
    public static final j m0;
    public static final j n;
    public static final j n0;
    public static final j o;
    public static final j o0;
    public static final j p;
    public static final j p0;
    public static final j q;
    public static final j q0;
    public static final j r;
    public static final j r0;
    public static final j s;
    public static final j s0;
    public static final j t;
    public static final j t0;
    public static final j u;
    public static final j u0;
    public static final j v;
    public static final j v0;
    public static final j w;
    public static final j w0;
    public static final j x;
    public static final j x0;
    public static final j y;
    public static final j y0;
    public static final j z;
    public static final j z0;
    private final String M0;
    private final boolean N0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final j f24847f = new j("UNRESOLVED_TYPE", 0, "Unresolved type for %s", true);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final j f24848g = new j("UNRESOLVED_TYPE_PARAMETER_TYPE", 1, "Unresolved type parameter type", true);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final j f24849h = new j("UNRESOLVED_CLASS_TYPE", 2, "Unresolved class %s", true);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final j f24850i = new j("UNRESOLVED_JAVA_CLASS", 3, "Unresolved java class %s", true);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final j f24851j = new j("UNRESOLVED_DECLARATION", 4, "Unresolved declaration %s", true);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final j f24852k = new j("UNRESOLVED_KCLASS_CONSTANT_VALUE", 5, "Unresolved type for %s (arrayDimensions=%s)", true);
    public static final j g0 = new j("UNRESOLVED_PARCEL_TYPE", 53, "Unresolved 'Parcel' type", true);
    private static final /* synthetic */ j[] L0 = g();

    static {
        boolean z2 = false;
        int i2 = 2;
        g gVar = null;
        l = new j("UNRESOLVED_TYPE_ALIAS", 6, "Unresolved type alias %s", z2, i2, gVar);
        boolean z3 = false;
        int i3 = 2;
        g gVar2 = null;
        m = new j("RETURN_TYPE", 7, "Return type for %s cannot be resolved", z3, i3, gVar2);
        n = new j("RETURN_TYPE_FOR_FUNCTION", 8, "Return type for function cannot be resolved", z2, i2, gVar);
        o = new j("RETURN_TYPE_FOR_PROPERTY", 9, "Return type for property %s cannot be resolved", z3, i3, gVar2);
        p = new j("RETURN_TYPE_FOR_CONSTRUCTOR", 10, "Return type for constructor %s cannot be resolved", z2, i2, gVar);
        q = new j("IMPLICIT_RETURN_TYPE_FOR_FUNCTION", 11, "Implicit return type for function %s cannot be resolved", z3, i3, gVar2);
        r = new j("IMPLICIT_RETURN_TYPE_FOR_PROPERTY", 12, "Implicit return type for property %s cannot be resolved", z2, i2, gVar);
        s = new j("IMPLICIT_RETURN_TYPE_FOR_PROPERTY_ACCESSOR", 13, "Implicit return type for property accessor %s cannot be resolved", z3, i3, gVar2);
        t = new j("ERROR_TYPE_FOR_DESTRUCTURING_COMPONENT", 14, "%s() return type", z2, i2, gVar);
        u = new j("RECURSIVE_TYPE", 15, "Recursive type", z3, i3, gVar2);
        v = new j("RECURSIVE_TYPE_ALIAS", 16, "Recursive type alias %s", z2, i2, gVar);
        w = new j("RECURSIVE_ANNOTATION_TYPE", 17, "Recursive annotation's type", z3, i3, gVar2);
        x = new j("CYCLIC_UPPER_BOUNDS", 18, "Cyclic upper bounds", z2, i2, gVar);
        y = new j("CYCLIC_SUPERTYPES", 19, "Cyclic supertypes", z3, i3, gVar2);
        z = new j("UNINFERRED_LAMBDA_CONTEXT_RECEIVER_TYPE", 20, "Cannot infer a lambda context receiver type", z2, i2, gVar);
        A = new j("UNINFERRED_LAMBDA_PARAMETER_TYPE", 21, "Cannot infer a lambda parameter type", z3, i3, gVar2);
        B = new j("UNINFERRED_TYPE_VARIABLE", 22, "Cannot infer a type variable %s", z2, i2, gVar);
        C = new j("RESOLUTION_ERROR_TYPE", 23, "Resolution error type (%s)", z3, i3, gVar2);
        D = new j("ERROR_EXPECTED_TYPE", 24, "Error expected type", z2, i2, gVar);
        E = new j("ERROR_DATA_FLOW_TYPE", 25, "Error type for data flow", z3, i3, gVar2);
        F = new j("ERROR_WHILE_RECONSTRUCTING_BARE_TYPE", 26, "Failed to reconstruct type %s", z2, i2, gVar);
        G = new j("UNABLE_TO_SUBSTITUTE_TYPE", 27, "Unable to substitute type (%s)", z3, i3, gVar2);
        H = new j("DONT_CARE", 28, "Special DONT_CARE type", z2, i2, gVar);
        I = new j("STUB_TYPE", 29, "Stub type %s", z3, i3, gVar2);
        J = new j("FUNCTION_PLACEHOLDER_TYPE", 30, "Function placeholder type (arguments: %s)", z2, i2, gVar);
        K = new j("TYPE_FOR_RESULT", 31, "Stubbed 'Result' type", z3, i3, gVar2);
        L = new j("TYPE_FOR_COMPILER_EXCEPTION", 32, "Error type for a compiler exception while analyzing %s", z2, i2, gVar);
        M = new j("ERROR_FLEXIBLE_TYPE", 33, "Error java flexible type with id %s. (%s..%s)", z3, i3, gVar2);
        N = new j("ERROR_RAW_TYPE", 34, "Error raw type %s", z2, i2, gVar);
        O = new j("TYPE_WITH_MISMATCHED_TYPE_ARGUMENTS_AND_PARAMETERS", 35, "Inconsistent type %s (parameters.size = %s, arguments.size = %s)", z3, i3, gVar2);
        P = new j("ILLEGAL_TYPE_RANGE_FOR_DYNAMIC", 36, "Illegal type range for dynamic type %s..%s", z2, i2, gVar);
        Q = new j("CANNOT_LOAD_DESERIALIZE_TYPE_PARAMETER", 37, "Unknown type parameter %s. Please try recompiling module containing \"%s\"", z3, i3, gVar2);
        R = new j("CANNOT_LOAD_DESERIALIZE_TYPE_PARAMETER_BY_NAME", 38, "Couldn't deserialize type parameter %s in %s", z2, i2, gVar);
        S = new j("INCONSISTENT_SUSPEND_FUNCTION", 39, "Inconsistent suspend function type in metadata with constructor %s", z3, i3, gVar2);
        T = new j("UNEXPECTED_FLEXIBLE_TYPE_ID", 40, "Unexpected id of a flexible type %s. (%s..%s)", z2, i2, gVar);
        U = new j("UNKNOWN_TYPE", 41, "Unknown type", z3, i3, gVar2);
        V = new j("NO_TYPE_SPECIFIED", 42, "No type specified for %s", z2, i2, gVar);
        W = new j("NO_TYPE_FOR_LOOP_RANGE", 43, "Loop range has no type", z3, i3, gVar2);
        X = new j("NO_TYPE_FOR_LOOP_PARAMETER", 44, "Loop parameter has no type", z2, i2, gVar);
        Y = new j("MISSED_TYPE_FOR_PARAMETER", 45, "Missed a type for a value parameter %s", z3, i3, gVar2);
        Z = new j("MISSED_TYPE_ARGUMENT_FOR_TYPE_PARAMETER", 46, "Missed a type argument for a type parameter %s", z2, i2, gVar);
        a0 = new j("PARSE_ERROR_ARGUMENT", 47, "Error type for parse error argument %s", z3, i3, gVar2);
        b0 = new j("STAR_PROJECTION_IN_CALL", 48, "Error type for star projection directly passing as a call type argument", z2, i2, gVar);
        c0 = new j("PROHIBITED_DYNAMIC_TYPE", 49, "Dynamic type in a not allowed context", z3, i3, gVar2);
        d0 = new j("NOT_ANNOTATION_TYPE_IN_ANNOTATION_CONTEXT", 50, "Not an annotation type %s in the annotation context", z2, i2, gVar);
        e0 = new j("UNIT_RETURN_TYPE_FOR_INC_DEC", 51, "Unit type returned by inc or dec", z3, i3, gVar2);
        f0 = new j("RETURN_NOT_ALLOWED", 52, "Return not allowed", z2, i2, gVar);
        h0 = new j("KAPT_ERROR_TYPE", 54, "Kapt error type", z2, i2, gVar);
        i0 = new j("SYNTHETIC_ELEMENT_ERROR_TYPE", 55, "Error type for synthetic element", z3, i3, gVar2);
        boolean z4 = false;
        int i4 = 2;
        g gVar3 = null;
        j0 = new j("AD_HOC_ERROR_TYPE_FOR_LIGHTER_CLASSES_RESOLVE", 56, "Error type in ad hoc resolve for lighter classes", z4, i4, gVar3);
        boolean z5 = false;
        int i5 = 2;
        g gVar4 = null;
        k0 = new j("ERROR_EXPRESSION_TYPE", 57, "Error expression type", z5, i5, gVar4);
        l0 = new j("ERROR_RECEIVER_TYPE", 58, "Error receiver type for %s", z4, i4, gVar3);
        m0 = new j("ERROR_CONSTANT_VALUE", 59, "Error constant value %s", z5, i5, gVar4);
        n0 = new j("EMPTY_CALLABLE_REFERENCE", 60, "Empty callable reference", z4, i4, gVar3);
        o0 = new j("UNSUPPORTED_CALLABLE_REFERENCE_TYPE", 61, "Unsupported callable reference type %s", z5, i5, gVar4);
        p0 = new j("TYPE_FOR_DELEGATION", 62, "Error delegation type for %s", z4, i4, gVar3);
        q0 = new j("UNAVAILABLE_TYPE_FOR_DECLARATION", 63, "Type is unavailable for declaration %s", z5, i5, gVar4);
        r0 = new j("ERROR_TYPE_PARAMETER", 64, "Error type parameter", z4, i4, gVar3);
        s0 = new j("ERROR_TYPE_PROJECTION", 65, "Error type projection", z5, i5, gVar4);
        t0 = new j("ERROR_SUPER_TYPE", 66, "Error super type", z4, i4, gVar3);
        u0 = new j("SUPER_TYPE_FOR_ERROR_TYPE", 67, "Supertype of error type %s", z5, i5, gVar4);
        v0 = new j("ERROR_PROPERTY_TYPE", 68, "Error property type", z4, i4, gVar3);
        w0 = new j("ERROR_CLASS", 69, "Error class", z5, i5, gVar4);
        x0 = new j("TYPE_FOR_ERROR_TYPE_CONSTRUCTOR", 70, "Type for error type constructor (%s)", z4, i4, gVar3);
        y0 = new j("INTERSECTION_OF_ERROR_TYPES", 71, "Intersection of error types %s", z5, i5, gVar4);
        z0 = new j("CANNOT_COMPUTE_ERASED_BOUND", 72, "Cannot compute erased upper bound of a type parameter %s", z4, i4, gVar3);
        A0 = new j("NOT_FOUND_UNSIGNED_TYPE", 73, "Unsigned type %s not found", z5, i5, gVar4);
        B0 = new j("ERROR_ENUM_TYPE", 74, "Not found the corresponding enum class for given enum entry %s.%s", z4, i4, gVar3);
        C0 = new j("NO_RECORDED_TYPE", 75, "Not found recorded type for %s", z5, i5, gVar4);
        D0 = new j("NOT_FOUND_DESCRIPTOR_FOR_FUNCTION", 76, "Descriptor not found for function %s", z4, i4, gVar3);
        E0 = new j("NOT_FOUND_DESCRIPTOR_FOR_CLASS", 77, "Cannot build class type, descriptor not found for builder %s", z5, i5, gVar4);
        F0 = new j("NOT_FOUND_DESCRIPTOR_FOR_TYPE_PARAMETER", 78, "Cannot build type parameter type, descriptor not found for builder %s", z4, i4, gVar3);
        G0 = new j("UNMAPPED_ANNOTATION_TARGET_TYPE", 79, "Type for unmapped Java annotation target to Kotlin one", z5, i5, gVar4);
        H0 = new j("UNKNOWN_ARRAY_ELEMENT_TYPE_OF_ANNOTATION_ARGUMENT", 80, "Unknown type for an array element of a java annotation argument", z4, i4, gVar3);
        I0 = new j("NOT_FOUND_FQNAME_FOR_JAVA_ANNOTATION", 81, "No fqName for annotation %s", z5, i5, gVar4);
        J0 = new j("NOT_FOUND_FQNAME", 82, "No fqName for %s", z4, i4, gVar3);
        K0 = new j("TYPE_FOR_GENERATED_ERROR_EXPRESSION", 83, "Type for generated error expression", z5, i5, gVar4);
    }

    private j(String str, int i2, String str2, boolean z2) {
        super(str, i2);
        this.M0 = str2;
        this.N0 = z2;
    }

    private static final /* synthetic */ j[] g() {
        return new j[]{f24847f, f24848g, f24849h, f24850i, f24851j, f24852k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, a0, b0, c0, d0, e0, f0, g0, h0, i0, j0, k0, l0, m0, n0, o0, p0, q0, r0, s0, t0, u0, v0, w0, x0, y0, z0, A0, B0, C0, D0, E0, F0, G0, H0, I0, J0, K0};
    }

    public static j valueOf(String str) {
        return (j) Enum.valueOf(j.class, str);
    }

    public static j[] values() {
        return (j[]) L0.clone();
    }

    public final String k() {
        return this.M0;
    }

    public final boolean q() {
        return this.N0;
    }

    /* synthetic */ j(String str, int i2, String str2, boolean z2, int i3, g gVar) {
        this(str, i2, str2, (i3 & 2) != 0 ? false : z2);
    }
}
