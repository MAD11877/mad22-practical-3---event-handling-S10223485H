package sg.edu.np.mad.practical2;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class myViewHolder extends RecyclerView.ViewHolder {
    TextView txt;

    public myViewHolder(View itemView) {
        super(itemView);
        txt = itemView.findViewById(R.id.NameView);
    }
}
