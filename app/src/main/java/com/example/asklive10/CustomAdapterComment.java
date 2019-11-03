package com.example.asklive10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asklive10.classes.Comment;
import com.example.asklive10.classes.Post;
import com.example.asklive10.classes.Question;

import java.util.ArrayList;

public class CustomAdapterComment extends ArrayAdapter<String> {

    CustomAdapterComment(Context context, ArrayList<String> questions) {
        super(context, R.layout.commentrow, questions);                     //TODO: FIX THIS ERROR
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater myInflater = LayoutInflater.from(getContext());
        View customView = myInflater.inflate(R.layout.commentrow, parent, false);

        String questText = getItem(position);
        Post myComm = Post.fromString(questText);
        TextView questText2 = (TextView) customView.findViewById(R.id.commentText);
        TextView questText3 = (TextView) customView.findViewById(R.id.commentTime);
        TextView questText4 = (TextView) customView.findViewById(R.id.commentVotes);
        ImageView theImage = (ImageView) customView.findViewById(R.id.upImage);

        questText2.setText(myComm.getText());
        questText3.setText(myComm.getTimestamp().toString());
        questText4.setText("" + myComm.getUpvotes());
        theImage.setImageResource(R.drawable.up_arrow);
        return customView;

    }


}
