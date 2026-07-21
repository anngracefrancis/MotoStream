package cm.aptoide.pt.view;

import cm.aptoide.pt.analytics.view.AnalyticsActivity;
import cm.aptoide.pt.presenter.Presenter;
import cm.aptoide.pt.presenter.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class ActivityView extends AnalyticsActivity implements View {

    /* JADX INFO: renamed from: cm.aptoide.pt.view.ActivityView$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$trello$rxlifecycle$android$ActivityEvent;

        static {
            int[] iArr = new int[com.trello.rxlifecycle.g.a.values().length];
            $SwitchMap$com$trello$rxlifecycle$android$ActivityEvent = iArr;
            try {
                iArr[com.trello.rxlifecycle.g.a.CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$trello$rxlifecycle$android$ActivityEvent[com.trello.rxlifecycle.g.a.START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$trello$rxlifecycle$android$ActivityEvent[com.trello.rxlifecycle.g.a.RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$trello$rxlifecycle$android$ActivityEvent[com.trello.rxlifecycle.g.a.PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$trello$rxlifecycle$android$ActivityEvent[com.trello.rxlifecycle.g.a.STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$trello$rxlifecycle$android$ActivityEvent[com.trello.rxlifecycle.g.a.DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: convertToEvent, reason: merged with bridge method [inline-methods] */
    public View.LifecycleEvent b(com.trello.rxlifecycle.g.a aVar) {
        switch (AnonymousClass1.$SwitchMap$com$trello$rxlifecycle$android$ActivityEvent[aVar.ordinal()]) {
            case 1:
                return View.LifecycleEvent.CREATE;
            case 2:
                return View.LifecycleEvent.START;
            case 3:
                return View.LifecycleEvent.RESUME;
            case 4:
                return View.LifecycleEvent.PAUSE;
            case 5:
                return View.LifecycleEvent.STOP;
            case 6:
                return View.LifecycleEvent.DESTROY;
            default:
                throw new IllegalStateException("Unrecognized event: " + aVar.name());
        }
    }

    @Override // cm.aptoide.pt.presenter.View
    public void attachPresenter(Presenter presenter) {
        presenter.present();
    }

    @Override // cm.aptoide.pt.presenter.View
    public final <T> com.trello.rxlifecycle.b<T> bindUntilEvent(View.LifecycleEvent lifecycleEvent) {
        return com.trello.rxlifecycle.c.b(getLifecycleEvent(), lifecycleEvent);
    }

    @Override // cm.aptoide.pt.presenter.View
    public rx.e<View.LifecycleEvent> getLifecycleEvent() {
        return lifecycle().X(new rx.m.e() { // from class: cm.aptoide.pt.view.c
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f8007f.b((com.trello.rxlifecycle.g.a) obj);
            }
        });
    }
}
