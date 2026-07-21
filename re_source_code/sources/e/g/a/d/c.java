package e.g.a.d;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import rx.j;

/* JADX INFO: compiled from: TextViewAfterTextChangeEventOnSubscribe.java */
/* JADX INFO: loaded from: classes2.dex */
final class c implements rx.e.a<e.g.a.d.b> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final TextView f21179f;

    /* JADX INFO: compiled from: TextViewAfterTextChangeEventOnSubscribe.java */
    class a implements TextWatcher {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ j f21180f;

        a(j jVar) {
            this.f21180f = jVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (this.f21180f.isUnsubscribed()) {
                return;
            }
            this.f21180f.onNext(e.g.a.d.b.b(c.this.f21179f, editable));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* JADX INFO: compiled from: TextViewAfterTextChangeEventOnSubscribe.java */
    class b extends rx.l.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ TextWatcher f21182f;

        b(TextWatcher textWatcher) {
            this.f21182f = textWatcher;
        }

        @Override // rx.l.a
        protected void onUnsubscribe() {
            c.this.f21179f.removeTextChangedListener(this.f21182f);
        }
    }

    c(TextView textView) {
        this.f21179f = textView;
    }

    @Override // rx.m.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(j<? super e.g.a.d.b> jVar) {
        rx.l.a.verifyMainThread();
        a aVar = new a(jVar);
        jVar.add(new b(aVar));
        this.f21179f.addTextChangedListener(aVar);
        TextView textView = this.f21179f;
        jVar.onNext(e.g.a.d.b.b(textView, textView.getEditableText()));
    }
}
