package retrofit2.adapter.rxjava;

import retrofit2.Response;
import rx.e;
import rx.exceptions.CompositeException;
import rx.exceptions.OnCompletedFailedException;
import rx.exceptions.OnErrorFailedException;
import rx.exceptions.OnErrorNotImplementedException;
import rx.exceptions.a;
import rx.j;
import rx.q.f;

/* JADX INFO: loaded from: classes3.dex */
final class ResultOnSubscribe<T> implements e.a<Result<T>> {
    private final e.a<Response<T>> upstream;

    private static class ResultSubscriber<R> extends j<Response<R>> {
        private final j<? super Result<R>> subscriber;

        ResultSubscriber(j<? super Result<R>> jVar) {
            super(jVar);
            this.subscriber = jVar;
        }

        @Override // rx.f
        public void onCompleted() {
            this.subscriber.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            try {
                this.subscriber.onNext(Result.error(th));
                this.subscriber.onCompleted();
            } catch (Throwable th2) {
                try {
                    this.subscriber.onError(th2);
                } catch (OnCompletedFailedException e2) {
                    e = e2;
                    f.c().b().a(e);
                } catch (OnErrorFailedException e3) {
                    e = e3;
                    f.c().b().a(e);
                } catch (OnErrorNotImplementedException e4) {
                    e = e4;
                    f.c().b().a(e);
                } catch (Throwable th3) {
                    a.e(th3);
                    f.c().b().a(new CompositeException(th2, th3));
                }
            }
        }

        @Override // rx.f
        public void onNext(Response<R> response) {
            this.subscriber.onNext(Result.response(response));
        }
    }

    ResultOnSubscribe(e.a<Response<T>> aVar) {
        this.upstream = aVar;
    }

    @Override // rx.m.b
    public void call(j<? super Result<T>> jVar) {
        this.upstream.call((Response<T>) new ResultSubscriber(jVar));
    }
}
