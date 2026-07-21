package kotlin.reflect.y.internal.j0.l.t1;

import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import kotlin.reflect.y.internal.j0.l.e0;

/* JADX INFO: compiled from: TypeCheckingProcedure.java */
/* JADX INFO: loaded from: classes3.dex */
public class u {
    private static /* synthetic */ void a(int i2) {
        String str = (i2 == 7 || i2 == 10) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 7 || i2 == 10) ? 2 : 3];
        switch (i2) {
            case 1:
            case 3:
            case 18:
            case 20:
                objArr[0] = "supertype";
                break;
            case 2:
            case 17:
            case 19:
            default:
                objArr[0] = "subtype";
                break;
            case 4:
                objArr[0] = "typeCheckingProcedureCallbacks";
                break;
            case 5:
            case 8:
            case 23:
                objArr[0] = MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD;
                break;
            case 6:
            case 9:
                objArr[0] = "argument";
                break;
            case 7:
            case 10:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure";
                break;
            case 11:
                objArr[0] = "type1";
                break;
            case 12:
                objArr[0] = "type2";
                break;
            case 13:
                objArr[0] = "typeParameter";
                break;
            case 14:
                objArr[0] = "typeArgument";
                break;
            case 15:
                objArr[0] = "typeParameterVariance";
                break;
            case 16:
                objArr[0] = "typeArgumentVariance";
                break;
            case 21:
                objArr[0] = "subtypeArgumentProjection";
                break;
            case 22:
                objArr[0] = "supertypeArgumentProjection";
                break;
        }
        if (i2 == 7) {
            objArr[1] = "getOutType";
        } else if (i2 != 10) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure";
        } else {
            objArr[1] = "getInType";
        }
        switch (i2) {
            case 5:
            case 6:
                objArr[2] = "getOutType";
                break;
            case 7:
            case 10:
                break;
            case 8:
            case 9:
                objArr[2] = "getInType";
                break;
            case 11:
            case 12:
                objArr[2] = "equalTypes";
                break;
            case 13:
            case 14:
            case 15:
            case 16:
                objArr[2] = "getEffectiveProjectionKind";
                break;
            case 17:
            case 18:
                objArr[2] = "isSubtypeOf";
                break;
            case 19:
            case 20:
                objArr[2] = "checkSubtypeForTheSameConstructor";
                break;
            case 21:
            case 22:
            case 23:
                objArr[2] = "capture";
                break;
            default:
                objArr[2] = "findCorrespondingSupertype";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i2 != 7 && i2 != 10) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static e0 b(e0 e0Var, e0 e0Var2) {
        if (e0Var == null) {
            a(0);
        }
        if (e0Var2 == null) {
            a(1);
        }
        return c(e0Var, e0Var2, new t());
    }

    public static e0 c(e0 e0Var, e0 e0Var2, v vVar) {
        if (e0Var == null) {
            a(2);
        }
        if (e0Var2 == null) {
            a(3);
        }
        if (vVar == null) {
            a(4);
        }
        return y.d(e0Var, e0Var2, vVar);
    }
}
