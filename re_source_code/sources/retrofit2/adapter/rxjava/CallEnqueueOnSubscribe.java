package retrofit2.adapter.rxjava;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.e;
import rx.exceptions.a;
import rx.j;

/* JADX INFO: loaded from: classes3.dex */
final class CallEnqueueOnSubscribe<T> implements e.a<Response<T>> {
    private final Call<T> originalCall;

    CallEnqueueOnSubscribe(Call<T> call) {
        this.originalCall = call;
    }

    @Override // rx.m.b
    public void call(j<? super Response<T>> jVar) {
        Call<T> callClone = this.originalCall.clone();
        final CallArbiter callArbiter = new CallArbiter(callClone, jVar);
        jVar.add(callArbiter);
        jVar.setProducer(callArbiter);
        callClone.enqueue(new Callback<T>() { // from class: retrofit2.adapter.rxjava.CallEnqueueOnSubscribe.1
            @Override // retrofit2.Callback
            public void onFailure(Call<T> call, Throwable th) {
                a.e(th);
                callArbiter.emitError(th);
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<T> call, Response<T> response) {
                callArbiter.emitResponse(response);
            }
        });
    }
}
