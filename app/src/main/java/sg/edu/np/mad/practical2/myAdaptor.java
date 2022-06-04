package sg.edu.np.mad.practical2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdaptor extends RecyclerView.Adapter<myViewHolder>{
    ArrayList<User> data;

    public myAdaptor(ArrayList<User> input) {
        data = input;
    }

    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout, parent, false);
        return new myViewHolder(item);
    }

    public void onBindViewHolder(myViewHolder holder, int position){
        User u = data.get(position);
        holder.txt.setText(u.getName());
    }

    public int getItemCount(){
        return data.size();
    }
}
