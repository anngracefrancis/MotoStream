package cm.aptoide.pt.reactions.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import cm.aptoide.pt.reactions.data.ReactionType;
import com.airbnb.lottie.LottieAnimationView;

/* JADX INFO: loaded from: classes.dex */
public class Reaction {
    private final ReactionType reactionType;
    private final LottieAnimationView view;

    public Reaction(ReactionType reactionType, int i2, Context context) {
        this.reactionType = reactionType;
        LottieAnimationView lottieAnimationView = new LottieAnimationView(context);
        this.view = lottieAnimationView;
        lottieAnimationView.setAnimation(reactionType.name().toLowerCase() + ".json");
        lottieAnimationView.k(true);
        lottieAnimationView.setPadding(i2, i2, i2, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setCallback$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(ReactionsView.Callback callback, View view) {
        if (callback != null) {
            callback.onReactionItemClicked(this.reactionType);
        }
    }

    public void cancel() {
        this.view.d();
    }

    public LottieAnimationView getView() {
        return this.view;
    }

    public void play() {
        this.view.l();
    }

    public void setCallback(final ReactionsView.Callback callback) {
        this.view.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.reactions.ui.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f7245f.a(callback, view);
            }
        });
    }

    public void setReactionParams(ViewGroup.LayoutParams layoutParams) {
        this.view.setLayoutParams(layoutParams);
    }
}
