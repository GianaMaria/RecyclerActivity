package com.example.recycleractivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<User> users;

    public Adapter(List<User> users) {
        this.users = users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View userView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(userView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        User user = users.get(position);
        TextView textView = holder.itemView.findViewById(R.id.textViewInfo);
        textView.setText(user.getName());

        Button button = holder.itemView.findViewById(R.id.buttonRec);
        button.setText(user.isInfo() ? "Детали" : "Добавить");
    }

    @Override
    public int getItemCount() {
        if (users == null) {
            return 0;
        } return users.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }


    // создание холдера
//    static class ViewHolderInfo extends RecyclerView.ViewHolder {
//
//        //для получения текствью
//        private final TextView textView;
//
//        // конструктор
//        public ViewHolderInfo(@NonNull View itemView) {
//            super(itemView);
//            textView = itemView.findViewById(R.id.textViewInfo);
//        }

//        // метод наполнения информацией
//        void bind(User user) {
//            textView.setText(user);
//        }
//    }
}
