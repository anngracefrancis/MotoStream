package cm.aptoide.pt.util;

import cm.aptoide.pt.utils.BaseException;
import rx.j;

/* JADX INFO: loaded from: classes.dex */
public class RxJavaStackTracer extends rx.q.d {

    static class OperatorTraceOnError<T> implements rx.e.b<T, T> {
        private final StackTraceElement[] trace = new Throwable().getStackTrace();

        private static class TracedException extends RuntimeException {
            public TracedException(Throwable th, StackTraceElement[] stackTraceElementArr) {
                super(th);
                setStackTrace(stackTraceElementArr);
            }
        }

        OperatorTraceOnError() {
        }

        public static <T> OperatorTraceOnError<T> traceOnError() {
            return new OperatorTraceOnError<>();
        }

        @Override // rx.m.e
        public j<? super T> call(final j<? super T> jVar) {
            j<T> jVar2 = new j<T>() { // from class: cm.aptoide.pt.util.RxJavaStackTracer.OperatorTraceOnError.1
                @Override // rx.f
                public void onCompleted() {
                    jVar.onCompleted();
                }

                @Override // rx.f
                public void onError(Throwable th) {
                    if (BaseException.class.isAssignableFrom(th.getClass())) {
                        jVar.onError(th);
                    } else {
                        jVar.onError(new TracedException(th, OperatorTraceOnError.this.trace));
                    }
                }

                @Override // rx.f
                public void onNext(T t) {
                    jVar.onNext(t);
                }
            };
            jVar.add(jVar2);
            return jVar2;
        }
    }

    @Override // rx.q.d
    public <T> rx.e.a<T> onSubscribeStart(rx.e<? extends T> eVar, final rx.e.a<T> aVar) {
        return new rx.e.a<T>() { // from class: cm.aptoide.pt.util.RxJavaStackTracer.1
            @Override // rx.m.b
            public void call(j<? super T> jVar) {
                try {
                    j<? super T> jVarCall = RxJavaStackTracer.this.onLift(OperatorTraceOnError.traceOnError()).call(jVar);
                    try {
                        jVarCall.onStart();
                        aVar.call(jVarCall);
                    } catch (Throwable th) {
                        rx.exceptions.a.e(th);
                        jVarCall.onError(th);
                    }
                } catch (Throwable th2) {
                    rx.exceptions.a.e(th2);
                    jVar.onError(th2);
                }
            }
        };
    }
}
