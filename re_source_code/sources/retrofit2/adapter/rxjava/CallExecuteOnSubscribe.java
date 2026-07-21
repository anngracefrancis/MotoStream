package retrofit2.adapter.rxjava;

import retrofit2.Call;
import retrofit2.Response;
import rx.e;
import rx.exceptions.a;
import rx.j;

/* JADX INFO: loaded from: classes3.dex */
final class CallExecuteOnSubscribe<T> implements e.a<Response<T>> {
    private final Call<T> originalCall;

    CallExecuteOnSubscribe(Call<T> call) {
        this.originalCall = call;
    }

    @Override // rx.m.b
    public void call(j<? super Response<T>> jVar) {
        Call<T> callClone = this.originalCall.clone();
        CallArbiter callArbiter = new CallArbiter(callClone, jVar);
        jVar.add(callArbiter);
        jVar.setProducer(callArbiter);
        try {
            callArbiter.emitResponse(callClone.execute());
        } catch (Throwable th) {
            a.e(th);
            callArbiter.emitError(th);
        }
    }
}
