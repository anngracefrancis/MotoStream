package retrofit2.adapter.rxjava;

import java.lang.reflect.Type;
import retrofit2.Call;
import retrofit2.CallAdapter;
import rx.e;
import rx.h;

/* JADX INFO: loaded from: classes3.dex */
final class RxJavaCallAdapter<R> implements CallAdapter<R, Object> {
    private final boolean isAsync;
    private final boolean isBody;
    private final boolean isCompletable;
    private final boolean isResult;
    private final boolean isSingle;
    private final Type responseType;
    private final h scheduler;

    RxJavaCallAdapter(Type type, h hVar, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.responseType = type;
        this.scheduler = hVar;
        this.isAsync = z;
        this.isResult = z2;
        this.isBody = z3;
        this.isSingle = z4;
        this.isCompletable = z5;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002c  */
    /* JADX WARN: Code duplicated, block: B:18:0x0034  */
    /* JADX WARN: Code duplicated, block: B:20:0x0039  */
    /* JADX WARN: Code duplicated, block: B:22:0x003d  */
    /* JADX WARN: Code duplicated, block: B:24:? A[RETURN, SYNTHETIC] */
    @Override // retrofit2.CallAdapter
    public Object adapt(Call<R> call) {
        e.a bodyOnSubscribe;
        e eVarL;
        h hVar;
        e.a callEnqueueOnSubscribe = this.isAsync ? new CallEnqueueOnSubscribe(call) : new CallExecuteOnSubscribe(call);
        if (!this.isResult) {
            if (this.isBody) {
                bodyOnSubscribe = new BodyOnSubscribe(callEnqueueOnSubscribe);
            }
            eVarL = e.l(callEnqueueOnSubscribe);
            hVar = this.scheduler;
            if (hVar != null) {
                eVarL = eVarL.I0(hVar);
            }
            if (this.isSingle) {
                return eVarL.Z0();
            }
            if (this.isCompletable) {
                return eVarL.X0();
            }
            return eVarL;
        }
        bodyOnSubscribe = new ResultOnSubscribe(callEnqueueOnSubscribe);
        callEnqueueOnSubscribe = bodyOnSubscribe;
        eVarL = e.l(callEnqueueOnSubscribe);
        hVar = this.scheduler;
        if (hVar != null) {
            eVarL = eVarL.I0(hVar);
        }
        if (this.isSingle) {
            return eVarL.Z0();
        }
        if (this.isCompletable) {
            return eVarL.X0();
        }
        return eVarL;
    }

    @Override // retrofit2.CallAdapter
    public Type responseType() {
        return this.responseType;
    }
}
