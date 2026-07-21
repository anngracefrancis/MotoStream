package cm.aptoide.pt.view.rx;

import android.widget.CompoundButton;
import androidx.appcompat.widget.SwitchCompat;
import rx.j;

/* JADX INFO: loaded from: classes.dex */
class SwitchOnCheckOnSubscribe implements rx.e.a<Boolean> {
    private final SwitchCompat switchCompat;

    public SwitchOnCheckOnSubscribe(SwitchCompat switchCompat) {
        this.switchCompat = switchCompat;
    }

    @Override // rx.m.b
    public void call(final j<? super Boolean> jVar) {
        rx.l.a.verifyMainThread();
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: cm.aptoide.pt.view.rx.SwitchOnCheckOnSubscribe.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (jVar.isUnsubscribed()) {
                    return;
                }
                jVar.onNext(Boolean.valueOf(z));
            }
        };
        jVar.add(new rx.l.a() { // from class: cm.aptoide.pt.view.rx.SwitchOnCheckOnSubscribe.2
            @Override // rx.l.a
            protected void onUnsubscribe() {
                SwitchOnCheckOnSubscribe.this.switchCompat.setOnCheckedChangeListener(null);
            }
        });
        this.switchCompat.setOnCheckedChangeListener(onCheckedChangeListener);
    }
}
