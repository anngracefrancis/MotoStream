package retrofit2;

import java.lang.reflect.Method;
import kotlin.KotlinNullPointerException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.p003y.Continuation;
import kotlin.p003y.intrinsics.d;
import kotlin.p003y.j.p004a.ContinuationImpl;
import kotlin.p003y.j.p004a.DebugMetadata;
import kotlin.p003y.j.p004a.h;
import kotlin.u;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Dispatchers;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: KotlinExtensions.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\u001a\u001c\u0010\u0002\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u0001H\u0086\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0000*\u00020\u0004*\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a+\u0010\u0006\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0000*\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005H\u0087@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0007\u001a)\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u0007\u001a\u001b\u0010\u000e\u001a\u00020\r*\u00060\u000bj\u0002`\fH\u0080@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"T", "Lretrofit2/Retrofit;", "create", "(Lretrofit2/Retrofit;)Ljava/lang/Object;", HttpUrl.FRAGMENT_ENCODE_SET, "Lretrofit2/Call;", "await", "(Lretrofit2/Call;Lkotlin/y/d;)Ljava/lang/Object;", "awaitNullable", "Lretrofit2/Response;", "awaitResponse", "Ljava/lang/Exception;", "Lkotlin/Exception;", HttpUrl.FRAGMENT_ENCODE_SET, "suspendAndThrow", "(Ljava/lang/Exception;Lkotlin/y/d;)Ljava/lang/Object;", "retrofit"}, k = 2, mv = {1, 4, 0})
public final class KotlinExtensions {

    /* JADX INFO: renamed from: retrofit2.KotlinExtensions$suspendAndThrow$1, reason: invalid class name */
    /* JADX INFO: compiled from: KotlinExtensions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u00060\u0000j\u0002`\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0080@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Ljava/lang/Exception;", "Lkotlin/Exception;", "Lkotlin/y/d;", HttpUrl.FRAGMENT_ENCODE_SET, "continuation", HttpUrl.FRAGMENT_ENCODE_SET, "suspendAndThrow", "(Ljava/lang/Exception;Lkotlin/y/d;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "retrofit2.KotlinExtensions", f = "KotlinExtensions.kt", l = {113}, m = "suspendAndThrow")
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return KotlinExtensions.suspendAndThrow(null, this);
        }
    }

    public static final <T> Object await(Call<T> call, Continuation<? super T> continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(kotlin.p003y.intrinsics.c.b(continuation), 1);
        cancellableContinuationImpl.e(new KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$1(call));
        call.enqueue(new Callback<T>() { // from class: retrofit2.KotlinExtensions$await$2$2
            @Override // retrofit2.Callback
            public void onFailure(Call<T> call2, Throwable t) {
                m.g(call2, "call");
                m.g(t, "t");
                CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
                Result.a aVar = Result.f25108f;
                cancellableContinuation.resumeWith(Result.a(o.a(t)));
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<T> call2, Response<T> response) {
                m.g(call2, "call");
                m.g(response, "response");
                if (!response.isSuccessful()) {
                    CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
                    HttpException httpException = new HttpException(response);
                    Result.a aVar = Result.f25108f;
                    cancellableContinuation.resumeWith(Result.a(o.a(httpException)));
                    return;
                }
                T tBody = response.body();
                if (tBody != null) {
                    CancellableContinuation cancellableContinuation2 = cancellableContinuationImpl;
                    Result.a aVar2 = Result.f25108f;
                    cancellableContinuation2.resumeWith(Result.a(tBody));
                    return;
                }
                Object objTag = call2.request().tag(Invocation.class);
                if (objTag == null) {
                    m.q();
                }
                m.b(objTag, "call.request().tag(Invocation::class.java)!!");
                Method method = ((Invocation) objTag).method();
                StringBuilder sb = new StringBuilder();
                sb.append("Response from ");
                m.b(method, "method");
                Class<?> declaringClass = method.getDeclaringClass();
                m.b(declaringClass, "method.declaringClass");
                sb.append(declaringClass.getName());
                sb.append('.');
                sb.append(method.getName());
                sb.append(" was null but response body type was declared as non-null");
                KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException(sb.toString());
                CancellableContinuation cancellableContinuation3 = cancellableContinuationImpl;
                Result.a aVar3 = Result.f25108f;
                cancellableContinuation3.resumeWith(Result.a(o.a(kotlinNullPointerException)));
            }
        });
        Object objW = cancellableContinuationImpl.w();
        if (objW == d.c()) {
            h.c(continuation);
        }
        return objW;
    }

    public static final <T> Object awaitNullable(Call<T> call, Continuation<? super T> continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(kotlin.p003y.intrinsics.c.b(continuation), 1);
        cancellableContinuationImpl.e(new KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$2(call));
        call.enqueue(new Callback<T>() { // from class: retrofit2.KotlinExtensions$await$4$2
            @Override // retrofit2.Callback
            public void onFailure(Call<T> call2, Throwable t) {
                m.g(call2, "call");
                m.g(t, "t");
                CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
                Result.a aVar = Result.f25108f;
                cancellableContinuation.resumeWith(Result.a(o.a(t)));
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<T> call2, Response<T> response) {
                m.g(call2, "call");
                m.g(response, "response");
                if (response.isSuccessful()) {
                    CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
                    T tBody = response.body();
                    Result.a aVar = Result.f25108f;
                    cancellableContinuation.resumeWith(Result.a(tBody));
                    return;
                }
                CancellableContinuation cancellableContinuation2 = cancellableContinuationImpl;
                HttpException httpException = new HttpException(response);
                Result.a aVar2 = Result.f25108f;
                cancellableContinuation2.resumeWith(Result.a(o.a(httpException)));
            }
        });
        Object objW = cancellableContinuationImpl.w();
        if (objW == d.c()) {
            h.c(continuation);
        }
        return objW;
    }

    public static final <T> Object awaitResponse(Call<T> call, Continuation<? super Response<T>> continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(kotlin.p003y.intrinsics.c.b(continuation), 1);
        cancellableContinuationImpl.e(new KotlinExtensions$awaitResponse$$inlined$suspendCancellableCoroutine$lambda$1(call));
        call.enqueue(new Callback<T>() { // from class: retrofit2.KotlinExtensions$awaitResponse$2$2
            @Override // retrofit2.Callback
            public void onFailure(Call<T> call2, Throwable t) {
                m.g(call2, "call");
                m.g(t, "t");
                CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
                Result.a aVar = Result.f25108f;
                cancellableContinuation.resumeWith(Result.a(o.a(t)));
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<T> call2, Response<T> response) {
                m.g(call2, "call");
                m.g(response, "response");
                CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
                Result.a aVar = Result.f25108f;
                cancellableContinuation.resumeWith(Result.a(response));
            }
        });
        Object objW = cancellableContinuationImpl.w();
        if (objW == d.c()) {
            h.c(continuation);
        }
        return objW;
    }

    public static final /* synthetic */ <T> T create(Retrofit retrofit) {
        m.g(retrofit, "$this$create");
        m.k(4, "T");
        return (T) retrofit.create(Object.class);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object suspendAndThrow(final Exception exc, Continuation<?> continuation) throws Throwable {
        final AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i2 = anonymousClass1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i2 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object objC = d.c();
        int i3 = anonymousClass1.label;
        if (i3 == 0) {
            o.b(obj);
            anonymousClass1.L$0 = exc;
            anonymousClass1.label = 1;
            Dispatchers.a().K(anonymousClass1.getL(), new Runnable() { // from class: retrofit2.KotlinExtensions$suspendAndThrow$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1
                @Override // java.lang.Runnable
                public final void run() {
                    Continuation continuationB = kotlin.p003y.intrinsics.c.b(anonymousClass1);
                    Exception exc2 = exc;
                    Result.a aVar = Result.f25108f;
                    continuationB.resumeWith(Result.a(o.a(exc2)));
                }
            });
            Object objC2 = d.c();
            if (objC2 == d.c()) {
                h.c(anonymousClass1);
            }
            if (objC2 == objC) {
                return objC;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            o.b(obj);
        }
        return u.a;
    }
}
