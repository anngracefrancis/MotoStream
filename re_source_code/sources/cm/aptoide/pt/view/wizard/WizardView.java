package cm.aptoide.pt.view.wizard;

import cm.aptoide.pt.presenter.View;

/* JADX INFO: loaded from: classes.dex */
public interface WizardView extends View {
    rx.b createWizardAdapter(boolean z);

    int getCount();

    void handleColorTransitions(int i2, float f2, int i3);

    void handleSelectedPage(int i2);

    void skipWizard();

    rx.e<Void> skipWizardClick();
}
