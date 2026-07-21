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
final class BodyOnSubscribe<T> implements e.a<T> {
    private final e.a<Response<T>> upstream;

    private static class BodySubscriber<R> extends j<Response<R>> {
        private final j<? super R> subscriber;
        private boolean subscriberTerminated;

        BodySubscriber(j<? super R> jVar) {
            super(jVar);
            this.subscriber = jVar;
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.subscriberTerminated) {
                return;
            }
            this.subscriber.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (!this.subscriberTerminated) {
                this.subscriber.onError(th);
                return;
            }
            AssertionError assertionError = new AssertionError("This should never happen! Report as a Retrofit bug with the full stacktrace.");
            assertionError.initCause(th);
            f.c().b().a(assertionError);
        }

        @Override // rx.f
        public void onNext(Response<R> response) {
            if (response.isSuccessful()) {
                this.subscriber.onNext(response.body());
                return;
            }
            this.subscriberTerminated = true;
            HttpException httpException = new HttpException(response);
            try {
                this.subscriber.onError(httpException);
            } catch (OnCompletedFailedException e2) {
                e = e2;
                f.c().b().a(e);
            } catch (OnErrorFailedException e3) {
                e = e3;
                f.c().b().a(e);
            } catch (OnErrorNotImplementedException e4) {
                e = e4;
                f.c().b().a(e);
            } catch (Throwable th) {
                a.e(th);
                f.c().b().a(new CompositeException(httpException, th));
            }
        }
    }

    BodyOnSubscribe(e.a<Response<T>> aVar) {
        this.upstream = aVar;
    }

    @Override // rx.m.b
    public void call(j<? super T> jVar) {
        this.upstream.call((Response<T>) new BodySubscriber(jVar));
    }
}
