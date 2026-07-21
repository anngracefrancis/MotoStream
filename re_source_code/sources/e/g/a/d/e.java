package e.g.a.d;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import rx.j;

/* JADX INFO: compiled from: TextViewTextChangeEventOnSubscribe.java */
/* JADX INFO: loaded from: classes2.dex */
final class e implements rx.e.a<d> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final TextView f21188f;

    /* JADX INFO: compiled from: TextViewTextChangeEventOnSubscribe.java */
    class a implements TextWatcher {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ j f21189f;

        a(j jVar) {
            this.f21189f = jVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (this.f21189f.isUnsubscribed()) {
                return;
            }
            this.f21189f.onNext(d.b(e.this.f21188f, charSequence, i2, i3, i4));
        }
    }

    /* JADX INFO: compiled from: TextViewTextChangeEventOnSubscribe.java */
    class b extends rx.l.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ TextWatcher f21191f;

        b(TextWatcher textWatcher) {
            this.f21191f = textWatcher;
        }

        @Override // rx.l.a
        protected void onUnsubscribe() {
            e.this.f21188f.removeTextChangedListener(this.f21191f);
        }
    }

    e(TextView textView) {
        this.f21188f = textView;
    }

    @Override // rx.m.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(j<? super d> jVar) {
        rx.l.a.verifyMainThread();
        a aVar = new a(jVar);
        jVar.add(new b(aVar));
        this.f21188f.addTextChangedListener(aVar);
        TextView textView = this.f21188f;
        jVar.onNext(d.b(textView, textView.getText(), 0, 0, 0));
    }
}
