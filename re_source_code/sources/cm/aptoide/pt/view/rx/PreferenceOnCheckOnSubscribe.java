package cm.aptoide.pt.view.rx;

import androidx.preference.CheckBoxPreference;
import androidx.preference.Preference;
import rx.j;

/* JADX INFO: loaded from: classes.dex */
class PreferenceOnCheckOnSubscribe implements rx.e.a<Boolean> {
    private final CheckBoxPreference preference;

    public PreferenceOnCheckOnSubscribe(CheckBoxPreference checkBoxPreference) {
        this.preference = checkBoxPreference;
    }

    @Override // rx.m.b
    public void call(final j<? super Boolean> jVar) {
        rx.l.a.verifyMainThread();
        Preference.d dVar = new Preference.d() { // from class: cm.aptoide.pt.view.rx.PreferenceOnCheckOnSubscribe.1
            @Override // androidx.preference.Preference.d
            public boolean onPreferenceClick(Preference preference) {
                if (!jVar.isUnsubscribed()) {
                    jVar.onNext(Boolean.valueOf(((CheckBoxPreference) preference).Z0()));
                }
                return true;
            }
        };
        jVar.add(new rx.l.a() { // from class: cm.aptoide.pt.view.rx.PreferenceOnCheckOnSubscribe.2
            @Override // rx.l.a
            protected void onUnsubscribe() {
                PreferenceOnCheckOnSubscribe.this.preference.N0(null);
            }
        });
        this.preference.N0(dVar);
    }
}
