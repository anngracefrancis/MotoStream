package cm.aptoide.pt.view.app;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import cm.aptoide.pt.R;
import cm.aptoide.pt.networking.image.ImageLoader;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes.dex */
public class ApplicationViewHolder extends ListStoreAppViewHolder {
    private final rx.s.b<Application> appClicks;
    private final ImageView iconView;
    private final TextView nameTextView;
    private final TextView rating;

    public ApplicationViewHolder(View view, rx.s.b<Application> bVar) {
        super(view);
        this.nameTextView = (TextView) view.findViewById(R.id.name);
        this.iconView = (ImageView) view.findViewById(R.id.icon);
        this.rating = (TextView) view.findViewById(R.id.rating_label);
        this.appClicks = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setApp$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(Application application, View view) {
        this.appClicks.onNext(application);
    }

    @Override // cm.aptoide.pt.view.app.ListStoreAppViewHolder
    public void setApp(final Application application) {
        this.nameTextView.setText(application.getName());
        ImageLoader.with(this.itemView.getContext()).load(application.getIcon(), this.iconView);
        float rating = application.getRating();
        if (rating == 0.0f) {
            this.rating.setText(R.string.appcardview_title_no_stars);
        } else {
            this.rating.setText(new DecimalFormat("0.0").format(rating));
        }
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.view.app.z0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f8002f.a(application, view);
            }
        });
    }
}
